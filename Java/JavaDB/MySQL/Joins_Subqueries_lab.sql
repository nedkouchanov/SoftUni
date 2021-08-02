SELECT 
    e.`employee_id`,
    CONCAT(e.`first_name`, ' ', e.`last_name`) AS 'full_name',
    d.`department_id`,
    d.`name` AS 'department_name'
FROM
    `departments` AS d
        LEFT JOIN
    `employees` AS e ON e.`employee_id` = d.`manager_id`
ORDER BY e.`employee_id`
LIMIT 5;
    
#EX2
SELECT 
    t.`town_id`, t.`name` AS 'town_name', a.`address_text`
FROM
    `towns` AS t
        JOIN
    `addresses` AS a USING (`town_id`)
WHERE
    a.`town_id` IN (9 , 15, 32)
ORDER BY a.`town_id` , a.`address_id`;

#EX3
SELECT 
    `employee_id`,
    `first_name`,
    `last_name`,
    `department_id`,
    `salary`
FROM
    `employees`
WHERE
    `manager_id` IS NULL;

#EX4
SELECT 
    COUNT(`employee_id`)
FROM
    `employees`
WHERE
    `salary` > (SELECT 
            AVG(`salary`)
        FROM
            `employees`);
