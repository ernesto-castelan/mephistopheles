<g:hasErrors>
    <div class="container alert alert-danger" role="alert">
        <h5 class="display5"><g:message code="template.errors.message" /></h5>
        <g:eachError >
            <ul>
                <li><g:message error="${it}"/></li>
            </ul>
        </g:eachError>
    </div>
</g:hasErrors>
