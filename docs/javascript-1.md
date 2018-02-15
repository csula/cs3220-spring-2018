# JavaScript



## Agenda


### Lecture

* JavaScript Intro
* JavaScript syntax
* EcmaScript 6 features
* You may not need jQuery
* Common JavaScript Usage
    * Query for DOM element
    * Add event listener
    * Class toggle


### Lab

* Button to counter


### Homework

* Background game loop



## JavaScript Intro


https://www.destroyallsoftware.com/talks/wat


* _Browser_
* Node.js
* EcmaScript


### Framework?

* Angular vs React



### Hello world

```javascript
console.log('Hello world');
```


```html
<p>Hello from HTML</p>
```

```javascript
document.querySelector('p').textContent =
'Hello from JavaScript';
```



## JavaScript Syntax


### Variables


```javascript
var newVariable;
```


```javascript
// to assign variable, it is the same statement
// as Java using "="
newVariable = 'Hello CS3220';

// you can also combine declaration with 
// assignment together
var newVariable2 = 'Hello CS-3220';

// and then to retrieve variable simply call variable
newVariable;

// After you declare and assign variable, you can always 
// assign the variable again
newVariable = 'Hello cs-3220 again';
```


### Types

* String
* Number
* Boolean
* Array
* Object


```javascript
var stringVariable = 'This is a string';
var numberVariable = 123;
var booleanVariable = true;
var array = [ 1, 2, 3 ];
var jsObject = {
	name: 'value',
	number: 123,
	array: [1234, 5678]
};
// as well as everything is an object in JavaScript
var h1 = document.querySelector('h1'); // is also an object
```


### Operators


* Add/concatenation

```javascript
6 + 4;
'A string' + 'another string';
```


* subtract, multiply, divide

```javascript
3 - 2;
2 * 3;
4 / 2;
```

* Identity operator

```javascript
1 === 1;
```


* Negative, not equals

```javascript
var t = true;
f = !t;

f !== t; // true
```


### Conditions

```javascript
if (1 === 2) {
	console.log('What!?!?!?!?');
} else {
	console.log('1 is not equal to 2');
}
```


```javascript
1 == '1';
true == 'true';
null == undefined;
```


### Loop

```javascript
var list = [1, 2, 3];

for (var i = 0; i < list.length; i ++) {
    console.log(list[i]);
}

// or use forEach function from Array
list.forEach(function(item) {
    console.log(item);
});
```


### Functions

```javascript
// to delcare a function
function aFunction () {
	console.log('Calling a function');
}

// or you can declare function in usual assignment way
var anotherFunction = function () {
	console.log('Calling another function');
}
```


```javascript
// to call a function, simply call the function name with "()"
aFunction();
anotherFunction();

// function can have arguments
function multiply (a, b) {
	return a * b;
}

multiply(2, 3); // return 6
```


#### Closure

Closure allows JavaScript function to use variable from its parent scope.


```javascript
function init () {
    var name = 'Mozilla';
    function displayName () {
        console.lot(name);
    }
    displayName();
}

init();
```


```javascript
function makeFunc () {
    var name = 'Mozilla';
    function displayName () {
        console.log(name);
    }
    return displayName;
}

var myFunc = makeFunc();
myFunc();
```


Common Mistake

```html
<ul>
    <li id="item_1">Item 1</li>
    <li id="item_2">Item 2</li>
    <li id="item_3">Item 3</li>
</ul>
```


```javascript
function logClick () {
    var logs = [ 'hello 1', 'hello 2', 'hello 3' ];
    for (var i = 0; i < logs.length; i ++) {
        var log = logs[i];
        document.getElementById('item_' + i).onclick = function () {
            console.log(log);
        };
    }
}

logClick();
```


### Array functions

Most data comes in not in single but in list.


```javascript
var list = [1, 2, 3];

// classic forEach, map, reduce, & filter functions
// forEach can replace the usage of traditional for loop
list.forEach(function(item) {
    console.log(item);
});
```


```javascript
// map is useful when you want to transform every item in array
list.map(function(item) {
    return item * 2;
}).forEach(function(item) {
    console.log(item); // should log out 2, 4, 6
});
```


```javascript
// reduce is useful when you want to combine array into a single item
list.reduce(function(accu, item) {
    return accu + item;
}, 0); // should return 6 because (1 + 2 + 3)
```


```javascript
// filter is useful when you want only certain items from array
list.filter(function(item) {
    return item > 1;
}).forEach(function(item) {
    console.log(item); // should only print 2, 3
});
```



### Events

```html
<button id="click_me">button</button>
```

```javascript
document.querySelector('#click_me')
    .onclick = function () {
        alert('Hello there');
    };
document.querySelector('#click_me')
    .addEventListener('click', function() {
        alert('Hello there again');
    });
```



### Practices

```html
<span class="rgb-square"></span>
```

```css
<style>
	.rgb-square {
		display: block;
		background-color: #fff;
		width: 2em;
		height: 2em;
	}

	.rgb-square.--red {
		background-color: red;
	}
	.rgb-square.--blue {
		background-color: blue;
	}
	.rgb-square.--green {
		background-color: green;
	}
</style>
```


```javascript
var dom = document.querySelector('.rgb-square');

dom.addEventListener('click', function () {
	// fill in the logic to change color of the square
	// hint: you can use https://developer.mozilla.org/en-US/docs/Web/API/Element/classList to change color
});
```


### Practice #2

Guessing game!

```html
<p>Hi there, I want to play a guessing game with you! Please guess a number
between 1 and 10; and I will tell you if it is my number or not!</p>
<button id="guess">Guess a number</button>
```

```javascript
var node = document.querySelector('#guess').addEventListener('click', function() {
	var number = prompt('Guess a number!');
});
```



## ES6 features

* Arrow function
* Classes
* Template string
* Default & Rest + Spread
* Let + const
* Module


### Arrow functions

Lambda!

```javascript
function a () {
    console.log('a');
}

b = () => {
    console.log('same as a');
}
```

```javascript
// You can use the arrow function to replace the usual function declaration
var list = [1, 2, 3];
console.log(list.map(i => i * 2));

var list2 = ['Hello', 'World'];
list2.forEach((item, index) => {
    console.log(item, index);
});
```


### Classes

```javascript
class Shape {
    get area() {
        console.log('Define me!');
    }
}

class Square extends Shape {
    constructor(length) {
        super();
        this.length = length;
    }

    get area() {
        return this.length * this.length;
    }

    print() {
        console.log('I\'m a square having length ' + this.length);
    }
}

var sq1 = new Square(5);
sq1.area;
sq1.print();
```


### Template string

```javascript
var test = 'Hello';
var tplString = `${test} World!`;
```


### Default, rest & spread

```javascript
function defaultValueFn (a = 'hello', b = 'world') {
    console.log(a, b);
}

defaultValueFn('Hey');
```


```javascript
function restValueFn (a, ...b) {
    console.log(a, b.length);
}

restValueFn('test', 'hello', '1', '2');
```


```javascript
function spreadFn (a, b, c) {
    console.log(a, b, c);
}

spreadFn(...[1, 2, 3]);
```

### Let & Const

```javascript
function blockFn () {
    let a = 3;
    const b = 'cannot be reassigned';
    b = 'test'; // error because b cannot be reassigned
    let a = 4; // error because a is already declared
}
```


### Module

```javascript
// math.js
export function multiply (a, b) {
    return a * b;
}
```

```javascript
import {multiply} from 'math';
console.log(multiply(2, 3));
```



## Common JavaScript usage

* Query for DOM element
* Adding event listener
* Toggle class


### Query for DOM element

```javascript
// find an element with id of "special"
const specialNode = document.querySelector('#special');
// find all elements with class of "btn"
const buttonWithBtnClass = document.querySelectorAll('.btn');
```


### Add event listener

```javascript
const btn = document.querySelector('#some_button');
btn.addEventListener('click', () => {
    alert('This event is responding to your button click');
});
// also valid
btn.onclick = function() {
    alert('This is onclick event');
};
```


### Class toggle

```javascript
function toggleBtnClass () {
    const btn = document.querySelector('#btn')
    btn.addEventListener('click', () => {
        btn.classList.toggle('--state-success');
    });
}
```



## Resources

* [What the heck is JavaScript event loop anyway?](https://www.youtube.com/watch?v=8aGhZQkoFbQ)
* [Learn JavaScript in one video](https://www.youtube.com/watch?v=fju9ii8YsGs)
* [Eloquent JavaScript book](http://eloquentjavascript.net/)
* [You don't know JS](https://github.com/getify/You-Dont-Know-JS)
* [Event bubbling and delegation](https://teamtreehouse.com/library/event-bubbling-and-delegation)
* https://developer.mozilla.org/en/docs/Web/JavaScript/EventLoop
