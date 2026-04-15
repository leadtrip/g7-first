package wood.mike

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RiderController {

    RiderService riderService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond riderService.list(params), model:[riderCount: riderService.count()]
    }

    def show(Long id) {
        respond riderService.get(id)
    }

    def create() {
        respond new Rider(params)
    }

    def save(Rider rider) {
        if (rider == null) {
            notFound()
            return
        }

        try {
            riderService.save(rider)
        } catch (ValidationException e) {
            respond rider.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rider.label', default: 'Rider'), rider.id])
                redirect rider
            }
            '*' { respond rider, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond riderService.get(id)
    }

    def update(Rider rider) {
        if (rider == null) {
            notFound()
            return
        }

        try {
            riderService.save(rider)
        } catch (ValidationException e) {
            respond rider.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rider.label', default: 'Rider'), rider.id])
                redirect rider
            }
            '*'{ respond rider, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        riderService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rider.label', default: 'Rider'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rider.label', default: 'Rider'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
