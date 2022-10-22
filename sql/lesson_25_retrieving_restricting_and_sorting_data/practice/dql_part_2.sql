/*
    SQL Functions:
    1. Character/String Functions -> {
        lower(), upper(), trim(), ASCII, CHR, concat_ws, FORMAT,
        INITCAP, left, right, repeat, reverse, trunc, mod
    }
    2. Fetch Functions -> {
        FIRST, NEXT, ROW, ROWS
    }
    3. Aggregate Functions -> {
        COUNT(), AVG(), SUM(), MIN, MAX
    }
    4. Sub query
    5. Group by
    6. Union/Union All
*/

-- LOWER & UPPER
SELECT 'Hello World' AS message; -- Hello World
SELECT lower('HELLO WORLD') AS message; -- hello world
SELECT upper('hello world') AS message; -- HELLO WORLD
SELECT lower('HI, HOW ARE YOU?'); -- hi, how are you?
SELECT upper(name)
FROM student;

-- TRIM -> { trailing | leading | booth }
-- default -> BOTH
SELECT trim(trailing '@' from '@hello.as@') AS message; -- @hello.as
SELECT trim(leading '@' from '@hello.as@') AS message; -- hello.as@
SELECT trim(both '@' from '@hello.as@') AS message; --hello.as
SELECT trim('@' from '@@@@@@hello.as@@@@@') AS message; -- hello.as

SELECT trim(both '!' from '!Hello!') AS message; --Hello
SELECT trim('A' from 'Apple') AS message; -- pple
SELECT trim('W' from 'WWW') AS message; -- ''
SELECT trim(both 'W' from 'WWadvW') AS message; -- 'adv'
SELECT trim('%' from '%Car%') AS message; -- 'Car'
SELECT trim(both '@gmail.com' from 'nicat.dursunlu@gmail.com') AS message; -- 'nicat.dursunlu'
SELECT trim(both '@gmail.com' from 'mireli@gmail.com') AS message; -- 're'

SELECT trim(FROM '    Dog    ') AS message; -- Dog
SELECT '    Dog    ' AS message; -- '    Dog    '
SELECT trim('#' from ' Apple#') AS message; -- ' Apple'
SELECT trim(trailing '1' from '123431') AS message; -- 12343
SELECT trim(leading '1' from '1233') AS message; -- 233
SELECT trim('1' from '113212321') AS message; -- 321232

SELECT trim(both 't' from student.name)
FROM student;

-- SUBSTRING
SELECT position('n' in 'nijat@gmail.com') AS index; -- 1
SELECT position('@' in 'nijat@gmail.com') AS index; -- 6
SELECT position('r' in 'nijat@gmail.com') AS index; -- 0  -- not found
SELECT substring('nijat@gmail.com', 1, position('@' in 'nijat@gmail.com') - 1) AS message; --nijat

SELECT name, surname, substring(name, 1, position('r' in name) - 1)
FROM student
WHERE name LIKE '%r%';

-- ASCII & chr
SELECT ascii('ABC'); -- 65
SELECT ascii('2'); -- 50
SELECT ascii('%'); -- 37
SELECT ascii('A') AS A, ascii('B') AS B, ascii('C') AS C; -- 65 66 67
SELECT chr(65); -- A
SELECT chr(66); -- B
SELECT chr(ascii('A'));
-- 65 -> chr -> A

-- concat_ws
SELECT concat('Ali', 'Samir'); -- AliSamir
SELECT concat_ws(', ', 'Hi', 'How are you?'); -- Hi, How are you?
SELECT concat_ws('+', '23', '13'); -- 23+13
SELECT concat_ws(' + ', '23', '13 = ' || 23 + 13);
-- 23+13=36

-- FORMAT
SELECT format('Hello %s', 'PostgreSQL'); -- Hello PostgreSQL

SELECT name, surname, format('%s %s', name, surname) AS full_name
FROM student;


-- initcap
SELECT initcap('hI therE');
-- Hi There

-- left & right
SELECT left('ABC', 2); -- AB
SELECT right('ABC', 1);
-- C

-- repeat
SELECT repeat('*', 5);

-- reverse
SELECT reverse('Hello World!');
-- !dlroW olleH

-- trunc
SELECT trunc(10.126, 2); -- 10.12
SELECT trunc(10.848584784, 4);
-- 10.8485

-- mod
SELECT mod(15, 2); -- 1
SELECT mod(23, 3);
-- 2


-- Aggregate functions
SELECT sum(age)
FROM student;

SELECT avg(age)
FROM student;

SELECT count(id)
FROM student;

SELECT min(age), max(age)
FROM student;

SELECT min(name), max(surname)
FROM student;

SELECT min(created_at), max(created_at)
FROM student;

SELECT sum(distinct age)
FROM student;

-- Sub query

SELECT id, name, age
FROM student
WHERE id IN (SELECT id FROM test_student);

SELECT count(age)
FROM student
WHERE age = 22;

SELECT sub_query1.id, sub_query1.name, sub_query2.id
FROM (SELECT * FROM student) as sub_query1,
     (SELECT id FROM student) as sub_query2;


-- Group by & having
SELECT name, count(name)
FROM student
WHERE age > 19
GROUP BY name
HAVING count(name) > 0
ORDER BY name;

SELECT name, surname, count(name)
FROM student
GROUP BY name, surname;

-- Union / Union all
SELECT name, surname
FROM student
UNION
SELECT test_name, surname
FROM test_student;

SELECT id, name, surname
FROM student
UNION ALL
SELECT id, test_name, surname
FROM test_student;