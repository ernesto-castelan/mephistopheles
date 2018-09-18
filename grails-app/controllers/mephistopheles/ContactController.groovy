package mephistopheles

class ContactController {

    //static  scaffold = true

    static allowedMethods = [index:'GET', create:'GET', save:'POST', show:'GET', update:'POST']

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
            println("**************************************************************")
            println(contactInstance.errors)
            render view:'create', model:[contactInstance:contactInstance, contactErrors:contactInstance.errors ]
            return
        }
        contactInstance.save()
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
            println("**************************************************************")
            println(contactInstance.errors)
            redirect action:'index'
            return
        }

        return [contactInstance:contactInstance]
    }

    def update(Long id) {
        Contact contactInstance = Contact.get(id)
        bindData(contactInstance, params)

        if(!contactInstance) {

            redirect action:'index'
            return
        }

        if(!contactInstance.validate()) {
            println("**************************************************************")
            println(contactInstance.errors)
            render view:'show', model:[contactInstance:contactInstance]
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

        contactInstance.delete(flush: true)
        redirect action:'index'
    }
}
