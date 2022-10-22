CREATE TABLE DETAILS
(
    ID         INT,
    EMP_NAME   VARCHAR(25),
    DEPT       VARCHAR(20),
    CONTACT_NO BIGINT NOT NULL,
    CITY       VARCHAR(15)
);

INSERT INTO DETAILS
VALUES (1, 'VISHAL', 'SALES', 9193458625, 'GAZIABAD'),
       (2, 'VIPIN', 'MANAGER', 7352158944, 'BARIELLY'),
       (3, 'ROHIT', 'IT', 7830246946, 'KANPUR'),
       (4, 'RAHUL', 'MARKETING', 9635688441, 'MEERUT'),
       (5, 'SANJAY', 'SALES', 9149335694, 'MORADABAD'),
       (6, 'VIPIN', 'MANAGER', 7352158944, 'BARIELLY'),
       (7, 'VISHAL', 'SALES', 9193458625, 'GAZIABAD'),
       (8, 'AMAN', 'IT', 78359941265, 'RAMPUR');

SELECT EMP_NAME, COUNT(*)
FROM DETAILS
GROUP BY EMP_NAME;

SELECT EMP_NAME, DEPT, COUNT(*)
FROM DETAILS
GROUP BY EMP_NAME, DEPT;

SELECT EMP_NAME, DEPT, CONTACT_NO, CITY, COUNT(*)
FROM DETAILS
GROUP BY EMP_NAME, DEPT, CONTACT_NO, CITY;

SELECT EMP_NAME, DEPT, CONTACT_NO, CITY, COUNT(*)
FROM DETAILS
GROUP BY EMP_NAME, DEPT, CONTACT_NO, CITY
HAVING COUNT(*) > 1;

SELECT *
FROM details
         LIMIT 5;

SELECT *
FROM details
ORDER BY CONTACT_NO DESC
    LIMIT 3;

SELECT EMP_NAME, DEPT, CONTACT_NO, CITY
FROM details
WHERE DEPT = 'SALES';

SELECT *
FROM DETAILS;


select char(70, 65, 97, 69);
select char(65, 67.3, 69.3);

select first_name, last_name, concat(first_name, last_name) as "Name Marks", salary
from employee
where salary = 3000
   or salary = 4000;

select lower('GEEKS FOR GEEKS') as "Lower Name 1",
       lower('Geeks For Geeks') as "Lower Name 2";

select substr('ABSDEFG', 3, 4) as Subs;
select substr('ABSDEFG', -5, 4) as Subs;

select upper('Large') as Uppercase;
select ucase('Large') as Uppercase;

select trim('Bar One');

select length('CANDIDE') "Length in characters";

select curdate();
select current_date;
select current_date();

select date('2020-12-31 01:02:03');
select month('2020-12-31');
select year('2020-12-31');

select now();
select now(), sleep(3), now();
select sysdate(), sleep(3), sysdate();


CREATE TABLE demo_table
(
    FIRST_NAME VARCHAR(20),
    END_NAME   VARCHAR(20),
    AGE        INT,
    GENDER     VARCHAR(20)
);

INSERT INTO demo_table
VALUES ('Romy', 'Kumari', 22, 'female'),
       ('Meenakshi', 'Jha', 20, 'female'),
       ('Shalini', 'Jha', 22, 'female'),
       ('Akanksha', 'Gupta', 23, 'female'),
       ('Rinkle', 'Arora', 23, 'female');

SELECT *
FROM demo_table;

SELECT FIRST_NAME, END_NAME AS LAST_NAME, AGE, GENDER
FROM demo_table;

SELECT FIRST_NAME AS "FIRST NAME", END_NAME AS "LAST NAME", AGE, GENDER
FROM demo_table;

SELECT first_name, last_name, salary
FROM employee
WHERE Salary BETWEEN 3000 AND 4800;

SELECT first_name, last_name, salary
FROM employee
WHERE Salary NOT BETWEEN 3000 AND 4800;

SELECT first_name, last_name, salary
FROM employee
WHERE Salary NOT IN (3000, 3600);

select first_name
from employee
where first_name like 'S%';

select first_name, last_name, salary
from employee
order by first_name;

select first_name, last_name, salary
from employee
order by salary desc;

select first_name, last_name, salary
from employee
order by salary desc, id;
