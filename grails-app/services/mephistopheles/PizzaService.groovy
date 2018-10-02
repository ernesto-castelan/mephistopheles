package mephistopheles


import grails.transaction.Transactional
import groovyx.net.http.RESTClient



@Transactional
class PizzaService {

    private static final String API_PATH = 'https://us-central1-ios-interviews.cloudfunctions.net/'
    private static final String PIZZA = 'pizza/'
    private static final String ORDER = 'order/'

    void orderPizza(String id){
        RESTClient restClient = new RESTClient(API_PATH)
        Map headers = [Authorization: "token: J5nKdbm5giWb6GYkbHg2dxcUp4C3"]
        def resp = restClient.post(path: "pizza/$id/order", headers: headers)
    }

    List<PizzaResult> pizza(){
        RESTClient restClient = new RESTClient(API_PATH)
        Map headers = [Authorization: "token: J5nKdbm5giWb6GYkbHg2dxcUp4C3"]
        def resp = restClient.get(path: PIZZA, headers: headers)

        List<PizzaResult> pizzaList
        pizzaList = resp.data.collect { key, value ->
            new PizzaResult(id: key.toString(),
                    description: value.get('description'),
                    price: value.get('price'),
                    thumbnail: value.get('thumbnail'),
                    title: value.get('title'),
                    url: value.get('url'))
        }
        pizzaList
    }

    List<PizzaOrder> order(){
        RESTClient restClient = new RESTClient(API_PATH)
        Map headers = [Authorization: "token: J5nKdbm5giWb6GYkbHg2dxcUp4C3"]
        def resp = restClient.get(path: ORDER, headers: headers)

        List<PizzaOrder> orderList
        orderList = resp.data.collect { key, value ->
            new PizzaOrder(id: key.toString(),
                    price: value.get('price'),
                    thumbnail: value.get('thumbnail'),
                    title: value.get('title'))
        }
        orderList
    }

    void deletePizza(String id) {
        RESTClient restClient = new RESTClient(API_PATH)
        Map headers = [Authorization: "token: J5nKdbm5giWb6GYkbHg2dxcUp4C3"]
        def resp = restClient.delete(path: "order/$id", headers: headers)
    }

    PizzaResult pizzaDetail(String id){
        RESTClient restClient = new RESTClient(API_PATH)
        Map headers = [Authorization: "token: J5nKdbm5giWb6GYkbHg2dxcUp4C3"]
        def resp = restClient.get(path: "pizza/$id", headers: headers)

        PizzaResult pizzaDetail
        pizzaDetail = new PizzaResult(id: id,
                description: resp.data.get('description'),
                price: resp.data.get('price'),
                thumbnail: resp.data.get('thumbnail'),
                title: resp.data.get('title'),
                url: resp.data.get('url'))
        pizzaDetail
    }


        def serviceMethod() {

    }

}
