# Exercise 2 Discussion

## Context

> This article is aim to provide some discussion and my implementation of exercise 2.
> Its goal is to provide review over the HTML section as well as preparing for the
> CSS syntaxes and some CSS magic.



## Agenda

* Useful toolkit
* Table element
* Form elements
    * `value`, `placeholder` attribute
    * `label` and `id`
* CSS Flexbox
    * Row/column based layout


* Patterns
    * Front end abstraction



## Toolkit

* https://emmet.io/



## Table

```html
<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>Name</td>
        <td>Description</td>
    </tr>
</table>
```

> The use of `th` element is key here, you can have table head cell having different
> style than the `td`.


```css
.info-table {
    border-collapse: collapse;
}
.info-table tbody tr:nth-child(even) {
    background-color: #eee;
}
.info-table td,
.info-table th {
    border: 1px solid #ccc;
    padding: 0.5rem;
}
.info-table .align-right {
    text-align: right;
}
```

> This should give you a good starting point on getting table looks not so … 90s


```css
/**
 * for getting text in the talbe cell to show up one line with ellipsis
 */
.table-with-ellipsis {
    table-layout: fixed;
}
.table-with-ellipsis td,
.table-with-ellipsis th {
    max-width: 20em;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}
```

> This allow you to add ellipsis to table description when it gets long rather
> than having styling



## Form elements

```html
<form action="">
    <label for="name">Name</label>
    <input id="name" type="text" value="pre-entered name">

    <label for="name_2">Another Name</label>
    <input id="name_2" type="text" placeholder="hinted name">
</form>
```



## CSS Flexbox

```css
.container {
    display: flex;
}
.container .fill {
    flex: 1;
}
```



## Patterns

Recognize common elements between the page and create CSS class
