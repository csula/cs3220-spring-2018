# Java Servlet & Tomcat



## Agenda


### Lecture

* [Servlet](#servlet)
* [Client/server](#client-server)


### Exercise

* Java environment setup
* Tomcat server setup



## Servlet


### Java Web Application Components


* Compiled Java Classes (.class files)
* Additional Java Libraries (.jar files)
* JavaServer Pages (JSPs)
* Static resources
	* HTML, CSS, images, JavaScripts ... etc.
* Meta data files
	* web.xml


Files structures on CS3 Server

```
/                        --> www folder
index.jsp                --> JSPs and static assets
other.jsp
WEB-INF/
  web.xml
  classes/               --> Compiled Java classes
  lib/                   --> Additional Java libraries
```


### Servlet Hello World

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello World");
	}
}
```


* Inherits from [HttpServlet](http://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpServlet.html)
* doGet()
	* Input: HttpServletRequest
	* Output: HttpServletResponse => sent back to browser


### Output HTML from Hello World Servlet

* Set content type to "text/html"
	* setContentType(String type)
* Generate an HTML page
	* getWriter().println(String output)


### Servlet mapping (routing)

```
@WebServlet(<URL Pattern(s)>)
```


### Java Annotations

```java
// for error detection
@Override
protected void doGet() {} 

// Suppress warning
@SuppressWarnings("unchecked")
public List<User> getAllUsers() {
	return (List<User>) new ArrayList();
}

// Servlet mapping
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet { }
```


### WebServlet elements for URL patterns

```java
@WebServlet("/HelloServlet")

@WebServlet({"/HelloServlet", "/members/*"}

@WebServlet( name="Hello", urlPatterns={"/HelloServlet", "/*.html"} )

@WebServlet(
	urlPatterns="/MyPattern",
	initParams={@WebInitParam(name="ccc", value="333")}
)
```


### Servlet Life Cycle


* When servlet is loaded -- `init()`
	* Executed only once
	* Don't forget to call `super.init(config)`
* Per request - `service()`
	* Dispatch to `doXxx()` e.g. `doGet()`
When servlet is unloaded -- `destroy()`


**Why use `init()` instread of constructor**

https://csns.calstatela.edu/wiki/content/cysun/notes/servlet_data_init

Also, ServletContext cannot be access in constructor



### Servlet example - SharedRequestCounter


```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello World");
	}
}
```


### Application Scope

* A "storage area" where data can be stored and accessed
* Data in application scope will remain there as long as application is running
* Data in application scope is shared by all Servlets


#### To access application scope:

* HttpServlet - `getServletContext()`
* HttpServletContext
	* setAttribute(String name, Object value)
	* getAttribute(String name)



### loadOnStartup


#### Lazy loading

* Could cause problem if one servlet must be run before another servlet


```java
@WevServlet(
	name="Hello",
	urlPatterns={"/HelloServlet", "/*.html"},
	loadOnStartup=1
)
```


### web.xml

Web application deployment descriptor. In example:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
</web-app>
```


### Debugging Servlets

* 404 errors: check URL and URL mapping
* Display problem: check the source of generated HTML
* Logical errors: Use debugger to set break points



## Client Server

![Explaing http request & response with servlet life cycle](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/http-request-response-servlet.png)


![Chrome developer network tab](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/chrome-developer-network.png)


![Chrome developer network tab detail](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/chrome-developer-network-2.png)


* Request header
	* Request URL
	* Request method


### Request methods

* GET
* POST
* PUT
* DELETE


#### GET request

To retrieve information under the URL pattern.


#### POST request

To create/update information within the request body.


```html
<form action="/create-food" method="post">
	<input type="text" name="name">
	<input type="text" name="imageUrl">
	<input type="text" name="description">
	<button type="Submit">Submit</button>
</form>
```


#### PUT request

Similar to POST but meant for update


#### DELETE request

Delete item


### HttpServlet methods

```
Request method -> HttpServlet method name
-----------------------------------------
GET            -> doGet()
POST           -> doPost()
PUT            -> doPut()
DELETE         -> doDelete()
```



### Request parameters

In additional to the request header, client has few other ways to include more
information of the request:

* Query string
	* ?param1=value1&param2=value2&...
* Form data



### Practice: addition

http://localhost:8080/sum?num1=2&num2=6

* https://tomcat.apache.org/tomcat-5.5-doc/servletapi/javax/servlet/ServletRequest.html#getParameter(java.lang.String)



### HTML Forms

In form element, you can specify the request sending to server. As example:


```html
<form action="/update-game-info" method="post">
</form>
```


**action** attribute

It indicates the URL of the server side program that process the submitted form
data

**method** attribute

Indicates what type of request form is sending



### Practice: Guest book

![Guest book mockup](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/example-guestbook.png)


#### Web application definition

Data + Operations


##### Data

* Guestbook entries, forum posts, products, customers, transactions ... etc.


##### Operations

* add/create, search, display, edit, delete ... etc.


#### Guestbook implementation:

Data:

* GuestBookEntry
* List<GuestBookEntry>


Operations:

* Display
* Add
* Edit
* Delete


#### Guestbook - display

* Initialize data storage in application scope
* Pre-create some data
* Generate HTML


#### Guestbook - add

* Handling web forms usually involves two operations
	* doGet() -> display form
	* doPost() -> process the form submission
* response.sendRedirect() -> to redirect after processing


#### Guestbook - edit

* Embed an identifier of the data to be edited in generated hyperlink or form (
using hidden form field)


#### Guestbook - delete

* Use an unique and immutable identifier instead of array index
