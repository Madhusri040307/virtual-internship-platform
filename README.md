# Virtual Internship Platform for Students

A Java Spring Boot based backend platform designed to help students discover internships, apply for opportunities, and track their application status through a centralized system.

## Project Overview

The **Virtual Internship Platform for Students** provides a structured platform where students can register, log in securely, browse available internships, apply for internships, and track their application status.

The backend is developed using **Java and Spring Boot** with **MySQL** as the database.

## Main Features

* Student registration
* Student login with JWT authentication
* Admin registration and login
* Internship creation
* Internship listing
* Internship search
* Internship pagination
* Internship update and deletion
* Student internship applications
* Application status management
* Application status values:

  * APPLIED
  * ACCEPTED
  * REJECTED
* Request validation
* Global exception handling
* Standardized API responses
* Password encryption using BCrypt
* RESTful APIs

## Technologies Used

### Backend

* Java 17
* Spring Boot 4.0.8
* Spring Web MVC
* Spring Data JPA
* Spring Security
* JWT
* BCrypt

### Database

* MySQL 8.0

### Build Tool

* Maven

### Development Tools

* Visual Studio Code
* Git
* GitHub
* Postman

## System Architecture

```text
Student / Admin
      |
      v
React Frontend
      |
      v
REST API
      |
      v
Spring Boot Backend
      |
      v
Spring Data JPA
      |
      v
MySQL Database
```

## Project Structure

```text
virtual_internship_platform/
│
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── virtual_internship_platform/
│   │   │   │           └── backend/
│   │   │   │               ├── controller/
│   │   │   │               ├── entity/
│   │   │   │               ├── exception/
│   │   │   │               ├── repository/
│   │   │   │               ├── response/
│   │   │   │               ├── security/
│   │   │   │               └── service/
│   │   │   │
│   │   │   └── resources/
│   │   │
│   │   └── test/
│   │
│   └── pom.xml
│
├── diagrams/
│   ├── architecture_diagram.md
│   ├── block_diagram.md
│   └── workflow.md
│
├── project_details.md
├── README.md
└── .gitignore
```

## API Endpoints

### Student

| Method | Endpoint                 | Description      |
| ------ | ------------------------ | ---------------- |
| POST   | `/api/students/register` | Register student |
| POST   | `/api/students/login`    | Student login    |

### Admin

| Method | Endpoint            | Description  |
| ------ | ------------------- | ------------ |
| POST   | `/api/admin/create` | Create admin |
| POST   | `/api/admin/login`  | Admin login  |

### Internships

| Method | Endpoint                  | Description                     |
| ------ | ------------------------- | ------------------------------- |
| POST   | `/api/internships`        | Create internship               |
| GET    | `/api/internships`        | Get all internships             |
| GET    | `/api/internships/{id}`   | Get internship by ID            |
| GET    | `/api/internships/search` | Search and paginate internships |
| PUT    | `/api/internships/{id}`   | Update internship               |
| DELETE | `/api/internships/{id}`   | Delete internship               |

### Applications

| Method | Endpoint                                      | Description                 |
| ------ | --------------------------------------------- | --------------------------- |
| POST   | `/api/applications`                           | Apply for internship        |
| GET    | `/api/applications/student/{studentId}`       | Get student's applications  |
| GET    | `/api/applications/internship/{internshipId}` | Get internship applications |
| PUT    | `/api/applications/{id}/status`               | Update application status   |

## Search and Pagination

Internships can be searched using the internship title.

Example:

```text
GET /api/internships/search?title=Java&page=0&size=5
```

Where:

* `title` = internship title to search
* `page` = page number
* `size` = number of internships per page

## Authentication

The platform uses:

* BCrypt for password encryption
* JWT for stateless authentication
* Spring Security for API security

Protected APIs require a JWT token in the request header:

```text
Authorization: Bearer <JWT_TOKEN>
```

## Database

Database name:

```text
virtual_internship_db
```

The application uses MySQL with Spring Data JPA for database operations.

Database credentials are stored locally in `application.properties` and are excluded from GitHub using `.gitignore`.

## Current Development Progress

The project is being developed incrementally using meaningful Git commits.

Completed modules include:

* Project documentation
* Student authentication
* Internship CRUD
* Internship application management
* Admin authentication
* Request validation
* Global exception handling
* Standardized API responses
* Internship search and pagination
* Application status management

## Future Development

Planned modules include:

* Swagger API documentation
* Unit testing
* Integration testing
* React frontend
* Student dashboard
* Admin dashboard
* Application management interface
* Dockerization
* Final project integration and testing

## Author

**Madhu Sri K**

Department of Information Technology
JJCET-Trichy
