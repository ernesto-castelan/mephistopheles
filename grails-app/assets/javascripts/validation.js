$().ready(function() {
    $("#contactForm").validate({
        debug: true,
        rules: {
            // simple rule, converted to {required:true}
            name: "required",
            fatherLastName: "required",
            motherLastName: "required",
            homePhone: "required",
            mobilePhone: "required",
            relationship: "required"
        },
        messages: {
            name: "Por favor introduzca su nombre",
            fatherLastName: "Por favor introduzca su apellido paterno",
            motherLastName: "Por favor introduzca su apellido materno",
            homePhone: "Por favor introduzca su teléfono de casa",
            mobilePhone: "Por favor introduzca su teléfono celular",
            relationship: "Por favor introduzca su parentezco"
        }
    });
});