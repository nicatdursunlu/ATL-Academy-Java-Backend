-- 1. Write a query which returns a count of races by each year.
select year, count(year) as year_count
from races
group by year
having count(year) > 10
order by year_count, year;

-- 2. Write a query which returns a total count of rounds by each year. Show
-- only years with a count of rounds more than 100.
select year, sum(round) as total_rounds
from races
group by year
having sum(round) > 100;

-- 3. Write a query which returns the maximum round of the race in 2008.
select max(round)
from races
where year = 2018;

-- 4. Write a query which returns the average points of the results.
select avg(points)
from results;

-- 5. Write a query which returns the count of drivers only who have a number
-- (column name)
select driverId, count(*)
from drivers
where number is not null
group by driverId;

select count(*)
from drivers
where number is not null;

select count(number)
from drivers;

-- 6. Write a query which returns count of drivers with nationality American,
-- French. Sort by nationality.
select nationality, count(*)
from drivers
where nationality in ('American', 'French')
group by nationality
order by nationality;

-- 7. Write a query which returns the total of points for each driver.
select driverId, sum(points) as total_points
from results
group by driverId;






