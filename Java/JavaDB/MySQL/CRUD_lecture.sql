SELECT * FROM employees;

SELECT first_name, department_id FROM employees
WHERE department_id=1;

#1
SELECT id,first_name,last_name,job_title
FROM employees
ORDER BY id;

#2
SELECT `id` , concat(`first_name`,' ',`last_name`)
AS'full_name',
`job_title`, `salary`
FROM `employees`
WHERE `salary`>1000.00
ORDER BY id;

#3
UPDATE employees
SET salary = salary+100
WHERE job_title='Manager';
SELECT * FROM employees;
#4

CREATE VIEW `v_top_paid_employee` AS(
SELECT *
FROM `employees`
ORDER BY `salary` DESC
LIMIT 1
);

DROP VIEW `v_top_paid_employee`;

#6
DELETE FROM employees
WHERE department_id IN (1,2);
SELECT * FROM employees
ORDER BY id;

#5
SELECT * FROM employees
WHERE salary>=1000 AND department_id=4
ORDER BY id ASC;



