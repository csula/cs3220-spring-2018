# Lab 3

## Deliverables

* Single txt file containing link to pull request
* src/models/generator.js [2 pts]
    * `getCost` function [1 pt]
    * `generate` function [1 pt]
* src/views/generator.js [2 pts]
    * DOM rendering [1 pt]
    * Event binding to buy [1 pt]
* src/reducers.js [1 pt]
    * handle `BUY_GENERATOR` action

> Starting from this lab and onward, you will need to pass unit tests
> executed by TravisCI. In other word, there should be a green check mark
> showing under your Pull Request.

Submission format should be like below:

```
https://github.com/csula-students/cs-3220-spring-2018-rcliao/pull/5
```

## Get Started

To start with, you will need to download lab 3 release into your lab3 folder: https://github.com/rcliao/cookie-clicker/releases/tag/lab3

> Click on `source code` to download entire folder

## Running tests

To run the test, ensure you have Node.js installed and run the following command
under `client` folder

```
npm test
```

## Descriptions

We are going to implement a couple components following [WebComponent][1]
spec. Specifically, we will implement the Generator components using WebComponents.

## Requirements

### Functional

* User should be able to buy generator by clicking on the "buy" button in generator
    * Resource should be deducted according to generator cost
    * Generator quantity should be updated
* Generator cost should increase based on its quantity

Following does not need to be functional just yet:

* Generator does *not* need to increment value on the background
    * This will be done at homework 1

### Technical

* Generator model should pass unit tests on `getCost` and `generate` function
* Generator view component should be implementing WebComponent spec
* Generator quantity should be stored under `store.state`
* Generator should read state from `store`
* Generator should only modify state through `reducer.js`

[1]: https://developers.google.com/web/fundamentals/web-components/
[2]: https://redux.js.org/
