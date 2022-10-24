CREATE TABLE EMPLOYEE
(
    SERIAL_NO INT NOT NULL UNIQUE,
    NAME      VARCHAR(55),
    SALARY    VARCHAR(55),
    AGE       INT
);

SELECT NAME, SUM(SALARY), COUNT(name)
FROM Employee
GROUP BY NAME;

select name, age, count(age), sum(age)
from employee
group by age;

SELECT NAME, SUM(SALARY)
FROM EMPLOYEE
GROUP BY NAME
HAVING SUM(SALARY) > 16000;

select name, sum(SALARY)
from employee
group by name
having sum(SALARY) > 3000;

create table student
(
    subject varchar(50),
    year    int,
    name    varchar(50)
);

insert into student
values ('English', 1, 'Samir'),
       ('English', 1, 'Sanan'),
       ('English', 1, 'Ayyub'),
       ('Math', 1, 'Yunis'),
       ('Math', 1, 'Csvid'),
       ('Literature', 2, 'KKKK'),
       ('Literature', 2, 'KKKK');

select subject, year, concat(subject, ' ', year) as concat, count(*)
from student
group by subject, year;

CREATE TABLE ATL_TABS
(
    ID     INT NOT NULL UNIQUE,
    NAME   VARCHAR(55),
    SALARY VARCHAR(55),
    CITY   VARCHAR(55),
    DOJ    varchar(55)
);

INSERT INTO lesson_26.Atl_Tabs (ID, NAME, SALARY, City, DOJ)
VALUES (134, 'Abc', '4500', 'Delhi', '6-Aug');

INSERT INTO lesson_26.Atl_Tabs (ID, NAME, SALARY, City, DOJ)
VALUES (245, 'Dfe', '6500', 'Noida', '4-March');

INSERT INTO lesson_26.Atl_Tabs (ID, NAME, SALARY, City, DOJ)
VALUES (432, 'Mno', '7800', 'Noida', '7-June');

INSERT INTO lesson_26.Atl_Tabs (ID, NAME, SALARY, City, DOJ)
VALUES (546, 'Def', '5400', 'Jaipur', '2-July');

INSERT INTO lesson_26.Atl_Tabs (ID, NAME, SALARY, City, DOJ)
VALUES (654, 'Ijk', '6700', 'Jaipur', '5-June');

INSERT INTO lesson_26.Atl_Tabs (ID, NAME, SALARY, City, DOJ)
VALUES (768, 'Jkl', '5400', 'Jaipur', '9-July');

INSERT INTO lesson_26.Atl_Tabs (ID, NAME, SALARY, City, DOJ)
VALUES (987, 'Lmn', '7800', 'Delhi', '8-June');

SELECT COUNT(NAME)
FROM ATL_TABS;

SELECT AVG(SALARY)
FROM ATL_TABS;

SELECT SUM(SALARY)
FROM ATL_TABS;

SELECT MIN(SALARY)
FROM ATL_TABS;

SELECT MAX(SALARY)
FROM ATL_TABS;