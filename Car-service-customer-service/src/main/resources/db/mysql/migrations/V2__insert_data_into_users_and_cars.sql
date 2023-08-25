INSERT INTO users (id, first_name, last_name)
VALUES (UUID(), 'Adam', 'Johnson'),
       (UUID(), 'Kate', 'Moss'),
       (UUID(), 'Sonya', 'Stark'),
       (UUID(), 'Geneva', 'Wilson');

INSERT INTO cars (id, make, model, year, kilometers, user_id)
VALUES (1, 'toyota', 'avensis', 2005, 186153,
        (SELECT id FROM users WHERE first_name = 'Adam' AND last_name = 'Johnson')),
       (2, 'ford', 'mondeo', 2014, 286283,
        (SELECT id FROM users WHERE first_name = 'Kate' AND last_name = 'Moss')),
       (3, 'volvo', 'xc60', 1999, 386383,
        (SELECT id FROM users WHERE first_name = 'Sonya' AND last_name = 'Stark')),
       (4, 'bmw', 'x1', 2000, 486483,
        (SELECT id FROM users WHERE first_name = 'Geneva' AND last_name = 'Wilson')),
       (5, 'bmw', 'x3', 2007, 586483,
        (SELECT id FROM users WHERE first_name = 'Geneva' AND last_name = 'Wilson'));
