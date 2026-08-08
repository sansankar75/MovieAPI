# Movie Booking System

A backend REST API for managing movies, theaters, screens, seats, shows, bookings, payments, users, actors, and genres.

The application is built with **Java and Spring Boot** using a layered architecture that separates HTTP request handling, business logic, data access, and persistence.

---

## Features

* Movie management
* Actor management
* Genre management
* Theater management
* Screen management
* Seat management
* Show scheduling
* Show-seat availability management
* User management
* Booking management
* Payment management
* Request validation using Jakarta Bean Validation
* Centralized exception handling
* Resource-not-found handling
* Duplicate-resource handling
* JPA/Hibernate entity mapping
* PostgreSQL database integration

---

## Architecture

The application follows a layered architecture:

```text
                    Client
                      │
                      ▼
              ┌───────────────┐
              │   Controller  │
              │  REST API     │
              └───────┬───────┘
                      │
                      ▼
              ┌───────────────┐
              │    Service    │
              │ Business Logic│
              └───────┬───────┘
                      │
                      ▼
              ┌───────────────┐
              │   Repository  │
              │ Data Access   │
              └───────┬───────┘
                      │
                      ▼
              ┌───────────────┐
              │   PostgreSQL  │
              │   Database    │
              └───────────────┘
```

### Request flow

```text
HTTP Request
     │
     ▼
Controller
     │
     ▼
Service
     │
     ▼
Repository
     │
     ▼
PostgreSQL
     │
     ▼
Repository
     │
     ▼
Service
     │
     ▼
Controller
     │
     ▼
HTTP Response
```

---

## Domain Model

The main entities and their relationships are:

```text
Theater
   │
   └── Screen
         │
         └── Seat

Movie ───────────────┐
                     │
Screen ──────────────┼──> Show
                     │      │
                     │      └── ShowSeat
                     │            │
                     │            └── Seat
                     │
User ───────────────────> Booking
                           │
                           ├── BookingSeat
                           │
                           └── Payment
```

### Core entities

| Entity        | Responsibility                                   |
| ------------- | ------------------------------------------------ |
| `User`        | Stores user information and role                 |
| `Movie`       | Stores movie information                         |
| `Actor`       | Stores actor information                         |
| `Genre`       | Stores movie genre information                   |
| `Theater`     | Represents a cinema theater                      |
| `Screen`      | Represents an individual screen within a theater |
| `Seat`        | Represents a physical seat                       |
| `Show`        | Schedules a movie on a screen                    |
| `ShowSeat`    | Maintains seat availability for a specific show  |
| `Booking`     | Represents a user's movie booking                |
| `BookingSeat` | Associates seats with a booking                  |
| `Payment`     | Stores payment information for a booking         |

---

## Project Structure

```text
src/
└── main/
    └── java/
        └── com/
            └── example/
                └── moviebooking/
                    │
                    ├── MovieBookingApplication.java
                    │
                    ├── controller/
                    │   ├── ActorController.java
                    │   ├── BookingController.java
                    │   ├── GenreController.java
                    │   ├── MovieController.java
                    │   ├── PaymentController.java
                    │   ├── ScreenController.java
                    │   ├── SeatController.java
                    │   ├── ShowController.java
                    │   ├── ShowSeatController.java
                    │   ├── TheaterController.java
                    │   └── UserController.java
                    │
                    ├── service/
                    │   ├── ActorService.java
                    │   ├── BookingService.java
                    │   ├── GenreService.java
                    │   ├── MovieService.java
                    │   ├── PaymentService.java
                    │   ├── ScreenService.java
                    │   ├── SeatService.java
                    │   ├── ShowService.java
                    │   ├── ShowSeatService.java
                    │   ├── TheaterService.java
                    │   └── UserService.java
                    │
                    ├── repository/
                    │
                    ├── entity/
                    │   ├── Actor.java
                    │   ├── Booking.java
                    │   ├── BookingSeat.java
                    │   ├── Genre.java
                    │   ├── Movie.java
                    │   ├── Payment.java
                    │   ├── Screen.java
                    │   ├── Seat.java
                    │   ├── Show.java
                    │   ├── ShowSeat.java
                    │   ├── Theater.java
                    │   └── User.java
                    │
                    └── exception/
                        ├── GlobalExceptionHandler.java
                        ├── ResourceNotFoundException.java
                        └── ActorAlreadyExistsException.java
```

---

## REST API

Base URL:

```text
http://localhost:8080/api
```

### Actors

| Method   | Endpoint       | Description     |
| -------- | -------------- | --------------- |
| `GET`    | `/actors`      | Get all actors  |
| `GET`    | `/actors/{id}` | Get actor by ID |
| `POST`   | `/actors`      | Create actor    |
| `PUT`    | `/actors/{id}` | Update actor    |
| `DELETE` | `/actors/{id}` | Delete actor    |

### Bookings

| Method   | Endpoint         | Description       |
| -------- | ---------------- | ----------------- |
| `GET`    | `/bookings`      | Get all bookings  |
| `GET`    | `/bookings/{id}` | Get booking by ID |
| `DELETE` | `/bookings/{id}` | Delete booking    |

### Genres

| Method   | Endpoint       | Description     |
| -------- | -------------- | --------------- |
| `GET`    | `/genres`      | Get all genres  |
| `GET`    | `/genres/{id}` | Get genre by ID |
| `POST`   | `/genres`      | Create genre    |
| `PUT`    | `/genres/{id}` | Update genre    |
| `DELETE` | `/genres/{id}` | Delete genre    |

### Movies

| Method   | Endpoint       | Description     |
| -------- | -------------- | --------------- |
| `GET`    | `/movies`      | Get all movies  |
| `GET`    | `/movies/{id}` | Get movie by ID |
| `POST`   | `/movies`      | Create movie    |
| `PUT`    | `/movies/{id}` | Update movie    |
| `DELETE` | `/movies/{id}` | Delete movie    |

### Payments

| Method | Endpoint         | Description       |
| ------ | ---------------- | ----------------- |
| `GET`  | `/payments`      | Get all payments  |
| `GET`  | `/payments/{id}` | Get payment by ID |
| `POST` | `/payments`      | Create payment    |

### Screens

| Method   | Endpoint        | Description      |
| -------- | --------------- | ---------------- |
| `GET`    | `/screens`      | Get all screens  |
| `GET`    | `/screens/{id}` | Get screen by ID |
| `POST`   | `/screens`      | Create screen    |
| `PUT`    | `/screens/{id}` | Update screen    |
| `DELETE` | `/screens/{id}` | Delete screen    |

### Seats

| Method   | Endpoint      | Description    |
| -------- | ------------- | -------------- |
| `GET`    | `/seats`      | Get all seats  |
| `GET`    | `/seats/{id}` | Get seat by ID |
| `POST`   | `/seats`      | Create seat    |
| `PUT`    | `/seats/{id}` | Update seat    |
| `DELETE` | `/seats/{id}` | Delete seat    |

### Shows

| Method   | Endpoint      | Description    |
| -------- | ------------- | -------------- |
| `GET`    | `/shows`      | Get all shows  |
| `GET`    | `/shows/{id}` | Get show by ID |
| `POST`   | `/shows`      | Create show    |
| `PUT`    | `/shows/{id}` | Update show    |
| `DELETE` | `/shows/{id}` | Delete show    |

### Show Seats

| Method | Endpoint           | Description         |
| ------ | ------------------ | ------------------- |
| `GET`  | `/show-seats`      | Get all show seats  |
| `GET`  | `/show-seats/{id}` | Get show seat by ID |

### Theaters

| Method   | Endpoint         | Description       |
| -------- | ---------------- | ----------------- |
| `GET`    | `/theaters`      | Get all theaters  |
| `GET`    | `/theaters/{id}` | Get theater by ID |
| `POST`   | `/theaters`      | Create theater    |
| `PUT`    | `/theaters/{id}` | Update theater    |
| `DELETE` | `/theaters/{id}` | Delete theater    |

### Users

| Method   | Endpoint      | Description    |
| -------- | ------------- | -------------- |
| `GET`    | `/users`      | Get all users  |
| `GET`    | `/users/{id}` | Get user by ID |
| `POST`   | `/users`      | Create user    |
| `PUT`    | `/users/{id}` | Update user    |
| `DELETE` | `/users/{id}` | Delete user    |

---

## HTTP Status Codes

The API uses standard HTTP status codes.

| Status                      | Meaning                                      |
| --------------------------- | -------------------------------------------- |
| `200 OK`                    | Request completed successfully               |
| `201 CREATED`               | Resource successfully created                |
| `204 NO CONTENT`            | Resource successfully deleted                |
| `400 BAD REQUEST`           | Invalid request or validation failure        |
| `404 NOT FOUND`             | Requested resource does not exist            |
| `409 CONFLICT`              | Resource conflicts with an existing resource |
| `500 INTERNAL SERVER ERROR` | Unexpected server error                      |

---

## Exception Handling

The application uses `@RestControllerAdvice` for centralized exception handling.

```text
Controller
    │
    │ exception
    ▼
GlobalExceptionHandler
    │
    ├── ResourceNotFoundException
    │       └── 404 NOT FOUND
    │
    ├── MethodArgumentNotValidException
    │       └── 400 BAD REQUEST
    │
    ├── ActorAlreadyExistsException
    │       └── 409 CONFLICT
    │
    └── Exception
            └── 500 INTERNAL SERVER ERROR
```

Example error response:

```json
{
  "timestamp": "2026-08-08T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Movie not found with id: 10"
}
```

---

## Validation

Request validation is implemented using Jakarta Bean Validation.

Example:

```java
@NotBlank(message = "Name is required")
@Size(max = 100, message = "Name must not exceed 100 characters")
private String name;
```

Controllers use:

```java
@Valid @RequestBody
```

Invalid requests are automatically handled by the global exception handler.

---

## Database Relationships

### Theater → Screen

A theater can contain multiple screens.

```text
Theater 1 ──────── * Screen
```

### Screen → Seat

A screen contains multiple physical seats.

```text
Screen 1 ──────── * Seat
```

### Movie → Show

A movie can have multiple scheduled shows.

```text
Movie 1 ──────── * Show
```

### Show → ShowSeat

Each show has its own seat availability records.

```text
Show 1 ──────── * ShowSeat
```

The database enforces uniqueness for:

```text
(show_id, seat_id)
```

Therefore, the same physical seat cannot be registered twice for the same show.

### Booking → BookingSeat

A booking can contain multiple booked seats.

```text
Booking 1 ──────── * BookingSeat
```

### Booking → Payment

A booking has a one-to-one payment relationship.

```text
Booking 1 ──────── 1 Payment
```

---

## Technology Stack

| Technology         | Purpose                         |
| ------------------ | ------------------------------- |
| Java               | Application development         |
| Spring Boot        | Backend framework               |
| Spring Web         | REST API                        |
| Spring Data JPA    | Data access                     |
| Hibernate          | ORM                             |
| PostgreSQL         | Relational database             |
| Jakarta Validation | Request validation              |
| Lombok             | Boilerplate reduction           |
| Maven              | Build and dependency management |

---

## Running the Application

### Prerequisites

Install:

* Java 17+
* Maven
* PostgreSQL

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

---

### Database Configuration

Create a PostgreSQL database:

```sql
CREATE DATABASE MovieDB;
```

Configure the application in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.application.name=movieBookingSystem

server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5432/MovieDB
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Do not commit real database passwords to Git.

Use environment variables or an external configuration mechanism for production credentials.

---

## Build

Clone the repository and enter the project directory:

```bash
git clone <repository-url>
cd movie-booking
```

Build the project:

```bash
mvn clean package
```

Run the application:

```bash
mvn spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

---

## Example API Request

### Create a movie

```http
POST /api/movies
Content-Type: application/json
```

```json
{
  "title": "Inception",
  "description": "A science-fiction thriller",
  "language": "English",
  "releaseDate": "2010-07-16",
  "posterUrl": "https://example.com/poster.jpg",
  "status": "ACTIVE"
}
```

### Get movie by ID

```http
GET /api/movies/1
```

Example response:

```json
{
  "id": 1,
  "title": "Inception",
  "description": "A science-fiction thriller",
  "language": "English",
  "releaseDate": "2010-07-16",
  "posterUrl": "https://example.com/poster.jpg",
  "status": "ACTIVE"
}
```

---

## Design Principles

The project follows these core principles:

* **Separation of concerns** — controllers, services, repositories, and entities have distinct responsibilities.
* **Dependency Injection** — Spring manages service and repository dependencies.
* **Centralized exception handling** — REST errors are handled in one place.
* **Validation at the API boundary** — invalid request data is rejected before business processing.
* **Database integrity** — entity relationships and unique constraints enforce domain rules.
* **Layered architecture** — each layer communicates primarily with the layer below it.

---

## Current Scope

The current implementation provides CRUD-style REST operations for the core movie-booking entities.

The booking domain is modeled around:

```text
User
  │
  ▼
Booking
  │
  ├── BookingSeat ──> ShowSeat ──> Seat ──> Screen ──> Theater
  │
  └── Payment

Movie ──> Show ──> Screen
```

Advanced booking workflows such as transactional seat reservation, payment processing, authentication/authorization, and concurrent seat locking can be added as the system evolves.

---

## Future Improvements

Potential improvements include:

* DTO-based request and response models
* Spring Security authentication and authorization
* Password hashing with BCrypt
* JWT-based authentication
* Role-based access control
* Transactional booking workflow
* Concurrent seat-booking protection
* Payment gateway integration
* Movie-to-actor and movie-to-genre relationships
* Pagination and sorting
* Search and filtering
* API documentation with OpenAPI/Swagger
* Automated unit and integration tests
* Database migrations with Flyway or Liquibase
* Production-ready logging and monitoring
* Docker containerization

---

## License

This project is intended for educational and development purposes.

Add an appropriate open-source license here if the project will be publicly distributed.

```
```
