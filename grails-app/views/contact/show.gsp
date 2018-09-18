<html>
<head>
    <head>
        <style>
		table {
		font-family: arial, sans-serif;
		border-collapse: collapse;
		width: 100%;
		}

		td, th {
		border: 1px solid #dddddd;
		text-align: left;
		padding: 8px;
		}

		tr:nth-child(even) {
		background-color: #dddddd;
		}
		</style>
    </head>
</head>
<body>
    <p>Contact Show View</p>

    <!--<g:form action="update"  controller="contact" id = "${contactInstance.id}" >
        Name: <input type="text" name="name" value="${contactInstance.name}"><br>
        Father Last name: <input type="text" name="fatherLastName" value="${contactInstance.fatherLastName}"><br>
        Mother Last name: <input type="text" name="motherLastName" value="${contactInstance.motherLastName}"><br>
        Home Phone: <input type="text" name="homePhone" value="${contactInstance.homePhone}"><br>
        Mobile Phone: <input type="text" name="mobilePhone" value="${contactInstance.mobilePhone}"><br>
        Relation Ship: <input type="text" name="relationship" value="${contactInstance.relationship}"><br>
        <g:submitButton name="update" value="Actualizar" />
        <!-- <g:link action="update" id="${contactInstance.id}" > Actualizar </g:link></td> -->
        <!--<g:link action="update" id="${contactInstance.id}"> Actualizar ${contactInstance.name}</g:link>-->
        <!--</g:form>-->

    <g:each in="${contactInstance}">
        <p>Name: ${contactInstance.name}</p>
        <p>Father Last Name: ${contactInstance.fatherLastName}</p>
        <p>Mother Last Name: ${contactInstance.motherLastName}</p>
        <p>Home Phone: ${contactInstance.homePhone}</p>
        <p>Mobile Phone: ${contactInstance.mobilePhone}</p>
        <p>Relationship: ${contactInstance.relationship}</p>
    </g:each>
    <g:link action="index" > Contactos </g:link><br>
    <g:link action="edit" controller="contact" id = "${contactInstance.id}" > Editar </g:link>


    <!--<g:form action="update" controller="contact" id = "${contactInstance.id}" >
            <g:render template="form"/>
            <g:submitButton name="update" value="Actualizar" />
    </g:form>
    <g:link action="index" > Contactos </g:link>-->

</body>
</html>