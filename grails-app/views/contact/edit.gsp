<html>
<body>
    <g:render template="errors"/>

    <g:form action="update" controller="contact" id = "${contactInstance.id}" >
        <g:render template="form"/>
        <g:submitButton name="update" value="Actualizar" />
    </g:form>
    <g:link action="index" > Contactos </g:link>
</body>
</html>