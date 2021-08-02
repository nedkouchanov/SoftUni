#EX1
CREATE SCHEMA stc;
USE stc;

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10) NOT NULL
);

CREATE TABLE `clients`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`full_name` VARCHAR(50) NOT NULL,
`phone_number` VARCHAR(20) NOT NULL
);

CREATE TABLE `drivers`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`age` INT NOT NULL,
`rating` FLOAT DEFAULT (5.5)
);

CREATE TABLE `cars`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`make` VARCHAR(20) NOT NULL,
`model` VARCHAR(20),
`year` INT NOT NULL DEFAULT(0),
`mileage` INT DEFAULT(0),
`condition` CHAR(1) NOT NULL,
`category_id` INT NOT NULL,
CONSTRAINT `fk_cars_categories`
FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`)
);

CREATE TABLE `courses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`from_address_id` INT NOT NULL,
`start` DATETIME NOT NULL,
`bill` DECIMAL(10,2) DEFAULT(10),
`car_id` INT NOT NULL,
`client_id` INT NOT NULL,
CONSTRAINT `fk_courses_addresses`
FOREIGN KEY (`from_address_id`) REFERENCES `addresses`(`id`),
CONSTRAINT `fk_courses_cars`
FOREIGN KEY (`car_id`) REFERENCES `cars`(`id`),
CONSTRAINT `fk_courses_clients`
FOREIGN KEY (`client_id`) REFERENCES `clients`(`id`)
);

CREATE TABLE `cars_drivers`(
`car_id` INT NOT NULL,
`driver_id`INT NOT NULL,
CONSTRAINT `fk_cars_drivers`
PRIMARY KEY(`car_id`,`driver_id`),
CONSTRAINT `fk_cars_drivers_cars`
FOREIGN KEY (`car_id`) REFERENCES `cars`(`id`),
CONSTRAINT `fk_cars_drivers_drivers`
FOREIGN KEY (`driver_id`) REFERENCES `drivers`(`id`)
);

#EX2
INSERT INTO `clients` (`full_name`, `phone_number`)
(SELECT CONCAT_WS(' ',d.`first_name`,d.`last_name`), CONCAT('(088) 9999' , 2*d.`id`) FROM `drivers` d
WHERE d.`id` BETWEEN 10 AND 20);

#EX3
UPDATE `cars` c 
SET 
    c.`condition` = 'C'
WHERE
    c.`make` NOT LIKE 'Mercedes-Benz'
        AND c.`year` BETWEEN 0 AND 2010
        AND c.`mileage` >= 800000
        OR c.`mileage` IS NULL;

#EX4
DELETE `clients` FROM `clients`
        LEFT JOIN
    `courses` ON courses.`client_id` = clients.`id` 
WHERE
    courses.`client_id` IS NULL;

#EX5
SELECT 
    c.`make`, c.`model`, c.`condition`
FROM
    `cars` AS c
ORDER BY `id`;

#EX6
SELECT 
    d.`first_name`,
    d.`last_name`,
    c.`make`,
    c.`model`,
    c.`mileage`
FROM
    `drivers` AS d
        JOIN
    `cars_drivers` AS cd ON cd.`driver_id` = d.`id`
        JOIN
    `cars` AS c ON c.`id` = cd.`car_id`
WHERE
    c.`mileage` IS NOT NULL
ORDER BY c.`mileage` DESC , d.`first_name`;

#EX7
SELECT 
    c.`id`,
    c.`make`,
    c.`mileage`,
    COUNT(cour.`id`) AS 'count_of_courses',
    ROUND(AVG(cour.`bill`), 2) AS 'avg_bill'
FROM
    `cars` AS c
        LEFT JOIN
    `courses` AS cour ON cour.`car_id` = c.`id`
GROUP BY c.`id`
HAVING `count_of_courses` NOT IN (2)
ORDER BY `count_of_courses` DESC , c.`id`;

#EX8
SELECT 
    cl.`full_name`,
    COUNT(c.`id`) AS 'count_of_cars',
    SUM(cour.`bill`) AS `total_sum`
FROM
    `clients` AS cl
        JOIN
    `courses` AS cour ON cour.`client_id` = cl.`id`
        JOIN
    `cars` AS c ON c.`id` = cour.`car_id`
GROUP BY cl.`id`
HAVING `count_of_cars` > 1
    AND cl.`full_name` LIKE '_a%'
ORDER BY cl.`full_name`;

#EX9
SELECT 
    a.`name`,
    CASE
        WHEN HOUR(cour.`start`) BETWEEN 6 AND 20 THEN 'Day'
        ELSE 'Night'
    END AS 'day_time',
    cour.`bill`,
    cl.`full_name`,
    c.`make`,
    c.`model`,
    ca.`name`
FROM
    `courses` AS cour
        JOIN
    `addresses` AS a ON a.`id` = cour.`from_address_id`
        JOIN
    `clients` AS cl ON cl.`id` = cour.`client_id`
        JOIN
    `cars` AS c ON c.`id` = cour.`car_id`
        JOIN
    `categories` AS ca ON ca.`id` = c.`category_id`
ORDER BY cour.`id`;

#EX10
DELIMITER $$
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(*) FROM `clients` AS c
JOIN `courses` AS cour ON cour.`client_id`=c.id
WHERE c.`phone_number`= `phone_num`);
END $$
DELIMITER ;
SELECT udf_courses_by_client ('(803) 6386812') as `count`; 

#EX11
DELIMITER $$
CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100))
BEGIN
SELECT 
    a.`name`,
    cl.`full_name` AS 'full_names',
        CASE
      WHEN cour.`bill` BETWEEN 0 AND 20 THEN 'Low'
        WHEN cour.`bill` BETWEEN 21 AND 30 THEN 'Medium'
        ELSE 'High'
    END AS 'level_of_bill',
    c.`make`,
    c.`condition`,
    ca.`name`
FROM
    `courses` AS cour
        JOIN
    `addresses` AS a ON a.`id` = cour.`from_address_id`
        JOIN
    `clients` AS cl ON cl.`id` = cour.`client_id`
        JOIN
    `cars` AS c ON c.`id` = cour.`car_id`
        JOIN
    `categories` AS ca ON ca.`id` = c.`category_id`
    WHERE a.`name` = `address_name`
	ORDER BY c.`make`,`full_names`;
END $$
DELIMITER ;
CALL udp_courses_by_address('700 Monterey Avenue');