# Microservices platform

We have microservices. They are written in Java stack and analytics-service in Python.
Analytics-service does not perform anything complex.
I have it here because I want to integrate microservices in different languages into the single 
platform.

### Requirements
1. User management
4. User purchase history and prediction analytics
5. Use a sidecar application for the analytics-service
6. Allow services discovery
7. Allow monitoring of the platform.
8. Use gateway as a single entry point into the platform.
All external request should be processed in gateway.

### Limitations
1. I do not use persistence in this project for simplicity reasons.
Each service operates with own data in memory.
2. I do not use containers in this project. See 1).
For simplicity reason, I will run all microservices manually.
3. No authentication. Only users present in application can be used.
4. No streaming, no messages, no communications between microservices.
In the real-world systems, there should not be synchronous communication between microservices.
Microservices can subscribe to topics and consume messages containing the data they need.

### Things for the future, maybe.
I will create an e-commerce platform imitation project or get hired to join a team
to make a great e-commerce platform.
There will be more services, more complexity, containers, persistence, message streaming
and many other things.

### Technical details
#### user-service
Keeps a few users in memory. It has two endpoints: get all users and get user by id.

#### analytics-service
A service written in python. In the real applications it will perform data mining and
applies machine learning algorithms. In this example, it just exists for sake of integration.

#### gateway
Single entry point for external requests. It will work as a forward proxy,
forwarding requests to the required services.

#### registry
It is used for services discovery. I use Eureka server.

#### monitoring-service
Spring Boot Admin Server, which receives data from Spring actuators. Shows status of each service.
