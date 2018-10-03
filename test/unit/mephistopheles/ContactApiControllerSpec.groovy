package mephistopheles

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Ignore
import spock.lang.Unroll
import groovyx.net.http.RESTClient
import grails.converters.JSON

@TestFor(ContactApiController)
class ContactApiControllerSpec  extends Specification{

    static String testURL = "http://localhost:8080/mephistopheles/api/"
    RESTClient restClient = new RESTClient(testURL)



    void "[index] Check index action"() {
        when: "get all contacts"
        def response = restClient.get(
                path: 'contacts',
                requestContentType: JSON
        )
        then: "Status is 200"
        response.status == 200
        println(response.status)

        and: "Body contains some values"
        assert response.data[0].id == 1
        assert response.data[0].fatherLastName == 'Perez'
        assert response.data.size >= 8
    }

    void "[save] Request with valid data api controller" (){

        given :
        def requestBody = [name: "Pedrito",
                           fatherLastName: 'Gutierrez',
                           motherLastName: 'Perez',
                           homePhone: "58745210",
                           mobilePhone: "5511223344",
                           relationship:  "Padre"]
        when:
        def response = restClient.post(path: 'contacts',
                                        body: requestBody,
                                        requestContentType: 'application/json')

        then:
        response.status == 200
        println(response.status)
    }

    void "[show] Request with valid ID" (){
        setup:
        def testContact = createTestContact().responseData
        println(testContact)

        when:
        def response = restClient.get( path: "contacts/$testContact.id")

        then:
        response.status == 200
        println(response.status)


        and:
        assert response.responseData.id != 1
        assert response.responseData.name == testContact.name
        assert response.responseData.fatherLastName != "PErez"

        cleanup:
        deleteTestContact(""+response.responseData.id)
    }

    def "[update] Request with valid ID and valid data" (){
        setup:
        def testContact = createTestContact().responseData
        println(testContact)

        when:
        def updatedContact = [name: "Pablito",
                              fatherLastName: "Cardenas",
                              motherLastName: 'Mendez',
                              homePhone: "58745210",
                              mobilePhone: "5511223344",
                              relationship:  "Padrino"]
        def response = restClient.put(path: "contacts/$testContact.id" ,
                                        body: updatedContact,
                                        requestContentType: 'application/json')

        then:
        response.status == 200
        println(response.status)

        cleanup:
        deleteTestContact(""+testContact.id)
    }

    def "[delete] Request with valid ID" (){
        setup:
        def testContact = createTestContact().responseData
        println(testContact)

        when:
        def response = restClient.delete(path: "contacts/$testContact.id")

        then:
        response.status == 200
        println(response.status)

    }



    def createTestContact() {
        def requestBody = [name: "Pedrito",
                           fatherLastName: 'Gutierrez',
                           motherLastName: 'Perez',
                           homePhone: "58745210",
                           mobilePhone: "5511223344",
                           relationship:  "Padre"]
        return restClient.post(path: 'contacts', body: requestBody, requestContentType: 'application/json')
    }

    def deleteTestContact(String contactId) {
        return restClient.delete(path: "contacts/$contactId")

    }
}
