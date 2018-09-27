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

    List<Contact> getContactReport (String relationship){
        Contact.findAllByRelationship(relationship, [max: 10, sort: "name", order: "desc"])
    }

    List<ContactReportResult> getGroupContactReport (){
        def criteriaContact = Contact.createCriteria()
        List contactList = criteriaContact.list {
            projections {
                groupProperty "relationship"
                count "relationship"
            }
        }
        List<ContactReportResult> reportContactList
        reportContactList = contactList.collect { queryResult ->
            new ContactReportResult(relationship: queryResult[0], count:queryResult[1])
        }
        reportContactList
    }
}
