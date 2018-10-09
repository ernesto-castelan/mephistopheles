<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="layout" content="contactmain" />
</head>
<body>

	<div class="container">
		<g:link class="btn btn-success" action="create" ><g:message code="view.index.newContact" /></g:link>
		<g:link class="btn btn-info" mapping="groupContactReport"><g:message code="view.index.contactReport" /></g:link></td>
	</div>
	<br>
	<div class="container table-responsive">
		<table class="table table-bordered table-hover table-sm">
			<caption><g:message code="view.index.captionTable"/></caption>
			<thead class="thead-dark">
				<tr>
					<th><g:message code="contact.name.label" /></th>
					<th><g:message code="contact.fatherLastName.label" /></th>
					<th><g:message code="contact.motherLastName.label" /></th>
					<th><g:message code="contact.mobilePhone.label" /></th>
					<th><g:message code="contact.homePhone.label" /></th>
					<th><g:message code="contact.relationship.label" /></th>
					<th><g:message code="contact.details.label" /></th>
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
						<td>${contactInstance.relationship}
						<td><g:link class="badge badge-success" action="show" id = "${contactInstance.id}" ><g:message code="contact.viewDetails.label" /></g:link></td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>

</body>
</html>