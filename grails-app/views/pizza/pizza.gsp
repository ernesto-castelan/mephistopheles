<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="contactmain" />
</head>
<body>

    <div class="container p-3">
        <h3 class="display3"><g:message code="view.pizza.message" /></h3>
    </div>
    <div class="container table-responsive">
        <table class="table table-bordered table-hover table-sm">
            <caption><g:message code="view.pizza.captionTable"/></caption>
            <thead class="thead-dark">
            <tr>
                <th><g:message code="pizza.title.label" /></th>
                <th><g:message code="pizza.description.label" /></th>
                <th><g:message code="pizza.price.label" /></th>
                <th><g:message code="pizza.thumbnail.label" /></th>
                <th><g:message code="pizza.order.label" /></th>
                <th><g:message code="pizza.detail.label" /></th>
            </tr>
            </thead>
            <tbody>
            <g:each var="pizzaInstance" in="${pizzaList}">
                <tr>
                    <td>${pizzaInstance.title}</td>
                    <td>${pizzaInstance.description}</td>
                    <td>$ ${pizzaInstance.price}</td>
                    <td><g:img width="100" height="100" class="img-thumbnail" uri="${pizzaInstance.thumbnail}"/></td>
                    <td><g:link class="badge badge-success" action="orderPizza" id = "${pizzaInstance.id}" ><g:message code="pizza.order.label" /></g:link></td>
                    <td><g:link class="badge badge-success" action="pizzaDetail" id = "${pizzaInstance.id}"><g:message code="pizza.viewDetails.label" /></g:link></td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</body>
</html>