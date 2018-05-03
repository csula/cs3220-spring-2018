# Homework 4

## Deliverables

* GeneratorsDAOImpl.java
* EventsService.java

## Description

In this homework, we will continue our effort from lab 7 to finish up the
database refactor work with GeneratorsDAO.

Your job is to implement the GeneratorsDAO and pass the unit tests just like
lab 7.

In additional to implementing the generators DAO, you will need to implement the
RESTful service layer with the lightweight library of Jersey (see notes from
modern Java framework) for the Events. One should be able to use
[Insomnia](https://insomnia.rest/) to test for functionality as the spec below:

```
GET     http://localhost:8080/api/v1/events
POST    http://localhost:8080/api/v1/events
PUT     http://localhost:8080/api/v1/event/:id
DELETE  http://localhost:8080/api/v1/event/:id
```

Please read up on [RESTful on wiki page](https://en.wikipedia.org/wiki/Representational_state_transfer) to under each end point and its meaning.

Upon implementing each service as above in `EventsService.java`, you should be
able to pass unit tests.

## Requirements

### Functional

* UI Remaining the same functionalities as before
* Server should provide additional API endpoints

### Technical

* Store Generators information in the MySQL database
