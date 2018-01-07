# Lab 2

## Deliverables

* Button component [2 pts]
* Counter component [2 pts]
* Ability to increment counter from reducer [1pt]

## Description

Using the component pattern learned in the lecture earlier, your job is
to implement first half of the incremental game functionality in JavaScript.

We want to be able to click on the button to increment counter. This requires us
to architect the application structure to share data state across multiple
components. To do so, we choose to follow [redux pattern][1] as our data store.
To simplify the idea, we have simpler version of redux store under "store.js".

Your task here is to continue the component pattern and data store pattern
to implement the core of the game – click on the button to increment counter.

## Starter code

You can start your code from downloading the source code from this repository
under branch `lab2`:

https://github.com/rcliao/cookie-clicker

## Requirements

### Functional

* When user clicks on *the button*, the counter should increase
* The *counter* should display up to date resource value

### Technical

* Should re-use the same HTML & CSS from lab 1
* Should use `client/src/store.js` to store all states (resource, generators & stories)
* Should implement the code under `client/src/views/button.js` and `client/src/views/counter.js`
* Should pass unit tests executed by `./scripts/front-test.sh`

[1]: https://redux.js.org/
