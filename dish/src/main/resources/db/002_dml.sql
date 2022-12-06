INSERT INTO category(name)
VALUES ('dessert'),
       ('salad')
;
INSERT INTO dish(name, category_id, description, price)
VALUES ('cheesecake', 1, 'Cheesecake is a sweet dessert consisting of one or more layers', 100),
       ('apple pie', 1, 'Fruit pie in which the principal filling ingredient is apples', 150),
       ('caesar', 2, 'green salad of romaine lettuce and croutons dressed with lemon juice (or lime juice),' ||
                     ' olive oil, egg, Worcestershire sauce, anchovies, garlic, Dijon mustard, Parmesan cheese,' ||
                     ' and black pepper', 200),
       ('caprese salad', 2, 'Simple Italian salad, made of sliced fresh mozzarella, tomatoes, and sweet basil,' ||
                            ' seasoned with salt, and olive oil', 250)