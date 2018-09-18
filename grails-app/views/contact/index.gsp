<html>
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
		<body>
		<p>Contact List</p>
		<table style="width:100%">
			<tr>
				<th>Name</th>
				<th>Father Lastname</th>
				<th>Mother Lastname</th>
				<th>Mobile Phone</th>
				<th>Home Phone</th>
				<th>Relationship</th>
				<th>Delete</th>
			</tr>
			<g:each var="contactInstance" in="${contactList}">
				<tr>
					<td><g:link action="show" id="${contactInstance.id}" >${contactInstance.name}</g:link></td>
					<td>${contactInstance.fatherLastName}</td>
					<td>${contactInstance.motherLastName}</td>
					<td>${contactInstance.mobilePhone}</td>
					<td>${contactInstance.homePhone}</td>
					<td>${contactInstance.relationship}</td>
					<td><g:link action="delete" id="${contactInstance.id}" > Eliminar ${contactInstance.name} </g:link></td>
				</tr>
			</g:each>
        </table>
        <g:link action="create" > Nuevo Contacto </g:link>


        </body>
</html>