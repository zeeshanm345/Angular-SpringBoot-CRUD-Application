Angular and Spring Boot CRUD Application
Angular and Spring Boot CRUD Application
This is a simple CRUD (Create, Read, Update, Delete) application built with Angular 10 for the frontend and Spring Boot for the backend.

Technologies Used
Angular 10
Spring Boot 2.7
PostgreSQL
Features
Create new records
Read existing records
Update existing records
List all records
Search records
Usage
Backend
The backend is a Spring Boot application that provides REST APIs to perform CRUD operations on a PostgreSQL database.

The main REST endpoints are:

Copy code

GET /api/v1/employe - Get all employees
POST /api/v1/employe - Create a new employee
GET /api/v1/employe/{id} - Get employee by id
PUT /api/v1/employe/{id} - Update employee 
DELETE /api/v1/employe/{id} - Delete employee
To run the backend:

Configure PostgreSQL connection settings
Run mvn spring-boot:run
The backend will start on port 8080.

Frontend
The frontend Angular app consumes the REST APIs exposed by the backend.

To run the frontend:

Run npm install
Run ng serve
The frontend will start on port 4200.

The main routes are:

/ - Home page
/employees - List all employees
/employees/new - Create employee form
/employees/:id - View employee
