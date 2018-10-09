<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="layout" content="contactmain" />
    <asset:stylesheet src="validationEngine.jquery.css"/>
    <asset:stylesheet src="template.css"/>
    <asset:javascript src="jquery.validationEngine-es.js" charset="utf-8"/>
    <asset:javascript src="jquery.validationEngine.js" charset="utf-8"/>
    <asset:javascript src="jqvalidatione.js"/>
</head>
<body>
    <div class="container mb-3">
        <g:link class="btn btn-info" action="index"><g:message code="contact.allContacts.label" /></g:link>
    </div>
    <div class="container border border-secondary rounded p-2">
        <p><g:message code="view.edit.updateContact" /></p>

        <g:render template="errors"/>

        <g:form action="update" controller="contact" name="contactForm" id = "${contactInstance.id}" >
            <g:render template="form"/>
            <g:submitButton class="btn btn-info" name="update" value="Guardar" />
            <g:link type="button" class="btn btn-secondary" action="show" id = "${contactInstance.id}"><g:message code="view.edit.cancelContact"/></g:link>
        </g:form>
    </div>
</body>
</html>