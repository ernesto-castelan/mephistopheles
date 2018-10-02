<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="contactmain" />
</head>
<body>

<div class="container">
    <g:link class="btn btn-success" mapping="pizzas" ><g:message code="pizza.allPizzas.label" /></g:link>
    <g:link class="btn btn-success" mapping="orders" ><g:message code="pizza.allOrders.label" /></g:link>
</div>
<br>
<div class="container table-responsive">
    <table class="table table-bordered table-hover table-sm">
        <caption><g:message code="view.pizzaDetail.captionTable"/></caption>
        <thead class="thead-dark">
        <tr>
            <th><g:message code="pizza.title.label" /></th>
            <th><g:message code="pizza.description.label" /></th>
            <th><g:message code="pizza.price.label" /></th>
            <th><g:message code="pizza.thumbnail.label" /></th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${pizzaDetail}">
            <tr>
                <td>${pizzaDetail.title}</td>
                <td>${pizzaDetail.description}</td>
                <td>$ ${pizzaDetail.price}</td>
                <td><g:img width="100" height="100" class="img-thumbnail" uri="${pizzaDetail.thumbnail}"/></td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

</body>
</html>