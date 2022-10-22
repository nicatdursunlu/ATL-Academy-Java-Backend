CREATE TABLE ADDITION
(
    employee_id   int,
    employee_name varchar(55),
    salary        int
);

INSERT INTO ADDITION
VALUES (1, 'Ulvi Aghajanov', 1500);

SELECT *
FROM ADDITION;

SELECT employee_id, employee_name, salary, salary + 100 AS "salary + 100"
FROM ADDITION;

SELECT employee_id, employee_name, salary, salary + ADDITION.employee_id AS "salary + employee_id"
FROM ADDITION;

SELECT employee_id, employee_name, salary, salary - 100 AS "salary - 100"
FROM ADDITION;

SELECT employee_id, employee_name, salary, salary * 100 AS "salary * 100"
FROM ADDITION;

SELECT employee_id, employee_name, salary, salary % 100 AS "salary % 100"
FROM ADDITION;

SELECT employee_id, employee_name, salary, salary % 1000 AS "salary % 1000"
FROM ADDITION;


CREATE TABLE ADDITION_SECOND
(
    employee_id   int,
    employee_name varchar(55),
    salary        int,
    type          varchar(20),
    CONSTRAINT addition_second_employee_id_pk PRIMARY KEY (employee_id)
);

INSERT INTO ADDITION_SECOND
VALUES (1, 'John Kempler', 500, null);

INSERT INTO ADDITION_SECOND
VALUES (2, 'Kate', 500, null);

SELECT employee_id, employee_name, salary, type, type + 100 AS "type + 100"
FROM ADDITION_SECOND;

SELECT *
from ADDITION_SECOND;

CREATE TABLE Employee
(
    id            int,
    first_name    varchar(55),
    last_name     varchar(55),
    email         varchar(55),
    date_if_birth date,
    salary        double
);

ALTER TABLE Employee
    ADD PRIMARY KEY (id);

INSERT INTO Employee
VALUES (1, 'Andrei', 'Pol', 'andrei.pol@gmail.com', '2001-10-02', 3000),
       (2, 'Samir', 'Ismayilov', 'samir.ismayilov@gmail.com', '2015-05-02', 5000),
       (3, 'Farid', 'Dadashzade', 'farid.dadash@gmail.com', '1991-07-11', 4000),
       (4, 'Peri', 'Qasimova', 'peri.qasimova@gmail.com', '2003-04-17', 3600),
       (5, 'Cavid', 'Huseynzade', 'cavid.huseyn@gmail.com', '2003-04-17', 2800),
       (6, 'Senan', 'Ashurov', 'senan.ashurov@gmail.com', '2007-12-15', 3100);

SELECT *
FROM Employee;

select id, first_name, last_name, first_name || last_name, salary, first_name || salary
from employee;

SELECT id, first_name, last_name, concat(first_name, ' ', last_name), salary, concat(first_name, ' ', salary)
FROM employee;

select *
from employee
where first_name = 'Andrei'
  and salary = '3000';

select *
from employee
where first_name = 'Andrei'
   or salary = '3000';

select *
from employee
where not first_name = 'Andrei'
  and not salary = '3000';

select *
from employee
where not first_name = 'Andrei'
   or not salary = '5000';

select *
from employee
where first_name != 'Andrei'
   and salary != '5000';