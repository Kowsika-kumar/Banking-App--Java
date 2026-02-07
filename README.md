🏦 BankApp – Spring Boot Banking REST API

BankApp is a RESTful banking application built using Spring Boot that provides core banking operations such as account retrieval, deposits, and withdrawals.
The project follows clean layered architecture, uses DTO & Mapper patterns, and integrates with MySQL using Spring Data JPA.

✨ Features

Retrieve account details by ID

Fetch all bank accounts

Deposit money into an account

Withdraw money from an account

Custom exception handling for invalid resources

Clean separation of Controller, Service, Repository layers

🛠 Tech Stack

Language: Java

Framework: Spring Boot

ORM: Spring Data JPA (Hibernate)

Database: MySQL

Build Tool: Maven

API Testing: Postman

IDE: IntelliJ IDEA

📂 Project Structure
src/main/java/com/example/bankApp
│
├── controller
│   └── AccountController.java
│
├── dto
│   └── AccountDto.java
│
├── entity
│   └── Account.java
│
├── exception
│   └── ResourceNotFoundException.java
│
├── mapper
│   └── AccountMapper.java
│
├── repository
│   └── AccountRepository.java
│
├── service
│   ├── AccountService.java
│   └── impl
│       └── AccountServiceImpl.java
│
└── BankAppApplication.java

🔁 Application Flow
Client (Postman)
     ↓
Controller (REST APIs)
     ↓
Service (Business Logic)
     ↓
Repository (JPA)
     ↓
MySQL Database

🌐 REST API Endpoints
🔹 Get Account by ID

GET

/api/accounts/{id}


Response

{
  "id": 1,
  "accountHolderName": "John",
  "balance": 5000
}

🔹 Get All Accounts

GET

/api/accounts/allaccounts

🔹 Deposit Amount

PUT

/api/accounts/{id}/deposit


Request Body

{
  "amount": 2000
}

🔹 Withdraw Amount

PUT

/api/accounts/{id}/withdraw


Request Body

{
  "amount": 1000
}

⚠️ Exception Handling

ResourceNotFoundException is thrown when an account ID does not exist.

Prevents application crashes and returns meaningful error messages.

Example:

Account not found with id : 10

🗄 Database Configuration

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/bankdb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

▶️ How to Run the Project
1️⃣ Clone the Repository
git clone https://github.com/your-username/bankApp.git

2️⃣ Create Database
CREATE DATABASE bankdb;

3️⃣ Run the Application
mvn spring-boot:run


OR
Run BankAppApplication.java from IntelliJ.

🧪 Testing

Use Postman

Set header:
Content-Type: application/json

Use PUT for deposit & withdraw APIs

🚀 Future Enhancements

Create account API

Delete account API

Transaction history

JWT Authentication

Swagger/OpenAPI documentation

Global exception handling (@ControllerAdvice)



Kowsika K
Electronics & Communication Engineering
Skills: Java, Spring Boot, MySQL, HTML, CSS,
