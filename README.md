# SpringMVCAndJDBC
This project was develop to show an example of Spring MVC and JDBC connection, the objective for this project was development java to backend, and Angularjs to frontend

This Project Contains
* Maven
* Log4j
* Spring
* Gson
* Junit
* Spring-test

 
java.version > 1.7

spring.version > 4.0.3.RELEASE

log4j.version > 1.2.17

gson.version > 2.7

postgresql.version > 9.4-1200-jdbc41

junit.version > 4.12

spring-test.version > 4.3.0.RELEASE



===========================================================================================================

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
    sinopse character varying(900) NOT NULL,
    stars character varying(100) NOT NULL,
    gender character varying(100) NOT NULL,
    PRIMARY KEY (id)
)
