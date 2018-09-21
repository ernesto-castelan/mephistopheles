<g:hasErrors>
    <div class="container alert alert-danger" role="alert">
        <h5 class="display5">Por favor verifica los siguientes errores:</h5>
        <g:eachError >
            <ul>
                <li><g:message error="${it}"/></li>
            </ul>
        </g:eachError>
    </div>
</g:hasErrors>
