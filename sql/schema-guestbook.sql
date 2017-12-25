DROP TABLE IF EXISTS guestbook;

CREATE TABLE guestbook (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    message TEXT,
    created timestamp
);

INSERT INTO guestbook (name, message, created)
    VALUES ('John', 'Hello', '2017-07-28 17:10:00'), ('Joe', 'Hi', now());
