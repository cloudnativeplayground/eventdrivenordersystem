# Event-Driven Order Management System

Welcome to the **Event-Driven Order Management System**! This project demonstrates a scalable, cloud-native approach to order processing using **event sourcing** and **CQRS (Command Query Responsibility Segregation)**. It leverages modern tools like **Spring Boot**, **Kafka**, **Docker**, and **Kubernetes** for high availability and fault tolerance.

---

## Features

1. **Event Sourcing**: Stores all changes to the order's state as a sequence of events.
2. **CQRS Pattern**: Separates write and read models for better performance and scalability.
3. **Asynchronous Processing**: Leverages Kafka for event-driven communication.
4. **Microservices Architecture**: Modular design with loosely coupled components.
5. **Containerized Deployment**: Ready-to-deploy with Docker and Kubernetes.
6. **Monitoring**: Integrated health checks and metrics using Spring Boot Actuator.

---

## Architecture

### Components

1. **Order Service**: Handles order creation, updates, and cancellations.
2. **Inventory Service**: Manages product stock and validates availability during order placement.
3. **Payment Service**: Processes payments and ensures transactions are recorded.
4. **Notification Service**: Sends order status updates to users.

### Flow

1. User places an order via the **Order Service**.
2. An **Order Placed** event is published to Kafka.
3. **Inventory Service** consumes the event to validate stock.
4. **Payment Service** processes payment asynchronously.
5. If successful, a confirmation event triggers the **Notification Service** to notify the user.

---

## Prerequisites

1. **Java 17** or higher
2. **Docker** and **Docker Compose**
3. **Kafka**
4. **Maven**
5. **Kubernetes** (optional for production deployment)

---

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/cloudnativeplayground/eventdrivenordersystem.git
cd eventdrivenordersystem
```

### Build the Project

```bash
mvn clean install
```

### Run with Docker Compose

1. Ensure Docker is running.
2. Start all services:

```bash
docker-compose up --build
```

3. Access services:
   - Order Service: `http://localhost:8080`
   - Kafka UI (optional): `http://localhost:8081`

### Run with Kubernetes (Optional)

1. Deploy Kafka and Zookeeper:

```bash
kubectl apply -f kubernetes/kafka.yaml
```

2. Deploy application services:

```bash
kubectl apply -f kubernetes/*.yaml
```

---

## API Endpoints

### Order Service

- **Create Order**: `POST /orders`
- **Update Order**: `PUT /orders/{id}`
- **Get Order**: `GET /orders/{id}`

### Inventory Service

- **Check Stock**: `GET /inventory/{productId}`
- **Update Stock**: `PUT /inventory/{productId}`

### Payment Service

- **Process Payment**: `POST /payments`

---

## Monitoring

Use Spring Boot Actuator endpoints for monitoring:

- Health: `http://localhost:8080/actuator/health`
- Metrics: `http://localhost:8080/actuator/metrics`

---

## Contribution

We welcome contributions! Please follow these steps:

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

For queries or feedback, reach out to **Aditya Pratap Bhuyan** via the project's [Issues](https://github.com/cloudnativeplayground/eventdrivenordersystem/issues) page.

---

Happy coding with **Event-Driven Order Management System**! 🚀
