# JSP & JSTL



## Agenda


### Lecture

* [Java Server Page](#java-server-page)
* [MVC Architecture](#mvc-architecture)
* [Expression Language(EL)](#expression-language)
* [JSTL (tag)](#jsp-standard-tag-library)
* [Custom Tag Library](#custom-tag-library)


### Lab

* Install JSTL lib in Tomcat
* Implement basic server side rendering



## Java Server Page


Server-side **template engine** for Java


```jsp
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	JSP can be treated the same way as HTML without Data.
</body>
</html>
```


### Two ways to use JSP


* JSP the old way (e.g. wrong way)
	* HTML + Java Code
* JSP as a template engine
	* HTML + EL/JSTL


#### Old way

```jsp
<p>The sum of <%= request.getParameter("a") %>
and <%= request.getParameter("b") %> is
<%= Integer.parseInt(request.getParameter("a"))
+ Integer.parseInt(request.getParameter("b")) %>
</p>
```


#### New way


```jsp
<p>The sum of ${a} and ${b} is
${sum}.</p>
```


### How JSP works

![JSP processing with Tomcat overview](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/how-jsp-works.png)


* `$TOMCAT_HOME/work/Catalina/localhost/context_name`


### JSP the old way example


```
<%! int counter = 1; %>             <%-- JSP variable declaration --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Counter</title>
</head>
<body>You are visitor #
<%= counter %>.                     <%-- JSP expression --%>
<% ++counter; %>                    <%-- JSP Scriplet --%>
</body>
</html>
```


### Why JSP the old way is the wrong way?

* Mixing presentation and processing logic



## MVC Architecture

Model-View-Controller


* Model for data
* Controller for processing
* View for display


![MVC in Web](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/mvc-architecture.png)


1. Browser sends a request to controller
2. Controller processes the request, update some data
3. Controller forwards the request and data to view
4. View generates the response that is sent back to the client


### In detail:

* Model: regular Java classes (aka. bean, or POJO - Plain Old Java Object)
* Controller: Servlet
* View: JSP


### Example using MVC

![MVC Example with addition](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/mvc-example.png)


```java
request.getRequestDispatcher("path_to_jsp")
	.forward(request, response);
```


### Forward vs Redirect


![Forward request vs redirect graph](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/forward-vs-redirect.png)


### Send data from Controller to View

* Application and session scope are shared
* Additional data can be sent in request scope


Request scope:

```java
request.setAttribute("key", value);

request.getRequestDispatcher("path_to_jsp")
	.forward(request, response);
```


### Tips about JSP

* Request should always go to controllers first
	* Hide JSPs under /WEB-INF so that user cannot access JSP directly
* Controllers do not generate HTML
	* No `out.println()`
* JSPS are only used for display
	* No Java code in JSP



## Expression Language

Expression language is a concise way to access data in JSP since JSP 2.0 
specification. Syntax looks like: `${expression}`


### Elements of a programming language

* Comments
* Literals
* Variables and types
* Operators
* **Expressions**: anything that evaluates to a single value
* Statements
* Functions
* Classes
* Packages


#### Comments

```
<%-- JSP (hidden) comments --%>
<!-- HTML comments -->
```


#### EL Literals

```
${true}, ${false}

${23}, ${0x10}

${6.5}, ${1.1e13}

${"double-quoted string"}, ${'single-quoted string'}

${null}
```


#### EL Variables

* Cannot declare a new variable using EL


```
${dataName}
```


##### What are a properties?


```java
class User {
	// Fields (beginning)
	private final String firstName;
	private final String lastName;
	// fields (end)

	// Constructor (beginning)
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	// constructor (end)

	// Methods (beginning)
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	// methods (end)
}
```


##### About properties

Property naming conventions should be *lowerCaseCamelCase*


You may have defined properties in following different types:

* read-only property: (only getter)
* write-only property: (only setter)
* read-write property: both


Then you can access properties from EL as followed:

```
${objectName.propertyName}
```


#### Implicit objects in JSP


* pageContext
	* servletContext
	* session
	* request
	* response
* param, paramValues
* header, headerValues
* cookie
* initParam
* pageScope
* requestScope
* sessionScope
* applicationScope


#### EL Operators


* Arithmetic
	* +, -, \*, /, %
	* div, mod
* Logical
	* &&, ||, !
	* and, or, not
* Relational
	* ==, !=, <, >, <=, >=
	* eq, ne, lt, gt, le, ge
* Conditional
	* ?, :
* empty
	* check whether a value is null or empty
* Other
	* [], ., ()


### Limitation of EL

Developers are only allowed to use expressions but not any statements. Especially
no control-flow statements.

To resolve this issue, you will need to know JSTL.



## JSP Standard Tag Library


```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>JSTL Hello</title></head>
<body>

<c:out value="Hello World in JSTL." />

</body>
</html>
```


### taglib Directive


* URI
	* A unique identifier for the tag library
	* NOT a URL
* Prefix
	* A short name for the tag library
	* Could be arbitrary name


### JSP Standard Tag Library (JSTL)

| Library | URI | Prefix |
| :--     | :-- | :--    |
| Core | http://java.sun.com/jsp/jstl/core | c |
| XML Processing | http://java.sun.com/jsp/jstl/xml | x |
| I18N Formatting | http://java.sun.com/jsp/jstl/fmt | fmt |
| Database Access | http://java.sun.com/jsp/jstl/sql | sql |
| Functions | http://java.sun.com/jsp/jstl/functions | fn |


### Important JSTL Tags and Functions

* Flow control
	* `<c:if>`
	* `<c:choose>`
		* `<c:when>`
		* `<c:otherwise>`
	* `<c:forEach>`
* URL
	* `<c:url>`
* Output
	* `<c:out>`
* Formatting
	* `<fmt:formateDate>`
	* `<fmt:formatNumber>`
* Functions
	* `<fn:length>`


#### Branch tags


```
<c:if test="${a.weekdays[0] == 'mon'}">Monday</c:if>
```


```
<c:choose>
    <c:when test="${a.weekdays[3] == 'tue'}">
        Tuesday
    </c:when>
    <c:when test="${a.weekdays[3] == 'wed'}">
        Wednesday</c:when>
    <c:when test="${a.weekdays[3] == 'thr'}">
        Thursday
    </c:when>
    <c:otherwise>Friday</c:otherwise>
</c:choose>
```


#### Loop Tag `<c:forEach>`


```
<ul>
    <c:forEach items="${a.numbers}" var="number">
        <li>${number}</li>
    </c:forEach>
</ul>
```


```
<ul>
    <c:forEach items="${a.numbers}" var="number"
          varStatus="status">
        <li>${status.index}: ${number}</li>
    </c:forEach>
</ul>
```


#### URL Tag `<c:url>`


```
<a href="<c:url value='/JSTLTest' />">A</a>
```


#### Format date and time with `<fmt:formatDate>`


```
<fmt:formatDate value="${a.date}" type="date" />

<fmt:formatDate value="${a.date}" type="time" />

<fmt:formatDate value="${a.date}" type="both" />

<fmt:formatDate value="${a.date}"
        pattern="yyyy-M-d h:m:s a" />
```


#### Format number with `<fmt:formatNumber>`


```
<fmt:formatNumber value="${number}" type="number" />

<fmt:formatNumber value="${number}" type="currency" />

<fmt:formatNumber value="${number}" type="percent" />

<fmt:formatNumber value="${number}" pattern="0.##" />
```


#### Example: Convert Guestbook to JSP and JSTL



## Custom Tag Library


To define a custom JSP tags:

* Implement a tag
	* Using Java code
	* Using a tag file (basically a JSP file)
* Declare the tag in a Tag Library Descriptor (TLD) file


### Example: Hello


```
<cs3220:hello />
```


```java
package edu.csula.cs3220.examples.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class HelloTag extends SimpleTagSupport {
   public void doTag() throws JspException, IOException {
      JspWriter out = getJspContext().getOut();
      out.println("Hello Custom Tag!");
   }
}
```


* `WEB-INF/custom.tld`

```tld
<taglib>
   <tlib-version>1.0</tlib-version>
   <jsp-version>2.0</jsp-version>
   <short-name>Example TLD</short-name>

   <tag>
      <name>Hello</name>
      <tag-class>edu.csula.cs3220.examples.tags.HelloTag</tag-class>
      <body-content>empty</body-content>
   </tag>
</taglib>
```


```
<%@ taglib prefix="cs3220" uri="custom.tld"%>

<html>
   <head>
      <title>A sample custom tag</title>
   </head>

   <body>
      <cs3220:Hello/>
   </body>
</html>
```


### Declaration for AddTag


* addTag.tld

```xml
<tag>
    <name>add</name>
    <tag-class>cs3220.tag.AddTag</tag-class>
    <body-content>empty</body-content>
    <attribute>
        <name>op1</name>
        <required>true</required>
        <rtexprvalue>true</rtexprvalue>
    </attribute>
    <attribute>
        <name>op2</name>
        <required>true</required>
        <rtexprvalue>true</rtexprvalue>
    </attribute>
</tag>
```


* AddTag.java

```java
package edu.csula.cs3220.examples.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AddTag extends SimpleTagSupport {
	int op1, op2;

	public AddTag () {
		op1 = op2 = 0;
	}

	public void setOp1(int i) {
		this.op1 = i;
	}

	public void setOp2(int i) {
		this.op2 = i;
	}

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print( op1 + op2 );
	}
}
```


* TaglibTest.jsp

```jsp
<%@ taglib prefix="cs3220"
    uri="http://cs.calstatela.edu/cs3220/stu31" %>
<!DOCTYPE html>
<html>
<head><title>TaglibTest</title></head>
<body>
    The sum of ${param.a} and ${param.b} is
    <cs3220:add op1="${param.a}" op2="${param.b}" />.
</body>
</html>
```
