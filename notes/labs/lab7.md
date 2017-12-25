# Lab 7

## Deliverables

* FoodResource.java [3 pts]
* FoodItem.java
* web.xml [1 pts]
* build.gradle [1 pt]

### Extra credit [5 pts]

* OrderResource.java [4 pts]
* Order.java [1 pt]

## Due date time

### August 12 10:00:00

## Description

After learning through the light weight modern web framework -- Jersey, we will
be building a RESTful service here with Jersey to extend our restaurant application
to expose service API so that other machine can call our restaurant application
to get information.

To do so, we will need to expose RESTful service with JSON.

### Get started

To get started, you will need some tooling in place:

* [gradle](https://gradle.org/)
* [postman](https://www.getpostman.com/)

Once you have above two tools installed:

1. Clone/download the [Java tomcat starter repo](https://github.com/csula/java-tomcat-gradle-starter)
2. Run `gradle appRun` to start Gretty server locally
3. Check http://localhost:8080/hello and you should see hello message running

Once you start to see hello world message, please follow the examples in the course
repo about how to set up Jersey.

In example, you may need to do:

* Add necessary runtime **dependencies** to build.gradle
* Change **web.xml** to contain necessary package location
* Add service and define business objects

In regards of the URL mapping, you want to map services as followed:

| method | URL | description |
| :-- | :-- | :-- |
| GET | /services/fooditems | return a list of food items in the database |
| GET | /services/fooditem/:id | return a single food items given by id in the database |
| POST | /services/fooditems | Create a new food item and add it to database |
| PUT | /services/fooditem/:id | Update a certain food item given its id |
| DELETE | /services/fooditem/:id | Delete a food item given id |

In extra credit, do the same thing but for order:

| method | URL | description |
| :-- | :-- | :-- |
| GET | /services/orders | return a list of orders in the database |
| GET | /services/order/:id | return a single order given by id in the database |
| POST | /services/orders | Create a new order and add it to database |
| PUT | /services/order/:id | Update a certain order given its id |
| DELETE | /services/order/:id | Delete a order given id |

## Requirements

* User should be able to send request to any of the URL mapping above and see changes
* All existing application should still perform the same (able to navigate the
web pages and add/remove/update items)
