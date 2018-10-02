package mephistopheles

class PizzaController {

    PizzaService pizzaService
    static defaultAction = "pizza"
    def pizza(){
        def pizzaList = pizzaService.pizza()
        flash.message = "Detalle de la pizza"
        return [pizzaList: pizzaList]
    }
    def pizzaDetail(String id){
        def pizzaDetail = pizzaService.pizzaDetail(id)
        return [pizzaDetail: pizzaDetail]
    }

    def orderPizza(String id){
        pizzaService.orderPizza(id)
        flash.message = "Su pizza ha sido ordenada"
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
}
