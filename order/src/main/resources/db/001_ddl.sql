CREATE TABLE IF NOT EXISTS orders
(
    id          SERIAL PRIMARY KEY,
    name        TEXT    NOT NULL,
    description TEXT    NOT NULL,
    price       DECIMAL NOT NULL,
    status      TEXT    NOT NULL
);
CREATE TABLE IF NOT EXISTS order_dish
(
    order_id INT REFERENCES orders (id),
    dish_id  INT REFERENCES dish (id),
    CONSTRAINT order_dish_pkey PRIMARY KEY (order_id, dish_id)
);