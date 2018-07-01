**Order Card**

Springboot application has been developed to Order Card. 

Each API (CustomerCardManagementAPI, OpalCardAPI) can be developed as MicroServices. However, this has been developed as part of one application for simplicity purpose

System has been coded for interfaces and implmentations can be changed without affecting consumers.

Layered approach has been followed
    
    * /dao - This is plain stub at the moment. However this can be connected to external systems. This implements interface and it allows to change implementations
    * /delegate - This can be used to delete to any other layers
    * /domain
    * /service - API layer
    


**Running Application**

mvn clean install -DskipTests

java -jar target/opal-0.0.1-SNAPSHOT.jar

Run CustomerOpalCardManagementServiceTest

**CustomerCardManagementAPI**

This API implements Card Ordering System

Assumption:
    
    1. Card will be ordered for existing customer
    
    2. This API doesn't include Customer Creation

**OpalCardAPI**

This implementation handles Card related activities. 
This API can be used to retrieve card, add card, update card, delete card

**Improvements*

Following improvement can be made

    1. More Unit testing and Integration Testing. 
    2. Implementation of PaymentAPI, PostageServiceAPI
    3. Toggling - This can be used to toggle between different implementation. eg: PaymentService Implementation
    4. Factory pattern to drive different implementation


