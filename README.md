# Assignment 2 - Data Access with JDBC 

### Authors 
<div style="display: flex; justify-content: space-between; align-items: center;">
  <div align="center" style="color: #d8d7d6;">
    <a href="https://github.com/vildekure">
      <img src="https://ca.slack-edge.com/T05AYAELMFV-U05M988QPMW-0b4bbf7a3958-512" alt="Vilde Kure" width="100" height="100" style="border-radius: 50%;">
    </a>
    <br>
    Vilde Kure
  </div>
  <div align="center" style="color: #d8d7d6;">
    <a href="https://github.com/egilhagen">
      <img src="https://media.licdn.com/dms/image/D4D03AQGK973sBlwNUA/profile-displayphoto-shrink_800_800/0/1692127770924?e=1698278400&v=beta&t=zR_SxHZqgq7IDqPSS9O8gtZpG64jPEPif37dPPfspe8" alt="Egil Hagen" width="100" height="100" style="border-radius: 50%;">
    </a>
    <br>
    Egil Hagen
  </div>
</div>

## Table of Contents

- [Project Overview](#project-overview)
- [Setup](#setup)
- [Superheroes Database](#superheroes-database)
    - [SQL Scripts](#sql-scripts)
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

Scripts for the Superheroes database are located in the `SuperheroDb` folder. Each script creates tables, defines relationships, and populate data.
- `01_tableCreate.sql:`Creates tables.
- `02_relationshipSuperheroAssistant.sql:` Creates foreign key in assistant, connecting it to superhero (one-to-many).
- `03_relationshipSuperheroPower.sql:`Creates a new table to connect superhero to power (many-to-many).
- `04_insertSuperheroes.sql:` Inserts new superheroes into the database.
- `05_insertAssistants.sql:` Inserts assistants and associates them with superheroes.
- `06_powers.sql:` Inserts powers and associates them with superheroes to demonstrate the many-to-many relationship.
- `07_updateSuperhero.sql:` Updates a given superhero based on ID.
- `08_deleteAssistant.sql:` Deletes assistants based on name.


## Chinook Database

Work on the Chinook database involves interacting with the provided database to implement specific functionalities.



### Repository Pattern

A repository pattern for data access has been implemented in the `no.accelerate.assignment2.repository` package. 
We utilize the generic CRUD parent interface along with specialized repositories for specific customer-related queries. 
These repositories extend the CRUDRepository and provide methods for querying customers based on various criteria.

`CustomerGenreRepository:` Provides methods for querying customers based on their preferred music genre.

`CustomerCountryRepository:` Provides methods for querying customers based on their country.

`CustomerSpenderRepository:` Provides methods for querying customers based on their spending behavior.

`CustomerRepositoryImpl:` A generic implementation of the CustomerRepository interface that includes basic CRUD operations. It inherits from CRUDRepositoryImpl and can be extended with additional methods.
By using the repository pattern, you can separate the data access logic from the rest of your application's business logic. This makes your code more maintainable and easier to test. It also allows you to encapsulate complex database operations behind simple and consistent methods.


### Functionality
The following functionalities are required for the Chinook database:

1. Read all customers.
2. Read a specific customer by ID.
3. Read a specific customer by name.
4. Return a page of customers with limit and offset parameters.
5. Add a new customer to the database (A method for deleting a customer by ID has also been implemented).
6. Update an existing customer.
7. Return the country with the most customers.
8. Identify the highest-spending customer.
9. Determine the most popular genre for a given customer.

### Branching Strategy
GitHub issues were created for each of the required functionalities listed above, as well as for other tasks such as project structure setup and documentation.  This helped the development team to get a structured overview of the tasks that needed to be completed, and the associated functional requirements.
A branch was created for each of these issues which means that each development branch shared the descriptive name of the given task.
This allowed us to safely work on implementing functionality locally while making sure the master branch was operational at al times. 





