package wood.mike

import grails.rest.RestfulController

class TeamRestController extends RestfulController<Team>{
    static responseFormats = ['json', 'xml']
    TeamRestController() {
        super(Team)
    }
}
