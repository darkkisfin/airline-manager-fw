package fi.lenkkeri.airline.grails

import fi.lenkkeri.airline.grails.model.Airplane    //man!
import grails.core.GrailsApplication    //man!
import grails.transaction.Transactional
import groovyx.net.http.HTTPBuilder    //man!

@Transactional
class JsonApiService {
    GrailsApplication grailsApplication //man!
    //man!
    def addAirplane(Airplane airplane, boolean saveLocal) {    //man!
        boolean addSuccess = false    //man!
        def uploadableData = airplane.properties    //man!
        uploadableData.remove("id")    //man!
        def http = new HTTPBuilder( grailsApplication.config.getProperty("fi.lenkkeri.grails.json.baseurl")+"addPlane" )    //man!
        http.request( POST, JSON ) { req ->    //man!
            body = uploadableData    //man!
            response.success = { resp, json ->    //man!
               if(resp.statusLine.statusCode==200)    //man!
               {
                   addSuccess=true    //man!
                   airplane.save(flush:true)    //man!
               }
            }
        }
        return addSuccess    //man!
    }
}
