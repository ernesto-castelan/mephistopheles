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
        <br>
        <table class="table table-bordered table-hover table-sm col-sm-6">
            <thead class="thead-dark">
                <tr>
                    <th>Contacto</th>
                    <th>Detalles</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${contactInstance}">
                    <tr>
                        <td>Nombre</td>
                        <td>${contactInstance.name}</td>
                    </tr>
                    <tr>
                        <td>Apellido Paterno</td>
                        <td>${contactInstance.fatherLastName}</td>
                    </tr>
                    <tr>
                        <td>Apellido Materno</td>
                        <td>${contactInstance.motherLastName}</td>
                    </tr>
                    <tr>
                        <td>Teléfono celular</td>
                        <td>${contactInstance.mobilePhone}</td>
                    </tr>
                    <tr>
                        <td>Teléfono de casa</td>
                        <td>${contactInstance.homePhone}</td>
                    </tr>
                    <tr>
                        <td>Parentezco</td>
                        <td>${contactInstance.relationship}</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
        <g:link class="btn btn-info" action="edit" controller="contact" id="${contactInstance.id}" >Editar</g:link>
        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
            Eliminar
        </button>

        <br>
        <br>


        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Mephistopheles App</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ¿Está seguro de querer eliminar el registro?
                    </div>
                    <div class="modal-footer">
                        <g:link class="btn btn-danger" action="delete" controller="contact" id="${contactInstance.id}" >Eliminar</g:link>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>


    </div>
</body>
</html>