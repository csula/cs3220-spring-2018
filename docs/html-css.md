# HTML & CSS



## Agenda


### Lecture

* Intro to CSS
	* CSS Selector
	* CSS Syntax


* Exercise sample
    * [box-sizing](https://css-tricks.com/box-sizing/)
    * [Table styling](https://css-tricks.com/complete-guide-table-element/)
    * Basic layout
* DOM
* Responsive design
    * Flexbox
* CSS Frameworks
* CSS Mythology


### Lab

#### [Lab 1](./labs/lab1.md)

* Create the game public facing page
    * Implement base on mockup



## CSS Intro

### Syntax

```css
h1 { // selector
// start of block
	// property: value;
	font-size: 24px;
	padding: 0.5em 1em;
	// same as padding: 0.5em 1em 0.5em 1em;
// end of block
}
```


### Selectors

* Id
* Class
* Tag
* Value attribute
* Pseudo-elements
* Combinators
* Multiple selectors


Selectors combinator:

* The descendant selector - `(space)`
* The child selector - `>`
* The adjacent sibling selector - `+`
* The general sibling selector - `~`


```css
#id_should_be_underscore_case {
	font-size: 18px;
}

.class-should-be-dash {
	font-size: 18px;
}

h1 {
	// tag style
}

input[type="text"] {
	font-size: 18px;
}
```


```css
/* pseudo-element */
.some-class:hover {
	background-color: #f00;
}

/* combine two classes to be more specific */
.some-class.some-other-class {
}
```


```css
/* for both class 1 and 2 */
.class-1,
.class-2 {
}

/* any child under the parent */
.parent .child {
}

/* direct child only first level */
.parent > .child {
}
```



### Values

On the CSS property, you can have a couple units:

* Numeric units
	* Pixels
	* Ems
	* Percentage


* Color
	* RGB
	* Hex
	* RGBA

> Pixels as unit is probably the most common unit you will see on the web. 1 pixel
indicates one pixel on your screen. In example if you want the width of the button
to be 300px you can set to be like below:


```css
.parent {
	position: relative;
	width: 300px;
	height: 300px;
}

// absolute center with position absolute is hard.
.child {
	position: absolute;
	left: 50%;
	top: 50%;
}
```


```css
.button {
	/* Hex value is #RRGGBB; */
	background-color: #ff0000;
}
```


```css
.button {
	/* RGB goes from 0 to 255 */
	background-color: rgb(255, 0, 0);
}

/* if you want transparent background color */
.overlay {
	background-color: rgba(0, 0, 0, 0.3);
}
```



### CSS animations

```css
.button {
	background-color: blue;
	transition: all ease-in 0.3s;
}

.button:hover {
	background-color: red;
}
```



### Cascade and inheritance

* Important
* Specificity
* Source order


```html
<p class="better">This is a paragraph.</p>
<p class="better" id="winning">One selector to rule them all</p>
```


```css
#winning {
  background-color: red;
  border: 1px solid black;
}

.better {
  background-color: gray;
  border: none !important;
}

p {
  background-color: blue;
  color: white;
  padding: 5px;
}
```



### CSS Specificity

1. Thousands: inline style
2. Hundreds: id
3. Tens: class, attribute
4. Ones: tag


```css
body {
    background-color: pink !important;
    z-index: 99999999999999999 !important;
}
```



### Box model

* Padding
* Border
* Margin

![box model example](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/box-model.png)



### Fonts

* Google font - https://fonts.google.com/
* Em as unit


#### Example typography styles

```css
html {
    font-size: 62.5%; /* reset back to 10px */
    font-family: Avenir Next,Helvetica,Arial,Sans-Serif;
}

body {
    font-size: 1.8rem;
    line-height: 1.618;
    max-width: 38em;
    margin: auto;
    color: #4a4a4a;
    background-color: #f9f9f9;
    padding: 1.3rem;
}
```


```css
@media (max-width: 684px) {
    body {
        font-size: 1.53rem;
    }
}
@media (max-width: 382px) {
    body {
        font-size: 1.35rem;
    }
}
```


```css
h1, h2, h3, h4, h5, h6 {
  line-height: 1.1;
  font-family: Verdana, Geneva, sans-serif;
  font-weight: 700;
  overflow-wrap: break-word;
  word-wrap: break-word;
  -ms-word-break: break-all;
  word-break: break-word;
  -ms-hyphens: auto;
  -moz-hyphens: auto;
  -webkit-hyphens: auto;
  hyphens: auto;
}
```



### CSS Layout

* Positioning
* Float
* Flexbox


```css
.relative-container {
    position: relative;
    width: 10em;
    height: 8em;
}

.relative-container .absolute-child {
    position: absolute;
    top: 0;
    right: 0;
}
```


```css
.floating-image.left {
    float: left;
}
```


```css
.flex-container {
    display: flex;
}

.flex-container.column {
    flex-direction: column;
}
```


#### Case study

```css
.center.flex-container {
    justify-content: center;
    align-items: center;
}
```


#### Flexbox resources

* https://medium.freecodecamp.org/an-animated-guide-to-flexbox-d280cf6afc35
* http://flexboxfroggy.com/



## CSS Framework

* https://material.io/components/web/
* https://semantic-ui.com/
* http://getbootstrap.com/



## CSS Mythology

* Block
    * Standalone entity that is meaningful on its own (like component)
    * Example: Card


* Element
    * A part of block that has no stand alone meaning (like element -- button) and is semantically tied to its block
    * Example: button in the card or header in the card


* Modifier
    * A flag on a block or element. Use them to change appearance or behavior.
    * Example: **primary** button, **sub**heading


* BEM - http://getbem.com/



## References:

* List of HTML elements: https://developer.mozilla.org/en-US/docs/Web/HTML/Element
* List of CSS properties: https://developer.mozilla.org/en-US/docs/Web/CSS/Reference
* https://medium.com/actualize-network/modern-css-explained-for-dinosaurs-5226febe3525

