-- DDL
-- create
-- alter
-- drop
-- truncate

CREATE TABLE STUDENT
(
    id      serial,
    name    varchar(20),
    surname varchar(20),
    constraint student_pk primary key (id)
);


CREATE TABLE TEACHER
(
    id      serial unique,
    name    varchar(20),
    surname varchar(20),
    age     int
);

ALTER TABLE STUDENT
    ADD COLUMN address varchar(64);

-- Delete the table itself
DROP TABLE TEACHER;

-- Delete the data in the table
TRUNCATE TABLE STUDENT;
