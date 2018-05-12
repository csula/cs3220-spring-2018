# Modern Java Framework



## Agenda

### Lecture

* RESTful services
* Jersey
* JavaScript integration



## Intro to RESTful Service


```
GET
POST
PUT
DELETE
```


### Example: Files and folders


```
/document
/Users
    /Eric
        /csula
            /cs3220-summer-2017
                README.md
                build.gradle
            /cs4660-fall-2017
                README.md
                docs/
    /John
log.txt
```


### Brief history of web service

1. RPC (remote procedure call)
2. CORBA (cross-platform RPC)
3. Cross-platform RPC over HTTP and SOAP 
4. RESTful


### RESTful Constraints


* Stateless
* Support caching
* Uniformly accessible
* Layered


### RESTful methods in a nutshell

| Method | Meaning |
| :-- | :-- |
| GET | Retrieve information |
| POST | Create/update information |
| PUT | Update/create information |
| DELETE | Delete information |


### URL Design


* Operation: get a file
* URL:
    * `/file/{id}`
    * `/file/get?id={id}`
    * `/file/{id}.{format}`
        * Use data format to define what output client wants (e.g. JSON vs XML)


Example:

| Operation | URL mapping |
| :-- | :-- |
| List files | GET `/files` |
| Get a file | GET `/file/1` |
| Delete a file | DELETE `/file/1` |
| Update a file | PUT `/file/1` |
| Add a file | POST `/files` |



## Jersey


* Full Webapp framework -- [Spring](https://spring.io/)
* Lightweight web service framework -- [Jersey][1]
* Convert between objects to JSON/XML
    * Jackson -- https://github.com/FasterXML/jackson
    * GSON - https://github.com/google/gson


### Dependency Management


```
compile group: 'javax.servlet', name: 'javax.servlet-api', version: '3.1.0'
```


### Jersey Dependency


```
// JAX-RS -- Jersey
compile group: 'javax.ws.rs', name: 'javax.ws.rs-api', version: '2.0.1'
// JAX-RS -- Jersey Servlet
compile group: 'org.glassfish.jersey.containers', name: 'jersey-container-servlet', version: '2.25'
// JAX-RS -- Jersey Jackson
compile group: 'org.glassfish.jersey.media', name: 'jersey-media-json-jackson', version: '2.25.1'
```


### Jersey configuration


```
package edu.csula.web;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class ServiceApplication extends ResourceConfig {
    public ServiceApplication() {
        packages("edu.csula.web.services");
    }
}
```


### Example: Hello Service


```
package edu.csula.web.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/hello")
public class HelloService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, JAX-RS";
    }
}
```


### Example: Guestbook

* `GET /services/guestbook`
* `POST /services/guestbook`
* `PUT /services/guestbook/:id`
* `DELETE /services/guestbook/:id`


### Common Jersey Annotations

* `@Path`
* `@PathParam`
* `@GET`, `@POST`, `@PUT` & `@DELETE`
* `@Produces`
    * Tell Jersey what data format the return value should be converted to
* `@Consumes`
    * Tell Jersey what data format of the data in the request body



## JavaScript integration

* [Fetch API](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API)
* [Axios](https://github.com/axios/axios)


### Example


#### GET

```
fetch(url)
	.then(resp => resp.json())
	.then(console.log);
```


#### POST

```
fetch(url, {
	body: JSON.stringify(data),
	method: 'POST'
}).then(resp => resp.json())
.then(console.log);
```
