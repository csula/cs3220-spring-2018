# Homework 3

## Deliverables

* Single txt file containing link to **the pull request** and **CS3 application**

* `admin-generator.jsp`
* `admin-authentication.jsp`
* Deploy to CS3 server
* Refactor events configuration page to use JSP

## Descriptions

In this lab, we will continue the implementation of homework 2 to transform our
`out.println` method to use JSP instead.

As reminder, generator admin page and authentication page look like below:

![Admin generators configuration page](../imgs/project/admin-generators.png)
![Admin Authentication Page](../imgs/project/user-authentication.png)

## Requirements

### Functional

* Application should perform the same as homework 2

### Technical

* All presentation code should go to JSP
* JSP should be hidden under `WEB-INF` folder (not accessible directly)
* No HTML output in Servlet (no `out.println`)
* No Java code in JSP (no computation in JSP)
