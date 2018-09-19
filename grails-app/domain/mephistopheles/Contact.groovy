package mephistopheles

class Contact {

    String name
    String fatherLastName
    String motherLastName
    String homePhone
    String mobilePhone
    String relationShip

    static constraints = {
        name size: 1..30
        fatherLastName size: 1..30
        motherLastName size: 1..30
        mobilePhone matches: "[0-9]+", size: 8..12
        homePhone matches: "[0-9]+", size: 8..12
        relationShip size: 3..25
    }

    @Override
    String toString() {
        return name + " " + fatherLastName + " " + relationShip
    }
    static mapping = {
        version false
    }
}
