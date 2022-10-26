-- 1. SELECT *
-- FROM table1
-- WHERE column_name IN (SELECT table2.column_name FROM table2)
select d2.nationality
from drivers d2
where d2.code = 'HAM';

select *
from drivers d1
where d1.nationality in (select d2.nationality
                         from drivers d2
                         where d2.code = 'HAM');


-- 2. SELECT * FROM (SELECT * FROM table_name)
select driverid, code
from (select * from drivers) as table1;

select *
from (select driverid, forename, surname from drivers) as table1;

-- View
create view british_drivers as
select *
from drivers
where nationality = 'British';


-- 3. SELECT column1, ...,
-- (SELECT column_name FROM table1) as column_alias
-- FROM table_name
select driverid,
       (select code
        from drivers d1
        where code = 'HAM')
from drivers;

select driverid,
       (select code
        from drivers d1
        where code = 'HAM') as column_1,
       (select code
        from drivers d1
        where code = 'ALO') as column_2
from drivers;


-- 4. INSERT INTO table1
-- SELECT * FROM table2
-- WHERE condition

-- SELECT INTO creates the table then insert data

-- insert all columns
select *
into american_drivers
from drivers
where nationality = 'American';

-- insert only two columns(driverid, nationality)
select driverid, nationality
into german_drivers
from drivers
where nationality = 'German';

-- To run INSERT INTO command the table must exist
insert into german_drivers
select driverid, nationality
from drivers
where nationality = 'American';