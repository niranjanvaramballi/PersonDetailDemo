# Getting Started

#Tools Required:
Intellij/Eclipse
JDK 1.8
Postman
Chrome

#Project setup:
Download the project from Git(Git pull) and open in Intellij or Eclipse. 
I have developed in Intellij, hence I will be providing all the intellij setup

#Project Details:
Project consist of settings.xml
Make sure set the local repository in settings.xml. At present, it is pointing to c:/.m2/repository 

#Maven Settings
Goto File -> Settings -> maven 

Maven home directory :  Maven 3 bundle or any maven 3 + version
User settings file : Click on override checkbox and Select the settings.xml from the project
Local repository : Leave it as it(uncheck override checkbox)

#Build
Open Maven panel in the right side of the Intellij and build the project by selecting clean and install

#Run Spring boot app 
Open PersonDetailSpringApplication java and run(ctrl + shift + F10)

#After starting SpringApplication
http://localhost:8080/h2-console

Driver class: org.h2.Driver
JDBC url: jdbc:h2:mem:test
Username: sa
Password: <No password required> 

Click on connect. Run the query in using this. 

Note: Everytime we restart the application, we need to reconnect to this URL to connect to DB.
All the data will be removed.

#Open the Postman and run the below payloads: 
Note: all payloads are entired in row format, hence follow the below steps

Body -> select row (raido button) and select format as JSON instead of TEXT

#Add a person
http://localhost:8080/addPerson

#Payload:
{
    "person" : {
        "firstName" : "Niranjan",
        "lastName" : "Varamballi"
    }
}

#Response:
{
    "pId": 1,
    "firstName": "Niranjan",
    "lastName": "Varamballi"
}

#Update a person
http://localhost:8080/updatePerson

#Payload:
{
    "person" : {
        "pId" : 2,
        "firstName" : "Niranjan",
        "lastName" : "V"
    }
}

#Response:
{
    "pId": 2,
    "firstName": "Niranjan",
    "lastName": "V"
}

#Delete a person
http://localhost:8080/deletePerson/3

#Payload:
None

#Response:
Person details 3 removed..

#count number of Persons
http://localhost:8080/countPersons

#Payload:
None

#Response:
Number of Persons count is 1

#List of Persons
http://localhost:8080/listPersons

#Payload:
None

#Response:
[
    {
        "pId": 1,
        "firstName": "Niranjan",
        "lastName": "Varamballi"
    },
    {
        "pId": 3,
        "firstName": "John",
        "lastName": "S"
    }
]


#Add an address

http://localhost:8080/addAddress

#Payload:
{
    "address" : {
            "street" : "333 S main street",
            "city" : "Salt lake City",
            "state" : "Utah",
            "postalCode" : 84104,
            "person" : {
                "pId" : 1
            }
    }
}

#Response: 
{
    "addId": 2,
    "street": "333 S main street",
    "city": "Salt lake City",
    "state": "Utah",
    "postalCode": 84104,
    "person": {
        "pId": 1,
        "firstName": "Niranjan",
        "lastName": "Varamballi"
    }
}



#Update an address

http://localhost:8080/updateAddress

#Payload:
{
    "address" : {
            "addId" : 7,
            "street" : "22 S main street",
            "city" : "West lake City",
            "state" : "Utah1",
            "postalCode" : 84105,
            "person" : {
                "pId" : 6
            }
    }
}

#Response: 
{
    "addId": 7,
    "street": "22 S main street",
    "city": "West lake City",
    "state": "Utah1",
    "postalCode": 84105,
    "person": {
        "pId": 6,
        "firstName": "Niranjan",
        "lastName": "Varamballi"
    }
}


#Delete an address

http://localhost:8080/deleteAddress/7

#Payload:
None

#Response: 
Address details removed for 7









 






