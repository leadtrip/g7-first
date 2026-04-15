package wood.mike

import grails.rest.RestfulController

class RiderRestController extends RestfulController<Rider>{
    static responseFormats = ['json', 'xml']
    RiderRestController() {
        super(Rider)
    }
}
