-- 1.	Write query to display count of each age in a table
SELECT age, count(age) AS count_of_age
FROM student
GROUP BY age;

-- 2.	First of all you need to create two tables:
--     a.	Loans -> {id, customer_id, loan}
--     b.	Limits -> {id, customer_id, limit}
--     Write a query to display the percent of limit which is used by each customer:
--     e.g.: if customer_id = 123
--     has a loan = 50 AZN; and has a limit = 100 AZN then the customer(123)
--     is used 50 % percent of the limit, so the result must be like: 50%.

CREATE TABLE loans
(
    id          SERIAL,
    customer_id int,
    loan        int
);

CREATE TABLE limits
(
    id          SERIAL,
    customer_id int,
    limits      int
);

INSERT INTO loans
VALUES (1, 175, 190),
       (2, 100, 120),
       (3, 123, 20),
       (4, 73, 200),
       (5, 25, 145);

INSERT INTO limits
VALUES (1, 123, 100),
       (2, 100, 250),
       (3, 175, 400),
       (4, 25, 300),
       (5, 73, 550);

SELECT loans.id,
       loans.customer_id,
       loans.loan,
       limits.limits,
       (loans.loan * 100 / limits.limits) || '%' AS percent
FROM loans,
     limits
where loans.customer_id = limits.customer_id;