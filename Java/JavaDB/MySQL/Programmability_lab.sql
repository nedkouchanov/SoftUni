#EX1 function
SELECT ufn_count_employees_by_town('Sofia') AS res;

#EX2 procedure
CALL usp_raise_salaries('Sales');

#EX3 procedure
CALL usp_raise_salary_by_id(1);

#EX4
CREATE TABLE `deleted_employees` (
  `employee_id` int(10) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `job_title` varchar(50) NOT NULL,
  `department_id` int(10) NOT NULL,
  `salary` decimal(19,4) NOT NULL,
   PRIMARY KEY (`employee_id`));
   
   DELETE FROM `employees`

