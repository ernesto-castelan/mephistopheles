<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="layout" content="contactmain" />
</head>
<body>

    <div class="container mb-2">
        <g:link class="btn btn-info" action="index"><g:message code="contact.allContacts.label" /></g:link>
    </div>
    <div class="container border border-secondary rounded p-3">
        <table class="table table-bordered table-hover table-sm col-sm-6">
            <thead class="thead-dark">
                <tr>
                    <th><g:message code="contact.contact.label" /></th>
                    <th><g:message code="" /></th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${contactInstance}">
                    <tr>
                        <td><g:message code="contact.name.label" /></td>
                        <td>${contactInstance.name}</td>
                    </tr>
                    <tr>
                        <td><g:message code="contact.fatherLastName.label" /></td>
                        <td>${contactInstance.fatherLastName}</td>
                    </tr>
                    <tr>
                        <td><g:message code="contact.motherLastName.label" /></td>
                        <td>${contactInstance.motherLastName}</td>
                    </tr>
                    <tr>
                        <td><g:message code="contact.mobilePhone.label" /></td>
                        <td>${contactInstance.mobilePhone}</td>
                    </tr>
                    <tr>
                        <td><g:message code="contact.homePhone.label" /></td>
                        <td>${contactInstance.homePhone}</td>
                    </tr>
                    <tr>
                        <td><g:message code="contact.relationship.label" /></td>
                        <td>${contactInstance.relationship}</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
        <g:link class="btn btn-info" action="edit" controller="contact" id="${contactInstance.id}" ><g:message code="view.show.editContact" /></g:link>
        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"><g:message code="contact.delete.label" /></button>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"><g:message code="contact.layout.header" /></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <g:message code="modal.window.header" />
                    </div>
                    <div class="modal-footer">
                        <g:link class="btn btn-danger" action="delete" controller="contact" id="${contactInstance.id}" ><g:message code="contact.delete.label" /></g:link>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal"><g:message code="contact.cancel.label" /></button>
                    </div>
                </div>
            </div>
        </div>


    </div>
</body>
</html>