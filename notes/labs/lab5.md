# Lab 5

## Deliverables

* SQL file containing all queries
* CSNS text submission as below:

```
Pull request URL:
https://github.com/csula-students/cs-3220-summer-2017-rcliao/pull/5
```

## Due date time

### July 22nd 23:59:59

## Descriptions

In this lab, we will be doing some database queries with MySQL. Before you get
started, you will want to set up MySQL as lecture. Once you have MySQL set up,
please answer the following questions in a single `.sql` file.

In specific, we want to start building out restaurant application database data
through these queries. To get started, you will need to create some tables
defining the information for the food item, order statuses & shopping cart.

Once you have the table definition, you will need to populate some default data
using `INSERT INTO` statement like below:

**Food items**

| ID | Name | Description | Price |
| :-- | :-- | :-- | :-- |
| 1 | Hamburger | A hamburger | 9.99 |
| 2 | Fries | Some fries | 4.99 |
| 3 | Coke | Coke cola | 2.99 |

**Orders**

| ID | Customer Name | Created |
| :-- | :-- | :-- |
| 1 | Eric | 2017-07-20 13:35:55 |
| 2 | John | 2017-07-22 10:35:55 |
| 3 | Jane | 2017-07-22 15:35:55 |
| 4 | Alice | 2017-07-22 16:35:55 |

**Order foods**

| OrderID | FoodID | Quantity |
| :-- | :-- | :-- |
| 1 | 1 | 1 |
| 1 | 2 | 2 |
| 2 | 2 | 2 |
| 2 | 3 | 1 |
| 3 | 3 | 1 |
| 4 | 2 | 1 |
| 4 | 3 | 2 |

**Shopping Cart**

| ID | Customer Name | FoodID | Quantity |
| :-- | :-- | :-- | :-- |
| 1 | Anonymous | 1 | 2 |
| 1 | Anonymous | 2 | 1 |
| 1 | Anonymous | 2 | 1 |
| 2 | Mike | 1 | 1 |
| 2 | Mike | 2 | 1 |
| 3 | Bob | 3 | 1 |

Then you may proceed to the following requirements (starting from working on the
`SELECT` queries to update queries and finish with delete queries.

## Requirements

* Create restaurant food item table
* Create restaurant order statuses table
* Create restaurant cart table
* Insert default food items into food items table
* Insert default order statuses into order statuses table
* Update food item name from "Hamburger" to "Salad"
* Update customer name from "Jane" to "Doe"
* Find out which food item has the most orders
* Find out which food item in least shopping carts
* Find out all restaurant food items using `SELECT` query
* Find out all restaurant order statuses using `SELECT` query
* Find out the order statuses that is created **today**
* DELETE restaurant food items table
* Delete restaurant order statuses table
* Delete restaurant cart table
