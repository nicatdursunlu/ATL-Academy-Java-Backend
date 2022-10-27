-- 1. Write a query which returns all races in USA circuits. Tables: races, circuits
select *
from races a
where a.circuitid in (select b.circuitid
                      from circuits b
                      where b.country = 'USA');

-- 2. Write a query which deletes the results of drivers who haven’t number
-- (column name). Tables: results, drivers
DELETE
FROM results
WHERE driverid IN (SELECT d.driverid
                   FROM drivers d
                   where d.number is null);

-- 3. Write a query which inserts all races into the table for archived races.
-- Races are before 2000. Tables: races, archived_races
select *
into archived_races
from races
where year < 2000;