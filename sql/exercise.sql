
-- create tables
CREATE TABLE employees (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    supervisor_id INTEGER REFERENCES employees(id)
);

CREATE TABLE projects (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    leader_id INTEGER REFERENCES employees(id)
);

CREATE TABLE project_members (
    project_id INTEGER REFERENCES projects(id),
    member_id INTEGER REFERENCES employees(id)
);

-- insert dummy data
INSERT INTO employees VALUES
(1, 'John', 'Doe', 'Street #215', null),
(2, 'Jane', 'Doe', 'Street #711', 1);

INSERT INTO projects VALUES
(1, 'Firestone', 1),
(2, 'Blue', 2);

INSERT INTO project_members VALUES
(1, 1),
(2, 1),
(2, 2);

-- exercise: Single-table selection

-- 1. list the last names of the employees whos
-- id are less than 10 (remove duplicates and
-- sort by alphabetical order)
SELECT DISTINCT last_name FROM employees
WHERE id < 10
ORDER BY last_name;

-- 2. find the id of Jane Doe
SELECT id FROM employees
WHERE first_name = 'Jane' AND last_name = 'doe';

-- 3. find the name of employees who do not
-- have supervisor (concatenate the first name
-- and last name)
SELECT CONCAT(first_name, ' ', last_name) FROM employees
WHERE supervisor_id IS NULL;


-- 4. List the employees who work on the project with id=1
SELECT * FROM employees INNER JOIN project_members ON member_id = employees.id
WHERE project_id = 1;
-- 5. List the employees who work on the project "Blue"
SELECT * FROM employees
    INNER JOIN project_members ON member_id = employees.id
    INNER JOIN projects ON project_id = projects.id
WHERE name = 'Blue';
-- 6. Find the name of Jane Doe's supervisor
SELECT s.first_name, s.last_name FROM employees e
INNER JOIN employees s ON e.supervisor_id = s.id
WHERE e.first_name = 'Jane' AND e.last_name = 'Doe';

-- 8. Find the number of employees whoes last name is "Doe"
SELECT COUNT(*) FROM employees
WHERE last_name = 'Doe';

