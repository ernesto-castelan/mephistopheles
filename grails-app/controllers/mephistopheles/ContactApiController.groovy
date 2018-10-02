package mephistopheles

import grails.transaction.*
import grails.converters.JSON


class ContactApiController {

    static allowedMethods = [index:'GET', save:'POST', show:'GET', update:'PUT', delete:'DELETE',
                             contactReport:'GET', groupContactReport:'GET']

    ContactService contactService

    def index() {
        params.max = Math.min(params.max ? params.int('max') : 50, 500)
        List<Contact> contactList = Contact.list(params)
        render(contactList as JSON)
    }

    def save () {
        Contact contactInstance = new Contact()
        bindData(contactInstance, params)

        if (!contactInstance.validate()) {
            response.status = 400
            render (contactInstance.errors as JSON)
            return
        }
        contactService.save(contactInstance)
        render(contactInstance as JSON)
    }

    def show(Long id) {
        Contact contactInstance = Contact.get(id)
        if (!contactInstance) {
            response.status = 404
            render ''
            return
        }
        render(contactInstance as JSON)
    }

    def update(Long id) {
        Contact contactInstance = Contact.get(id)
        if(!contactInstance) {
            reponse.status = 404
            render ''
            return
        }
        bindData(contactInstance, params)

        if(!contactInstance.validate()) {
            reponse.status = 400
            render(contactInstance.errors as JSON)
            return
        }
        contactService.save(contactInstance)
        render(contactInstance as JSON)
    }

    def delete (Long id) {
        Contact contactInstance = Contact.get(id)
        if (!contactInstance) {
            response.status = 404
            render ''
            return
        }
        contactService.delete(contactInstance)
        render ''
    }

    def contactReport (){
        List<Contact> contactList = contactService.getContactReport(params.relationship)
        render(contactList as JSON)
    }

    def groupContactReport (){
        List<ContactReportResult> groupContactList = contactService.getGroupContactReport()
        return [groupContactList: groupContactList]
        render(groupContactList as JSON)
    }
}
