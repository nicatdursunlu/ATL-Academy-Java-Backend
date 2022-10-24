CREATE TABLE NEW_TABLE
(
    NAME         varchar(55),
    ROLL_NO      varchar(55),
    LOCATION     varchar(55),
    PHONE_NUMBER varchar(55)
);

CREATE TABLE NEW_STUDENT
(
    NAME    varchar(55),
    ROLL_NO varchar(55),
    SECTION varchar(55)
);

SELECT NAME, LOCATION, PHONE_NUMBER, ROLL_NO
from NEW_TABLE
WHERE ROLL_NO IN
      (SELECT ROLL_NO from NEW_STUDENT where SECTION = 'A');

CREATE TABLE NEW_STUDENT_2
(
    NAME    varchar(55),
    ROLL_NO varchar(55),
    SECTION varchar(55)
);

INSERT INTO NEW_STUDENT_2
SELECT *
FROM NEW_STUDENT;

SELECT *
FROM NEW_STUDENT_2;

delete
from new_student_2
where ROLL_NO in (select ROLL_NO from new_table where LOCATION = 'Coimbatore');

update new_table
set name = 'ATL'
where LOCATION in (select LOCATION from new_student where name in ('Raju', 'Ravi'));

update new_student
set name = 'Raji'
where name = 'Raj';

SELECT 2020.208302, TRUNCATE(2020.208302, 2);

SELECT 20.5, ROUND(20.5);

SELECT '7 % 2', MOD(7, 2);