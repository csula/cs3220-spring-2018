# Lab 5

## Deliverables

* Single txt file containing link to **the pull request** and **CS3 application**

* `admin-events.jsp`
* Deploy to CS3 server
* Refactor events configuration page to use JSP

## Descriptions

In this lab, we will continue the implementation of lab 4 to transform our
`out.println` method to use JSP instead.

I'm assuming most students should have the majority of the lab 4 completed by now
as the due date was the beginning of the class today.

As reminder, events admin page looks like below:

![admin events configuration pages](../imgs/project/admin-events.png)

## Requirements

### Functional

* Application should perform the same as lab 4

### Technical

* All presentation code should go to JSP
* JSP should be hidden under `WEB-INF` folder (not accessible directly)
* No HTML output in Servlet (no `out.println`)
* No Java code in JSP (no computation in JSP)
