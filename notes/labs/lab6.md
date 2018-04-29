# Lab 6

## Deliverables

* Define MySQL schema in the CS3 server
* Define tables for generators and events meta data
* Define the table for users
* Single sql file called `game.sql`

## Description

In this lab, your job is to create the necessary schema designs for the meta
data including generators and events. In other word, by the end of this lab, you
should have the generators and events meta data information schema ready in CS3
MySQL Server.

In additional to the game meta data, you will also need to define the users table
to store who is authorized to login. From the users table, you need to add up the
creator information to the generators and events meta data table.

Before we start diving into the detail, I've created an application for you
to test your SQL logic here:
http://104.131.155.18:8000/91961f18b3ec7bcff0fa2142f65fa17e

Please use the SQL unit test website to confirm your result. In specific, I
should be able to copy your submission and paste in the SQL unit test
website and see them all passing (or failing).

## Specific

In specific, you will need to create the query for the following items:

1. Create `users` table
    * Use `DESCRIBE users;` to test your result after creating the table
2. Create `generators` table
    - `created_by` should be reference key to `users` table
    * Use `DESCRIBE generators;` to test your result after creating the table
3. Create `events` table
    - `created_by` should be reference key to `users` table
    * Use `DESCRIBE events;` to test your result after creating the table
4. Create `quantities` table
    - Combination of `token` and `generator_id` should be unique
    * Use `DESCRIBE quantities;` to test your result after creating the table
5. Insert sample records to `users` like below
    * After insert, use `SELECT * FROM users;` to test the result
6. Insert sample records to `generators` like below
    * After insert, use `SELECT * FROM generators;` to test the result
7. Insert sample records to `events` like below
    * After insert, use `SELECT * FROM events;` to test the result
8. Insert sample records to `quantities` like below
    * After insert, use `SELECT * FROM quantities;` to test the result
9. Update generator record of name "grandma" to have `unlock_at` value of 10 and `rate` of 1
    * After update, use `SELECT * FROM generators;` to test the result
10. Find out the information of generators including quantity, name, description, rate, base_cost and unlock_at for token `80516ce4663c3bd0c8385309a2fe226e`
11. Find out which generator has the most `unlock_at` value
12. Find out all the generators with the order of `unlock_at` from lowest to highest
13. Delete an event called "sample event"
    * After delete, use `SELECT * FROM events;` to test the result

### Sample Data

#### Users

| id | username | password |
| :-- | :-- | :-- |
| 1 | admin | cs3220password |
| 2 | me | notapassword |

#### Generators

| id | name | description | rate | base_cost | unlock_at | created_by |
| :-- | :-- | :-- | :-- | :-- | :-- | :-- |
| 1 | Grandma | Grandma likes to make cookies | 5 | 10 | 10 | 1 |
| 2 | Factory | Factory to produce cookies | 10 | 50 | 50 | 1 |
| 3 | Mine | Mining cookies | 20 | 200 | 200 | 2 |

#### Events

| id | name | description | trigger_at | created_by |
| :-- | :-- | :-- | :-- | :-- |
| 1 | Grandma shows up | You always know grandma likes to make cookies | 10 | 1 |
| 2 | You can construct factory now! | Factory to produce cookies | 50 | 1 |
| 3 | We've found cookies in deep mountain ... in the mine? | Mining cookies | 200 | 2 |
| 4 | sample event | This is a sample event. Please delete me | 99999 | 2 |

#### Quantities

| generator_id | token | quantity |
| :-- | :-- | :-- |
| 1 | c7a69d44e0b9b415b2d9956cb26b944a | 2 |
| 2 | c7a69d44e0b9b415b2d9956cb26b944a | 1 |
| 1 | 80516ce4663c3bd0c8385309a2fe226e | 20 |
| 2 | 80516ce4663c3bd0c8385309a2fe226e | 30 |

## Requirements

### Functional

* None

### Technical

* Pass sql-unit-test test cases
