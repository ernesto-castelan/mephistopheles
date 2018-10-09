class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        name contactReport: "/details/$relationship" {
            controller = 'contact'
            action = 'contactReport'
        }

        name groupContactReport: "/group/" {
            controller = 'contact'
            action = 'groupContactReport'
        }

        "/api/contacts" (
            controller : 'contactApi',
            action : 'index',
            method : 'GET'
        )

        "/api/contacts/$id" (
                controller : 'contactApi',
                action : 'show',
                method : 'GET'
        )

        "/api/contacts" (
                controller : 'contactApi',
                action : 'save',
                method : 'POST'
        )

        "/api/contacts/$id" (
                controller : 'contactApi',
                action : 'update',
                method : 'PUT'
        )

        "/api/contacts/$id" (
                controller : 'contactApi',
                action : 'delete',
                method : 'DELETE'
        )

        name pizzas: "/pizzas" (
                controller : 'pizza',
                action : 'pizza',
                method : 'get'
        )

        name orders: "/orders" (
                controller : 'pizza',
                action : 'order',
                method : 'GET'
        )


        "/"(view:"/index")
        "500"(view:'/error')
	}
}
