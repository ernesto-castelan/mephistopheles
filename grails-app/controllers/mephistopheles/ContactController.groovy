package mephistopheles

class ContactController {

    static allowedMethods = [index:'GET', create:'GET', save:'POST', show:'GET', update:'POST', edit:'GET', delete:'GET']

    ContactService contactService

    def index () {
        params.max = Math.min(params.max ? params.int('max') : 50, 500)
        def contactList = Contact.list(params)
        return [contactList: contactList]
    }

    def create(){
    }

    def save () {
        Contact contactInstance = new Contact()
        bindData(contactInstance, params)

        if (!contactInstance.validate()) {
            render view:'create', model:[contactInstance:contactInstance, contactErrors:contactInstance.errors ]
            return
        }
        contactService.save(contactInstance)
        redirect action:'show', id:contactInstance.id
    }

    def show(Long id) {
        Contact contactInstance = Contact.get(id)
        if (!contactInstance) {
            redirect action:'index'
            return
        }
        return [contactInstance:contactInstance]
    }

    def edit(Long id) {
        Contact contactInstance = Contact.get(id)
        if (!contactInstance) {
            redirect action:'index'
            return
        }
        return [contactInstance:contactInstance]
    }

    def update(Long id) {
        Contact contactInstance = Contact.get(id)

        if(!contactInstance) {
            redirect action:'index'
            return
        }
        bindData(contactInstance, params)

        if(!contactInstance.validate()) {
            render view:'edit', model:[contactInstance:contactInstance, contactErrors:contactInstance.errors ]
            return
        }

        contactInstance.save(flush: true)
        redirect action:'show', id:contactInstance.id
    }

    def delete (Long id) {
        Contact contactInstance = Contact.get(id)
        if (!contactInstance) {
            redirect action:'index'
            return
        }
        contactService.delete(contactInstance)
        redirect action:'index'
    }

    def report (String relationship){
        List<Contact> contactList = contactService.report(relationship)
        println(contactList)
        return [contactList: contactList]
    }

}
