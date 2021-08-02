#EX1
SELECT 
    e.`employee_id`,
    e.`job_title`,
    a.`address_id`,
    a.`address_text`
FROM
    `employees` AS e
        JOIN
    `addresses` AS a ON a.`address_id` = e.`address_id`
ORDER BY e.`address_id`
LIMIT 5;

#EX2
SELECT 
    e.`first_name`, e.`last_name`, t.`name`, a.`address_text`
FROM
    `employees` AS e
        JOIN
    `addresses` AS a ON e.`address_id` = a.`address_id`
        JOIN
    `towns` AS t ON a.`town_id` = t.`town_id`
ORDER BY e.`first_name` , e.`last_name`
LIMIT 5;

#EX3
SELECT 
    e.`employee_id`,
    e.`first_name`,
    e.`last_name`,
    d.`name`
FROM
    `employees` AS e
        JOIN
    `departments` AS d USING (`department_id`)
WHERE
    d.`name` = 'Sales'
ORDER BY e.`employee_id` DESC;
 
#EX4
SELECT 
    e.`employee_id`,
    e.`first_name`,
    e.`salary`,
	d.`name`
FROM
    `employees` AS e
        JOIN
    `departments` AS d USING (`department_id`)
WHERE
    e.`salary` > 15000
ORDER BY d.`department_id` DESC
LIMIT 5;

#EX5
SELECT 
    e.`employee_id`, e.`first_name`
FROM
    `employees` AS e
        LEFT JOIN
    `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
WHERE
    ep.`project_id` IS NULL
ORDER BY e.`employee_id` DESC
LIMIT 3;

#EX6
SELECT 
    e.`first_name`, e.`last_name`, e.`hire_date`, d.`name`
FROM
    `employees` AS e
        JOIN
    `departments` AS d ON e.`department_id` = d.`department_id`
WHERE
    DATE(e.`hire_date`) > '1999-01-01'
        AND d.`name` IN ('Sales', 'Finance')
ORDER BY e.`hire_date`;

#EX7
SELECT 
    e.`employee_id`, e.`first_name`, p.`name`
FROM
    `employees` AS e
        JOIN
    `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
        JOIN
    `projects` AS p ON p.`project_id` = ep.`project_id`
WHERE
    DATE(p.`start_date`) > '2002-08-13'
        AND p.`end_date` IS NULL
ORDER BY e.`first_name` , p.`name`
LIMIT 5;

#EX8
SELECT 
    e.`employee_id`,
    e.`first_name`,
    IF(YEAR(p.`start_date`) > 2004,
        NULL,
        p.`name`) AS 'p_name'
FROM
    `employees` AS e
        JOIN
    `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
        JOIN
    `projects` AS p ON p.`project_id` = ep.`project_id`
WHERE
    e.`employee_id` = 24
ORDER BY `p_name`;

#EX9
SELECT 
    e.`employee_id`,
    e.`first_name`,
    e.`manager_id`,
    m.`first_name`
FROM
    `employees` AS e
        JOIN
    `employees` AS m ON e.`manager_id` = m.`employee_id`
WHERE
    m.`employee_id` IN (3 , 7)
ORDER BY e.`first_name`;
    
#EX10
SELECT 
    e.`employee_id`,
    CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS 'employee_name',
    CONCAT_WS(' ', m.`first_name`, m.`last_name`) AS 'manager_name',
    d.`name`
FROM
    `employees` AS e
        JOIN
    `employees` AS m ON e.`manager_id` = m.`employee_id`
        JOIN
    `departments` AS d ON e.`department_id` = d.`department_id`
ORDER BY e.`employee_id`
LIMIT 5;

#EX11
SELECT 
    AVG(`salary`) AS 's_avg'
FROM
    `employees`
GROUP BY `department_id`
ORDER BY `s_avg`
LIMIT 1;

#EX12
#georgraphy
SELECT 
    c.`country_code`,
    m.`mountain_range`,
    p.`peak_name`,
    p.`elevation`
FROM
    `countries` AS c
        JOIN
    `mountains_countries` AS mc ON c.`country_code` = mc.`country_code`
        JOIN
    `mountains` AS m ON mc.`mountain_id` = m.`id`
        JOIN
    `peaks` AS p ON p.`mountain_id` = m.`id`
WHERE
    c.`country_code` = 'BG'
        AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;

#EX13
SELECT 
    mc.`country_code`, COUNT(m.`id`) AS 'm_count'
FROM
    `mountains` AS m
        JOIN
    `mountains_countries` AS mc ON mc.`mountain_id` = m.`id`
WHERE
    mc.`country_code` IN ('BG' , 'RU', 'US')
GROUP BY mc.`country_code`
ORDER BY `m_count` DESC;

#EX14
SELECT 
    c.`country_name`, r.`river_name`
FROM
    `countries` AS c
        LEFT JOIN
    `countries_rivers` AS cr USING (`country_code`)
        LEFT JOIN
    `rivers` AS r ON cr.`river_id` = r.`id`
WHERE
    c.`continent_code` = 'AF'
ORDER BY c.`country_name`
LIMIT 5;

#EX15

#EX16
SELECT 
    COUNT(*)
FROM
    `countries`
WHERE
    `country_code` NOT IN (SELECT 
            `country_code`
        FROM
            `mountains_countries`);

#EX17
SELECT 
    c.`country_name`,
    MAX(p.`elevation`) AS 'm_elevation',
    MAX(r.`length`) AS 'longest_river_length'
FROM
    `countries` AS c
        JOIN
    `countries_rivers` AS cr ON cr.`country_code` = c.`country_code`
        JOIN
    `rivers` AS r ON r.`id` = cr.`river_id`
        JOIN
    `mountains_countries` AS mc ON c.`country_code` = mc.`country_code`
        JOIN
    `mountains` AS m ON mc.`mountain_id` = m.`id`
        JOIN
    `peaks` AS p ON p.`mountain_id` = m.`id`
GROUP BY c.`country_code`
ORDER BY `m_elevation` DESC , `longest_river_length` DESC , c.`country_name`
LIMIT 5;
