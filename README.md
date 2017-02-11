# SpringMVCAndJDBC
This project was develop to show an example of Spring MVC and JDBC connection

This Project Contains
* Maven
* Log4j
* Spring
* Gson

 
<java.version>1.7</java.version>
<spring.version>4.0.3.RELEASE</spring.version>
<log4j.version>1.2.17</log4j.version>
 

And during development was tested on SGBD postgresql.

This project contains "db.properties", "log4j.properties" to settings all of configurations.

Create an user with name: springJdbc 
 
Here are the create table:

CREATE TABLE Movie
(
    id serial NOT NULL,
    name character varying(100) NOT NULL,
    director character varying(100) NOT NULL,
    writers character varying(100) NOT NULL,
    year integer NOT NULL,
    sinopse character varying(100) NOT NULL,
    stars character varying(100) NOT NULL,
    gender character varying(100) NOT NULL,
    PRIMARY KEY (id)
)
