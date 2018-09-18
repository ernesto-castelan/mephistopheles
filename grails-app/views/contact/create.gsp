<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Contact</title>
</head>
<body>
    <p>Nuevo contacto</p>
    <!--<g:form name="myForm" url="[action:'save', controller:'contact']">
        <p>Name: <input type="text" name="name"></p>
        <p>Father Last name: <input type="text" name="fatherLastName"></p>
        <p>Mother Last name: <input type="text" name="motherLastName"></p>
        <p>Home Phone: <input type="text" name="homePhone"></p>
        <p>Mobile Phone: <input type="text" name="mobilePhone"></p>
        <p>Relation Ship: <input type="text" name="relationship"></p>
        <g:submitButton name="create" value="Crear contacto" />
    </g:form>-->

    <g:render template="errors"/>


    <g:form action="save" controller="contact"  >
        <g:render template="form"/>
        <g:submitButton name="update" value="Crear contacto" />
    </g:form>



</body>
</html>