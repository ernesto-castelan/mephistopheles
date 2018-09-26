<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="layout" content="contactmain" />
</head>
<body>

	<div class="container">
		<g:link class="btn btn-success" action="create" > Nuevo Contacto </g:link>
	</div>
	<br>
	<div class="container table-responsive">
		<table class="table table-bordered table-hover table-sm">
			<caption>Contact List</caption>
			<thead class="thead-dark">
				<tr>
					<th>Nombre</th>
					<th>Apellido Paterno</th>
					<th>Apellido Materno</th>
					<th>Teléfono celular</th>
					<th>Teléfono de casa</th>
					<th>Parentezco</th>
					<th>Detalles</th>
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
						<td><g:link class="badge badge-success" action="show" id="${contactInstance.id}" >Ver</g:link></td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>

</body>
</html>