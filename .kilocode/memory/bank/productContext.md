# Product Context: Spring PTK

## Problem Statement
Organizations need a robust, secure, and well-structured backend API for managing products, brands, and user authentication in their business operations.

## Solution
Spring PTK provides a Domain-Driven Design based REST API that:
- Separates concerns into distinct layers (Domain, Application, Infrastructure, Presentation)
- Implements secure JWT-based authentication
- Offers comprehensive API documentation
- Uses industry-standard technologies (Spring Boot, MySQL, JPA)

## User Experience Goals
- **Developers**: Easy-to-understand API with clear documentation via Swagger UI
- **Integrators**: Consistent response formats with `ApiResponse` wrapper
- **Administrators**: Secure access control with role-based permissions

## How It Works
1. Users authenticate via `/api/v1/auth/login` to obtain JWT tokens
2. Authenticated requests include the JWT in the Authorization header
3. API endpoints validate tokens and authorize based on user roles
4. Responses follow a consistent format with success/error indicators

## Key URLs
- **Swagger UI**: `http://localhost:8080/api/swagger-ui/index.html`
- **API Docs**: `http://localhost:8080/api/api-docs`
- **Health Check**: `http://localhost:8080/api/actuator/health`
