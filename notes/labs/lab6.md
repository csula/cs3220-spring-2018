# Lab 6

## Deliverables

* schema.sql [2 pts]
* FoodItemDAO.java [2 pts]
* Necessary Servlet changes [1 pt]
* CNSN text submission as below:

```
Application URL:
http://cs3.calstatela.edu/cs3220xstu25/menu

Pull request URL:
https://github.com/csula-students/cs-3220-summer-2017-rcliao/pull/12
```

## Due date time

### July 30th 23:59:59

## Description

In this lab, we will be applying what we learned from JDBC to connect
Java to MySQL. Furthermore, getting result set from MySQL and convert
it into Java objects to display them on JSP.

We will continue our restaurant app to convert the app data to store into
MySQL and get data from it.

In specific, we will be converting the **food items** into MySQL.

The first step you want to do is to create SQL files to create table and
insert some dummy data.

You will need to create table like below:

**Food items**

| ID | Name | Description | Price |
| :-- | :-- | :-- | :-- |
| 1 | Hamburger | A hamburger | 9.99 |
| 2 | Fries | Some fries | 4.99 |
| 3 | Coke | Coke cola | 2.99 |

And then you will need to implement the DAO interface with FoodItemDAO.java.
DAO stands for data access object will be the abstraction level between the
food item and database.

After implementing DAO interface to create FoodItemDAO.java, you will need to
change your implementation in the Java Servlets that get items and update items
from application scope to use FoodItemDAO.java so that your food items are stored
now in the database as to application scope.

## Requirements

* Functional requirements are the same as before
* Food items should be stored in database now
* Password should not be stored under Github

