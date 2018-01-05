# TravlendarPlus

## Usage
Import in your IDE as a Maven project. <br>
You need to execute mvn install. Some IDEs (e.g.: Eclipe JEE) automatically execute it when you run the project.<br>
Run the class TravlendarApplication.java as a Java Application.<br>
From your browser navigate to localhost:8080.

## MySQL - Database Setup
To import the database in your PC:
1. Install MySQL Workbench
2. In the program: Server -> Data Import
3. Select "Import from Self-Contained File" and browse Dump.sql
4. Create a new schema for the Default Target Schema and name it "travlendar" (important)
5. Refresh schemas to see travlendar

Alternately, create manually a new schema with MySQL Command Line:<br>
copy and paste the text from the file "sql_entries". <br>
The database or the database server must have a jdbc Connector for port 3306.

## Resources and documentation
Java JDK 1.8.0<br>
Apache Maven 3.5.2<br>
Eclipse JEE Oxigen<br>
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
