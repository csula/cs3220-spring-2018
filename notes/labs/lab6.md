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

## Specific

In specific, you will need to create the query for the following items:

* Create `users` table
* Create `generators` table
    - `created_by` should be reference key to `users` table
* Create `events` table
    - `created_by` should be reference key to `users` table
* Create `quantities` table
    - Combination of `token` and `generator_id` should be unique
* Insert sample records to `generators` like below
* Insert sample records to `events` like below
* Insert sample records to `users` like below
* Insert sample records to `quantities` like below
* Update generator record of name "grandma" to have `unlock_at` value of 10 and `rate` of 1
* Find out the information of generators including quantity, name, description, rate, base_cost and unlock_at for token `80516ce4663c3bd0c8385309a2fe226e`
* Find out which generator has the most `unlock_at` value
* Find out all the generators with the order of `unlock_at` from lowest to highest
* Delete an event called "sample event"

### Sample Data

#### Generators

| id | name | description | rate | base_cost | unlock_at | created_by |
| :-- | :-- | :-- | :-- | :-- | :-- | :-- |
| 1 | Grandma | Grandma likes to make cookies | 5 | 10 | 10 | 1 |
| 2 | Factory | Factory to produce cookies | 10 | 50 | 50 | 1 |
| 3 | Mine | Mining cookies | 20 | 200 | 200 | 2 |

#### Events

| id | name | description | trigger_at | created_by |
| :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- |
| 1 | Grandma shows up | You always know grandma likes to make cookies | 10 | 1 |
| 2 | You can construct factory now! | Factory to produce cookies | 50 | 1 |
| 3 | We've found cookies in deep mountain ... in the mine? | Mining cookies | 200 | 2 |
| 4 | sample event | This is a sample event. Please delete me | 99999 | 2 |

#### Users

| id | username | password |
| :-- | :-- | :-- |
| 1 | admin | cs3220password |
| 2 | me | notapassword |

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
* Define the tables in CS3 MySQL server
