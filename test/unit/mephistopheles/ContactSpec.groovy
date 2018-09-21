package mephistopheles

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Contact)
class ContactSpec extends Specification{

    @Unroll("Test '#reason' resulted #result with #expectedErrorCount errors")
    void "Validate constraints"() {
        when: "A new instance"
        Contact contactInstance = new Contact(name:name,
                                              fatherLastName: fatherLastName,
                                              motherLastName: motherLastName,
                                              homePhone: homePhone,
                                              mobilePhone: mobilePhone,
                                              relationship: relationship)
        //println getProperties(contactInstance)
        and: "A pair of instances to test uniqueness"
        new Contact(name:"Pedro",
                fatherLastName: "Pica",
                motherLastName: "Piedra",
                homePhone: "11223344",
                mobilePhone: "44556677",
                relationship: "Esposo").save(flush: true, failOnError:true)
        assert Contact.count() == 1

        then: "Validate fields"
        result == contactInstance.validate()
        and: "Error count is expected"
        expectedErrorCount == contactInstance.errors.errorCount

        where:
        name            |fatherLastName |motherLastName    |homePhone       |mobilePhone    |relationship ||result    |expectedErrorCount |reason
        "Pedro"         |"Pica"         |"Piedra"          | "11223344"     |"99887766"     |"Esposo"     ||true      |0                  |"All good :-)"
        null            |null           |null              |null            |null           |null         ||false     |6                  |"All bad :-("

        //name
        null            |"Pica"         |"P5555"          | "11223344"  |"44556677"  |"Esposo"     ||false     |1                  |"name is null"
        ""              |"Pica"         |"P5555"          | "11223344"  |"44556677"  |"Esposo"     ||false     |1                  |"name is blank"
        "Pedro"*8       |"Pica"         |"P5555"          | "11223344"  |"44556677"  |"Esposo"     ||false     |1                  |"name is above maximum size (30)"
        "p"*30          |"Pica"         |"P5555"          | "11223344"  |"44556677"  |"Esposo"     ||true      |0                  |"name is ok"

        //fatherLastName
        "Pedro"         |null           |"Piedra"          | "11223344"  |"44556677"  |"Esposo"     ||false     |1                  |"fatherLastName is null"
        "Pedro"         |""             |"Piedra"          | "11223344"  |"44556677"  |"Esposo"     ||false     |1                  |"fatherLastName is blank"
        "Pedro"         |"Pica"*9       |"Piedra"          | "11223344"  |"44556677"  |"Esposo"     ||false     |1                  |"fatherLastName is above maximum size (30)"
        "Pedro"         |"P"*2          |"Piedra"          | "11223344"  |"44556677"  |"Esposo"     ||true      |0                  |"fatherLastName is ok"

        //motherLastName
        "Pedro"         |"Pica"        |null               | "11223344"  |"44556677"  |"Esposo"     ||false     |1                  |"motherLastName is null"
        "Pedro"         |"Pica"        |""                 | "11223344"  |"44556677"  |"Esposo"     ||false     |1                  |"motherLastName is blank"
        "Pedro"         |"Pica"        |"P"*31             | "11223344"  |"44556677"  |"Esposo"     ||false     |1                  |"motherLastName is above maximum size (30)"
        "Pedro"         |"Pica"        |"P"*2              | "11223344"  |"44556677"  |"Esposo"     ||true      |0                  |"motherLastName is ok"

        //homePhone
        "Pedro"         |"Pica"        |"Piedra"           |null            |"44556677"  |"Esposo"     ||false     |1                  |"homePhone is null"
        "Pedro"         |"Pica"        |"Piedra"           |""              |"44556677"  |"Esposo"     ||false     |1                  |"homePhone is blank"
        "Pedro"         |"Pica"        |"Piedra"           |"1"*13          |"44556677"  |"Esposo"     ||false     |1                  |"homePhone is above maximum size (13)"
        "Pedro"         |"Pica"        |"Piedra"           |"0000000000"    |"44556677"  |"Esposo"     ||true      |0                  |"homePhone is ok"
        "Pedro"         |"Pica"        |"Piedra"           |"11*11-11-11"   |"44556677"  |"Esposo"     ||false     |1                  |"homePhone does not match with [0-9]*"

        //mobilePhone
        "Pedro"        |"Pica"        |"Piedra"           | "11223344"  |null           |"Esposo"     ||false     |1                  |"mobilePhone is null"
        "Pedro"        |"Pica"        |"Piedra"           | "11223344"  |""             |"Esposo"     ||false     |1                  |"mobilePhone is blank"
        "Pedro"        |"Pica"        |"Piedra"           | "11223344"  |"5"*13         |"Esposo"     ||false     |1                  |"mobilePhone is above maximum size (13)"
        "Pedro"        |"Pica"        |"Piedra"           | "11223344"  |"88008800"     |"Esposo"     ||true      |0                  |"mobilePhone is ok"
        "Pedro"        |"Pica"        |"Piedra"           | "11223344"  |"11-11-11*10"  |"Esposo"     ||false     |1                  |"mobilePhone does not match with [0-9]*"

        //relationship
        "P"*10  |"Pica"        |"Piedra"           | "11223344"  |"44556677"  |null         ||false     |1                  |"relationship is null"
        "P"*10  |"Pica"        |"Piedra"           | "11223344"  |"44556677"  |""           ||false     |1                  |"relationship is blank"
        "P"*10  |"Pica"        |"Piedra"           | "11223344"  |"44556677"  |"Esposo"*5   ||false     |1                  |"relationship is above maximum size (25)"
        "P"*10  |"Pica"        |"Piedra"           | "11223344"  |"44556677"  |"Esposo"     ||true      |0                  |"relationship is ok"

    }

    void "Validates toString method"() {
        given:"A Contact"
        Contact contactInstance =  new Contact(name:"Pedro",
                fatherLastName: "Pica",
                motherLastName: "Piedra",
                homePhone: "11223344",
                mobilePhone: "44556677",
                relationship: "Esposo")
        contactInstance.save(flush: true)
        assert Contact.count() == 1

        when:"Calling toString method"
        String toString = contactInstance.toString()

        then:"String is correct"
        toString == "Pedro Pica Esposo"
    }




}
