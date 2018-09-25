package mephistopheles

import grails.transaction.Transactional

@Transactional
class ContactService {

    void save(Contact contactInstance){
        contactInstance.save(flush: true, failOnError:true)
    }

    void delete(Contact contactInstance){
        contactInstance.delete(flush: true)
    }

    List<Contact> report(String relationship){
        println(relationship)
        Contact.findAllByRelationship(relationship, [max: 10, sort: "name", order: "desc"])
    }
}
