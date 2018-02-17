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
counter.

You should create a brand new JavaScript file called `app.js` and import such
file under the `index.html` from lab 1.

From there, you have to implement the event binding to add click event to the
button and increment the value accordingly.

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

In additional to above, you want to ensure your state mutation code goes into a
single function so you can notify the changes to the view layer on update.

As starter, you may want to consider using this code:

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

## Requirements

### Functional

* When user clicks on *the button*, the counter should increase
* The *counter* should display up to date resource value from `window.incrementalGame.state.counter`

### Technical

* Should re-use the same (similar) HTML & CSS from lab 1
* Should store all state under `window.incrementalGame.state`
* Should use `PubSub` object provided in lab 2
