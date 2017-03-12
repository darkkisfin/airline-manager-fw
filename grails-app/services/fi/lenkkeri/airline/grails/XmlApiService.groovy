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

        def http = new HTTPBuilder( grailsApplication.config.getProperty("fi.lenkkeri.grails.xml.baseurl").toString()+"findPerson" )    //man!

        http.handler.failure = { resp ->    //man!
            log.error "Response: $resp"    //man!
            log.error "Unexpected failure: ${resp.statusLine}"    //man!
        }

        http.request( POST ) { req ->    //man!
            requestContentType = groovyx.net.http.ContentType.XML
            body = {    //man!
                FindPersonCommand {    //man!
                    firstName gfirstName    //man!
                    lastName glastName    //man!
                }
            }
            response.success = { resp, xml ->    //man!
                if(resp.statusLine.statusCode==200)    //man!
                {
                    xml?.entry?.find {it.@key=='data'}?.pilotData?.each { pilotXml ->   //man!
                        def pilotMap = convertToMap(pilotXml)    //man!
                        Pilot pilot = [id: pilotXml.@id,firstName:pilotMap?.firstName, lastName:pilotMap?.lastName, middleName:pilotMap?.middleName, birthDate:Date.parse("yyyy-MM-dd HH:mm:ss.S", pilotMap?.birthDate), enteredEmployment:Date.parse("yyyy-MM-dd HH:mm:ss.S", pilotMap?.enteredEmployment), callsign:pilotMap?.callsign]   //man!
                        foundPilots.add(pilot)  //man!
                    }
                }
            }
        }
        return foundPilots    //man!
    }

    def convertToMap(nodes) {    //man!
        nodes.children().collectEntries {    //man!
            [ it.name(), it.childNodes() ? convertToMap(it) : it.text() ]    //man!
        }
    }
}
