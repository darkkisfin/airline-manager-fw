package fi.lenkkeri.airline.grails.domain

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CityController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def findCity(String text, Integer max, Integer offset) //man!
    {
        params.max = Math.min(max?:10, 100) //man!
        params.offset = offset?:0 //man!
        def cities = City.createCriteria().list([max:max, offset:offset]) { //man!
            eq("hidden", false) //man!
            or { //man!
                like("cityName", "%$text%") //man!
                like("countryName", "%$text%") //man!
                like("airfieldName", "%$text%") //man!
            }
            if(params.sort)order(params.sort, params.order) //man!
        }
        respond cities, model:[cityCount:cities.totalCount], view: "index" //man!
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def cities = City.findAllByHidden(false, params) //man!
        respond cities, model:[cityCount: City.countByHidden(false)] //man!
    }

    def show(City city) {
        respond city
    }

    def create() {
        respond new City(params)
    }

    @Transactional
    def save(City city) {
        if (city == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (city.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond city.errors, view:'create'
            return
        }

        city.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'city.label', default: 'City'), city.id])
                redirect city
            }
            '*' { respond city, [status: CREATED] }
        }
    }

    def edit(City city) {
        respond city
    }

    @Transactional
    def update(City city) {
        if (city == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (city.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond city.errors, view:'edit'
            return
        }

        city.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'city.label', default: 'City'), city.id])
                redirect city
            }
            '*'{ respond city, [status: OK] }
        }
    }

    @Transactional
    def delete(City city) {

        if (city == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        city.hidden = true //man!
        city.save flush:true //man!

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'city.label', default: 'City'), city.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'city.label', default: 'City'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
