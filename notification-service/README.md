# Notification Service

The **Notification Service** is a part of the **Event-Driven Order Management System**. It is responsible for sending notifications to users based on various events, such as order creation or status updates. This service leverages **Spring Boot**, **Kafka**, and a RESTful API to achieve its functionality.

---

## Features

- **Event-Driven Architecture**: Consumes messages from Kafka topics to trigger notifications.
- **REST API**: Exposes endpoints for status checks and manual notification sending.
- **Scalable Design**: Built with Kafka for distributed and scalable event handling.
- **Spring Boot Integration**: Simplifies configuration and dependency management.
- **Logging**: Configured with Logback for structured and meaningful logs.

---

## Technologies Used

- **Java 17**
- **Spring Boot 3.x**
- **Apache Kafka**
- **Maven**
- **Docker (Optional)**

---

## Prerequisites

1. Java 17 or higher installed.
2. Apache Kafka running locally or on a server.
3. Maven installed for building the project.

---

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/cloudnativeplayground/eventdrivenordersystem.git
cd notification-service
```

### Build and Run the Application

1. Build the application using Maven:

   ```bash
   mvn clean install
   ```

2. Run the application:

   ```bash
   mvn spring-boot:run
   ```

3. The service will start on `http://localhost:8083` by default.

### Run with Docker (Optional)

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

### **GET /notifications/status**
- **Description**: Check the status of the service.
- **Response**: `"Notification Service is up and running!"`

### **POST /notifications**
- **Description**: Send a notification.
- **Request Body**:

   ```json
   {
     "id": "1",
     "message": "Your order has been shipped!"
   }
   ```
- **Response**: Confirms the notification was sent.

### **GET /notifications**
- **Description**: Retrieve all notifications sent.
- **Response**: List of notifications.

---

## Configuration

### application.yml

Modify the following in `src/main/resources/application.yml`:

```yaml
server:
  port: 8083

spring:
  application:
    name: notification-service
  kafka:
    bootstrap-servers: localhost:9092
```

### Kafka Configuration

Ensure Kafka is running locally or update the `bootstrap-servers` property to point to your Kafka server.

---

## Testing

### Unit Tests

Run unit tests using:

```bash
mvn test
```

### Example Test Cases

- Verify the status endpoint returns the correct response.
- Validate notification sending logic in `NotificationService`.

---

## Contribution

We welcome contributions! To contribute:

1. Fork the repository.
2. Create a feature branch:

   ```bash
   git checkout -b feature-name
   ```

3. Commit your changes and push the branch:

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

For any queries or feedback, reach out via the project's [Issues](https://github.com/cloudnativeplayground/eventdrivenordersystem/issues) page.

---

Happy coding with the **Notification Service**! 🚀
