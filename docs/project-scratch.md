# Project brain storm

## Introduction

In the web development class last summer, we've experimented with the idea of
having single project for the entire semester while building different parts
throughout the period. After teaching the class, I like this idea a lot of
building quite respectable project in the class while guiding students in
different session on different layer.

In upcoming semester, lets build an [incremental game](https://en.wikipedia.org/wiki/Incremental_game).

Basic idea for the incremental game is to click on a button to increment some
value. Using this value, user would be able to purchase some automatic methods to
further increment value. And then, there may be some external environment requiring
user attention once a while to spend value for automatic methods kind of
like a maintenance to keep user around.

There are several variations to the incremental game from here while some focuses
on the story telling like http://www.decisionproblem.com/paperclips/index2.html
some focuses on the graphic and its theme like http://orteil.dashnet.org/cookieclicker/

However, the game aspect is not the central focus of this class. I do still
want students to have space to use their creativity to experiment with ideas,
thoughts and fun.

Our concrete theme can be anything. To begin with, one idea I have is to build
on top of the BitCoin hype. In example, one can click on the button to "mine BitCoin".
And then use BitCoin to buy computing resource to mine more BitCoin while keeping the
electronic bill in mind.

Since the theme can be anything, I start thinking about the idea of creating a CMS
(Content Management System) around the resource in the incremental game. We can
have the backend server to define the resource name, type, exchange rate. And
on the front end service running the incremental game while reading the backend
server for the resource and its storage.

## Problems

Software engineering is all about solving problems. In this section, I want to
summarize a couple problems I had in summer and what I want to accomplish:

* JavaScript wasn't covered in depth enough for students to use it effectively
* Architecture wasn't taught well. Many students didn't know what architecture they were following even to the end.
* Database abstraction can be cleaner. As for now, getting simple connection remains a lot more code snippets to resolve

## Fragments

It will be damn difficult for students who just start leaning web development
to build the whole project all at once while learning. It's important to slice
the project into multiple pieces.

In the past (summer 2017), I tried vertical slicing of the project into semester
as *User Interface* (HTML & CSS), *User Interaction* (JavaScript), *Backend
Service* (Java Servlet), *Backend Rendering* (JSP & JSTL) and then *Backend
Storage* (MySQL & JDBC).

In this coming year (2018), I think I'll continue the same approach going from
layer to layer.

### User Interface (1.5 weeks)

In the User Interface section, students will be implementing how they want their
project to look starting from small components to layout. Components like button, form and
table are important pieces as they will be used later in project. In the inspiration of 
[Atomic Design](http://bradfrost.com/blog/post/atomic-web-design/), students should
be learning how to design and implement smaller component like buttons to 
complicated combined components like button groups and then to learn how to layout
to define a page.

In specific to the incremental game project, we should design:

* button
* picking fonts good for number
* forms to control resource
* card to separate types of resource
* a dedicated area for showing logs (pre element).
* [optional] animation to show number changes

> Another interesting finding I had this year (2017) was that students tend to
> release their creativity in this stage a lot! Maybe I can emphasize further on
> the design further and give students more guidelines to design a better project.

Side note about the component defined here is also to set up the next section
followed by [the component based design](https://material.io/components/web/docs/authoring-components/).

### User Interaction (2 to 3 weeks)

In this section, students start to learn how to add behavior into their front
end application. In last year, the behavior was so simple so that a lot of students
didn't quite get the concept of behavior.

> This pushes me to design more or less front end heavy application like game this year.

In this year, we will need to build a front end long running process to run the
incremental game. This process will be reactive to button click or any other
automatic resource generating action.

One idea I have is to use some sort of state management framework like [Redux](https://redux.js.org/)
or some sort of light weight solution like [Redux Zero](https://github.com/concretesolutions/redux-zero)
or even [Dva](https://github.com/dvajs/dva) to handle the common state changes.

Besides the state management, it's also important to cover the overall front end
architecture before jumping into the detail. In summer, many students had trouble
understanding what are the parameter passing into the component (like what is
root and what not).

To start with, we need to define a long running process through `setInterval`
call. Maybe running once every second.

In this long running process, we will need to cover state changes (update state
in store abstraction) and have view to be functional component – take data and
display. Maybe we should also cover the behavior through dispatch actions.

The store abstraction is quite important because it allows students later to
be able to refactor certain functionality to backend without destroying the
entire application.

> One feat I have here is that I'm limiting the architecture design too much.
> In other word, I'm micromanaging students. I don't want this to happen so I
> didn't provide too much of the architecture last year. This lack of architecture
> causes quite a bit of confusion. In summary, I need to figure out a good balance
> of providing a guided architecture but also giving enough freedom to make mistakes.

While teaching all these architecture decisions, it's also important to show
students how to debug their JavaScript code through logging and debugger console.

> Many students had reliance on integrated development environment (IDE) last year
> and not able to understand what functions they can call in JavaScript (because
> there is no intellisence in normal text editor for JavaScript.

### Backend Service (1 to 2 weeks)

Assuming students already had the prerequisite (Java programming), Backend service
should be relatively easy to teach.

The challenge here is to teach students how to set up the development environment
(Tomcat, Java) as well as the deployment process (deploying to CS3 server).

Going back to the architecture design, I'd prefer to separate out the business
logic (incremental game) from the controller logic (handling request/response)
without losing too much of space in learning and experimenting.

### Backend Rendering (1 to 2 weeks)

JSP, even though, is a new concept to students. It's usually not hard to teach
either. Challenges live on how to teach students to use JSP as only template and
nothing else since students can effectively code everything in JSP.

In other word, it's important to teach good practices along with the bad practices.

### Backend Storage (2 weeks)

This is the difficult session to teach because many students varies based on their
background. Some already took the database class then this session becomes super
easy to teach; while some had no idea what database is, they got lost and have no
idea how to write queries.

Even though I spent like 2 weeks teaching database last summer, it still feels like
not enough to get students prepared for the later assignments.

> A side note here is to define a good database abstraction to run queries and
> de-serialize database result into object.


