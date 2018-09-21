<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="layout" content="contactmain" />
</head>
<body>
    <div class="container">
        <g:link class="btn btn-info" action="index">Todos los contactos</g:link>
    </div>
    <br>
    <div class="container border border-secondary rounded">
        <p>Nuevo contacto</p>

        <g:render template="errors"/>

        <g:form action="save" controller="contact"  >
            <g:render template="form"/>
            <g:submitButton class="btn btn-success" name="update" value="Guardar contacto" />
        </g:form>
        <br>
    </div>

</body>
</html>