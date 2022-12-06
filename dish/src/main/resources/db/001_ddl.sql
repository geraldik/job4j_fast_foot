CREATE TABLE IF NOT EXISTS category
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS dish
(
    id          SERIAL PRIMARY KEY,
    name        TEXT                         NOT NULL,
    category_id INT REFERENCES category (id) NOT NULL,
    description TEXT                         NOT NULL,
    price       DECIMAL                      NOT NULL
)