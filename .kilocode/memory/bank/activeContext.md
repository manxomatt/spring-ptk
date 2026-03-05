# Active Context: Spring PTK

## Current State
The project is a functional Spring Boot REST API with:
- Product and Brand management endpoints
- JWT-based authentication
- Swagger UI documentation
- MySQL database integration

## Recent Changes (2026-02-28)

### Swagger UI Access Fix
**Issue**: Access denied when accessing `/api/swagger-ui/index.html`

**Solution Applied**:
1. Added context path to `application.yml`:
   ```yaml
   server:
     servlet:
       context-path: /api
   ```

2. Updated security whitelist in `SecurityConfig.java`:
   - Changed `/api/v1/auth/**` to `/v1/auth/**` (context path handled by servlet)
   - Added `/swagger-ui/index.html` explicitly
   - Added `/api-docs/**` and `/api-docs` paths

## Current Focus Areas
- API security configuration
- Swagger/OpenAPI documentation accessibility
- JWT authentication flow

## Active Endpoints

### Authentication
- `POST /api/v1/auth/login` - User login
- `POST /api/v1/auth/refresh` - Refresh token

### Products
- `GET /api/v1/products` - List all products
- `GET /api/v1/products/{id}` - Get product by ID
- `POST /api/v1/products` - Create product
- `PUT /api/v1/products/{id}` - Update product
- `DELETE /api/v1/products/{id}` - Delete product

### Brands
- `GET /api/v1/brands` - List all brands
- `GET /api/v1/brands/{id}` - Get brand by ID
- `POST /api/v1/brands` - Create brand
- `PUT /api/v1/brands/{id}` - Update brand
- `DELETE /api/v1/brands/{id}` - Delete brand

## Known Issues
- None currently active

## Next Steps
- Verify Swagger UI accessibility after restart
- Continue implementing additional domain entities
- Add comprehensive test coverage
