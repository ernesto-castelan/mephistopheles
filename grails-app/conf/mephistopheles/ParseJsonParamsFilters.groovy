package mephistopheles

import org.codehaus.groovy.grails.web.converters.exceptions.ConverterException
import grails.converters.JSON

class ParseJsonParamsFilters {

    def filters = {
        contactFilter(controller:'contactApi') {
            before = {
                try {
                    if (request.JSON) {
                        params << request.JSON
                    }
                }
                catch (ConverterException e) {
                    response.setContentType('application/json')
                    response.status = 400
                    render([message:'invalid JSON', description:'Request contains invalid JSON'] as JSON)
                    false
                }
            }
        }
    }
}
