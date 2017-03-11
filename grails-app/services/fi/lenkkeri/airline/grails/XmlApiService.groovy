package fi.lenkkeri.airline.grails

import fi.lenkkeri.airline.grails.model.Airplane
import fi.lenkkeri.airline.grails.model.Pilot
import grails.core.GrailsApplication
import grails.transaction.Transactional
import groovy.xml.MarkupBuilder
import groovyx.net.http.HTTPBuilder    //man!
import static groovyx.net.http.Method.POST //man!
import static groovyx.net.http.ContentType.XML //man!
import org.codehaus.groovy.runtime.InvokerHelper
import grails.converters.*

@Transactional
class XmlApiService {

    GrailsApplication grailsApplication //man!
    //man!
    List<Pilot> findPilot(String gfirstName, String glastName) {    //man!
        List<Pilot> foundPilots = []    //man!
        println "Searching for $gfirstName and $glastName"
        def uploadableData = ["firstName":gfirstName, "lastName":glastName]    //man!
        def writer = new StringWriter()
        def xmld = new MarkupBuilder(writer)
        xmld.FindPersonCommand() {
            firstName(gfirstName)
            lastName(glastName)
        }
        uploadableData = writer.toString()

        def http = new HTTPBuilder( grailsApplication.config.getProperty("fi.lenkkeri.grails.xml.baseurl").toString()+"findPerson" )    //man!

        http.handler.failure = { resp ->    //man!
            log.error "Response: $resp"
            log.error "Unexpected failure: ${resp.statusLine}"    //man!
        }

        http.request( POST, groovyx.net.http.ContentType.XML ) { req ->    //man!
            requestContentType : groovyx.net.http.ContentType.XML
            body = uploadableData //man!
            response.success = { resp, xml ->    //man!
                if(resp.statusLine.statusCode==200)    //man!
                {
                    println convertToMap(xml)
                    xml?.each { pilotXml ->   //man!
                        def pilotMap = convertToMap(pilotXml)?.entry?.pilotData
                        Pilot pilot = [firstName:pilotMap?.firstName, lastName:pilotMap?.lastName, middleName:pilotMap?.middleName, birthDate:Date.parse("yyyy-MM-dd HH:mm:ss.S", pilotMap?.birthDate), enteredEmployment:Date.parse("yyyy-MM-dd HH:mm:ss.S", pilotMap?.enteredEmployment), callsign:pilotMap?.callsign]   //man!
                        println "Pilot:" + pilot //TODO: poista kun testattu
                        foundPilots.add(pilot)  //man!
                    }
                }
            }

        }
        return foundPilots    //man!
    }

    def convertToMap(nodes) {
        nodes.children().collectEntries {
            [ it.name(), it.childNodes() ? convertToMap(it) : it.text() ]
        }
    }
}
