<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><g:message code="showreport.title" /></title>
    <meta name="layout" content="contactmain" />
</head>
<body>
    <div class="container">
        <g:link class="btn btn-info" action="index">Todos los contactos</g:link>
    </div>
<br>
    <div class="container table-responsive">
        <table class="table table-bordered table-hover table-sm">
            <caption>Reporte</caption>
            <thead class="thead-dark">
            <tr>
                <th>Nombre</th>
                <th>Apellido Paterno</th>
                <th>Apellido Materno</th>
                <th>Teléfono celular</th>
                <th>Teléfono de casa</th>
                <th>Parentezco</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="contactInstance" in="${contactList}">
                <tr>
                    <td>${contactInstance.name}</td>
                    <td>${contactInstance.fatherLastName}</td>
                    <td>${contactInstance.motherLastName}</td>
                    <td>${contactInstance.mobilePhone}</td>
                    <td>${contactInstance.homePhone}</td>
                    <td>${contactInstance.relationship}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</body>
</html>