DROP TABLE IF EXISTS "orders";

CREATE TABLE orders
(
    "id"          INTEGER  PRIMARY KEY,
    "name"        text NOT NULL,
    "description" text,
    "price"       numeric
);