-- 1)	Create table (Orders)
-- Columns :
-- 	Id, customer_id, price, order_date
CREATE TABLE orders
(
    id          serial,
    customer_id int,
    price       float4,
    order_date  timestamp,
    constraint order_pk primary key (id)
);

-- 2)	Add new column (order_name) use alter
ALTER TABLE orders
    ADD COLUMN order_name varchar(30);

-- 3)	Add new column (test) use alter
ALTER TABLE orders
    ADD COLUMN test int;

-- 4)	Insert some data (10)
INSERT INTO orders
VALUES (2, 4, 120.4, '2020-03-25', 'Second order'),
       (3, 7, 782.9, '2021-12-04', 'Third order'),
       (4, 1, 414782.7, '2017-06-12', 'Fourth order'),
       (5, 2, 4847, '2020-01-04', 'Fifth order'),
       (6, 5, 4844.47, '2019-06-24', 'Sixth order'),
       (7, 4, 4748, '2021-11-05', 'Seventh order'),
       (8, 1, 145488.4, '2022-05-14', 'Eighth order'),
       (9, 6, 1745, '2019-02-17', 'Ninth order'),
       (10, 10, 879314, '2018-08-27', 'Tenth order');

-- 5)	Select some rows where order_name not starts with T
SELECT *
FROM orders
where order_name NOT LIKE 'T%';

-- 6)	Select orders where order date between January - May
SELECT *
FROM orders
where order_date BETWEEN 'January' AND 'May';

-- 7)	Concat two columns (order_name (customer_id))
SELECT order_name,
       customer_id,
       concat(orders.order_name, '(', customer_id, ')') AS "(order_name (customer_id))"
FROM orders;

-- 8)	Case/when
-- Price > 12
-- Price < 12
-- Price = 12
SELECT order_name,
       price,
       CASE
           WHEN price > 12 then 'Price is more than 12'
           WHEN price < 12 then 'Price is less than 12'
           WHEN price = 12 then 'Price is equal to 12'
           END AS price_information
FROM orders;

-- 9)	Write a query to display a string "Hello SQL".
SELECT 'Hello SQL' AS hello_sql;

-- 10)	Write a query to display three numbers in three columns.
SELECT 10 AS a, 20 AS b, 30 AS c;

-- 11)	Write a query to display the sum of two numbers 200 and 30
SELECT 200 + 30;

-- 12)	Write a query to display unique names
INSERT INTO orders
VALUES (11, 5, 231466, '2020-03-25', 'Second order');

SELECT DISTINCT order_name
FROM orders;

-- 13)	 Write a query to display orders where price more than $100
SELECT *
FROM orders
WHERE price > 100;

-- 14)	 Drop column (test) use alter;
ALTER TABLE orders
DROP
COLUMN test;