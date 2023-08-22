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
- [Submission](#submission)

## Project Overview

This assignment is part of the Java Fullstack course at Noroff Accelerate. It involves creating a Spring Boot application using JDBC for data access. It is divided into two main parts: working with the Superheroes database and the Chinook database. The Superheroes database focuses on schema creation, relationships, and data population. The Chinook database requires implementing various functionalities related to customer data.

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

## Branching Strategy

Follow a structured branching strategy to manage the project's development. Create branches for specific functionalities or tasks. Use descriptive branch names, and prefix branches with the developer's name. Frequent commits are encouraged, especially after completing each requirement.

## Submission

Follow these steps for submission:

1. Create a GitLab repository containing your code and the `superheroes-scripts` folder.
2. Add me (@NicholasLennox) as a Maintainer.
3. Submit the link to your GitLab repository.

Remember to include the names of both group members in the submission.

Feel free to expand on the project's functionality and user experience beyond the minimum requirements. Good luck with the project!
