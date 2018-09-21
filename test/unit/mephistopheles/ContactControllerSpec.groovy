package mephistopheles

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([Contact])
@TestFor(ContactController)
class ContactControllerSpec extends Specification {

    def setup() {
        new Contact(name: "Demetrio",
                    fatherLastName: "Madero",
                    motherLastName: "García",
                    homePhone: "59778800",
                    mobilePhone: "5511223344",
                    relationship: "Padre").save(flush:true)
        new Contact(name: "Federico",
                fatherLastName: "Cardenas",
                motherLastName: "Mendez",
                homePhone: "52478800",
                mobilePhone: "5588954278",
                relationship: "Primo").save(flush:true)

        assert Contact.count() == 2
    }

    //index
    @Unroll("[index] Method #requestMethod have response code #responseStatus")
    void "Test request method for index"() {
        setup: "Set request method"
        request.method = requestMethod

        when: "Calling the index action"
        controller.index()

        then: "Validate status"
        response.status == responseStatus

        where:
        requestMethod   |responseStatus
        'GET'           |200
        'HEAD'          |405
        'TRACE'         |405
        'CONNECT'       |405
        'POST'          |405
        'PUT'           |405
    }

    void "[index] Request with params.max too big"() {
        setup: "Set request data"
        request.method = 'GET'
        params.max = 10000

        when: "Calling the index action"
        def model = controller.index()

        then: "Default value is used"
        params.max == 500
        and: "Model is correct"
        model.contactList.size() == 2
    }

    void "[index] Request with custom params.max"() {
        setup: "Set request data"
        request.method = 'GET'
        params.max = 1

        when: "Calling the index action"
        def model = controller.index()

        then: "Custom value is used"
        params.max == 1
        and: "Model is correct"
        model.contactList.size() == 1
    }

    //create
    @Unroll("[create] Method #requestMethod have response code #responseStatus")
    void "Test request method for create"() {
        setup: "Set request method"
        request.method = requestMethod

        when: "Calling the create action"
        controller.create()

        then: "Validate status"
        response.status == responseStatus

        where:
        requestMethod   |responseStatus
        'GET'           |200
        'HEAD'          |405
        'TRACE'         |405
        'CONNECT'       |405
        'POST'          |405
        'PUT'           |405
    }

    //save
    @Unroll("[save] Method #requestMethod have response code #responseStatus")
    void "Test request method for save"() {
        setup: "Set request method"
        request.method = requestMethod

        when: "Calling the save action"
        controller.save()

        then: "Validate status"
        response.status == responseStatus

        where:
        requestMethod   |responseStatus
        'GET'           |405
        'HEAD'          |405
        'TRACE'         |405
        'CONNECT'       |405
        'POST'          |200
        'PUT'           |405
    }

    void "[save] Request with invalid data"() {
        setup: "Set the request data"
        request.method = 'POST'
        and: "Set contact params"
        //params.code = ''
        params.name = ''

        when: "Calling the save action"
        controller.save()

        then: "View is correct"
        view == '/contact/create'
        and: "Model is correct"
        !model.contactInstance.name
        and: "Contact instance is not saved"
        Contact.count == 2
    }

    void "[save] Request with valid data"() {
        setup: "Set the request data"
        request.method = 'POST'
        and: "Set contact params"

        params.name = "Fernando"
        params.fatherLastName = "Montes"
        params.motherLastName = "García"
        params.homePhone = "58745210"
        params.mobilePhone = "5511223344"
        params.relationship =  "Padre"

        when: "Calling the save action"
        controller.save()

        /*then: "Success message is displayed"
        flash.message == 'contact.created.message'*/
        then: "User is redirected"
        response.redirectedUrl == "/contact/show/${Contact.last().id}"
        and: "Contact instance is saved"
        Contact.count == 3
        Contact.last().refresh().name == 'Fernando'
    }

    //show
    @Unroll("[show] Method #requestMethod have response code #responseStatus")
    void "Test request method for details"() {
        setup: "Set request method"
        request.method = requestMethod
        controller.params.id = Contact.first().id

        when: "Calling the show action"
        controller.show()

        then: "Validate status"
        response.status == responseStatus

        where:
        requestMethod   |responseStatus
        'GET'           |200
        'HEAD'          |405
        'TRACE'         |405
        'CONNECT'       |405
        'POST'          |405
        'PUT'           |405
    }

    void "[show] Request with invalid ID"() {
        setup: "Set the request data"
        request.method = 'GET'
        params.id = 999

        when: "Calling the show action"
        controller.show()

        then: "User is redirected"
        response.redirectedUrl == '/contact/index'
    }

    void "[show] Request with valid ID"() {
        setup: "Set the request data"
        request.method = 'GET'
        params.id = Contact.first().id

        when: "Calling the show action"
        def model = controller.show()

        then: "Model is correct"
        model.contactInstance == Contact.first()
    }


    //update
    @Unroll("[update] Method #requestMethod have response code #responseStatus")
    void "Test request method for update"() {
        setup: "Set request method"
        request.method = requestMethod
        controller.params.id = Contact.first().id

        when: "Calling the update action"
        controller.update()

        then: "Validate status"
        response.status == responseStatus

        where:
        requestMethod   |responseStatus
        'GET'           |405
        'HEAD'          |405
        'TRACE'         |405
        'CONNECT'       |405
        'POST'          |302
        'PUT'           |405
    }

    void "[update] Request with invalid ID"() {
        setup: "Set the request data"
        request.method = 'POST'
        and: "With invalid id"
        params.id = 19

        when: "Calling the update action"
        controller.update()

        then: "User is redirected"
        response.redirectedUrl == '/contact/index'
    }

    void "[update] Request with valid ID but invalid data"() {
        setup: "Set the request data"
        request.method = 'POST'
        and: "With incorrect params for validation"
        params.id = Contact.first().id
        params.name = ''

        when: "Calling the update action"
        controller.update()

        then: "View is correct"
        view == "/contact/edit"
        and: "Model is correct"
        !model.contactInstance.name
        and: "Contact instance is not updated"
        Contact.first().refresh().name == 'Demetrio'
    }

    void "[update] Request with valid ID and valid data"() {
        setup: "Set the request data"
        request.method = 'POST'
        and: "With valid params for validation"
        params.id = Contact.first().id
        params.name = 'Filiberto'

        when: "Calling the update action"
        controller.update()

        /*then: "Success message is displayed"
        flash.message == 'contact.updated.message'*/
        then: "User is redirected"
        response.redirectedUrl == "/contact/show/${params.id}"
        and: "Contact instance is updated"
        Contact.first().refresh().name == 'Filiberto'
    }

    //edit
    @Unroll("[edit] Method #requestMethod have response code #responseStatus")
    void "Test request method for edit"() {
        setup: "Set request method"
        request.method = requestMethod
        controller.params.id = Contact.first().id

        when: "Calling the update action"
        controller.edit()

        then: "Validate status"
        response.status == responseStatus

        where:
        requestMethod   |responseStatus
        'GET'           |200
        'HEAD'          |405
        'TRACE'         |405
        'CONNECT'       |405
        'POST'          |405
        'PUT'           |405
    }

    void "[edit] Request with invalid ID"() {
        setup: "Set the request data"
        request.method = 'GET'
        and: "With invalid id"
        params.id = 19

        when: "Calling the update action"
        controller.edit()

        then: "User is redirected"
        response.redirectedUrl == '/contact/index'
    }

    void "[edit] Request with valid ID"() {
        setup: "Set the request data"
        request.method = 'GET'
        params.id = Contact.first().id

        when: "Calling the update action"
        def model = controller.edit()

        then: "Model is correct"
        model.contactInstance == Contact.first()

    }

    //edit
    @Unroll("[delete] Method #requestMethod have response code #responseStatus")
    void "Test request method for delete"() {
        setup: "Set request method"
        request.method = requestMethod
        controller.params.id = Contact.first().id

        when: "Calling the update action"
        controller.delete()

        then: "Validate status"
        response.status == responseStatus

        where:
        requestMethod   |responseStatus
        'GET'           |302
        'HEAD'          |405
        'TRACE'         |405
        'CONNECT'       |405
        'POST'          |405
        'PUT'           |405
    }

    void "[delete] Request with invalid ID"() {
        setup: "Set the request data"
        request.method = 'GET'
        and: "With invalid id"
        params.id = 19

        when: "Calling the update action"
        controller.delete()

        then: "User is redirected"
        response.redirectedUrl == '/contact/index'
        and: "Contact instance is not deleted"
        Contact.count == 2
    }

    void "[delete] Request with valid ID"() {
        setup: "Set the request data"
        request.method = 'GET'
        params.id = Contact.first().id

        when: "Calling the update action"
        controller.delete()

        then: "User is redirected"
        response.redirectedUrl == '/contact/index'

        and: "Contact instance is deleted"
        Contact.count == 1
    }

    def cleanup() {
    }

    void "test something"() {
    }
}
