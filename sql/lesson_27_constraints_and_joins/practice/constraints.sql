-- NOT NULL declaring:
-- 1.
CREATE TABLE invoices
(
    product_id INT NOT NULL,
    name       varchar
);

-- 2.
ALTER TABLE invoices
    ALTER COLUMN name SET NOT NULL;


-- UNIQUE declaring:
-- 1.
CREATE TABLE person
(
    id    SERIAL PRIMARY KEY,
    email VARCHAR(50) UNIQUE
);

-- 2.
CREATE TABLE person
(
    id    SERIAL PRIMARY KEY,
    email VARCHAR(50),
    UNIQUE (email)
);

-- 3.
CREATE TABLE person
(
    id    SERIAL PRIMARY KEY,
    email VARCHAR(50),
    UNIQUE (id, email)
);

-- 4.
CREATE UNIQUE INDEX CONCURRENTLY email_unique
    ON person (email);



-- CHECK declaring:
-- 1.
CREATE TABLE products
(
    product_no integer,
    name       text,
    price      numeric CHECK (price > 0)
);

-- 2. Giving a separate name to constraint
CREATE TABLE products
(
    product_no integer,
    name       text,
    price      numeric
        CONSTRAINT positive_price CHECK (price > 0)
);

-- 3. Refers to several columns
CREATE TABLE products
(
    product_no       integer,
    name             text,
    price            numeric CHECK (price > 0),
    discounted_price numeric CHECK (discounted_price > 0),
    CHECK (price > discounted_price)
);

-- 4.
alter table products
    add constraint product_no
        check (product_no > 0);