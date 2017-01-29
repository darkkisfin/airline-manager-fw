package fi.lenkkeri.airline.grails

import fi.lenkkeri.airline.grails.model.Airplane
import fi.lenkkeri.airline.grails.model.Pilot
import grails.core.GrailsApplication
import grails.transaction.Transactional
import groovyx.net.http.HTTPBuilder    //man!
import org.codehaus.groovy.runtime.InvokerHelper

@Transactional
class XmlApiService {

    GrailsApplication grailsApplication //man!
    //man!
    List<Pilot> findPilot(String firstName, String lastName) {    //man!
        List<Pilot> foundPilots = []    //man!
        def uploadableData = ["firstName":firstName, "lastName":lastName]    //man!
        def http = new HTTPBuilder( grailsApplication.config.getProperty("fi.lenkkeri.grails.xml.baseurl")+"findPerson" )    //man!
        http.request( POST, XML ) { req ->    //man!
            body = uploadableData    //man!
            response.success = { resp, xml ->    //man!
                if(resp.statusLine.statusCode==200)    //man!
                {
                    xml?.data?.each { pilotXml ->   //man!
                        Pilot pilot = new Pilot()   //man!
                        InvokerHelper.setProperties(pilot, pilotXml.properties)//man!
                        println pilot //TODO: poista kun testattu
                        println pilotXml //TODO: poista kun testattu
                        foundPilots.add(pilot)  //man!
                    }
                }
            }
        }
        return foundPilots    //man!
    }
}
