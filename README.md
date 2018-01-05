# Software_Engineering_2

# RASD
RASD document was mainly elaborated on a shared Google Doc, to improve team cooperation in the document's production. Once closed to final version it was refined with Latex. It is possible to access it in the delivery folder.

# DD
RASD document was mainly elaborated on a shared Google Doc, to improve team cooperation in the document's production. Once closed to final version it was refined with Latex. It is possible to access it in the delivery folder.

# Implementation

## Usage
Import in your IDE as a Maven project. <br>
You need to execute mvn install. Some IDEs (e.g.: Eclipe JEE) automatically execute it when you run the project.<br>
Run the class TravlendarApplication.java as a Java Application.<br>
From your browser navigate to localhost:8080.

## MySQL
To import the database in your PC:
1. Install MySQL Workbench
2. In the program: Server -> Data Import
3. Select "Import from Self-Contained File" and browse Dump.sql
4. Create a new schema for the Default Target Schema and name it "travlendar" (important)
5. Refresh schemas to see travlendar
### Other Database Init
(insert here some instructions)

Alternately, create manually a new schema with MySQL Command Line:<br>
Copy and Paste commands from the file _"sql_entries"_ that is accessible in the folder _Implementation_.


## Stripe Verification

All payments are done through Stripe. All customers, credit card data and transactions are safely stored in the cloud area, accessible with credentials ( username: pie-gro-n26@hotmail.it , password: Tr@vlendar2017 ) from https://dashboard.stripe.com . <br> Account is set in testing mode, so it is advised to used fake credit cards in testing this project (here: https://stripe.com/docs/testing). We have not checked all these test codes.

## Troubles
Currently Eclipse Java Oxygen is not a good-fitting IDE. We included Lombox 1.16.18. jar , which creates problems in Eclipse. <br> See https://stackoverflow.com/questions/45461777/lombok-problems-with-eclipse-oxygen and https://github.com/rzwitserloot/lombok/issues/1427 articles for further details.

## Resources and documentation
Java JDK 1.8.0<br>
Apache Maven 3.5.2<br>
Netbeans 8.2<br>
MySQL 5.7.20<br>
Vaadin 8
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
