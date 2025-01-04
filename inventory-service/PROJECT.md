# Inventory Service Module Overview

This document provides a detailed description of the **Inventory Service** module, its components, workflow, prerequisites, and steps to build and run the application.

---

## Module Description

The **Inventory Service** is a core microservice in the Event-Driven Order Management System. It is responsible for managing product inventory, ensuring stock availability during order placement, and facilitating updates to inventory levels. This service is part of a larger event-driven architecture that integrates with Kafka to handle asynchronous communication.

---

## File and Component Uses

### **1. Source Code Structure**

- **`InventoryController.java`**
    - Defines RESTful API endpoints for managing inventory operations.
    - Handles HTTP requests and responses.

- **`InventoryService.java`**
    - Contains business logic for CRUD operations on inventory items.
    - Validates product availability and updates inventory levels.

- **`InventoryItem.java`**
    - Represents the data model for inventory items.
    - Mapped to the database using JPA annotations.

- **`InventoryRepository.java`**
    - Provides data access methods by extending `JpaRepository`.
    - Facilitates interaction with the underlying database.

### **2. Configuration Files**

- **`application.yml`**
    - Configures application properties like server port, database URL, and Kafka settings.

- **`logback.xml`**
    - Configures logging for the application, including log format and level.

### **3. Test Files**

- **Unit Tests**
    - Test individual methods in `InventoryService` to ensure correctness.

- **Integration Tests**
    - Test REST endpoints in `InventoryController` using MockMvc.

---

## Workflow

1. **Inventory Management**
    - The user interacts with the Inventory Service via REST API endpoints.
    - CRUD operations are processed through the service and repository layers.

2. **Stock Validation**
    - During order placement, the service validates stock availability.
    - Updates to inventory levels are made synchronously.

3. **Event Communication**
    - Kafka is used to publish events like `StockUpdated` for downstream services.

4. **Data Persistence**
    - Inventory data is stored in an in-memory H2 database (local development).

---

## Prerequisites

1. **Tools**
    - Java 17 or higher
    - Maven
    - Docker (optional for containerization)
    - Kubernetes (optional for deployment)

2. **Environment**
    - Kafka setup (via Docker Compose or a local instance).
    - Ports 8081 (service) and 9092 (Kafka) available.

---

## How to Build and Run the Application

### **Build the Application**

1. Clone the repository:
   ```bash
   git clone https://github.com/cloudnativeplayground/eventdrivenordersystem.git
   cd inventory-service
   ```

2. Build using Maven:
   ```bash
   mvn clean install
   ```

### **Run Locally**

1. Start Kafka (if not already running):
   ```bash
   docker-compose -f kafka/docker-compose.yml up
   ```

2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

3. Access the service at `http://localhost:8081`.

### **Run with Docker**

1. Build the Docker image:
   ```bash
   docker build -t inventory-service:latest .
   ```

2. Run the container:
   ```bash
   docker run -p 8081:8081 inventory-service:latest
   ```

### **Run with Kubernetes**

1. Deploy Kafka:
   ```bash
   kubectl apply -f kafka/kafka.yaml
   ```

2. Deploy the service:
   ```bash
   kubectl apply -f kubernetes/inventory-service.yaml
   ```

3. Verify the deployment:
   ```bash
   kubectl get pods
   kubectl get svc
   ```

---

## Key Features

- **CRUD Operations**: Manage inventory items with RESTful APIs.
- **Stock Validation**: Ensure product availability during order placement.
- **Event-Driven Communication**: Integrates with Kafka for event handling.
- **Database Persistence**: Uses H2 for development and supports other relational databases in production.

---

## Logs and Monitoring

- Application logs are configured in `logback.xml`.
- Use the following endpoints for health and monitoring:
    - Health Check: `http://localhost:8081/actuator/health`
    - Metrics: `http://localhost:8081/actuator/metrics`

---

## Contribution

Contributions are welcome! Please follow the guidelines in the project's [README](README.md).

---

## Contact

For questions or issues, contact **Aditya Pratap Bhuyan** via the project's [Issues](https://github.com/cloudnativeplayground/eventdrivenordersystem/issues) page.

---

Happy coding with **Inventory Service**! 🚀
