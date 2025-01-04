# Inventory Service

The **Inventory Service** is a microservice in the Event-Driven Order Management System. It manages product inventory, processes stock validations, and ensures the availability of products during order placement.

## Features

- Manage inventory items (CRUD operations).
- Validate product availability.
- Integration with an event-driven architecture using Kafka.
- RESTful API endpoints.
- Containerized for Docker and Kubernetes deployment.

---

## Technologies Used

- **Java 17**
- **Spring Boot** (Data JPA, Web, Kafka)
- **H2 Database** (In-memory for local development)
- **Docker**
- **Kubernetes**

---

## Prerequisites

- **Java 17** or higher
- **Maven**
- **Kafka** (locally or via Docker Compose)
- **Docker** (for containerization)

---

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/cloudnativeplayground/eventdrivenordersystem.git
cd inventory-service
```

### Build the Application

```bash
mvn clean install
```

### Run the Application Locally

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8081`.

### Run with Docker

1. Build the Docker image:
   ```bash
   docker build -t inventory-service:latest .
   ```
2. Run the container:
   ```bash
   docker run -p 8081:8081 inventory-service:latest
   ```

### Run with Kubernetes

1. Apply the Kubernetes deployment file:
   ```bash
   kubectl apply -f kubernetes/inventory-service.yaml
   ```
2. Verify the service:
   ```bash
   kubectl get pods
   kubectl get svc
   ```

---

## API Endpoints

### Inventory Controller

- **GET** `/inventory`
    - Retrieve all inventory items.

- **GET** `/inventory/{id}`
    - Retrieve details of a specific inventory item.

- **POST** `/inventory`
    - Add a new inventory item.

- **PUT** `/inventory/{id}`
    - Update an existing inventory item.

Example payload for POST/PUT:
```json
{
  "name": "Product A",
  "quantity": 100
}
```

---

## Configuration

### `application.yml`

Configure Kafka and database settings in `src/main/resources/application.yml`:

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
  datasource:
    url: jdbc:h2:mem:inventorydb
    username: sa
    password: password
```

---

## Testing

### Run Unit Tests

```bash
mvn test
```

### Run Integration Tests

```bash
mvn verify
```

---

## Contribution Guidelines

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
4. Submit a pull request for review.

---

## License

This project is licensed under the **GNU General Public License v3 (GPLv3)**.

---

## Contact

For queries or feedback, reach out to **Aditya Pratap Bhuyan** via the project's [Issues](https://github.com/cloudnativeplayground/eventdrivenordersystem/issues) page.

---

Happy coding with **Inventory Service**! 🚀
