# Project File Overview

This document provides a detailed description of the key files in the `order-service` microservice, their roles, prerequisites for running the service, and the overall flow.

---

## **File Roles**

### **Source Files**

| **File**                             | **Location**                                        | **Purpose**                                                                 |
|--------------------------------------|----------------------------------------------------|----------------------------------------------------------------------------|
| `OrderController.java`               | `src/main/java/com/cloudnativeplayground/orderservice/controller` | Exposes REST APIs for order operations like creation and retrieval.       |
| `Order.java`                         | `src/main/java/com/cloudnativeplayground/orderservice/model`       | Represents the `Order` entity with attributes like `id`, `productName`, etc. |
| `OrderService.java`                  | `src/main/java/com/cloudnativeplayground/orderservice/service`     | Contains business logic for handling orders and integrating with Kafka.   |
| `KafkaProducerConfig.java`           | `src/main/java/com/cloudnativeplayground/orderservice/config`      | Configures the Kafka producer to publish order events.                    |
| `application.yml`                    | `src/main/resources`                                   | Holds the application configurations such as datasource and Kafka details. |
| `logback.xml`                        | `src/main/resources`                                   | Configures the logging system for the microservice.                       |

### **Test Files**

| **File**                             | **Location**                                        | **Purpose**                                                                 |
|--------------------------------------|----------------------------------------------------|----------------------------------------------------------------------------|
| `OrderControllerTest.java`           | `src/test/java/com/cloudnativeplayground/orderservice/controller` | Tests the REST API endpoints of `OrderController`.                        |
| `OrderServiceTest.java`              | `src/test/java/com/cloudnativeplayground/orderservice/service`     | Tests the business logic in `OrderService`.                               |

---

## **Pre-Requisites**

1. **Java Development Kit (JDK)**: Version 17 or higher.
2. **Apache Kafka**: Running instance on `localhost:9092`.
3. **H2 Database**: Embedded database configured in the `application.yml`.
4. **Maven**: For building and running the service.
5. **Docker (Optional)**: For containerized deployment of the service.

---

## **Flow**

### **Order Creation Flow**
1. **User Request**:
    - The client sends a `POST /orders` request with order details to the `OrderController`.

2. **Controller Logic**:
    - `OrderController` calls the `OrderService.placeOrder()` method.

3. **Business Logic**:
    - `OrderService` saves the order to the database using the `OrderRepository`.
    - Publishes an event (`Order Placed`) to Kafka.

4. **Kafka Producer**:
    - `KafkaProducerConfig` ensures the message is sent to the Kafka topic (`orders`).

5. **Response**:
    - `OrderController` returns a success response to the client.

### **Order Retrieval Flow**
1. **User Request**:
    - The client sends a `GET /orders/{id}` request to retrieve order details.

2. **Controller Logic**:
    - `OrderController` calls `OrderService.getOrderById(id)`.

3. **Business Logic**:
    - `OrderService` fetches the order details from the database.

4. **Response**:
    - `OrderController` returns the order details in the response.

---

## **Key Configurations**

1. **Kafka Configuration**:
    - Defined in `KafkaProducerConfig.java`.
    - Bootstrap server: `localhost:9092`.
    - Topic: `orders`.

2. **Database Configuration**:
    - Defined in `application.yml`.
    - URL: `jdbc:h2:mem:orders` (in-memory database).

3. **Logging Configuration**:
    - Defined in `logback.xml`.
    - Outputs structured logs to the console.

---

## **How to Run**

1. **Start Kafka**:
    - Ensure Kafka is running locally on `localhost:9092`.

2. **Run the Service**:
    - Use Maven to start the service:
      ```bash
      mvn spring-boot:run
      ```

3. **Test the Endpoints**:
    - Create an order:
      ```bash
      curl -X POST -H "Content-Type: application/json" -d '{"productName":"Laptop","quantity":2,"price":1200.0}' http://localhost:8080/orders
      ```
    - Retrieve an order:
      ```bash
      curl -X GET http://localhost:8080/orders/1
      ```

---

This overview helps understand the functionality and organization of files in the `order-service`. Let me know if you need further enhancements! 🚀
