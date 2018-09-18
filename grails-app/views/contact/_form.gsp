<div class="">
    <label for="name">
        Name: 
    </label>
    <g:textField name="name" maxlength="30" required="" value="${contactInstance?.name}"/>
</div>

<div class="">
    <label for="fatherLastName">
        Father Last Name: 
    </label>
    <g:textField name="fatherLastName" maxlength="30" required="" value="${contactInstance?.fatherLastName}"/>
</div>

<div class="">
    <label for="motherLastName">
        Mother Last Name: 
    </label>
    <g:textField name="motherLastName" maxlength="30" required="" value="${contactInstance?.motherLastName}"/>
</div>

<div class="">
    <label for="homePhone">
        Home Phone: 
    </label>
    <g:textField name="homePhone" maxlength="12" required="" value="${contactInstance?.homePhone}"/>
</div>

<div class="">
    <label for="mobilePhone">
        Mobile Phone: 
    </label>
    <g:textField name="mobilePhone" maxlength="12" required="" value="${contactInstance?.mobilePhone}"/>
</div>

<div class="">
    <label for="relationship">
        Relationship: 
    </label>
    <g:textField name="relationship" maxlength="25" required="" value="${contactInstance?.relationship}"/>
</div>
