package mephistopheles

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Ignore
import grails.test.mixin.Mock

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@Mock([Contact])
@TestFor(ContactService)
class ContactServiceSpec extends Specification {

    def setup() {
        new Contact(
                name: "Jonathan",
                fatherLastName: "Hernandez",
                motherLastName: "Herrera",
                mobilePhone: "123456789",
                homePhone: "987654321",
                relationship: "Hermano").save(flush:true)
        new Contact(
                name: "Hirving",
                fatherLastName: "Lozano",
                motherLastName: "Gutierrez",
                mobilePhone: "123456789",
                homePhone: "987654321",
                relationship: "Hijo").save(flush:true)
        new Contact(
                name: "Hector",
                fatherLastName: "Ochoa",
                motherLastName: "Camil",
                mobilePhone: "123456789",
                homePhone: "987654321",
                relationship: "Padre").save(flush:true)

        assert Contact.count() == 3
    }

    void "Test save method"() {
        given: "A new contact"
        assert Contact.count() == 3
        Contact contactInstance = new Contact(
                name: "Hector",
                fatherLastName: "Ochoa",
                motherLastName: "Camil",
                mobilePhone: "123456789",
                homePhone: "987654321",
                relationship: "Padre")

        when: "Saving the contact"
        service.save(contactInstance)

        then: "Contact is saved correctly"
        Contact.count() == 4
    }

    void "Test delete method"() {
        given: "A contact"
        assert Contact.count() == 3
        Contact contactInstance = Contact.first()

        when: "Deleting the contact"
        service.delete(contactInstance)

        then: "Contact is deleted correctly"
        Contact.count() == 2
    }

    void "Test getContactReport with relationship = 'Hermano'"() {
        assert Contact.count() == 3

        given:"Existing contacts"
        new Contact(
                name: "Jonathan",
                fatherLastName: "Hernandez",
                motherLastName: "Herrera",
                mobilePhone: "123456789",
                homePhone: "987654321",
                relationship: "Hermano").save(flush:true)
        new Contact(
                name: "Hirving",
                fatherLastName: "Lozano",
                motherLastName: "Gutierrez",
                mobilePhone: "123456789",
                homePhone: "987654321",
                relationship: "Hermano").save(flush:true)
        new Contact(
                name: "Hector",
                fatherLastName: "Ochoa",
                motherLastName: "Camil",
                mobilePhone: "123456789",
                homePhone: "987654321",
                relationship: "Padre").save(flush:true)

        assert Contact.count() == 6

        when:"Calling getContactReport method"
        List<Contact> contactList = service.getContactReport("Hermano")

        then:"Result is correct"
        contactList.size() == 3
    }
    @Ignore("Criteria does not work at unit tests")
    void "Test reportContactList with POGO"() {
        assert Contact.count() == 3

        given:"Existing contacts"
        new Contact(
                name: "Jonathan",
                fatherLastName: "Hernandez",
                motherLastName: "Herrera",
                mobilePhone: "123456789",
                homePhone: "987654321",
                relationship: "Hermano").save(flush:true)
        new Contact(
                name: "Hirving",
                fatherLastName: "Lozano",
                motherLastName: "Gutierrez",
                mobilePhone: "123456789",
                homePhone: "987654321",
                relationship: "Hermano").save(flush:true)
        new Contact(
                name: "Hector",
                fatherLastName: "Ochoa",
                motherLastName: "Camil",
                mobilePhone: "123456789",
                homePhone: "987654321",
                relationship: "Padre").save(flush:true)

        assert Contact.count() == 6

        when:"Calling reportContactList method"
        List<ContactReportResult> reportContactList = service.getGroupContactReport()

        then:"Result is correct"
        reportContactList.size() == 3
    }

    def cleanup() {
    }

    void "test something"() {
    }
}
