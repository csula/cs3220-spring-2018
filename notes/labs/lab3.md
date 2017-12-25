# Lab 3

## Deliverables

* Deploy Servlets compiled classes to CS3 server
* HelloWorld Servlet [1 pt]
* RestaurantServlets - food items [2 pts]
* RestaurantAdminServlets - add/update food item [2pts]
* Pull request containing all the necessary Java changes
* CSNS text file submission as followed:

```
application link:
http://cs3.calstatela.edu:8080/<username>/<servlet_or_jsp_name>

pull request URL:
https://github.com/csula-students/cs-3220-summer-2017-rcliao/pull/5
```

## Descriptions

Your job here is to create the basic server application for the restaurants
application we have been working on in the past from the front-end application
to be back-end supported application.

In specific, you will need to write the back-end application in Java Servlet to
store the information in the **application scope** so that multiple users
can see the same information from different browsers/locations.

To do so, you will need a running tomcat server running. Fortunately, in CSULA,
we already have CS3 server with tomcat running. All you need is the credential
to ssh/tcp files over to the CS3 server.

> Please talk to me individually to get your credential if you haven't got one.

See https://csns.calstatela.edu/wiki/content/cysun/course_materials/eclipse as
recap on how to run Java Servlets locally or on CS3.

## Requirements

* Deploy code to CS3 server
* User should be able to create food item
* User should be able to see the food items
* User should be able to edit the food item

## Instructions

### Get Started

To get started, make sure you have the following installed:

* Java JDK8
* One of the following:
	* Gradle
	* Eclipse
	* Tomcat

With two of above items installed, you should be able to run Servlets locally.

Please refer to [this link on how to run Servlet locally](../utils/tomcat.md)

Get the HelloServlet going and start hacking!

### Business Models

The very first starting point should be defining your business model objects.
In this case, your business model should be **FoodItem**. Since our requirements
are all about food items, you will need to define the FoodItem containing following
attributes:

* ID (as integer)
* Name
* Description
* Image URL
* Price

### Necessary Servlets

Think of each Servlet as a page, for the restaurant admin pages, you will need:

* A page to create food item
* A page to display a list of food items (with link to delete food item)
* A page to edit food item

On the customer facing side, you will at least need:

* A page to display food menu

> Please find a way to re-use as much from the existing HTML from lab 1 and lab 2

That is, you will need at least 4 Servlets:

| Servlet Name | URL Patterns |
| :--          | :--          |
| CreateFoodAdminServlet.java | /admin/foods/create |
| FoodItemListAdminServlet.java | /admin/foods/ |
| EditFoodAdminServlet.java | /admin/foods/edit/:id |
| FoodMenuServlet.java | /menu |

> If you found, at any point not sure what to do. Please find GuestBook Servlet
as reference.
