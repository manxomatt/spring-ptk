# Spring PTK - REST API with Domain-Driven Design

A Spring Boot REST API application following Domain-Driven Design (DDD) principles with MySQL database integration.

## Project Structure

```
src/main/java/com/ptk/
├── SpringPtkApplication.java          # Main application entry point
├── domain/                             # Domain Layer (Core Business Logic)
│   ├── model/                          # Domain entities and value objects
│   │   ├── BaseEntity.java             # Base entity with common fields
│   │   └── product/                    # Product aggregate
│   │       ├── Product.java            # Product entity (Aggregate Root)
│   │       └── ProductStatus.java      # Product status enum
│   ├── repository/                     # Domain repository interfaces
│   │   └── ProductRepository.java      # Product repository contract
│   └── exception/                      # Domain exceptions
│       ├── DomainException.java        # Base domain exception
│       └── EntityNotFoundException.java # Entity not found exception
├── application/                        # Application Layer (Use Cases)
│   ├── dto/                            # Data Transfer Objects
│   │   ├── common/                     # Common DTOs
│   │   │   ├── ApiResponse.java        # Generic API response wrapper
│   │   │   └── PageResponse.java       # Paginated response wrapper
│   │   └── product/                    # Product DTOs
│   │       ├── ProductRequest.java     # Product create/update request
│   │       └── ProductResponse.java    # Product response
│   ├── mapper/                         # Object mappers
│   │   └── ProductMapper.java          # Product entity-DTO mapper
│   └── service/                        # Application services
│       ├── ProductService.java         # Product service interface
│       └── impl/
│           └── ProductServiceImpl.java # Product service implementation
├── infrastructure/                     # Infrastructure Layer
│   ├── config/                         # Configuration classes
│   │   ├── GlobalExceptionHandler.java # Global exception handling
│   │   └── OpenApiConfig.java          # Swagger/OpenAPI configuration
│   └── persistence/                    # Persistence implementations
│       ├── JpaProductRepository.java   # Spring Data JPA repository
│       └── ProductRepositoryImpl.java  # Domain repository implementation
└── presentation/                       # Presentation Layer (API)
    └── controller/
        └── ProductController.java      # Product REST controller
```

## Technology Stack

- **Java 17**
- **Spring Boot 3.2.3**
- **Spring Data JPA** - Data persistence
- **MySQL** - Database
- **Lombok** - Boilerplate code reduction
- **MapStruct** - Object mapping
- **SpringDoc OpenAPI** - API documentation
- **H2 Database** - Testing

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+

## Database Configuration

The application is configured to connect to MySQL with the following settings:

| Property | Value |
|----------|-------|
| Host | localhost |
| Port | 3306 |
| Database | prod_ptk |
| Username | root |
| Password | password |

Make sure to create the database before running the application:

```sql
CREATE DATABASE prod_ptk;
```

## Running the Application

### Using Maven

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

### Using Java

```bash
# Build the project
mvn clean package

# Run the JAR
java -jar target/spring-ptk-0.0.1-SNAPSHOT.jar
```

## API Documentation

Once the application is running, you can access:

- **Swagger UI**: http://localhost:8080/api/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/api/api-docs

## API Endpoints

### Products

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/products` | Get all products |
| GET | `/api/v1/products/{id}` | Get product by ID |
| GET | `/api/v1/products/sku/{sku}` | Get product by SKU |
| GET | `/api/v1/products/status/{status}` | Get products by status |
| GET | `/api/v1/products/category/{category}` | Get products by category |
| POST | `/api/v1/products` | Create a new product |
| PUT | `/api/v1/products/{id}` | Update a product |
| DELETE | `/api/v1/products/{id}` | Delete a product |

### Example Request

**Create Product:**
```bash
curl -X POST http://localhost:8080/api/v1/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Sample Product",
    "description": "A sample product description",
    "sku": "SKU-001",
    "price": 99.99,
    "quantity": 100,
    "status": "ACTIVE",
    "category": "Electronics"
  }'
```

**Response:**
```json
{
  "success": true,
  "message": "Product created successfully",
  "data": {
    "id": 1,
    "name": "Sample Product",
    "description": "A sample product description",
    "sku": "SKU-001",
    "price": 99.99,
    "quantity": 100,
    "status": "ACTIVE",
    "category": "Electronics",
    "available": true,
    "createdAt": "2024-01-01T12:00:00",
    "updatedAt": "2024-01-01T12:00:00"
  },
  "timestamp": "2024-01-01T12:00:00"
}
```

## Domain-Driven Design Layers

### Domain Layer
Contains the core business logic, entities, value objects, and repository interfaces. This layer is independent of any framework or infrastructure concerns.

### Application Layer
Contains application services that orchestrate the use cases. This layer coordinates the domain objects to perform the required tasks.

### Infrastructure Layer
Contains implementations of repository interfaces, database configurations, and other infrastructure concerns like exception handling.

### Presentation Layer
Contains REST controllers that handle HTTP requests and responses.

## Database Migrations

This project uses **Flyway** for database migrations. Migration scripts are located in `src/main/resources/db/migration/`.

### Migration Naming Convention
- Format: `V{version}__{description}.sql`
- Example: `V1__add_principal_id_to_brands.sql`

### Running Migrations
Migrations run automatically on application startup. To run migrations manually:

```bash
# Run migrations via Maven
mvn flyway:migrate

# Check migration status
mvn flyway:info

# Repair migration history (if needed)
mvn flyway:repair
```

### Creating New Migrations
1. Create a new SQL file in `src/main/resources/db/migration/`
2. Follow the naming convention: `V{next_version}__{description}.sql`
3. Write your SQL statements
4. Restart the application or run `mvn flyway:migrate`

## Testing

```bash
# Run all tests
mvn test

# Run tests with coverage
mvn test jacoco:report
```

## Health Check

The application exposes health endpoints via Spring Actuator:

- **Health**: http://localhost:8080/api/actuator/health
- **Info**: http://localhost:8080/api/actuator/info
- **Metrics**: http://localhost:8080/api/actuator/metrics

## License

MIT License
