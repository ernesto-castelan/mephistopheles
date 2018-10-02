package mephistopheles

class PizzaOrder {

    String id
    Double price
    String thumbnail
    String title

    @Override
    String toString() {
        return "$id, $price, $thumbnail, $title"
    }
}
