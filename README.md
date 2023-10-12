# ItemCollection.github.io

DealVPS Assignment - Item Management System
This project is a simple Item Management System that provides basic CRUD (Create, Read, Update, Delete) operations for items. It is implemented using Spring Boot, Spring Data JPA, and other related technologies.

Table of Contents
Endpoints
Entities
Exceptions
Payloads
Repositories
Services
Application Configuration
Endpoints
Item Controller
The ItemController class provides RESTful endpoints for managing items.

Create Item

Endpoint: POST /api/items/
Request Body: ItemDto
Response Body: ItemDto
Update Item

Endpoint: PUT /api/items/{itemId}
Path Variable: itemId
Request Body: ItemDto
Response Body: ItemDto
Delete Item

Endpoint: DELETE /api/items/{itemId}
Path Variable: itemId
Response Body: ApiResponse
Get All Items

Endpoint: GET /api/items/
Response Body: List of ItemDto
Get Item by ID

Endpoint: GET /api/items/{itemId}
Path Variable: itemId
Response Body: ItemDto
Global Exception Handler
The GlobalExceptionHandler class handles global exceptions.

Resource Not Found Exception

Exception Type: ResourseNotFoundException
Response Body: ApiResponse
Method Argument Not Valid Exception

Exception Type: MethodArgumentNotValidException
Response Body: Map<String, String>
Entities
Item Entity
The Item class represents the entity for items.

Fields:
id (auto-generated)
name (String)
description (String)
Exceptions
Resource Not Found Exception
The ResourseNotFoundException class is a custom exception for resource not found scenarios.

Fields:
resourceName (String)
fieldName (String)
fieldValue (long)
Payloads
ApiResponse
The ApiResponse class represents the response structure for API operations.

Fields:
message (String)
success (boolean)
ItemDto
The ItemDto class represents the data transfer object for items.

Fields:
id (int)
name (String)
description (String)
Repositories
Item Repository
The ItemRepository interface extends JpaRepository for item-related database operations.

Services
Item Service
The ItemService interface defines the service methods for item management.

createItem(ItemDto item)
updateItem(ItemDto item, Integer itemId)
getItemById(Integer itemId)
getAllItems()
deleteItem(Integer itemId)
Item Service Implementation
The ItemServiceImpl class implements the ItemService interface.

Application Configuration
Main Application Class
The MohitcodesApplication class is the main application class.

Bean:
ModelMapper bean for object mapping.
