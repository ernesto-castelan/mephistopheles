package mephistopheles

class User {
    static hasMany = [contacts: Contact]

    String name
    String fatherLastName
    String motherLastName
    Date admissionDate
    Date birthDate
    Date separationDate
    Gender gender
    String homePhone
    String mobilePhone
    String ineNumber
    String socialSecurityNumber
    String address
    String personalEmail
    String jobEmail
    String bankAccountKey
    String gitHubAccount
    Boolean active

    static constraints = {
        name size: 1..30, blank:false
        fatherLastName size: 1..30, blank: false
        motherLastName size: 1..30, nullable: true
        admissionDate max: new Date()
        birthDate max: new Date() - 6570
        separationDate validator: { Date separationDate, User user-> (separationDate > (user.admissionDate + 30))}
        homePhone matches: "([0-9]{2}[-]*){4}"
        mobilePhone matches: "([0-9]{2}[-]*){4}"
        ineNumber matches: "[0-9]{10}", unique: true
        socialSecurityNumber matches: "[0-9]{10}", unique: true
        address size: 10..200, blank: false, unique: false
        personalEmail email:true, nullable: true, unique:true
        jobEmail email:true, unique:true
        bankAccountKey matches: "[0-9]{18}", unique: true
        gitHubAccount size: 1..30, blank: false, unique: true
    }

    static mapping = {
        version false
    }
}
