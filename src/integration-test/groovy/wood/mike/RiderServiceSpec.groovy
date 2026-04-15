package wood.mike

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RiderServiceSpec extends Specification {

    RiderService riderService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Rider(...).save(flush: true, failOnError: true)
        //new Rider(...).save(flush: true, failOnError: true)
        //Rider rider = new Rider(...).save(flush: true, failOnError: true)
        //new Rider(...).save(flush: true, failOnError: true)
        //new Rider(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //rider.id
    }

    void "test get"() {
        setupData()

        expect:
        riderService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Rider> riderList = riderService.list(max: 2, offset: 2)

        then:
        riderList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        riderService.count() == 5
    }

    void "test delete"() {
        Long riderId = setupData()

        expect:
        riderService.count() == 5

        when:
        riderService.delete(riderId)
        sessionFactory.currentSession.flush()

        then:
        riderService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Rider rider = new Rider()
        riderService.save(rider)

        then:
        rider.id != null
    }
}
