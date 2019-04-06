package fi.lenkkeri.airline.grails

import fi.lenkkeri.airline.grails.domain.Airplane //man!

//man!
import grails.core.GrailsApplication    //man!
import grails.transaction.Transactional
import groovyx.net.http.ContentType //man!
import groovyx.net.http.HTTPBuilder //man!
import groovyx.net.http.Method //man!

//man!

@Transactional
class JsonApiService {
    GrailsApplication grailsApplication //man!
    //man!
    def addAirplane(Airplane airplane, boolean saveLocal) {    //man!
        boolean addSuccess = false    //man!
        def uploadableData = airplane.properties    //man!
        def http = new HTTPBuilder( grailsApplication.config.getProperty("fi.lenkkeri.grails.json.baseurl").toString()+"addPlane" )    //man!

        http.handler.failure = { resp ->    //man!
            log.error "Unexpected failure: ${resp.statusLine}"    //man!
        }
        def printResponse, printJson
        http.request(Method.POST, ContentType.JSON ) { req ->    //man!
            body = uploadableData    //man!
            response.success = { resp, json ->    //man!
               if(resp.statusLine.statusCode==200)    //man!
               {
                   printResponse = resp //man!
                   printJson = json //man!
                   addSuccess=true    //man!
                   airplane.save(flush:true)    //man!
               }
            }
        }
        return ["success":addSuccess, "response":printResponse, "json":printJson]    //man!
    }
}
