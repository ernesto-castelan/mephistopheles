package mephistopheles

class Contact {
    static belongsTo = [user: User]

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
        mobilePhone matches: "([0-9]{2}[-]*){4}"
        homePhone matches: "([0-9]{2}[-]*){4}"
        relationShip size: 3..25
    }

    static mapping = {
        version false
    }
}
