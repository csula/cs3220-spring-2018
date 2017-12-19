# Project brain storm

In the past summer, I have taught the class using the same project while building
different parts of the project for homework.

I do want to keep this aspect the same this year. One project, different parts
through out the semester.

In this semester, lets build a [incremental game](https://en.wikipedia.org/wiki/Incremental_game).

Basic idea for the incremental game is to click on a button to increment some
counter. Using counter, user would be able to buy some automatic way of generating
the counter. And from there, it builds up to buy more way to generate this counter.

Concrete theme can be anything. However, one idea I have now is to build on top of the
BitCoin hype. In example, one can click on the button to "mine BitCoin". And
then use BitCoin to buy computing resource to mine BitCoin more while keeping the
electronic bill in mind.

Since the theme can be anything, I start thinking of the idea of creating a CMS
around the resource in the incremental game. We can have the backend server to
define the resource name, type, exchange rate. And on the front end service running
the incremental game while reading the backend server for the resource and its
storage.

# Fragments

It's going to be impossible for students who just start leaning web development
to build the whole project all at once while learning. It's important to slice
the project into multiple pieces.

In the past (summer 2017), I tried vertical slicing of the project into semester
as User Interface (HTML & CSS), User Interaction (JavaScript), Backend Service
(Java Servlet), Backend Rendering (JSP & JSTL) and then Backend Storage (MySQL &
JDBC).

In this coming year (2018), I think I'll continue the same approach going from
layer to layer.

## User Interface (1.5 weeks)

In the User Interface section, students will be implementing how they want their
project to look in small components to layout. Components like button, form and
table are important to design here. In the inspiration of 
[atomic design](http://bradfrost.com/blog/post/atomic-web-design/), I like to
have students learning how to design smaller component to complicated combined
components and then to learn how layout defined to define a page.

> Another interesting finding I had this year (2017) was that students tend to
> release their creativity in this stage a lot! Maybe I can emphasize further on
> the design further and give students more guidelines to design a better project.

Side note about the component defined here is also to set up the next section
followed by [the component based design](https://material.io/components/web/docs/authoring-components/).

## User Interaction (2 to 3 weeks)

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

## Backend Service (1 to 2 weeks)

Assuming students already had the prerequisite (Java programming), Backend service
should be relatively easy to teach.

The challenge here is to teach students how to set up the development environment
(Tomcat, Java) as well as the deployment process (deploying to CS3 server).

## Backend Rendering (1 to 2 weeks)

JSP, even though, is a new concept to students. It's usually not hard to teach
either. Challenges live on how to teach students to use JSP as only template and
nothing else since students can effectively code everything in JSP.

In other word, it's important to teach good practices along with the bad practices.

## Backend Storage (2 weeks)

This is the difficult session to teach because many students varies based on their
background. Some already took the database class then this session becomes super
easy to teach; while some had no idea what database is, they got lost and have no
idea how to write queries.

Even though I spent like 2 weeks teaching database last summer, it still feels like
not enough to get students prepared for the later assignments.

> A side note here is to define a good database abstraction to run queries and
> deserialize database result into object.
