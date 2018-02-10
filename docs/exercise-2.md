
# Exercise 2 Discussion



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

