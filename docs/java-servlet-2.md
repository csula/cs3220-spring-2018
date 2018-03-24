# Java Servlet & Tomcat



## Agenda


### Lecture

* Http Responses
* web.xml - Error pages
* Http Headers
* Cookies
* Session
* Storage diagram


### Exercise

* Game name meta storage
* Java Tomcat Setup
* Deploy to CS3 Server



## Http Response

* Response status
* Modifying response header
* Response body


### General status code:

```
1**, Hold on
2**, Here you go
3**, Go away
4**, You f***ed up
5**, I f***ed up
```


https://httpstatuses.com/


#### Common Response Codes

* 200 (Okay)
* 302 (Temporary moved)
* 401 (Unauthorized)
* 403 (Forbidden)
* 404 (Not found)
* 500 (Internal Server Error)


### General Controller Flow

* [Authentication and Authorization]
* Parse and de-serialize request
* Validate request
* Data Storage Transaction
* Return response


```java
if (!isAuthenticated(request) || isAuthorized(request)) {
	// return 403 UNAUTHORIZED response
}
DataTransferObject dto = parse(request);
if (!dto.isValid()) {
	// return 400 BAD REQUEST response
}
DatabaseAccessObject dao = new DAO(storage);
try {
	dao.save(dto);
	// implicit Java Servlet returns 200 success
} catch (Exception e) {
	// return 503 SERVER ERROR response
}
```


### Redirects

* 301 (Move permanently)
* 302 (Move temporarily)
* 303 (See other)
* 307 (temporary redirect)


* Header `Location`



## Error pages in web.xml

```xml
<error-page>
    <error-code>404</error-code>
    <location>/WEB-INF/404.html</location>
</error-page>

<error-page>
    <error-code>403</error-code>
    <location>/WEB-INF/403.html</location>
</error-page>
```



## Http Headers


* Request
	* Accept
	* Accept-Charset
	* Accept-Encoding
	* Accept-Language
	* Connection
	* Content-Length
	* Cookies


* Response
	* Content-Type
	* Content-Encoding
	* Content-Language
	* Connection
	* Content-Length
	* Set-Cookie


### HttpServletResponse

http://download.oracle.com/javaee/7/api/javax/servlet/http/HttpServletResponse.html


* `addHeader()`, `setHeader()`
* `containsHeader()`
* `setContentType(String type)`
* `sendRedirect(String location)`
* `getWriter()`
	* For text response, e.g. HTML page
* `getOutputStream()`
	* For binary responses, e.g. images


### Example Add revisited

* Redirect the user back to the input form if the parameters are missing or invalid
	* `sendRedirect()` method doesn't terminate the method



## Cookies


![Jetbrain cookie notification](https://puu.sh/lQYT8.png)


### What are this mysterious cookies?


![Cookie monster](http://vignette1.wikia.nocookie.net/iannielli-legend/images/6/6e/Cookie_monster.jpg/revision/latest?cb=20150918140937)


A small set of data stored on user's browser.


### Why do we need cookies?

* User related data (user info)


### Challenge of session tracking

* HTTP is **stateless**


![Http session general idea](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/http-session-idea.png)


* URL Re-write
	* e.g. http://csns.calstatela.edu/index.html;jsessionid=748D9512C9B19B0DCC9477696A88CF12
* Hidden form fields
	* `<input type="hidden" name="sessionid" value="12345" />"`
* Cookies


### Cookies

* Response `Set-Cookie`


![Cookie request example](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/cookie-request-example.png)


![Cookie request header example](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/cookie-request-header-example.png)


### Cookie Attributes

* Name, value (key-value pair)
* Host/Domain, Path
	* Control whether cookie should be included in the request
* Require secure connection
* Max age
* Comment


http://docs.oracle.com/javaee/6/api/javax/servlet/http/Cookie.html

* `addCookie( cookie )`
* `getCookies()`


#### Example: Guestbook with cookies

* Use a cookie to store name so a user only needs to enter their name once.


### Concerns about cookies

* Security concern?
* What about privacy?


### Known problems with cookies

* Size limit
* Malicious users can fake cookie
* Sometimes cookie is disabled in browser (which is why you see the notification all the time)
* Cookie API is somewhat tedious to use



## Session

* [HttpServletRequest#getSession](http://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletRequest.html#getSession())
* [HttpSession](http://download.oracle.com/javaee/6/api/javax/servlet/http/HttpSession.html)
	* `getAttribute( String )`
	* `setAttribute( String, Object )`
	* `invalidate()`


* Data is stored on the server, e.g. no size limit
* A unique session id per request
* Session id is randomly generated and hard to fake
* Session tracking use cookie by default, but it can automatically switch to URL rewriting if cookie is disabled


### Example: Guestboook with session tracking API

* Session is shared among Servlets
	* Servlet context attributes (application scope) vs session attribute (session scope)
	* Similarities??
	* Differences??
	* Usage??


### Session configuration in web.xml

* Default session timeout in Tomcat is 30 minutes
* Session timeout can be changed in web.xml
	* The timeout value must be an integer
	* Session never timeout if value <= 0


```xml
<session-config>
    <session-timeout>60</session-timeout>
</session-config>
```



## Storage diagram


![Client server storage from high level](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/client-server-storage.png)
