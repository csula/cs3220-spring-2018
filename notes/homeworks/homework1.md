# Homework 1

## Deliverables

* src/views/story.js [1 pt]
* src/models/story.js [1 pt]
* src/game.js [3 pts]

> Should pass unit test executed by TravisCI

## Description

### Game Loop

Continue from lab 3, you should have the generator model and view component
implemented. This means you should be able to buy generator from the
button.

In other word, the game state now should consist of:

```javascript
const currentState = {
    counter: 0,
    generators: [
        {
            name: 'Grandma',
            description: '…',
            rate: 5,
            baseCost: 10,
            quantity: 0,
            unlockValue: 10
        }
    ],
    stories: []
}
```

From this state (which is stored under the `store.js`), you need to
implement the game loop that will tick once every second (see `game.js` for
how it is executed once every second. When the loop get called, you need to
read the game state object to determine how much of the resouces to
generator (through `generator.generate` function.

With the generator generating the value on the background, the counter we implemented back in lab1.md should also display up to date number.

### Story Component

First thing we will do in this homework is to implement the story component following the WebComponent spec.

You should find this familiar with the implementation you did in lab 3 earlier as generator component. The differences between the generator and story component is:

* They look at different state attribute (one looks at generators and the other looks at stories)
* Story doesn't have action associate with it (e.g. generator has click event)
* Story should appear from the game loop triggering

## Requirements

### Functional

* Game should increment its value on the background based on the quantity of generator
* Story should appear based on game loop ticks (over story `triggerAt` value)

### Technical

* Game loop should increment value under store through reducers
* Game loop should trigger story to be visible (based on counter value)
* Story component should be implemented using WebComponent spec
* Should implement `isUnlockYet` and `unlock` method under story
* Pass all unit tests

