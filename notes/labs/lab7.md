# Lab 7

## Deliverables

* `schema.sql`
* `EventsDAOImpl.java` under _mysql_ package
* `Events related Servlet` changes
* Single txt submission containing link to the *pull request* and *cs 3 application*

## Description

In this lab, we first implement the DAO by using JDBC under mysql package. Then,
we refactor out the existing usage of the DAO to use MySQL instead of using
application scope DAO.

The functionality should remain unchanged while refactoring.

At the end of this lab, your application should be reading data from MySQL rather
than from memory (application scope). This implies that all the data you create
in the application should be _persistent_ across the server restart.

To do so, you may find the following items useful to start with:

1. Create `schema.sql` that defines table schemas and insert sample data
2. Change the `*Query` variables under _EventsDAOImpl_
3. Implement each method under _EventsDAOImpl_ until passing all unit tests
4. Execute `schema.sql` against the database you are connecting with (local and CS3)
5. Refactor the DAO usages from the Servlet (controller layer)

## Requirements

### Functional

* Application should remain the same as before

### Technical

* Data should be read from database
* Should pass all unit tests
* Should utilize the DAO under mysql package throughout the Servlets
