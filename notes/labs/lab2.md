# Lab 2

## Deliverables

* app.js [4 pts]
    * button on click [2 pts]
    * counter display [2 pts]
        * Need to use `PubSub` object below
* index.html [1 pt]
    * should be nearly the same as lab 1

## Description

Implement the first behavior of the game – click on the button to increment
the counter.

You should create a brand new JavaScript file called `app.js` and import such
file under the `index.html` from lab 1.

> You may create a new folder called `lab2` and copy the `index.html` as well as `app.css` over

From there, you have to add the click event binding to the
button and increment the counter value.

As a starter, you will need a place to store the game state. Lets keep it simple
and store the state under Window object (global sharable object across all scripts)

```html
<script>
    window.incrementalGame = {
        state: {
            counter: 0
        }
    };
</script>
```

> Put this `script` tag before you import the `app.js` so that the state can be defined the app.js get executed

In additional to above, you want to ensure your state mutation code goes into a
single function so you can notify the changes to the view layer on update.

> Think about creating a single function to increment the value accordingly

There is one more challenge we have to resolve in additional to the event
binding and increment values – how do we notify the state changes to the
counter?

> One may argue to increment value and update the DOM accordingly. As for
> us, we will need something more generic because we will be using this
> counter state in later lab and homework.

We will implement a quick dummy `PubSub` object like below:

```javascript
// PubSub is single object for publish data to multiple subscribers
class PubSub {
    constructor () {
        this.subscribers = [];
    }

    // subscribe allows a new subscriber to listen for changes by providing
    // callback function in the parameter
    subscribe (fn) {
        this.subscribers.push(fn);
    }

    // one can publish any data to subscribers
    publish (data) {
        this.subscribers.forEach(subscriber => {
            subscriber(data);
        });
    }
}

const pubSub = new PubSub();

pubSub.subscribe(data => {
    console.log(data);
});

pubSub.publish('Hello world!');
```

The purpose of the `PubSub` is to notify changes. You may find example above to subscribe and publish changes.

From there, you will need the function we defined earlier (that mutate the
counter state) to notify the pubSub object as well. So your counter can
*subscribe* to the changes and update the state accordingly.

## Requirements

### Functional

* When user clicks on *the button*, the counter should increase
* The *counter* should display up to date resource value from `window.incrementalGame.state.counter`

### Technical

* Should re-use the same (similar) HTML & CSS from lab 1
* Should store all state under `window.incrementalGame.state`
* Should use `PubSub` object provided in lab 2
    * To publish state changes
    * To subscribe state changes and update the counter value
