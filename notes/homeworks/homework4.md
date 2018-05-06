# Homework 4

## Deliverables

* mysql/GeneratorsDAOImpl.java
* Necessary Servlet changes

## Description

In this homework, we are going to finish up the last piece of the project –
refactoring the GeneratorsDAO to use MySQL to store meta information.

Your task here is to implement similar implementation just like lab 7 of
EventsDAO but for GeneratorsDAO.

Once this refactor is completed, the CS3 application should be fully working with
generators and events connecting to database. The front end should be running in
JavaScript with passing the meta information through JSON format to JavaScript.

You may download from the starter code from: https://github.com/rcliao/cookie-clicker/releases/tag/hw4

Files changes from Lab 7:

* src/main/java/edu/csula/storage/mysql/GeneratorsDAOImpl.java
* src/test/java/edu/csula/storage/mysql/GeneratorsDAOImplTest.java

## Requirements

### Functional

* UI Remaining the same functionalities

### Technical

* Store Generators information in the MySQL database
* Passing all unit tests
* Application should be *fully* working on CS3 server
