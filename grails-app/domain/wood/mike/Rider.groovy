package wood.mike

import grails.rest.Resource

import java.time.LocalDate

@Resource(uri='/riders')
class Rider {

    String forename
    String surname
    LocalDate dob
    String nationality
    static belongsTo = [team: Team]

    static constraints = {
        forename nullable: false, blank: false, size: 1..100
        surname nullable: false, blank: false, size: 1..100
        dob nullable: false, blank: false
        nationality nullable: false, blank: false, size: 2..2
    }
}
