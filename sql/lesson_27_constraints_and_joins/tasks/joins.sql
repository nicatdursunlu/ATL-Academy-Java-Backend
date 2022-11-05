-- 1. Write a query which returns records from the race table with circuit name
-- which the race related to. Using sub query.
select r.*,
       (select c.name
        from circuits c
        where r.circuitid = c.circuitid) as cirvuit_name
from races r;


-- 2. Write a query which returns records from the race table with circuit name
-- which the race related to. Using join.
select r.*, c.name
from races r
         inner join circuits c on c.circuitid = r.circuitid;


-- 3. Write a query which returns the results of the driver with code “KUB” in
-- each year.
select rs.year, sum(r.points)
from drivers d
         inner join results r on d.driverid = r.driverid
         inner join races rs on rs.raceid = r.raceid
where d.code = 'KUB'
group by rs.year;


-- 4. Create a new table from the results table where driverid less than 20. Write
-- a query for getting drivers’ records with results. Note: Not all drivers have
-- results.
select *
into drivers_results
from results
where driverid < 20;

select *
from drivers d
         left join drivers_results r on r.driverid = d.driverid;


-- 5. Write a query which returns employees list with their manager name and
-- surname. If an employee is a manager then his manager data will be null.
select e1.*, e2.first_name, e2.last_name
from employees e1
         left join employees e2 on e1.employee_id = e2.manager_id;

-- 6. Write a query which returns the unique department name of employees
-- whose salary is more than the minimum salary of their job.
select e.employee_id,
       e.first_name,
       e.last_name,
       d.department_name,
       j.job_title,
       e.salary,
       j.min_salary
from departments d
         inner join employees e
                    on d.department_id = e.department_id
         inner join jobs j
                    on e.job_id = j.job_id
where e.salary > j.min_salary;


-- 7. Return all locations with departments if the departments exist for the
-- current location.
select *
from countries c
         inner join locations l on c.country_id = l.country_id
         inner join departments d on l.location_id = d.location_id;


-- 8. Return dependents count for each employee. Show employee name,
-- surname and count of children.
select e.employee_id,
       e.first_name,
       e.last_name,
       count(d.dependent_id)
from employees e
         inner join dependents d on e.employee_id = d.employee_id
group by e.employee_id;


-- 9. Write a query which returns records from the employees table with total
-- salary in their department
select d.department_name, sum(e.salary)
from employees e
         inner join departments d on d.department_id = e.department_id
group by d.department_name;