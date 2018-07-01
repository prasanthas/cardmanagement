**Order Card**

Springboot application has been developed to Order a Card. 

Each API (CustomerCardManagementAPI, OpalCardAPI) can be developed as MicroServices. However, this has been developed as part of one application for simplicity purpose

System has been coded for interfaces, hence implementations can be changed without affecting consumers.

Layered approach has been followed
    
    * /dao - This is plain stub at the moment. However this can be connected to external systems. This implements interface and it allows to change implementations
    * /delegate - This can be used to delete to any other layers
    * /domain
    * /service - API layer
    


**Running Application**

`mvn clean install -DskipTests`

`java -jar target/opal-0.0.1-SNAPSHOT.jar`

Run CustomerOpalCardManagementServiceTest (test/java/au/com/ps/opal/service/CustomerOpalCardManagementServiceTest)

Run CardAPITest - This is the test class for CardAPI

**CustomerCardManagementAPI**

This API implements Card Ordering System


Assumption:
    
    1. Card will be ordered for existing customer. CardType will be part of the OpalCard object. 
    
    2. This API doesn't include Customer Creation. It will only link an existing customer to the card. 

**OpalCardAPI**

This implementation handles Card related interactions. 
This API can be used to retrieve card, add card, update card, delete card

**Improvements*

Following improvement can be made

    1. More Unit testing and Integration Testing. TDD should have been followed.
    2. Implementation of PaymentAPI, PostageServiceAPI
    3. Toggling - This can be used to toggle between different implementation. eg: PaymentService Implementation
    4. Factory pattern to drive different implementation
    5. Error handling - Various error scenarions should be handled.
    6. Code cleanup  


