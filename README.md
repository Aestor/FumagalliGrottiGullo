# Software_Engineering_2

# RASD
RASD document was mainly elaborated on a shared Google Doc, to improve team cooperation in the document's production. Once closed to final version it was refined with Latex. It is possible to access it in the delivery folder.

# DD
RASD document was mainly elaborated on a shared Google Doc, to improve team cooperation in the document's production. Once closed to final version it was refined with Latex. It is possible to access it in the delivery folder.

# Implementation

## Configuration

### In short
Import in your IDE as a Maven project. <br>
You need to execute mvn install. Some IDEs (e.g.: Eclipe JEE) automatically execute it when you run the project.<br>
Run the class TravlendarApplication.java as a Java Application.<br>
From your browser navigate to localhost:8080.

### Database configuration with MySQL Workbench
To import the database in your PC:
1. Install MySQL Workbench
2. In the program: Server -> Data Import
3. Select "Import from Self-Contained File" and browse Dump.sql
4. Create a new schema for the Default Target Schema and name it "travlendar" (important)
5. Refresh schemas to see travlendar

### Database configuration with command line
Alternately, create manually a new schema with MySQL Command Line:<br>
Copy and Paste commands from the file _"sql_entries"_ that is accessible in the folder _Implementation_.

### Configure JDBC
To access the database, the application reads the information in the file src/main/resources/application.properties. By default, the application tries to connect to localhost:3306 with username "admin" and password "root", which are the standard settings of MySQL Workbench. 

## Usage

### Login, registration and user's settings
When you first access the website, you will be asked to authenticate. If you choose to register, the application will create one new row in "users" table and one in "user_setting". <br>
When you are logged, you can choose "Settings" in the left bar to customize your account. <br>
Currently, the settings are not really taken in consideration when creating user's events.

### Manage schedule
When logged, click on "Schedule" in the left bar. Here you can see all your events on an interactive calendar.<br>
Click on "Create Event" on the left bar to create a new event. Here you can specify location, description, date, time and other information. When you will have created your event it will be registered on the database in the "events" schema and will be visible in your schedule.

### Google Maps directions
When you choose the location of your event, you will be asked also to set a starting point. It will be needed by the application to calculate the directions and the travel duration to reach the event's location with Google Maps APIs. <br>
Our implementation does not go further, but according to our project design the application should also take in consideration user's setting to narrow down the trasports choice and notify the user of possible conflict with other events on the schedule. <br>
You can also navigate to http://localhost:8080/#!place-search to test Google Maps integration.

### Credit and tickets purchase
With "My Balance" and "My Tickets" in the left bar you can respectively buy credit and transport tickets. <br>
The credit buying will be simulated using Stripe. <br>
To buy tickets you need to use the credit in your balance.

### Payment verification with Stripe
All payments are done through Stripe. All customers, credit card data and transactions are safely stored in the cloud area, accessible with credentials ( username: pie-gro-n26@hotmail.it , password: Tr@vlendar2017 ) from https://dashboard.stripe.com . <br> Account is set in testing mode, so it is advised to used fake credit cards in testing this project (here: https://stripe.com/docs/testing). We have not checked all these test codes. We suggest using the test card 4242 4242 4242 4242.

### Sharing services
The sharing services are not supported yet in our implementation: the "Sharing Services" page contains some links which redirect to the web sites of the main car and bike sharing services.

## Testing

Unit testing can be done by typing the command `mvn test` <br>
Integration Testing can be conducted by typing the command `mvn  verify -P integration-test` in the _Implementation_ folder



## Troubles and quick fixes

### Best IDE for this project
Currently Eclipse Java Oxygen is not a good-fitting IDE. We included Lombox 1.16.18. jar , which creates problems in Eclipse. <br> See https://stackoverflow.com/questions/45461777/lombok-problems-with-eclipse-oxygen and https://github.com/rzwitserloot/lombok/issues/1427 articles for further details. <br> We suggest to use Netbeans, with which the project has been developed.

### Widgetset error
If you see a Widgetset error when you try to access localhost:8080 from your browser, you need to recompile Vaadin Widgetset. <br> In Eclipse, it can be done by downloading Vaadin plugin and clicking on "Compile Vaadin Widgetset". <br> In Netbeans, right-click on the project and click "Clean and Build" (ignore possible errors about Maven version).

## Resources and documentation
Java JDK 1.8.0<br>
Apache Maven 3.5.2<br>
Netbeans 8.2<br>
MySQL 5.7.20<br>
Vaadin 8<br>
Google Maps APIs<br>
Google Maps Services Java 2.1.0<br>
Stripe 5.25.0 (payments)<br>
EvoSuite 1.0.5 (testing)
##### Vaadin + MySQL
https://vaadin.com/blog/building-a-web-ui-for-mysql-databases-in-plain-java-?utm_campaign=New%20registration&utm_source=hs_automation&utm_medium=email&utm_content=39610603&_hsenc=p2ANqtz--ut22Rfm32KlobpIHtq6LpH3COcrPL4sZEWDAXO1ZoRH34i0P46KUYGkVxwFIw49_cBYJPSgFVZ82j3sQ5lAAvDc8h-g&_hsmi=39610603
##### Vaadin layout components
https://vaadin.com/docs/v8/framework/layout/layout-overview.html
##### Vaadin server-side app. (e.g.: notification and error handling)
https://vaadin.com/docs/v8/framework/application/application-overview.html
##### SQL syntax
https://www.w3schools.com/sql/default.asp
##### Vaadin login
https://examples.javacodegeeks.com/enterprise-java/vaadin/vaadin-login-example/
##### Google Maps
Directions API: https://developers.google.com/maps/documentation/directions/ <br>
Places API: https://developers.google.com/maps/documentation/javascript/places <br>
Java library: https://github.com/googlemaps/google-maps-services-java
##### EvoSuite
http://www.evosuite.org/
