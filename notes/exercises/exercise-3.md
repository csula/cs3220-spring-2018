# Exercise 3

## Deliverables

* Single txt file containing link to both pull request and CS3 application URL
* `GameInfoServlet.java`

## Description

We will start our first Java Tomcat Web application in this exercise.

As usual, this may be the first time many of students interact with Java and Tomcat;
therefore, this is a *un-graded* exercise while I highly encourage students to
accomplish this exercise for learning purpose.

## Goal

The goal for the exercise is to be able to store the first piece of the game
information – Game Name – into the backend (Java Tomcat Servlet at this case).

![admin info](../imgs/project/admin-info.png)

On the submission side of thing, you have to submit a single text file containing
the link to Pull Request as usual and you will need a link to CS3 application
like following:

```
Pull Request:
https://github.com/csula-students/cs-3220-spring-2018-rcliao/pull/9

Application:
http://cs3.calstatela.edu:8080/cs3220stu01/admin/game_info
```

## Dev Environment Set Up

To do so, you will need Java tomcat to be set up, please read the following articles
about how to set it up:

* https://github.com/csula/Utilities/blob/master/setups/java-gradle-setup.md
* https://github.com/csula/Utilities/blob/master/setups/java-tomcat.md
* https://github.com/csula/cs3220-spring-2018/blob/master/notes/utils/cs3-deployment.md

Make sure you have Java and Tomcat installed correctly!

## Get Started

As first step, you may want to copy the source code again from the starter code
repository: https://github.com/rcliao/cookie-clicker with few files important as
below commit:

* https://github.com/rcliao/cookie-clicker/commit/b525caed7138c7c3a931da5f9a43e0d2efd35e87

After you copied the files, you can start the application following the Tomcat
set up notes above.

## Requirements

### Functional

* User should be able to store the game name after clicking on the "Save" button

### Technical

* The game name should be stored under the "application scope" (in memory)
* Should re-use the same HTML from the exercise-2
* Should deploy application to CS3 server
