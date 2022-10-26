select year, count(*)
from races
group by year;

select year, count(*)
from races
group by year
having count(*) > 10
order by year, count(*);

select year, count(*)
from races
where year >= 2000
group by year
having count(*) > 10
order by year, count(*);


