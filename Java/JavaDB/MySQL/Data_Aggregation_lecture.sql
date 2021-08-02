#EX1
SELECT `department_id`, COUNT(`department_ID`) AS 'Number of employees' FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`, `Number of employees`;

#EX2
SELECT `department_id`, ROUND(AVG(`salary`),2) FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

#EX3
SELECT `department_id`, ROUND(MIN(`salary`),2) AS 'Min Salary' FROM `employees`
GROUP BY `department_id`
HAVING `Min Salary` > 800
ORDER BY `department_id`;

#EX4
SELECT COUNT(*) FROM `products`
WHERE `price` > 8 AND `category_id` = 2;

#EX5
SELECT 
    `category_id`,
    ROUND(AVG(`price`), 2) AS 'Avarage Price',
    ROUND(MIN(`price`)) AS 'Cheapest Product',
    ROUND(MAX(`price`)) AS 'Most Expensive Product'
FROM
    `products`
GROUP BY `category_id`;