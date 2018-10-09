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


        "/"(view:"/index")
        "500"(view:'/error')
	}
}
