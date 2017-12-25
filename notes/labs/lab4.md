# Lab 4

## Deliverables

* Deploy to CS3 server
* AdminHeader.java, admin-header.tld & web.xml [1 pts]
* admin/inventory.jsp [1 pt]
* admin/create-food.jsp [1 pt]
* admin/order-statuses.jsp [1 pt]
* app.css [1 pt]

## Due date time

### July 15th 23:59:59

## Descriptions

Your job here is to refactor the existing restaurant application into using JSP/JSTL.
We will start the refactoring by the admin site changes. These includes:

* inventory page
* create food form page
* control order statuses page

If you don't recall what those pages are, here is the refresher:

![Restaurant inventory](../imgs/restaurant-inventory.png)
![Restaurant create food form](../imgs/restaurant-new-food.png)
![Restaurant inventory](../imgs/restaurant-admin-statuses.png)

In additional to the converting Java Servlet to JSP, you will also need to create
an Admin header tag in JSTL. To do so, you will need to create an 
`AdminHeader.java` and `admin-header.tld`.

In this `AdminHeader.java`, you will need to put your header template into the
JSTL output. There are a few parameter to take into consideration:

* Header title

And in the Java Servlet, you should be passing a list of navigation items into
the request scope for the header template to pick up.

Finally, to use the header template, you will need to register the template into
web.xml and use it in each of the JSP above like:

```jsp
<cs3220:header title="{Restaurant name}" />
```

## Requirements

* Functional requirements stays the same as before:
	* Admin should be able to create new food from the create food form
	* Admin should be able to see its food inventory from the inventory page
	* Admin should be able to adjust the order statuses from the order-statuses
* Technical requirements:
	* All presentation logic should be done in JSP.
	* No processing is allowed in JSP
	* Request should be sent to controller and not to JSP directly
	* Servlets should not generate HTML output

