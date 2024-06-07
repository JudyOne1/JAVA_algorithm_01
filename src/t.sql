Select title, avg(salary)
FROM titles
         Join salaries on titles.emp_no = salaries.emp_no
group by title
order by avg(salary) ASC