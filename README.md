# Assignment 2 - Data Access with JDBC 

## Table of Contents

- [Project Overview](#project-overview)
- [Setup](#setup)
- [Superheroes Database](#superheroes-database)
    - [SQL Scripts](#sql-scripts)
    - [Repository Implementation](#repository-implementation)
- [Chinook Database](#chinook-database)
    - [Functionality](#functionality)
    - [Repository Pattern](#repository-pattern)
    - [Branching Strategy](#branching-strategy)


## Project Overview

This assignment is part of the Java Fullstack course at Noroff Accelerate. It involves creating a Spring Boot application using JDBC for data access. It is divided into two main parts: working with a Superheroes database and a Chinook database. The Superheroes database focuses on schema creation, relationships, and data population. The Chinook database requires implementing various functionalities related to customer data.

## Setup

The setup of the development environment requires the following tools installed:

- Intellij Ultimate
- Postgres and PgAdmin
- Java 17
- Postgres SQL driver dependency

## Superheroes Database

### SQL Scripts

Scripts for the Superheroes database are located in the `SuperheroDb` folder. Follow the instructions in each script to create tables, define relationships, and populate data.

### Repository Implementation

For the Superheroes database, you need to implement a repository to access data. The repository interface should be placed in the `com.example.superheroes.repository` package. Javadoc should be provided for each method, explaining its purpose, potential exceptions, and return data (if applicable).

## Chinook Database

The Chinook database involves interacting with the provided database to implement specific functionalities.

### Functionality

The following functionalities are required for the Chinook database:

1. Read all customers.
2. Read a specific customer by ID.
3. Read a specific customer by name.
4. Return a page of customers with limit and offset parameters.
5. Add a new customer to the database.
6. Update an existing customer.
7. Return the country with the most customers.
8. Identify the highest-spending customer.
9. Determine the most popular genre for a given customer.

### Repository Pattern

Implement the repository pattern for data access. Create the required repository interfaces and classes in the `com.example.chinook.repository` package. Utilize the generic CRUD parent interface along with a specialized customer repository.

### Branching Strategy

GitHub issues were used to manage the development process.
GitHub issues were created for each of the required functionalities listed above, as well as for other tasks such as project structure setup and documentation.  This helped the development team to get a structured overview of the tasks that needed to be completed, and the associated functional requirements.
Each of these created for each of these issues which means that each development branch shares the descriptive name of the given task.


a big portion of the development process was done practicing pair programming. Pair programming




