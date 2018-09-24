
    <div class="form-group row">
        <label for="name" class="col-sm-2 col-form-label">Nombre:</label>
        <g:textField class="form-control col-sm-9" placeholder="Nombre"  name="name" minlength="1" maxlength="30" value="${contactInstance?.name}" required=""/>
    </div>

    <div class="form-group row">
        <label for="fatherLastName" class="col-sm-2 col-form-label">Apellido Paterno:</label>
        <g:textField class="form-control col-sm-9" placeholder="Apellido Paterno" name="fatherLastName" maxlength="30" required="" value="${contactInstance?.fatherLastName}"/>
    </div>

    <div class="form-group row">
        <label for="motherLastName" class="col-sm-2 col-form-label">Apellido Materno:</label>
        <g:textField class="form-control col-sm-9" placeholder="Apellido Materno" name="motherLastName" maxlength="30" required="" value="${contactInstance?.motherLastName}"/>
    </div>

    <div class="form-group row">
        <label for="homePhone" class="col-sm-2 col-form-label">Teléfono celular:</label>
        <g:textField class="form-control col-sm-9" placeholder="Teléfono celular" name="mobilePhone" maxlength="12" required="" value="${contactInstance?.mobilePhone}"/>
    </div>

    <div class="form-group row">
        <label for="mobilePhone" class="col-sm-2 col-form-label">Teléfono de casa:</label>
        <g:textField class="form-control col-sm-9" placeholder="Teléfono de casa" name="homePhone" maxlength="12" required="" value="${contactInstance?.homePhone}"/>
    </div>

    <div class="form-group row">
        <label for="relationship" class="col-sm-2 col-form-label">Parentezco:</label>
        <g:textField class="form-control col-sm-9" placeholder="Parentezco" name="relationship" maxlength="25" required="" value="${contactInstance?.relationship}"/>
    </div>
