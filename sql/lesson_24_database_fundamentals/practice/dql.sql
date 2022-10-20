-- DQL
-- SELECT

-- Arithmetic Expressions and Operations
-- Null Values
-- Defining a Column Alias, Concatenation
-- Arithmetic Operators
-- Comparison Operators -- >, <. <=, >=, <>, =, !=
-- Distinct, Limit
-- Like
-- Between
-- in, not in
-- Order by
-- ALL, AND, ANY, BETWEEN, EXISTS, In, LIKE, NOT, OR
-- GREATEST, LEAST, NULLIF, COALESCE, CASE/WHEN
-- Using TO_CHAR, TO_NUMBER, TO_DATE, CAST, INTERVAL

SELECT 10 + 2 AS sum;
SELECT 10 * 2 AS multiply;
SELECT 10 - 2 AS subtract;
SELECT 10 / 2 AS divide;
SELECT 41 % 2 AS mod;

SELECT 15 + 2 AS sum, 40 * 2 AS "a * b", 40 - 3 AS "a - b";

-- concat
SELECT *, (name || ' ' || surname) AS full_name
FROM student;

SELECT id, name, surname, concat(name, ' ', surname) AS full_name
FROM student;

SELECT id, name, surname, (name || ' ' || 25) AS full_name
FROM student;

ALTER TABLE student
    ADD COLUMN age int;

ALTER TABLE student
    ADD COLUMN balance float;

SELECT id, name, surname, concat(name, ' ', surname) AS full_name
FROM student;

SELECT id, concat(name, ' ', surname) AS full_name, age, balance, (age + balance) AS "age + balance"
FROM student;

-- WHERE
SELECT *
FROM student
WHERE age > 20;

SELECT *
FROM student
WHERE age > 20
  AND balance > 1500;

SELECT *
FROM student
WHERE age > 20
   OR address IS NOT NULL;

SELECT *
FROM student
WHERE age > 20
   OR address IS NULL;

-- LIKE
SELECT *
FROM student
WHERE surname LIKE '%ov';

SELECT *
FROM student
WHERE name LIKE 'B%';

SELECT *
FROM student
WHERE name LIKE '%am%';

-- BETWEEN
SELECT *
FROM student
WHERE balance BETWEEN 1500 AND 5000;

SELECT *
FROM student
WHERE name BETWEEN 'N' AND 'T';

SELECT *
FROM student
WHERE name NOT BETWEEN 'N' AND 'S';

-- ORDER BY
SELECT *
FROM student
ORDER BY name DESC;

SELECT *
FROM student
ORDER BY id;

-- greatest
SELECT greatest('2020-12-12', '2021-12-12', '2022-01-12');

-- least
SELECT least('2020-12-12', '2021-12-12', '2022-01-12');


-- NULLIF
SELECT NULLIF(23, 23);

SELECT NULLIF(23, 25);

-- COALESCE  -- first notnull value
SELECT COALESCE(null, 5);

-- CASE WHEN
SELECT id,
       name,
       surname,
       age,
       CASE
           WHEN age > 20 then 'The age is is more than 20'
           WHEN age < 20 then 'The age is less than 20'
           WHEN age = 20 then 'The age is equal to 20'
           ELSE 'No other case'
           END AS age_information
FROM student;

ALTER TABLE student
    ADD COLUMN created_at timestamp;

ALTER TABLE student
    ADD COLUMN updated_at timestamp;

-- to_char time 12h format
SELECT name, surname, created_at, (created_at, 'HH:MI:SS')
FROM student;

-- to_char date and time 24h format
SELECT name,
       surname,
       created_at,
       to_char(created_at, 'DD-MM-YYYY') AS date,
       to_char(created_at, 'HH24:MI:SS') AS time
FROM student;

-- to_char
SELECT to_char(cast('2010/01/10 13:13:12.000000' AS timestamp), 'DD.MM.YYYY') AS date;

SELECT to_char(cast('2010-01-10 13:13:12.000000' AS timestamp), 'YYYY-MM-DD') AS date;

SELECT to_char(cast('2010/01/10 13:13:12.000000' AS timestamp), 'HH:MI:SS') AS time;

-- to_number
SELECT to_number('$1,121,433,233.43343434', 'L9G999g999g999.99999') AS number;

SELECT to_number('1,234.32', '99G999D99S') AS number;

SELECT to_number('1,234.32-', '99G999D99S') AS number;

-- to_date
SELECT to_date('20192012', 'YYYYDDMM') AS date;

SELECT to_date('10 FEB 2020', 'DD Mon YYYY') AS date;

SELECT to_date(cast(30112019 AS text), 'DDMMYYYY');

SELECT cast('123.30' AS float4);

-- current_database
SELECT current_database();

-- current_date
SELECT current_date;

-- INTERVAL
SELECT INTERVAL '6 years 1 month 12 days' - INTERVAL '1 year 8 days';