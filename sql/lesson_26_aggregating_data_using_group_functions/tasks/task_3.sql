-- 1. Assume you have an old_circuits table which contains only circuits with
-- circuitid greater than 10. Write a query using set operators which returns
-- records from circuits table and aren’t in old_circuits.
select *
into old_circuits
from circuits
where circuitid > 10;

select *
from circuits
except
select *
from old_circuits;

-- 2. Assume you have an old_circuits table which contains only circuits with
-- circuitid greater than 10. Write a query using set operators which returns
-- only records from circuits table which are in old_circuits.
select *
from circuits
intersect
select *
from old_circuits;

-- 3. Write a query which first returns races in 2009 and then races in 2008.
-- Races must be sorted descending by round count in each year.
select year, round
from races
where year = 2009
group by year, round
union all
select year, round
from races
where year = 2008
group by year, round
order by round desc;

select year, round
from (select *
      from races
      where year = 2009
      order by round desc) as races1
union all
select year, round
from (select *
      from races
      where year = 2008
      order by round desc) as races2;

-- 4. Assume you have an archived_races table which contains only races with
-- a year less than 2000. Write a query using set operators which returns only
-- records of new races with round count less than 50 or more than 200 in
-- each year
select *
into archived_races
from races
where year < 2000;

select year, sum(round) as rounds
from races
group by year
having sum(round) < 50
    or sum(round) > 200
except
select year, sum(round)
from archived_races
group by year
order by rounds;
