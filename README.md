# Random project title

Basic project on microservices architecture. Spring Boot 2.0, Spring Cloud and Angular 5.

### Prerequisites

- Eclipse
- JDK 1.8
- Node.js
- Node Package Manager (NPM)
- Angular CLI(npm install @angular/cli -g)

### Up and running

1. Import in eclipse all services directories.
2. Run with: 
  - ./mvnw spring-boot:run (Linux)
  - mvnw spring-boot:run (Windows)
  - if Spring Tools extension in Eclipse is installed, just Run as Spring Boot App
3. Run order:
  - eureka-service and then the rest
4. Run angular client:
  - in movie-client directory, npm install and then ng serve
  
### Tests

   localhost:8761 (Eureka, service registration)
1. From angular: localhost:4200 (just observe that we call gateway-service in order to retrieve elements)
2. From gateway-service: localhost:8080/movies (json media type)
3. From movie-service: localhost:8081/movies (json+hal media type)
