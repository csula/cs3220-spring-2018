# Modern Java Framework

## Agenda

### Lecture

* RESTful services
* [Jersey][1]

### Lab

* Refactor existing front-end into using RESTful service calls
* Refactor existing app using Jersey

## Intro to RESTful Service

[RESTful service](https://en.wikipedia.org/wiki/Representational_state_transfer)
is a concept that has been around for a long time (from 2000) but recently
being used a lot into web standard for the web service development because it
meets the normal expectation of how resource is being organized.

### Example: Files and folders

Before we get into the detail of what RESTful service is. Lets talk about some
practical examples of files and folders in your local computer:

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

As how a human may organize the folder structure like above, you will notice a
pattern of resource management (from big to small).

RESTful service is all about continuing this concept to form a standard developers
can follow to build reasonable service APIs (application programming interface).

### Usage of RESTful Web Service

In additional to serve request to web clients (browser), there is also a huge
need to serve up information to mobile devices or even some other services (so
to called micro-services).

An example of the API exposing to other services can be like integration between
companies. Lets say we want to add in Yelp integration into our restaurant app,
we might need to add a programming interface for the Yelp to call easily.
Following RESTful interface will make this integration relatively easy (or at
least reasonable).

### Brief history of web service

We will start by talking about RPC (remote procedure call). RPC is essentially
a way for the web client to call certain function at the server so that the
web client can do certain transaction going to server. There are certain pain
in the RPC (e.g. security concern) that is not easily resolved then developers
moved on.

From here, developers start to use CORBA (cross-platform RPC) so that the
functionality of the RPC get extended into the other platform easily. Nevertheless,
there are still issue in the CORBA.

Then, after the HTTP standard becomes more appreciated, developers started to
do Cross-platform RPC over HTTP (what we have learned in the class) and SOAP.

Now, after re-inventing the protocol of RPC all the time, developers start to 
follow RESTful Web Service to define more predictable services.

### RESTful Constraints

RESTful, as simple as it sounds, still comes with a few constraints:

* Stateless
* Support caching
* Uniformly accessible
* Layered

Moreover, RESTful is not only designed for human to use but also for machine --
it generates responses in a format that is readable by machine (e.g. JSON and XML)

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

> A general rule of thumb on picking between path id vs query string is --
> path parameter is *required* where as query string is *optional*

Example:

| Operation | URL mapping |
| :-- | :-- |
| List files | GET `/files` |
| Get a file | GET `/file/1` |
| Delete a file | DELETE `/file/1` |
| Update a file | PUT `/file/1` |
| Add a file | POST `/files` |

## Jersey

Now it's time to implement RESTful service in Java using [Jersey framework][1]!

Before we move onto the detail example, lets talk about a couple library choices:

* Full Webapp framework -- [Spring](https://spring.io/)
* Lightweight web service framework -- [Jersey][1]
* Convert between objects to JSON/XML
    * Jackson -- https://github.com/FasterXML/jackson
    * GSON - https://github.com/google/gson

### Serialization/Marshalling

Serialization is a process of converting Java object into a format (e.g. JSON/XML).
Deserialization is the other process of converting the format (JSON/XML) back to
Java Object.

Why is JSON/XML important?

It's easy to be read by JavaScript! Nonetheless, JSON (JavaScript Object Notation)
is designed for JavaScript after all.

From here, many other languages (e.g. Java) has dedicated libraries to support
JSON. To this day, it's safe to say all programming languages has a support of
JSON parsing and converting.

### Client side libraries

On the other hand, if one machine need to talk to other, it may Http client library
to send HTTP request (e.g. we have [Apache HttpClient](hc.apache.org/httpcomponents-client-ga/)
for Java).

### Jersey implementation

In this class, we will focus on learning Jersey considering it's the light weight
solution to implement RESTful service and easy to learn.

> Sometimes this Java RESTful is also being referred as JAX-RS (Java API for RESTful Web Service)

### Using Gradle for dependency management

Before we move on, we will need to get the library in our runtime so that Java
can import such library to use it.

In traditional way (Eclipse and Tomcat), you will need to download the jersey.jar
file and manually put them into tomcat lib folder in order to have jersey in
the runtime environment. This manual process of copying and pasting jar file one
by one is okay if you only have one or two runtime dependencies (e.g. jstl.jar
and jdbc.jar). It will soon become unmaintainable when you start to have ten or
hundred of dependencies!

[Gradle](https://gradle.org/) is being developed to solve this dependency problem!

To run Gradle, you can go ahead and download Gradle from [the earlier set up
documentation](https://github.com/csula/Utilities/blob/master/setups/java-gradle-setup.md)

Once you have Gradle installed, please go ahead and download https://github.com/csula/java-tomcat-gradle-starter
as starting point.

To start Gradle web application, run `gradle appRun` on the directory you have
**build.gradle** file.

Open http://localhost:8080/hello to confirm web application is working!

### Dependency Management

Dependency of project is usually a library that project depends on (e.g. jstl.jar)

Adding dependency in Gradle is as simple as adding a line in the **dependencies**
block.

e.g. `compile group: 'javax.servlet', name: 'javax.servlet-api', version: '3.1.0'`

Then, on next Gradle task execution, Gradle will automatically download the 
dependency and put into right place so your application will have access to
the dependency!

In example, to get Jersey as dependency:

```
compile group: 'javax.ws.rs', name: 'javax.ws.rs-api', version: '2.0.1'
```

### Example: Get file in Jersey

* URL: `/service/file/{id}`

### Common Jersey Annotations

* `@Path`
* `@PathParam`
* `@GET`, `@POST`, `@PUT` & `@DELETE`
* `@Produces`
    * Tell Jersey what data format the return value should be converted to
* `@Consumes`
    * Tell Jersey what data format of the data in the request body

## WAR file distribution

You can run `gradle war` to generate single war file for deployment.

[1]: https://jersey.github.io/
