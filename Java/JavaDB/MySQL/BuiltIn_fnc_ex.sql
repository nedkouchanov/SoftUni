#EX1
SELECT `first_name`,`last_name` FROM `employees`
WHERE SUBSTRING(`first_name`,1,2)='Sa'
#може и с LEFT с 2 или WildCard Sa%
ORDER BY `employee_id` ASC;

#EX2
SELECT `first_name`,`last_name` FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id` ASC;

#EX3
SELECT `first_name` FROM `employees`
WHERE (`department_id` IN(3,10)) AND
(YEAR(`hire_date`) BETWEEN 1995 AND 2005)
ORDER BY `employee_id` ASC;

#EX4
SELECT `first_name`, `last_name` FROM `employees`
WHERE (`job_title`) NOT LIKE '%engineer%'
ORDER BY `employee_id` ASC;

#EX5
SELECT `name` FROM `towns`
WHERE CHAR_LENGTH(`name`)=6 OR CHAR_LENGTH(`name`)=5
ORDER BY `name` ASC;

#EX6
SELECT `town_id`,`name` FROM `towns`
WHERE LEFT(`name`,1)='M' OR
LEFT(`name`,1)='M' OR
LEFT(`name`,1)='K' OR
LEFT(`name`,1)='B' OR
LEFT(`name`,1)='E'
ORDER BY `name` ASC;

#EX7
SELECT `town_id`,`name` FROM `towns`
WHERE LEFT(`name`,1) NOT IN ('R','D','B')
ORDER BY `name` ASC;

#EX8
CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`,`last_name` FROM `employees`
WHERE YEAR(`hire_date`) > 2000;
SELECT * FROM `v_employees_hired_after_2000`;

#EX9
SELECT `first_name`,`last_name` FROM `employees`
WHERE CHAR_LENGTH(`last_name`)=5;

#EX10
SELECT `country_name`, `iso_code` FROM `countries`
WHERE `country_name` LIKE '%A%A%A%'
ORDER BY `iso_code` ASC;

#EX11
SELECT 
    `peak_name`,
    `river_name`,
    LOWER(CONCAT(`peak_name`, SUBSTRING(`river_name`, 2))) AS 'mix'
FROM
    `peaks`,
    `rivers`
WHERE
    RIGHT(LOWER(`peak_name`), 1) = LEFT(LOWER(`river_name`), 1)
ORDER BY `mix` ASC;

#EX12
SELECT `name`,DATE_FORMAT(`start`,'%Y-%m-%d') FROM `games`
WHERE YEAR(`start`) BETWEEN 2011 AND 2012
ORDER BY `start` ASC,`name`
LIMIT 50;

#EX13
SELECT 
    `user_name`,
    SUBSTRING(`email`,
        LOCATE('@', `email`) + 1) AS 'email_provider'
FROM
    users
ORDER BY `email_provider` , `user_name`;

#EX14
SELECT 
    `user_name`, `ip_address`
FROM
    `users`
WHERE
    `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name`;

#EX15
SELECT 
    `name`,
    (CASE
        WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
    END) AS 'Part of the Day',
    (CASE
        WHEN `duration` < 4 THEN 'Extra Short'
        WHEN `duration` < 7 THEN 'Short'
        WHEN `duration` < 11 THEN 'Long'
        ELSE 'Extra Long'
    END) AS 'Duration'
FROM
    `games`;
    
#EX16
SELECT 
    `product_name`,
    `order_date`,
    DATE_ADD(`order_date`, INTERVAL 3 DAY) AS 'pay_due',
    DATE_ADD(`order_date`, INTERVAL 1 MONTH) AS 'deliver_due'
FROM
    `orders`;


