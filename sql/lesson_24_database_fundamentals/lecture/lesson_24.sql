CREATE TABLE Employee
(
    employee_id   int,
    first_name    varchar(55),
    last_name     varchar(55),
    email         varchar(55),
    date_if_birth date
);

INSERT INTO employee
VALUES (1111, 'Nijat', 'Dursunlu', 'nicat.dursunlu@gmail.com', '1999-11-13');

SELECT *
FROM employee;

CREATE TABLE IF NOT EXISTS Customer
(
    customer_id   int,
    first_name    varchar(55),
    last_name     varchar(55),
    email         varchar(100),
    date_if_birth date,
    CONSTRAINT customer_customer_id_pk PRIMARY KEY (customer_id)
    );

CREATE TABLE Account
(
    account_no      int,
    type            varchar(20),
    current_balance int,
    CONSTRAINT customer_account_no_fk FOREIGN KEY (account_no)
        REFERENCES Customer (customer_id)
);

CREATE TABLE Employee_details
(
    emp_id      varchar(8),
    emp_name    varchar(20),
    emp_surname varchar(20),
    emp_dept_id varchar(20),
    emp_age     int
);

INSERT INTO lesson_24.employee_details
VALUES ('E40001', 'PRADEEP', 'TEST', 'E101', 36);

INSERT INTO lesson_24.employee_details
VALUES ('E40002', 'ASHOK', 'SURNAME', 'E102', 28);

INSERT INTO lesson_24.employee_details
VALUES ('E40003', 'PAVAN KUMAR', 'DOE', 'E103', 28);

SELECT *
FROM Employee_details;