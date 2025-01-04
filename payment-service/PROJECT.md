# Payment Service Documentation

## File Descriptions

### Main Application Files

1. **PaymentServiceApplication.java**
    - Entry point for the Payment Service.
    - Initializes the Spring Boot application.

2. **Payment.java**
    - Represents the payment entity with fields like `orderId`, `amount`, and `status`.
    - Used to pass data between the controller and service layers.

3. **PaymentController.java**
    - Exposes REST API endpoints for payment operations.
    - Handles HTTP requests and delegates processing to the service layer.

4. **PaymentService.java**
    - Contains the business logic for processing payments.
    - Updates the payment status and returns the result.

5. **KafkaConfig.java**
    - Configures Kafka producer settings.
    - Enables asynchronous messaging to communicate with other services.

### Configuration Files

1. **application.yml**
    - Defines application-specific configurations, such as server port and Kafka settings.

2. **logback.xml**
    - Configures logging settings, including log format and file storage.

### Test Files

1. **PaymentControllerTest.java**
    - Unit tests for the PaymentController to validate API endpoint behavior.

2. **PaymentServiceTest.java**
    - Unit tests for the PaymentService to ensure payment processing logic works correctly.

---

## Application Flow

1. A client sends a payment request to the **PaymentController** via the `/payments` endpoint.
2. The **PaymentController** validates the request and forwards it to the **PaymentService**.
3. The **PaymentService** processes the payment, updating its status and publishing any necessary events to Kafka.
4. If configured, Kafka forwards the payment event to other services (e.g., Notification or Order Service).
5. The controller returns a response indicating the result of the payment operation.

---

## Prerequisites

1. **Java 17**
2. **Maven 3.8+**
3. **Kafka** installed and running on `localhost:9092`
4. **Docker** and **Docker Compose** (optional for containerized deployment)

---

## Build and Start the Application

### Building the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/cloudnativeplayground/eventdrivenordersystem.git
   cd payment-service
   ```
2. Build the application:
   ```bash
   mvn clean install
   ```

### Starting the Application

#### Using Maven

1. Run the application:
   ```bash
   mvn spring-boot:run
   ```
2. Access the service at `http://localhost:8082`.

#### Using Docker Compose

1. Ensure Docker is installed and running.
2. Start the service with Docker Compose:
   ```bash
   docker-compose up --build
   ```
3. Verify the service is running at `http://localhost:8082`.

---

## Troubleshooting

1. **Kafka Not Running**:
    - Ensure Kafka is installed and accessible at `localhost:9092`.
    - Use Docker Compose or local installation to start Kafka.

2. **Port Conflict**:
    - Modify the `server.port` value in `application.yml` to use a different port.

3. **Build Errors**:
    - Ensure you have the correct version of Maven and Java installed.
    - Run `mvn dependency:resolve` to resolve any dependency issues.

---

Happy Coding! 🚀
