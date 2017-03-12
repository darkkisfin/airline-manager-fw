package fi.lenkkeri.airline.grails.domain

import static org.springframework.http.HttpStatus.*
import fi.lenkkeri.airline.grails.model.*
import grails.converters.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FlightController {

    def jsonApiService
    def xmlApiService
    def planeDataService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Flight.list(params), model:[flightCount: Flight.count()]
    }

    def show(Flight flight) {
        respond flight
    }

    def create() {
        respond new Flight(params), model:[cityInstanceList:City.findAllByHidden(false)] //man!
    }

    def getAirplanes(String serialNumber) { //man!
        def airplanes = planeDataService.findPlaneBySN(serialNumber) //man!
        //Airplane plane = [serialNumber:"111"] //REMOVE WHEN DONE
        //airplanes = [plane] //REMOVE WHEN DONE
        render airplanes as JSON //man!
    }

    def getPilots(String firstName, String lastName) { //man!
        def pilots = xmlApiService.findPilot(firstName, lastName) //man!
        render pilots as JSON //man!
    }

    def findFlights(String text, Integer max, Integer offset){
        params.max = Math.min(max?:10, 100) //man!
        params.offset = offset?:0 //man!
        def flights = Flight.createCriteria().list([max:max, offset:offset]) { //man!
            or { //man!
                like("pilotName", "%$text%") //man!
                like("copilotName", "%$text%") //man!
                origin { //man!
                    like("airfieldName", "%$text%") //man!
                }
                destination { //man!
                    like("airfieldName", "%$text%") //man!
                }
            }
            if(params.sort)order(params.sort, params.order) //man!
        }
        respond flights, model:[flightCount:flights.totalCount], view: "index" //man!
    }

    @Transactional
    def save(Flight flight) {
        if (flight == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (flight.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond flight.errors, view:'create'
            return
        }

        flight.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'flight.label', default: 'Flight'), flight.id])
                redirect flight
            }
            '*' { respond flight, [status: CREATED] }
        }
    }

    def edit(Flight flight) {
        respond flight, model:[cityInstanceList:City.findAllByHidden(false)] //man!
    }

    @Transactional
    def update(Flight flight) {
        if (flight == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (flight.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond flight.errors, view:'edit'
            return
        }

        flight.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'flight.label', default: 'Flight'), flight.id])
                redirect flight
            }
            '*'{ respond flight, [status: OK] }
        }
    }

    @Transactional
    def delete(Flight flight) {

        if (flight == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        flight.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'flight.label', default: 'Flight'), flight.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'flight.label', default: 'Flight'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
