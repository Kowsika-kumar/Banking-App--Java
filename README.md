# Banking-App--Java
A simple Bank Account Management REST API built using Spring Boot, Spring Data JPA, and MySQL. This application allows users to create accounts, view accounts, deposit money, and withdraw money.

1. Features

Create and manage bank accounts

Get account details by ID

Fetch all accounts

Deposit money into an account

Withdraw money from an account

Exception handling for invalid account IDs

DTO and Mapper pattern used for clean architecture

2. Project Structure

bankApp
 └── src/main/java/com/example/bankApp
     ├── controller
     │   └── AccountController.java
     ├── dto
     │   └── AccountDto.java
     ├── entity
     │   └── Account.java
     ├── exception
     │   └── ResourceNotFoundException.java
     ├── mapper
     │   └── AccountMapper.java
     ├── repository
     │   └── AccountRepository.java
     ├── service
     │   ├── AccountService.java
     │   └── impl
     │       └── AccountServiceImpl.java
     └── BankAppApplication.java
 └── src/main/resources
     └── application.properties
3.🛠️ Tech Stack
Backend	Java, Spring Boot
ORM	Spring Data JPA (Hibernate)
Database	MySQL
Build Tool	Maven
API Testing	Postman
IDE	IntelliJ IDEA

4.Architecture Overview

This project follows a Layered Architecture:

Controller → Service → Repository → Database


Controller: Handles HTTP requests & responses

Service: Business logic

Repository: Database access

DTO: Prevents exposing entity directly

Mapper: Converts Entity ↔ DTO

5.Exception Handling

ResourceNotFoundException
Thrown when:
Account ID does not exist
Example message:
Account not found with id : 5
Handled centrally to return clean error responses.

