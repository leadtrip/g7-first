package wood.mike

import grails.gorm.services.Service

@Service(Rider)
interface RiderService {

    Rider get(Serializable id)

    List<Rider> list(Map args)

    Long count()

    void delete(Serializable id)

    Rider save(Rider rider)

}