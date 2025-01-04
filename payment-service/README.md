# Payment Service

## Overview
The **Payment Service** is a critical component of the Event-Driven Order Management System. It handles payment processing for customer orders in a secure and scalable manner, utilizing **Spring Boot** for the service logic and **Kafka** for asynchronous messaging. This service is designed with extensibility and fault tolerance in mind.

---

## Features

- **Asynchronous Payment Processing**: Uses Kafka to handle payment events.
- **REST API**: Exposes endpoints for payment operations.
- **Extensibility**: Modular design for easy integration with other services.
- **Containerization**: Fully containerized using Docker.
- **Logging and Monitoring**: Integrated logging with Logback and health monitoring via Spring Actuator.

---

## Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Kafka**
- **Docker**
- **JUnit 5** for unit testing
- **Logback** for logging

---

## Prerequisites

- **Java 17**
- **Maven 3.8+**
- **Docker** and **Docker Compose**
- **Kafka**

---

## Project Structure

```
payment-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cloudnativeplayground/paymentservice/
│   │   │       ├── controller/
│   │   │       │   └── PaymentController.java
│   │   │       ├── service/
│   │   │       │   └── PaymentService.java
│   │   │       ├── model/
│   │   │       │   └── Payment.java
│   │   │       ├── config/
│   │   │       │   └── KafkaConfig.java
│   │   │       └── PaymentServiceApplication.java
│   │   ├── resources/
│   │   │   ├── application.yml
│   │   │   └── logback.xml
│   └── test/
│       ├── java/
│       │   └── com/cloudnativeplayground/paymentservice/
│       │       ├── controller/
│       │       │   └── PaymentControllerTest.java
│       │       └── service/
│       │           └── PaymentServiceTest.java
├── pom.xml
```

---

## API Endpoints

### Base URL
```
http://localhost:8082
```

### Endpoints

1. **Process Payment**
    - **POST** `/payments`
    - Request Body:
      ```json
      {
          "orderId": "123",
          "amount": 100.00
      }
      ```
    - Response:
      ```json
      "Payment processed for order ID: 123"
      ```

---

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/cloudnativeplayground/payment-service.git
cd payment-service
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

#### Using Maven

```bash
mvn spring-boot:run
```

#### Using Docker Compose

1. Ensure Docker is installed and running.
2. Run the following command:

```bash
docker-compose up --build
```

---

## Testing

### Run Unit Tests

```bash
mvn test
```

### Coverage
- **Controller Tests**: Validates API endpoints.
- **Service Tests**: Ensures payment logic works as expected.

---

## Configuration

### `application.yml`

```yaml
server:
  port: 8082

spring:
  kafka:
    bootstrap-servers: localhost:9092
```

---

## Logging

- Log files are stored in `logs/payment-service.log`.
- Logback configuration can be found in `logback.xml`.

---

## Contribution Guidelines

We welcome contributions to enhance this service:

1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes and push to the branch:
   ```bash
   git commit -m "Add feature"
   git push origin feature-name
   ```
4. Open a pull request for review.

---

## License

This project is licensed under the **GNU General Public License v3 (GPLv3)**.

---

## Contact

For any queries, feel free to raise an issue or contact **Aditya Pratap Bhuyan** via GitHub.

---

Happy Coding! 🚀
