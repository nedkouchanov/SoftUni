#EX1
CREATE SCHEMA softuni_stores_system;
USE softuni_stores_system;
CREATE TABLE `pictures` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`url` VARCHAR(100) NOT NULL,
`added_on` DATETIME NOT NULL
);

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) UNIQUE NOT NULL
);


CREATE TABLE `products` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) UNIQUE NOT NULL,
`best_before` DATE ,
`price` DECIMAL(10,2) NOT NULL,
`description` TEXT,
`category_id` INT NOT NULL,
`picture_id` INT NOT NULL,
CONSTRAINT `fk_products_categories`
FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`),
CONSTRAINT `fk_products_pictures`
FOREIGN KEY (`picture_id`) REFERENCES `pictures`(`id`)
);

CREATE TABLE `towns`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(20) UNIQUE NOT NULL 
);

CREATE TABLE `addresses`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) UNIQUE NOT NULL,
`town_id` INT NOT NULL,
CONSTRAINT `fk_addresses_towns`
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`)
);

CREATE TABLE `stores`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(20) UNIQUE NOT NULL,
`rating` FLOAT NOT NULL,
`has_parking` TINYINT(1) DEFAULT(0),
`address_id` INT NOT NULL,
CONSTRAINT `fk_stores_addresses`
FOREIGN KEY (`address_id`) REFERENCES `addresses`(`id`)
);

CREATE TABLE `products_stores`(
`product_id` INT NOT NULL,
`store_id` INT NOT NULL,
CONSTRAINT `pk_products_stores` PRIMARY KEY (`product_id`,`store_id`),
CONSTRAINT `fk_products_stores_products`
FOREIGN KEY (`product_id`) REFERENCES `products`(`id`),
CONSTRAINT `fk_products_stores_stores`
FOREIGN KEY (`store_id`) REFERENCES `stores`(`id`)
);

CREATE TABLE `employees`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(15) NOT NULL,
`middle_name` CHAR(1),
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(19,2) NOT NULL DEFAULT(0),
`hire_date` DATE NOT NULL,
`manager_id` INT,
`store_id` INT NOT NULL,
CONSTRAINT `fk_employees_managers`
FOREIGN KEY (`manager_id`) REFERENCES `employees`(`id`),
CONSTRAINT `fk_employees_stores`
FOREIGN KEY (`store_id`) REFERENCES `stores`(`id`)
);

#EX2
INSERT INTO `products_stores`
(SELECT p.`id`,1 FROM `products` AS p
 WHERE p.`id` NOT IN (SELECT `product_id` FROM `products_stores`));
 
#EX3
UPDATE `employees` e 
SET 
    e.`salary` = e.`salary` - 500,
    e.`manager_id` = 3
WHERE
    YEAR(e.`hire_date`) > 2003
        AND e.`store_id` NOT IN (SELECT 
            s.`id`
        FROM
            `stores` AS s
        WHERE
            s.`name` = 'Cardguard'
                OR s.`name` = 'Veribet');
 
#EX4
DELETE FROM `employees` e
WHERE e.`salary` >= 6000 AND
e.`manager_id` IS NOT NULL;

#EX5
SELECT `first_name`,`middle_name`,`last_name`,`salary`,`hire_date` FROM `employees`
ORDER BY `hire_date` DESC;

#EX6
SELECT 
    p.`name` AS 'product_name',
    p.`price`,
    p.`best_before`,
    CONCAT(SUBSTRING(p.`description`, 1, 10), '...') AS 'short_description',
    ps.`url`
FROM
    `products` AS p
        JOIN
    `pictures` ps ON p.`picture_id` = ps.`id`
WHERE
    p.`price` > 20
        AND YEAR(ps.`added_on`) < 2019
        AND LENGTH(p.`description`) > 100
ORDER BY p.`price` DESC;

#EX7
SELECT 
    s.`name`,
    COUNT(p.`id`) AS 'product_count',
    ROUND(AVG(p.`price`),2) AS 'avg'
FROM
    `stores` AS s
        LEFT JOIN
    `products_stores` AS ps ON s.`id` = ps.`store_id`
        LEFT JOIN
    `products` AS p ON p.`id` = ps.`product_id`
GROUP BY s.`id`
ORDER BY `product_count` DESC , `avg` DESC , s.`id`;

#EX8
SELECT 
    CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS 'full_name',
    s.`name` AS 'store_name',
    a.`name` AS 'address',
    e.`salary`
FROM
    `employees` AS e
        JOIN
    `stores` AS s ON e.`store_id` = s.`id`
        JOIN
    `addresses` AS a ON s.`address_id` = a.`id`
WHERE
    e.`salary` < 4000
        AND a.`name` LIKE '%5%'
        AND LENGTH(s.`name`) > 8
        AND e.`last_name` LIKE '%n';

#EX9
SELECT 
    REVERSE(s.`name`),
    CONCAT(UPPER(t.`name`), '-', a.`name`) AS 'full_address',
    COUNT(e.`id`) AS 'employees_count'
FROM
    `stores` s
        JOIN
    `addresses` a ON s.`address_id` = a.`id`
        JOIN
    `towns` t ON a.`town_id` = t.`id`
        JOIN
    `employees` e ON s.`id` = e.`store_id`
GROUP BY s.`id`
HAVING `employees_count` > 0
ORDER BY `full_address`;

#EX10
DELIMITER $$
CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50))
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
RETURN (SELECT CONCAT(e.`first_name`,' ',e.`middle_name`,'. ',e.`last_name`,' ',
'works in store for ',
2020 - YEAR(e.`hire_date`),' ',
'years')
FROM `employees` e
JOIN `stores` s ON e.`store_id`=s.`id`
WHERE s.`name`=`store_name`
ORDER BY e.`salary` DESC
LIMIT 1);
END $$
DELIMITER ;
SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info';

#EX11
DELIMITER $$
CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))
BEGIN
DECLARE `increase_level` INT;
IF `address_name` like '0%' 
	THEN SET `increase_level` = 100;
	ELSE SET `increase_level` = 200;
END IF;
UPDATE `products` p SET `price` = `price` + `increase_level`
WHERE p.`id` IN 
				(SELECT ps.`product_id` FROM `addresses` a 
				JOIN `stores` s ON a.`id`=s.`address_id`
				JOIN `products_stores` ps ON ps.`store_id`=s.`id`
				WHERE a.`name`= `address_name`);
END$$
DELIMITER ;
CALL udp_update_product_price('07 Armistice Parkway');
SELECT name, price FROM products WHERE id = 15;
