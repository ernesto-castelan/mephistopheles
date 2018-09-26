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
    <div class="container">
        <g:link class="btn btn-info" action="index">Todos los contactos</g:link>
    </div>
    <br>
    <div class="container border border-secondary rounded">
        <p>Nuevo contacto</p>

        <g:render template="errors"/>

        <g:form action="save" controller="contact"  name="contactForm">
            <g:render template="form"/>
            <g:submitButton class="btn btn-success" name="create" value="Guardar contacto" />
        </g:form>
        <br>
    </div>

</body>
</html>