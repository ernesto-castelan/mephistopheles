package mephistopheles

class PizzaResult {

    String id
    String description
    Double price
    String thumbnail
    String title
    String url

    @Override
    String toString() {
        return "$id, $description, $price, $thumbnail, $title $url"
    }
}
