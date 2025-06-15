# Product-Management-Tool
Product-Management-Tool

For this project I used: Java 17, Spring Boot 3.5.0, Spring Data JPA, Spring Security (Basic auth), H2 Database, Lombok, JUnit 5 and Mockito.

There are 2 users 1 is the "ADMIN" with password "adminpass" and "USER" with password "userpass" for basic authentication with role-based access.
There is an error handling @RestControllerAdvice.
There is a logging for key operations (addProduct, getProduct - ProductController and also addProduct, updateProductPrice - ProductServiceImpl).
A unit test for adding a product.
DTO and layered structure.
Runs with H2 console.

Endpoints:

POST -> '/products - we add a product 
GET -> '/products/{id} - get product by ID
PUT -> '/products/{id}/price' - update product price

For H2 console:
URL: localhost:8080/h2-console 
JDBC URL: jdbc:h2:mem:testdb
user: sa
password:
..(no password)

