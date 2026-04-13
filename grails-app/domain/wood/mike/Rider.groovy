package wood.mike

import java.time.LocalDate

class Rider {

    String forename
    String surname
    LocalDate dob
    String nationality

    static constraints = {
        forename nullable: false, blank: false, size: 1..100
        surname nullable: false, blank: false, size: 1..100
        dob nullable: false, blank: false
        nationality nullable: false, blank: false, size: 2..2
    }
}
