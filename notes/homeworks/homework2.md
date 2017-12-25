# Homework 2

## Deliverables

* Deploy to CS3 server
* OrdersAdminServlet.java
* EditOrderAdminServlet.java
* OrderStatusesServlet.java
* CartServlet.java (for displaying)

## Descriptions

Continue to apply the concept of server side application with server side rendering
techniques (JSPs and JSTLs) to build rich dynamic web application.

Your job here in homework 2 is to implement the customer facing applications using
Java Servlets. Specifically, you will need to re-use the HTML pages you created
earlier from Lab 1 & 2 in your JSPs.

UI mock wise, it will be the same if not similar from the earlier [lab 1][1] and [lab 2][2].
If you don't remember the mock up, please review [lab 1][1], [2][2] and [homework 1][4].

## Requirements

Requirements wise, it's similar to the Lab 3:

* Deploy code to CS3 server
* User should be able to create order continuing from the shopping cart module we
implemented from Lab 2.
* User should be able to see the order statuses after creating order
* Admin should be able to manually change the order statuses from the Admin panel

> Order should be using the food items created earlier from [lab 3][3]

## Instructions

### Get Started

You will need to get Java, tomcat, and one of the tomcat application runner ready.
If you are not sure how to set up tomcat, please check [this link on how to run Servlet locally](../utils/tomcat.md)

### Business Models

Again, the very starting point should be defining what data we will be communicating
between client and server.

Continue from lab 3, you will need **FoodItem.java** ready.

From here, you will need to also define **Order.java** containing the following
attributes:

* ID (as integer)
* Items (refers to the Collection of FoodItem)
* Customer name
* Statuses (should be defined as enum of [IN\_QUEUE, IN\_PROGRESS, COMPLETED]
* Created (as DateTime type)

### Servlets

Again, each Servlet is a page, you will need to create at least the following
pages:

* A page to display order statuses (customer facing)
* A page to display admin panel on order statuses
* A page to edit order statuses
* A page to display shopping cart

That is, you will need to map route like following:

| Servlet Name | URL Patterns |
| :--          | :--          |
| OrderStatusesServlet.java | /orders |
| OrderStatusesAdminServlet.java | /admin/orders |
| EditOrderStatusServlet.java | /admin/order/:id |
| CartServlet.java | /shopping-cart |

[1]: ../labs/lab1.md
[2]: ../labs/lab2.md
[3]: ../labs/lab3.md
[4]: homework1.md
