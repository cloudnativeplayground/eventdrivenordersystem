# Notification Service Documentation

This document provides an overview of the files in the **Notification Service**, their roles, the application's flow, prerequisites, and steps to build and start the application.

---

## File Overview

### **Main Application Files**

1. **NotificationServiceApplication.java**
    - Entry point of the application.
    - Initializes and starts the Spring Boot application.

2. **NotificationController.java**
    - Exposes RESTful endpoints to interact with the notification service.
    - Handles incoming API requests, such as checking service status and sending notifications.

3. **NotificationService.java**
    - Contains the business logic for sending and managing notifications.
    - Processes incoming requests from the controller and interacts with the model.

4. **Notification.java**
    - Represents the data structure for a notification.
    - Contains fields like `id` and `message` with getter and setter methods.

5. **KafkaConfig.java**
    - Configures Kafka topics used for event-driven communication.
    - Defines a topic named `notification-topic`.

### **Configuration Files**

1. **application.yml**
    - Configures application properties, such as server port and Kafka bootstrap servers.

2. **logback.xml**
    - Sets up logging configuration for structured and meaningful logs.

### **Test Files**

1. **NotificationControllerTest.java**
    - Unit tests for `NotificationController`.
    - Ensures REST endpoints behave as expected.

2. **NotificationServiceTest.java**
    - Unit tests for `NotificationService`.
    - Verifies business logic for sending notifications.

### **Build File**

1. **pom.xml**
    - Maven build file containing dependencies for Spring Boot, Kafka, and testing frameworks.

---

## Application Flow

1. **REST API Interaction**:
    - Clients interact with the application through REST endpoints exposed by `NotificationController`.

2. **Notification Processing**:
    - Incoming requests are processed by `NotificationService`, which handles the business logic of creating and sending notifications.

3. **Event Handling**:
    - Notifications can be integrated with Kafka for event-driven processing, enabling scalability and asynchronous communication.

---

## Prerequisites

1. **Java 17** or higher.
2. **Maven** for building the application.
3. **Apache Kafka** running locally or on a server.
4. **Docker** (optional for containerized deployment).

---

## Building the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/cloudnativeplayground/eventdrivenordersystem.git
   cd notification-service
   ```

2. Build the application using Maven:
   ```bash
   mvn clean install
   ```

---

## Starting the Application

### Running Locally

1. Ensure Kafka is running and accessible at the configured `bootstrap-servers` address.

2. Start the application:
   ```bash
   mvn spring-boot:run
   ```

3. The service will be available at `http://localhost:8083`.

### Running with Docker

1. Build the Docker image:
   ```bash
   docker build -t notification-service .
   ```

2. Run the Docker container:
   ```bash
   docker run -p 8083:8083 notification-service
   ```

---

## API Endpoints

1. **GET /notifications/status**
    - Check the status of the service.

2. **POST /notifications**
    - Send a notification with the provided message.

3. **GET /notifications**
    - Retrieve a list of all sent notifications.

---

## Notes

- Update `application.yml` to match your local Kafka configuration if necessary.
- For production deployment, configure secure logging, externalized configurations, and scalable Kafka brokers.

---

Happy coding with the **Notification Service**! 🚀