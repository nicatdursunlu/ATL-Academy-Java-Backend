-- DML
-- insert
-- update
-- delete

INSERT INTO student (name, surname, age, balance)
VALUES ('Igrar', 'Hajizade', 22, 1700);

UPDATE student
set address = 'Baku, City Point'
WHERE id = 9;

CREATE TABLE test_student
(
    id      int PRIMARY KEY,
    name    varchar(50) DEFAULT ('TEST'),
    surname varchar(50)
);

SELECT *
FROM test_student;

ALTER TABLE test_student
    ALTER COLUMN name DROP DEFAULT;

ALTER TABLE test_student
    RENAME name TO test_name;