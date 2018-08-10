# Optimization Solver

This application is to demostrate the rate limit for Optimization Solver framework's solve API.
The class `OptimizationSolver` under package `com.ipgmedia.lib` is mocking as Optimization Solver framework. The `solve` method under the class `OptimizationSolver` will just do the reverse string operation.
`OptimizationSolverService` class under package `com.ipgmedia.service` is a wrapper with rate limiter. The `MainController` class under package `com.ipgmedia.controller` have the API endpoint to send request (i.e. `solve/{data}`)
Number of licences are defined in application.properties with param `optimization.solver.license.count`

To rate limit the framework's solve method, Google Guava RateLimiter library is used. Which can be found under dependencies of pom.xml file.

In order to test the functionality of rate limit. Initiate multiple GET request to the following URI.
`http://<IP>:<Port>/solve/{some-sample-data}`
Example http://localhost:8081/solve/myString

## Build and Run

Maven is used for dependencies and project build.

To build the project run following maven command   
`mvn clean package`  

Exceute following command to run the application  
`mvn spring-boot:run`  

Open the following URL in browser for testing the optimization solve API library method
`localhost:8081/solve/{some-string-data}`  

Note: The default port set for this application is 8081 in application.properties file. Web server in the application will start on port 8081

