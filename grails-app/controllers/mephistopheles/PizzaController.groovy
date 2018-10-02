package mephistopheles

class PizzaController {

    PizzaService pizzaService

    def pizza(){
        def pizzaList = pizzaService.pizza()
        return [pizzaList: pizzaList]
    }
    def pizzaDetail(String id, String message){
        def pizzaDetail = pizzaService.pizzaDetail(id)
        return [pizzaDetail: pizzaDetail]
    }

    def orderPizza(String id){
        pizzaService.orderPizza(id)
        redirect (action:'pizzaDetail', id: id)
    }

    def order(){
        def orderList = pizzaService.order()
        return [orderList: orderList]
    }

    def deletePizza(String id){
        pizzaService.deletePizza(id)
        redirect action:'order'
    }

    def index() {
        redirect (action:'pizza')
    }
}
