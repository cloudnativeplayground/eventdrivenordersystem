# Order Service

The **Order Service** is a microservice in the Event-Driven Order Management System. It handles order-related operations, including order creation, retrieval, and event publishing using Kafka. This service is built with **Spring Boot** and follows a cloud-native microservices architecture.

---

## Features

- Create and manage orders.
- Publish order events to Kafka for downstream processing.
- Integrated with an in-memory H2 database for testing and local development.
- Configurable logging using Logback.

---

## Technologies Used

- **Spring Boot**: Core framework.
- **Spring Data JPA**: For database interactions.
- **Spring Kafka**: For event publishing.
- **H2 Database**: In-memory database for local development.
- **Logback**: Logging framework.

---

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven**
- **Kafka** (Local or Docker setup)

### Clone the Repository

```bash
git clone https://github.com/cloudnativeplayground/order-service.git
cd order-service
```

### Build the Project

```bash
mvn clean install
```

### Run the Service

```bash
mvn spring-boot:run
```

The service will start at `http://localhost:8080` by default.

### Kafka Setup

Ensure Kafka is running locally or use Docker Compose for a local Kafka setup:

```bash
docker-compose -f kafka/docker-compose.yml up
```

---

## API Endpoints

### 1. Create an Order
- **URL**: `/orders`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
      "productName": "Laptop",
      "quantity": 2,
      "price": 1200.0
  }
  ```
- **Response**:
  ```json
  "Order placed successfully!"
  ```

### 2. Get an Order by ID
- **URL**: `/orders/{id}`
- **Method**: `GET`
- **Response**:
  ```json
  {
      "id": 1,
      "productName": "Laptop",
      "quantity": 2,
      "price": 1200.0
  }
  ```

---

## Configuration

### `application.yml`

Configure database and Kafka settings in `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:orders
    driver-class-name: org.h2.Driver
    username: sa
    password: password
  jpa:
    hibernate:
      ddl-auto: update

kafka:
  bootstrap-servers: localhost:9092
```

---

## Testing

### Run Unit Tests

```bash
mvn test
```

### Test Coverage
- **Controller Tests**: Verifies API endpoints.
- **Service Tests**: Validates business logic and interactions with Kafka.

---

## Contribution

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes and push:
   ```bash
   git commit -m "Add new feature"
   git push origin feature-name
   ```
4. Submit a pull request.

---

## License

This project is licensed under the **GNU General Public License v3 (GPLv3)**.

---

## Contact

For queries or feedback, please reach out to **Aditya Pratap Bhuyan** via the [Issues](https://github.com/cloudnativeplayground/order-service/issues) page.

---

Happy coding with **Order Service**! 🚀
