-- Transaction Control Language (TCL)
-- 1. COMMIT
-- 2. ROLLBACK
-- 3. SAVEPOINT
-- 4. TRANSACTION

START TRANSACTION;

DELETE
FROM student
WHERE id = 11;

ROLLBACK;
COMMIT;


START TRANSACTION;

DELETE
FROM student
WHERE id = 12;

SAVEPOINT my_sava_point;
-- rollback until save point
-- in this case will rollback id = 13 and id = 14

DELETE
FROM student
WHERE id = 11;

DELETE
FROM student
WHERE id = 10;

ROLLBACK TO my_sava_point;
COMMIT;