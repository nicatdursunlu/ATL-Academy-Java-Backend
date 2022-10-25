CREATE TABLE employee
(
    id    int,
    Email Varchar(255),
    City  Varchar(20)
);

CREATE TABLE department
(
    id          int,
    name        varchar(20),
    gender      varchar(20),
    dateOfBirth varchar(255)
);

INSERT INTO department
VALUES (1, 'Neha', 'F', '1994-06-03');
INSERT INTO department
VALUES (2, 'Harsh', 'M', '1996-03-12');
INSERT INTO department
VALUES (3, 'Harsh', 'M', '1995-05-01');
INSERT INTO department
VALUES (4, 'Rupali', 'F', '1996-11-11');
INSERT INTO department
VALUES (5, 'Rohan', 'M', '1992-03-08');

INSERT INTO employee
VALUES (1, 'ANURAG@xyz.com', 'Noida');
INSERT INTO employee
VALUES (2, 'HARSH@xyz.com', 'Jaipur');
INSERT INTO employee
VALUES (3, 'SUMIT@xyz.com', 'Noida');
INSERT INTO employee
VALUES (4, 'RUHI@xyz.com', 'Jaipur');
INSERT INTO employee
VALUES (5, 'KAE@xyz.com', 'Noida');

SELECT department.*, employee.email, employee.city
FROM department,
     employee
WHERE department.id = employee.id;

SELECT department.id, department.name, employee.email, employee.city
FROM department
         JOIN
     employee
     ON department.id = employee.id;

create table student
(
    roll_no int,
    name    varchar(20),
    address varchar(20),
    phone   varchar(255),
    age     varchar(25)
);

create table student_course
(
    roll_no   int,
    course_id int
);

-- CROSS JOIN
select student.name, student.age, student.address, student_course.course_id
from student
         cross join student_course;

-- SELF JOIN
select a.roll_no, b.name
from student a,
     student b
where a.roll_no < b.roll_no;

-- INNER JOIN
select student.name, student.age, student.address, student.roll_no, student_course.course_id
from student
         inner join student_course on student.roll_no = student_course.roll_no;

-- LEFT JOIN
select student.name, student.age, student.address, student.roll_no, student_course.course_id
from student
         left join student_course on student.roll_no = student_course.roll_no;

-- RIGHT JOIN
select student.name, student.age, student.address, student.roll_no, student_course.course_id
from student
         right join student_course on student.roll_no = student_course.roll_no;

CREATE TABLE Atl
(
    ID      int(6)      NOT NULL,
    NAME    varchar(10) NOT NULL,
    ADDRESS varchar(20)
);

CREATE TABLE primary_atl
(

    ID      int(6) NOT NULL UNIQUE,
    NAME    varchar(10),
    ADDRESS varchar(20),
    PRIMARY KEY (ID)
);

CREATE TABLE Course
(
    ID      int(6) NOT NULL UNIQUE,
    NAME    varchar(10),
    ADDRESS varchar(20)
);

CREATE TABLE Customers
(
    C_ID    int         NOT NULL,
    NAME    varchar(50) NOT NULL,
    ADDRESS varchar(100),
    PRIMARY KEY (C_ID)
);

CREATE TABLE Orders
(
    O_ID     int NOT NULL,
    ORDER_NO int NOT NULL,
    C_ID     int,
    PRIMARY KEY (O_ID),
    FOREIGN KEY (C_ID) REFERENCES Customers (C_ID)
);

select *
from customers c
         left join orders o on c.C_ID = o.C_ID;

CREATE TABLE test_student
(
    ID   int(6)      NOT NULL,
    NAME varchar(10) NOT NULL,
    AGE  int         NOT NULL CHECK (AGE >= 18)
);

CREATE TABLE test_student_2
(
    ID   int(6)      NOT NULL,
    NAME varchar(10) NOT NULL,
    AGE  int DEFAULT 18
);