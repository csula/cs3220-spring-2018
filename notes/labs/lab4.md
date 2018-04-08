# Lab 4

## Deliverables

* Single txt file containing link to **the pull request** and **CS3 application**

Pull request should at least containing the following changed files:

* `src/main/java/edu/csula/storage/web/AdminEventsServlet.java`
* `src/main/java/edu/csula/storage/servlet/EventsDAOImpl.java`
* `app.css`

## Common Q&A

### Overall roadmap

```
* DAOImpl
	* getAll
	* getById
	* add
	* set
	* remove

* EventsServlet
	* doGet (render HTML)
	* doPost (adding)
* EditEventServlet
	* doPost (edit)
* RemoveEventServlet
	* doPost (delete)

* copy `app.css` to "src/main/webapps" (or "WebContent" in Eclipse)
```

### I use Eclipse, and this lab requires Gradle. What do I do?

Follow http://www.vogella.com/tutorials/EclipseGradle/article.html to install
Eclipse Gradle plugin.

Or

You can run the tests through the command line application through the
`./gradlew check`

### How do I build the Servlets when tests are failing in Gradle?

```
./gradlew -x build
```

## Descriptions

In this lab, we will pick up what we implemented back in exercise-2 with the
proper backend functionality. To get started with, we will implement the events
configuration page like below:

![admin events configuration pages](../imgs/project/admin-events.png)

And your mission is to create Java Servlets that:

* Display the page like above
* Handle the necessary persistence transaction about event information

> Hint, you may need to handle the `id` as **query parameter** so that you know if
> user is currently editing any event or not

## Get Started

Download the starter code from 
https://github.com/rcliao/cookie-clicker/releases/tag/lab4-7

Once downloaded, you have a couple files you have to pay attention to:

```
~/dev/sandbox/cookie-clicker master
❯ tree -I 'node_modules|package-*|client|build|dest|gradle*|scripts|tags'
.
├── README.md
├── build.gradle
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   ├── edu
    │   │   │   └── csula
    │   │   │       ├── models
    │   │   │       │   ├── Event.java
    │   │   │       │   └── Generator.java
    │   │   │       ├── storage
    │   │   │       │   ├── BaseDAO.java
    │   │   │       │   ├── EventsDAO.java
    │   │   │       │   ├── GeneratorsDAO.java
    │   │   │       │   ├── Storage.java
    │   │   │       │   └── servlet
    │   │   │       │       ├── EventsDAOImpl.java
    │   │   │       │       └── GeneratorsDAOImpl.java
    │   │   │       └── web
    │   │   │           ├── AdminEventsServlet.java
    │   │   │           ├── AdminGeneratorsServlet.java
    │   │   │           └── HelloServlet.java
    │   │   └── hello
    │   │       └── SimpleMath.java
    │   └── webapp
    │       └── WEB-INF
    │           └── web.xml
    └── test
        └── java
            ├── edu
            │   └── csula
            │       ├── models
            │       │   └── EventTest.java
            │       └── storage
            │           └── servlet
            │               └── EventsDAOImplTest.java
            └── hello
                └── SimpleMathTest.java

```

> Specifically, you need to get everything under `src/` folder over with `build.gradle` to run the unit tests

Once you have downloaded the starter code, you want to start by looking at
the `EventsDAOImpl.java` first to implement all functionalities inside in
order to pass unit tests from `./gradlew check` command.

Then, your next step is to fill in the blank under `AdminEventsServlet.java` to
render HTML and handle transaction accordingly.

Once you are done coding, you want to deploy the code to CS3 server following
this article
https://github.com/csula/cs3220-spring-2018/blob/master/notes/utils/cs3-deployment.md

## Requirements

### Functional

* User should be able to create event passing event name, description and trigger value
* User should be able to see a list of events
* User should be able to modify a single event
* User should be able to delete a single event

### Technical

* Application needs to be deployed to CS3 server and working
* Application should store the event information in the _application scope_
* Application should display HTML with proper CSS (similar to what you have accomplished in exercise-2)
* `./gradlew check` should pass all unit tests
