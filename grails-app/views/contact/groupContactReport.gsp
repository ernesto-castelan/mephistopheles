<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="layout" content="contactmain" />
</head>
<body>
    <div class="container mb-3">
        <g:link class="btn btn-info" action="index"><g:message code="contact.allContacts.label" /></g:link>
    </div>
    <div class="container table-responsive">
        <table class="table table-bordered table-hover table-sm col-sm-6">
            <caption><g:message code="report.relationship.label" /></caption>
            <thead class="thead-dark">
            <tr>
                <th><g:message code="contact.relationship.label" /></th>
                <th><g:message code="report.quantity.label" /></th>
            </tr>
            </thead>
            <tbody>
            <g:each var="contactReportInstance" in="${groupContactList}">
                <tr>
                    <td><g:link class="badge badge-success" mapping="contactReport" params="[relationship: contactReportInstance.relationship]" >${contactReportInstance.relationship}</g:link></td>
                    <td>${contactReportInstance.count}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</body>
</html>