package wood.mike

class Team {

    String name

    static hasMany = [riders: Rider]

    static constraints = {
        name nullable: false, blank: false, size: 1..100
    }
}
