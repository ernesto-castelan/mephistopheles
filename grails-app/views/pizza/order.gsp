<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="contactmain" />
</head>
<body>

<div class="container">
    <h3 class="display3"><g:message code="view.order.message" /></h3>
    <g:link class="btn btn-success" mapping="pizzas" ><g:message code="pizza.allPizzas.label" /></g:link>

</div>
<br>
<div class="container table-responsive">
    <table class="table table-bordered table-hover table-sm">
        <caption><g:message code="view.pizza.captionTable"/></caption>
        <thead class="thead-dark">
        <tr>
            <th><g:message code="pizza.title.label" /></th>
            <th><g:message code="pizza.price.label" /></th>
            <th><g:message code="pizza.thumbnail.label" /></th>
            <th><g:message code="pizza.delete.label" /></th>
        </tr>
        </thead>
        <tbody>
        <g:each var="orderInstance" in="${orderList}">
            <tr>
                <td>${orderInstance.title}</td>
                <td>$ ${orderInstance.price}</td>
                <td><g:img width="100" height="100" class="img-thumbnail" uri="${orderInstance.thumbnail}"/></td>
                <td><g:link class="badge badge-danger" action="deletePizza" id = "${orderInstance.id}" ><g:message code="pizza.delete.label" /></g:link></td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

</body>
</html>