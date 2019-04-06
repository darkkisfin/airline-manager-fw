package fi.lenkkeri.airline.grails.domain

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AirplaneController {

    def jsonApiService //man!

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Airplane.list(params), model:[airplaneCount: Airplane.count()]
    }

    def show(Airplane airplane) {
        respond airplane
    }

    def create() {
        respond new Airplane(params)
    }

    @Transactional
    def save(Airplane airplane) {
        if (airplane == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (airplane.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond airplane.errors, view:'create'
            return
        }

        log.info jsonApiService.addAirplane(airplane, false)//man!

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'airplane.label', default: 'Airplane'), airplane.id])
                redirect airplane
            }
            '*' { respond airplane, [status: CREATED] }
        }
    }

    def edit(Airplane airplane) {
        respond airplane
    }

    @Transactional
    def update(Airplane airplane) {
        if (airplane == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (airplane.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond airplane.errors, view:'edit'
            return
        }

        airplane.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'airplane.label', default: 'Airplane'), airplane.id])
                redirect airplane
            }
            '*'{ respond airplane, [status: OK] }
        }
    }

    @Transactional
    def delete(Airplane airplane) {

        if (airplane == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        airplane.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'airplane.label', default: 'Airplane'), airplane.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'airplane.label', default: 'Airplane'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
