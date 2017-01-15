package fi.lenkkeri.airline.grails.domain

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FlightController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Flight.list(params), model:[flightCount: Flight.count()]
    }

    def show(Flight flight) {
        respond flight
    }

    def create() {
        respond new Flight(params)
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
        respond flight
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
