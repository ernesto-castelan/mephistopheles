class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        name contactList: "/details/$relationship" {
            controller = 'contact'
            action = 'report'
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
