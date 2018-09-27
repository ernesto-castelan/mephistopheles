
    <div class="form-group row">
        <label for="name" class="col-sm-2 col-form-label"><g:message code="contact.name.label" /></label>
        <g:textField class="form-control col-sm-9 validate[required,custom[onlyLetterNumber]]" placeholder="Nombre"  name="name" minlength="1" maxlength="30" value="${contactInstance?.name}"/>
    </div>

    <div class="form-group row">
        <label for="fatherLastName" class="col-sm-2 col-form-label"><g:message code="contact.fatherLastName.label" /></label>
        <g:textField class="form-control col-sm-9 validate[required,custom[onlyLetterNumber]]" placeholder="Apellido Paterno" name="fatherLastName" maxlength="30" value="${contactInstance?.fatherLastName}"/>
    </div>

    <div class="form-group row">
        <label for="motherLastName" class="col-sm-2 col-form-label"><g:message code="contact.motherLastName.label" /></label>
        <g:textField class="form-control col-sm-9 validate[required,custom[onlyLetterNumber]]" placeholder="Apellido Materno" name="motherLastName" maxlength="30"  value="${contactInstance?.motherLastName}"/>
    </div>

    <div class="form-group row">
        <label for="homePhone" class="col-sm-2 col-form-label"><g:message code="contact.mobilePhone.label" /></label>
        <g:textField class="form-control col-sm-9 validate[required,custom[phone]]" placeholder="Teléfono celular" name="mobilePhone" maxlength="12"  value="${contactInstance?.mobilePhone}"/>
    </div>

    <div class="form-group row">
        <label for="mobilePhone" class="col-sm-2 col-form-label"><g:message code="contact.homePhone.label" /></label>
        <g:textField class="form-control col-sm-9 validate[required,custom[phone]]" placeholder="Teléfono de casa" name="homePhone" maxlength="12"  value="${contactInstance?.homePhone}"/>
    </div>

    <div class="form-group row">
        <label for="relationship" class="col-sm-2 col-form-label"><g:message code="contact.relationship.label" /></label>
        <g:textField class="form-control col-sm-9 validate[required,custom[onlyLetterNumber]]" placeholder="Parentezco" name="relationship" maxlength="25"  value="${contactInstance?.relationship}"/>
    </div>
