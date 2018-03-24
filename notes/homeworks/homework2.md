# Homework 2

## Deliverables

* Single txt file containing link to **the pull request** and **CS3 application**

Pull request should at least containing the following changed files:

* AdminGeneratorsServlet.java
* GeneratorsDAOImpl.java
* app.css

## Descriptions

In this lab, we will pick up what we implemented back in exercise-2 with the
proper backend functionality. To get started with, we will implement the generators
configuration page like below:

![admin generators configuration page](../imgs/project/admin-generators.png)

And your mission is to create Java Servlets that:

* Display the page as above
* Handle the necessary persistence about generators information

## Get Started

You should continue your code from lab 4 before except download additional two
files under homework 2 release:
https://github.com/rcliao/cookie-clicker/releases/tag/hw2

The two files are:
* `src/main/java/edu/csula/models/Generator.java`
* `src/test/java/edu/csula/storage/servlet/GeneratorsDAOImplTest.java`

Once download these two files, add those two files to be under your lab 4.

And you are ready to start. Use `./gradlew check` to find all the failing tests
and modify `GeneratorsDAOImpl.java` to fix the unit test.

## Requirements

### Functional

* User should be able to create event passing generator name, description, rate, base cost and unlock value
* User should be able to see a list of generators
* User should be able to modify a single generator

### Technical

* Application needs to be deployed to CS3 server
* Application should store the generator information in application scope
* Application should display HTML with proper CSS (similar to what you have accomplished in exercise-2)
* Should pass all the unit tests from `./gradlew check`
