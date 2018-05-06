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

You may find the starter code from the release:
https://github.com/rcliao/cookie-clicker/releases/tag/lab-7-2

In specific, you will need to create/overwrite the following files:

* `src/main/java/edu/csula/storage/Database.java`
* `src/main/java/edu/csula/storage/mysql/Database.java`
* `src/main/java/edu/csula/storage/mysql/EventsDAOImpl.java`
* `src/test/java/edu/csula/storage/mysql/EventsDAOImplTest.java`

At the end of this lab, your application should be reading data from MySQL rather
than from memory (application scope). This implies that all the data you create
in the application should be _persistent_ across the server restart.

To do so, following items may be useful to get you started:

1. Create `schema.sql` that defines table schemas and insert sample data
2. Change the `*Query` String variables under _EventsDAOImpl_
3. Implement each method under _EventsDAOImpl_ until passing all unit tests
4. Execute `schema.sql` against the database you are connecting with (local and CS3)
5. Refactor the DAO usages from the Servlet (controller layer)
6. Test to ensure the functionalities remain the same

## Requirements

### Functional

* Application should remain the same as before

### Technical

* Data should be read from database
* Should pass all unit tests
* Should utilize the DAO under mysql package throughout the Servlets
