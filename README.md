# hopster-api-gateway
API gateway serves as an entry point for client requests, providing routing, load balancing, and other cross-cutting concerns for communication between clients and backend services in a microservices architecture.
## Prerequisites
 - Java JDK 22 
 - Maven 3.9.5
## Running the Api Gateway
1. Clone the repository:

        https://github.com/GrowingUpTech/hopster-api-gateway.git

2. Navigate to the project directory:

        cd hopster-api-gateway

3. Build the project:

        mvn clean install

4. Run the project:

        mvn spring-boot:run

5. Access the API Gateway:
- Root: http://localhost:8081/

## Services
- Service 1: User service
- Service 2: Physical Activity Service
- Service 3: Support Behaviour Service

## Additional Information
- The API Gateway routes requests to the appropriate service based on the requested path.
- Update the ServiceDiscoveryService to include actual service discovery logic.
