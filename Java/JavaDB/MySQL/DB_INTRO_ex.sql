CREATE DATABASE `minions`;

USE `minions`;

#Ex1
CREATE TABLE `minions`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`age` INT
);
CREATE TABLE `towns`(
`town_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);

#Ex2
ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT `fk_minions_towns`
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`); 

#Ex3
INSERT INTO `towns`
VALUES
(1,'Sofia'),
(2,'Plovdiv'),
(3,'Varna');
INSERT INTO `minions`
VALUES
(1,'Kevin',22,1),
(2,'Bob',15,3),
(3,'Steward',NULL,2);

#Ex4
TRUNCATE TABLE `minions`;

#Ex5
DROP TABLE `minions`, `towns`;

#Ex6
CREATE TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (200) NOT NULL,
`picture` BLOB,
`height` FLOAT(5,2),
`weight` FLOAT(5,2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);
INSERT INTO `people`
VALUES
(1, 'Ivan','da', 172.5, 73,'m','1999-08-19', 'pendel'),
(2, 'Chock', 'da',173.5, 71,'m','1999-01-19', 'asd'),
(3, 'Mock','da', 171.5, 83,'m','1999-07-16', 'dsa'),
(4, 'Bock','da', 172.9, 55,'m','1999-07-25', 'sad'),
(5, 'Vock', 'da',179.1, 93,'m','1999-08-30', 'sda');

#Ex7
CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR (30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` DATE,
`is_deleted` BOOLEAN
);
INSERT INTO `users`
VALUES
(1, 'Ivan','da', 'da', '1999-08-19',false),
(2, 'Chock', 'da','da', '1999-08-19',true),
(3, 'Mock','da', 'da', '1999-08-19',true),
(4, 'Bock','da', 'da', '1999-08-19',false),
(5, 'Vock', 'da','da', '1999-08-19',true);

#Ex8
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY (`id`,`username`);

#Ex9
ALTER TABLE `minions`.`users` 
CHANGE COLUMN `last_login_time` `last_login_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ;


#``


#Ex11
CREATE DATABASE `Movies`;
USE `Movies`;
CREATE TABLE `directors`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(30) NOT NULL,
`notes` TEXT
);
CREATE TABLE `genres`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(30) NOT NULL,
`notes` TEXT
);
CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(30) NOT NULL,
`notes` TEXT
);
CREATE TABLE `movies`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(30) NOT NULL,
`director_id` INT NOT NULL,
`copyright_year` DATE,
`length` TIME,
`genre_id` INT NOT NULL,
`category_id` INT NOT NULL,
`rating` FLOAT,
`notes` TEXT
);
INSERT INTO `directors`
VALUES
(1,'John','az'),
(2,'Kim','az1'),
(3,'John1','a1z'),
(4,'John2','a2z'),
(5,'John3','a4z');
INSERT INTO `genres`
VALUES
(1,'Comedy','az'),
(2,'Criminal','az1'),
(3,'Action','a1z'),
(4,'S-FI','a2z'),
(5,'Anime','a4z');
INSERT INTO `categories`
VALUES
(1,'zahora','az'),
(2,'zanehora','az1'),
(3,'zajivotni','a1z'),
(4,'S-zanejivotni','a2z'),
(5,'zamen','a4z');
INSERT INTO `movies`
VALUES
(1,'InTime',3,'1999-08-19','1:23:34',2,5,8.7,'az'),
(2,'InTime2',1,'1991-08-19','12:23:34',1,1,6.7,'1az'),
(3,'InTime3',2,'1992-08-19','1:21:34',3,2,4.7,'a2z'),
(4,'InTime4',4,'1993-08-19','1:22:34',4,3,1.7,'a3z'),
(5,'InTime5',3,'1994-08-19','1:26:34',5,4,2.7,'a4z');

#Ex12
CREATE DATABASE `car_rental`;
USE `car_rental`;
CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(30) NOT NULL,
`daily_rate` FLOAT,
`weekly_rate` FLOAT,
`monthly_rate` FLOAT,
`weekend_rate` FLOAT
);
CREATE TABLE `cars`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`plate_number` VARCHAR(15) NOT NULL,
`make` VARCHAR(15),
`model` VARCHAR(15),
`car_year` INT,
`category_id` INT,
`doors` INT,
`picture` BLOB,
`car_condition` VARCHAR(10),
`available` BOOLEAN
);
CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`title` VARCHAR(30) NOT NULL,
`notes` TEXT
);
CREATE TABLE `customers`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`driver_licence_number` VARCHAR(15) NOT NULL,
`full_name` VARCHAR(50) NOT NULL,
`address` VARCHAR(50),
`city` VARCHAR(20) NOT NULL,
`zip_code` INT,
`notes` TEXT
);
CREATE TABLE `rental_orders`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT NOT NULL,
`customer_id` INT NOT NULL,
`car_id` INT NOT NULL,
`car_condition` VARCHAR(10),
`tank_level` INT,
`kilometrage_start` FLOAT,
`kilometrage_end` FLOAT,
`total_kilometrage` FLOAT,
`start_date` DATE,
`end_date` DATE,
`total_days` INT,
`rate_applied` FLOAT,
`tax_rate` FLOAT,
`order_status` VARCHAR(20),
`notes` TEXT
);
INSERT INTO `categories`
VALUES
(1,'zahora',19.4,19.4,19.4,19.4),
(2,'zanehora',19.4,19.4,19.4,19.4),
(3,'zajivotni',19.4,19.4,19.4,19.4);
INSERT INTO `cars`
VALUES
(1,'EH2123BT','Opel','Meriva',2007,2,4,'tupalka','excellent',true),
(2,'EH2123BT','Opel','Meriva',2007,2,4,'tupalka','excellent',true),
(3,'EH2123BT','Opel','Meriva',2007,2,4,'tupalka','excellent',true);
INSERT INTO `employees`
VALUES
(1,'Ivan','Ivanov','mishok','da'),
(2,'Ivan','Ivanov','mishok','da'),
(3,'Ivan','Ivanov','mishok','da');

INSERT INTO `customers`
VALUES
(1,'EH2123BT','Ivan Ivanov','Klokotnica12','Belene',5930,'az'),
(2,'EH2123BT','Ivan Ivanov','Klokotnica12','Belene',5930,'az'),
(3,'EH2123BT','Ivan Ivanov','Klokotnica12','Belene',5930,'az');

INSERT INTO `rental_orders`
VALUES
(1,1,2,3,'as',23,23.1,23.1,23.1,'1999-08-19','1999-08-19',23,23.1,23.1,'Ivan Ivanov','Klokotnica12'),
(2,1,2,3,'as',23,23.1,23.1,23.1,'1999-08-19','1999-08-19',23,23.1,23.1,'Ivan Ivanov','Klokotnica12'),
(3,1,2,3,'as',23,23.1,23.1,23.1,'1999-08-19','1999-08-19',23,23.1,23.1,'Ivan Ivanov','Klokotnica12');

#
CREATE DATABASE `soft_uni`;
USE `soft_uni`;
CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);
CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address_text` VARCHAR(100) NOT NULL,
`town_id` INT NOT NULL,
CONSTRAINT fk_addresses_towns
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`)
);
CREATE TABLE `departments`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL
);
CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`middle_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`job_title` VARCHAR(20),
`salary` DECIMAL(10,2),
`department_id` INT,
`hire_date` DATE,
`address_id` INT,
CONSTRAINT fk_employees_department
FOREIGN KEY (`department_id`) REFERENCES `departments`(`id`),
CONSTRAINT fk_employees_addresses
FOREIGN KEY(`address_id`) REFERENCES `addresses`(`id`)
);
#Ex13
INSERT INTO `towns`(`name`)
VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');
INSERT INTO `departments`(`name`)
VALUES
('Engineering'),
('Marketing'),
('Software Development'),
('Quality Assurance');
INSERT INTO `employees`
VALUES
(1,'Ivan','Ivanov','Ivanov','.NET Developer',3500.00,4,'2013-02-01',NULL),
(2,'Petar','Petrov','Petrov','Senior Engineer',4000.00,1,'2004-03-02',NULL),
(3,'Maria','Petrova','Ivanova','Intern',525.25,5,'2016-08-28',NULL),
(4,'Georgi','Terziev','Ivanov','CEO',3000.00,2,'2007-12-09',NULL),
(5,'Peter','Pan','Pan','Intern',599.88,3,'2016-08-28',NULL);

#Ex14
SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;

#Ex15
SELECT * FROM `towns`
ORDER BY `name`;
SELECT * FROM `departments`
ORDER BY `name`;
SELECT * FROM `employees`
ORDER BY `salary` DESC;

#Ex16
SELECT `name` FROM `towns`
ORDER BY `name`;
SELECT `name` FROM `departments`
ORDER BY `name`;
SELECT `first_name`,`last_name`,`job_title`,`salary` FROM `employees`
ORDER BY `salary` DESC;

#Ex17
UPDATE `employees`
SET `salary`=`salary` * 1.1;
SELECT `salary` FROM `employees`;

#Ex18


