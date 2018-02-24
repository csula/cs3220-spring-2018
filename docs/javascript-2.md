# JavaScript



## Agenda


### Lecture

* [Component pattern](#component-pattern)
* [State management](#state-management)
* [JavaScript Tooling](#javascript-tooling)
    * [JavaScript testing](#javascript-testing)
    * [JavaScript bundler](#javascript-bundler)


### Lab

* Lab 3
    * Generator to inventory


### Homework

* Background game loop



## Component Pattern


![project home with components](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/project/home-components.png)


```
<App>
    <Game-Header>
    </Game-Header>
    <Game-Main>
        <Resource>
        </Resource>
        <TheButton>
        </TheButton>
        <Generator-List>
            <Generator>
            </Generator>
        </Generator-List>
    </Game-Main>
</App>
```


### What is a component?

![lego as component metaphor](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/lego-component.jpeg)


#### WebComponent

* Custom Element
* Shadow DOM


### Example component


#### Plain Old JavaScript

https://gist.github.com/rcliao/2da6b1ce044a7cba2948ba94b5650afd#file-plain-javascript-component-js


#### WebComponent

https://gist.github.com/rcliao/2da6b1ce044a7cba2948ba94b5650afd#file-web-component-html


#### Plain JavaScript

```javascript
const squrares = document.querySelectorAll('.rbq-square');
// forEach on NodeList type may not work in IE!
squares.forEach(square => {
    square.colors = ['r', 'g', 'b'];
    square.index = -1;
    square.addEventListener('click', () => {
        const oldClass = square.colors[square.index];
        const newClass = square.colors[++square.index];
        if (oldClass) {
            square.classList.remove(oldClass);
        }
        square.classList.add(newClass);
    });
});
```


### What if JavaScript need to do render?

* innerHTML

https://gist.github.com/rcliao/2da6b1ce044a7cba2948ba94b5650afd#file-random-list-js



## State management


![State management need](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/state-management.png)


![Redux architecture](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/redux-architecture.png)


https://gist.github.com/rcliao/2da6b1ce044a7cba2948ba94b5650afd#file-store-js


### Hello Store


#### Reducer

```javascript
// reducer is single action to change data state
const reducer = (state, action) => {
    switch (action.type) {
    case 'TEST':
        state.data = action.payload;
        return state;
    default:
        return state;
    }
};
```


### Usage

```javascript
// create new store object
const store = Store(reducer, {});

// one can subscribe to store state changes
store.subscribe(state => {
    console.log(state);
});

// dispatch shows intent to change data (toward certain reducer logic above)
store.dispatch({
    type: 'TEST',
    payload: 'Hello world'
});
```


### WebComponent with Store

https://github.com/csula/cs3220-spring-2018/blob/master/practices/rgb-webcomponent.html



## JavaScript Tooling


### Prerequisites

* [Node.js](https://nodejs.org/en/)


```
~
[I] ➜ node -v
v9.3.0

~
[I] ➜ npm -v
5.6.0
```


### JavaScript Testing

```javascript
test('adds 1 + 2 to equal 3', () => {
  expect(sum(1, 2)).toBe(3);
});
```

```
npm test
```


#### Travis CI

```
.travis.yml
```


### JavaScript Bundler

```
src => dest
```

```
npm run build
```



## Resources

* [What the heck is JavaScript event loop anyway?](https://www.youtube.com/watch?v=8aGhZQkoFbQ)
* [Learn JavaScript in one video](https://www.youtube.com/watch?v=fju9ii8YsGs)
* [Eloquent JavaScript book](http://eloquentjavascript.net/)
* [You don't know JS](https://github.com/getify/You-Dont-Know-JS)
* [Event bubbling and delegation](https://teamtreehouse.com/library/event-bubbling-and-delegation)
* https://developer.mozilla.org/en/docs/Web/JavaScript/EventLoop
