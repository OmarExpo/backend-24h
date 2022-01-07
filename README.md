# backend-electionSystem


backend-votingSystemApp
REST / Spring Boot / JPA / MySQL

Here is the <a href="https://github.com/OmarExpo/backend-electionSystem/blob/main/Application-Architecture.PNG">Application Architecture</a>

The Voter [Spring Boot](https://projects.spring.io/spring-boot/) Service is a RESTful Web Service, backed by MySQL DB, using Spring Boot, Spring Data JPA, Hibernate, H2 (for Unit Testing) and Swagger (Open API docs) plus Exception Handling. It is part of the Voting System API. The Voting System service exposes several HTTP API endpoints, listed below. 

Voting system that allows to fecth / create / edit / delete Candidates (plus Party & VotingSystem APIs as well), in short perform all CRUD operations.

<a href="https://github.com/OmarExpo/backend-electionSystem/blob/main/swagger.jpg">Swagger preview here</a> 

<br/>
Technology stack:

Spring Boot 

REST 

Spring Data JPA 

Hibernate

MySQL DB 

Maven 

JUnit & Mockito

<br/>
How to use this program
<br/>

Clone a repository: git clone https://github.com/OmarExpo/backend-votingSystemApp 2. Open the project using the IDE

Execute initial script to create database schema, see src/resources/init_data.sql

Run your program or just execute it with Maven:

mvn spring-boot:run

Use Postman to test this API, or use another REST Client Tool on your own.
