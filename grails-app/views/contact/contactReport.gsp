<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="layout" content="contactmain" />
</head>
<body>
    <div class="container mb-3">
        <g:link class="btn btn-info" action="index"><g:message code="contact.allContacts.label" /></g:link>
        <g:link class="btn btn-info" mapping="groupContactReport"><g:message code="contact.report.label" /></g:link></td>
    </div>
    <div class="container table-responsive">
        <table class="table table-bordered table-hover table-sm">
            <caption><g:message code="contact.report.label" /></caption>
            <thead class="thead-dark">
            <tr>
                <th><g:message code="contact.name.label" /></th>
                <th><g:message code="contact.fatherLastName.label" /></th>
                <th><g:message code="contact.motherLastName.label" /></th>
                <th><g:message code="contact.mobilePhone.label" /></th>
                <th><g:message code="contact.homePhone.label" /></th>
                <th><g:message code="contact.relationship.label" /></th>
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