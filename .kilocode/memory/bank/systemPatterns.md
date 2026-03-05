# System Patterns: Spring PTK

## Architecture Overview
The project follows **Domain-Driven Design (DDD)** with a layered architecture:

```
src/main/java/com/ptk/
├── domain/           # Core business logic (entities, repositories, exceptions)
├── application/      # Use cases (services, DTOs, mappers)
├── infrastructure/   # Technical implementations (persistence, security, config)
└── presentation/     # API layer (controllers)
```

## Key Design Patterns

### 1. Repository Pattern
- **Domain Repository Interface**: `ProductRepository`, `BrandRepository` in `domain/repository/`
- **JPA Repository**: `JpaProductRepository`, `JpaBrandRepository` in `infrastructure/persistence/`
- **Implementation**: `ProductRepositoryImpl`, `BrandRepositoryImpl` bridges domain and JPA

### 2. DTO Pattern
- Request DTOs: `ProductRequest`, `BrandRequest`, `LoginRequest`
- Response DTOs: `ProductResponse`, `BrandResponse`, `AuthResponse`
- Common DTOs: `ApiResponse<T>`, `PageResponse<T>`

### 3. Mapper Pattern
- Uses MapStruct for entity-DTO mapping
- `ProductMapper`, `BrandMapper` in `application/mapper/`

### 4. Service Layer Pattern
- Interface: `ProductService`, `BrandService`, `AuthService`
- Implementation: `ProductServiceImpl`, `BrandServiceImpl`, `AuthServiceImpl`

## Security Architecture

### JWT Authentication Flow
1. `JwtAuthenticationFilter` intercepts requests
2. Extracts and validates JWT token via `JwtService`
3. Loads user details via `UserBackofficeDetailsService`
4. Sets authentication in `SecurityContextHolder`

### Security Configuration
- Whitelist paths defined in `SecurityConfig.WHITE_LIST_URLS`
- Stateless session management
- BCrypt password encoding

## Database Patterns
- JPA/Hibernate for ORM
- `BaseEntity` provides common fields (id, createdAt, updatedAt)
- MySQL dialect with HikariCP connection pooling

## API Response Pattern
All API responses wrapped in `ApiResponse<T>`:
```java
{
  "success": boolean,
  "message": String,
  "data": T,
  "timestamp": LocalDateTime
}
```

## Configuration
- `application.yml` for main configuration
- Context path: `/api`
- JWT secret and expiration in config
- SpringDoc OpenAPI for documentation
