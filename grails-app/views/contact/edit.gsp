<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="layout" content="contactmain" />
    <asset:javascript src="validation.js"/>
    <asset:stylesheet src="contact.form.css"/>
</head>
<body>
    <div class="container">
        <g:link class="btn btn-info" action="index">Todos los contactos</g:link>
    </div>
    <br>
    <div class="container border border-secondary rounded">
        <p>Actualizar contacto</p>

        <g:render template="errors"/>

        <g:form action="update" controller="contact" name="contactForm" id = "${contactInstance.id}" >
            <g:render template="form"/>
            <g:submitButton class="btn btn-info" name="update" value="Guardar" />
            <g:link type="button" class="btn btn-secondary" action="show" id = "${contactInstance.id}">Cancelar</g:link>
        </g:form>
        <br>
    </div>
</body>
</html>