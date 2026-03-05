# Technical Context: Spring PTK

## Technology Stack

### Core Framework
- **Java 17** - Language version
- **Spring Boot 3.2.3** - Application framework
- **Maven** - Build tool and dependency management

### Data Layer
- **Spring Data JPA** - Data persistence abstraction
- **Hibernate** - ORM implementation
- **MySQL 8.0+** - Production database
- **H2 Database** - Testing database
- **HikariCP** - Connection pooling
- **Flyway** - Database migration tool

### Security
- **Spring Security** - Authentication and authorization
- **JWT (JSON Web Tokens)** - Stateless authentication
- **BCrypt** - Password hashing

### API Documentation
- **SpringDoc OpenAPI** - API documentation
- **Swagger UI** - Interactive API explorer

### Code Generation & Utilities
- **Lombok** - Boilerplate code reduction
- **MapStruct** - Object mapping

## Development Setup

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+

### Database Configuration
```yaml
Host: localhost
Port: 3306
Database: prod_ptk
Username: root
Password: password
```

### Running the Application
```bash
# Build
mvn clean install

# Run
mvn spring-boot:run

# Or run JAR
java -jar target/spring-ptk-0.0.1-SNAPSHOT.jar
```

### Testing
```bash
# Run tests
mvn test

# With coverage
mvn test jacoco:report
```

## Configuration Files

### Main Configuration
- `src/main/resources/application.yml` - Main application config
- `src/test/resources/application-test.yml` - Test configuration

### Key Configuration Properties
```yaml
server:
  port: 8080
  servlet:
    context-path: /api

jwt:
  secret: [base64-encoded-secret]
  expiration: 86400000  # 24 hours
  refresh-expiration: 604800000  # 7 days

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
```

## Dependencies (Key)
- `spring-boot-starter-web` - Web MVC
- `spring-boot-starter-data-jpa` - JPA support
- `spring-boot-starter-security` - Security
- `spring-boot-starter-validation` - Bean validation
- `springdoc-openapi-starter-webmvc-ui` - OpenAPI/Swagger
- `mysql-connector-j` - MySQL driver
- `flyway-core`, `flyway-mysql` - Database migrations
- `jjwt-api`, `jjwt-impl`, `jjwt-jackson` - JWT library
- `lombok` - Code generation
- `mapstruct` - Object mapping

## Build Output
- JAR file: `target/spring-ptk-0.0.1-SNAPSHOT.jar`
