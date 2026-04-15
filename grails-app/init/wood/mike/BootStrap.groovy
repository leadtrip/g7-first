package wood.mike

import java.time.LocalDate
import java.time.Month

class BootStrap {

    def init = {
        Team t1 = new Team(name: "Team 1").save(failOnError: true)

        Rider r1 = new Rider(forename: "Bob", surname: "Skills", dob: LocalDate.of(2020, Month.APRIL, 3), nationality: "GB", team: t1).save(failOnError: true)
        Rider r2 = new Rider(forename: "Chris", surname: "Endo", dob: LocalDate.of(2013, Month.MARCH, 1), nationality: "IT", team: t1).save(failOnError: true)
        Rider r3 = new Rider(forename: "Sam", surname: "Brakes", dob: LocalDate.of(2015, Month.DECEMBER, 21), nationality: "HU", team: t1).save(failOnError: true)
        Rider r4 = new Rider(forename: "Dave", surname: "Wheelie", dob: LocalDate.of(2016, Month.OCTOBER, 16), nationality: "IE", team: t1).save(failOnError: true)
    }

    def destroy = {
    }

}