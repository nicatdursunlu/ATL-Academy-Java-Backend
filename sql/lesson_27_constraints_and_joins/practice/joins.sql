-- Cross Join
select *
from jobs,
     employees;

select *
from jobs j,
     employees e
where j.job_id = e.job_id;

-- Left Join
select *
from employees e
         left join jobs j on j.job_id = e.job_id
where e.job_id = 19;

-- Right Join
select e.*, j.job_title
from employees e
         right join jobs j on j.job_id = e.job_id;

-- Full Join
SELECT *
FROM employees e
         FULL OUTER JOIN jobs j on e.job_id = j.job_id;