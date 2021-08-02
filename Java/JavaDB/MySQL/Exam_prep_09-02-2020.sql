CREATE SCHEMA fsd;
USE fsd;
CREATE TABLE `countries` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL
);

CREATE TABLE `towns` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL,
    `country_id` INT NOT NULL,
    CONSTRAINT `fk_towns_countries` FOREIGN KEY (`country_id`)
        REFERENCES `countries` (`id`)
);

CREATE TABLE `stadiums` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL,
    `capacity` INT NOT NULL,
    `town_id` INT NOT NULL,
    CONSTRAINT `fk_stadiums_towns` FOREIGN KEY (`town_id`)
        REFERENCES `towns` (`id`)
);

CREATE TABLE `teams` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(45) NOT NULL,
`established` DATE NOT NULL,
`fan_base` BIGINT NOT NULL DEFAULT(0),
`stadium_id` INT NOT NULL,
CONSTRAINT `fk_teams_stadiums`
FOREIGN KEY (`stadium_id`)
REFERENCES `stadiums`(`id`)
);

CREATE TABLE `skills_data`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`dribbling` INT DEFAULT (0),
`pace` INT DEFAULT (0),
`passing` INT DEFAULT (0),
`shooting` INT DEFAULT (0),
`speed` INT DEFAULT (0),
`strength` INT DEFAULT (0)
);

CREATE TABLE `players` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`age` INT NOT NULL DEFAULT (0),
`position` CHAR(1) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL DEFAULT(0),
`hire_date` DATETIME,
`skills_data_id` INT NOT NULL,
`team_id` INT,
CONSTRAINT `fk_players_skill_data`
FOREIGN KEY (`skills_data_id`)
REFERENCES `skills_data`(`id`),
CONSTRAINT `fk_players_teams`
FOREIGN KEY (`team_id`)
REFERENCES `teams`(`id`)
);

CREATE TABLE `coaches`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL DEFAULT(0),
`coach_level` INT NOT NULL DEFAULT (0)
);

CREATE TABLE `players_coaches` (
    `player_id` INT,
    `coach_id` INT,
    CONSTRAINT `pk_players_coaches` PRIMARY KEY (`player_id` , `coach_id`),
    CONSTRAINT `fk_players_coaches_players` FOREIGN KEY (`player_id`)
        REFERENCES `players` (`id`),
    CONSTRAINT `fk_players_coaches_coaches` FOREIGN KEY (`coach_id`)
        REFERENCES `coaches` (`id`)
);

#EX2
INSERT INTO `coaches` (`first_name`,`last_name`,`salary`,`coach_level`)
SELECT `first_name`,`last_name`,`salary`*2, char_length(`first_name`) AS 'coach_level' FROM `players`
WHERE `age` >= 45;

#EX3
#Could be DONE with JOIN also
#JOIN `players_coaches` AS pk ON pk.`coach_id` = c.`id`
#GROUP BY c.`id`
UPDATE `coaches` 
SET 
    `coach_level` = `coach_level` + 1
WHERE
    `first_name` LIKE 'A%'
        AND `id` = (SELECT 
            `coach_id`
        FROM
            `players_coaches`
        WHERE
            `coach_id` = `id`
        LIMIT 1);

#EX4
DELETE FROM `players` 
WHERE
    `age` >= 45;

#EX5
SELECT 
    `first_name`, `age`, `salary`
FROM
    `players`
ORDER BY `salary` DESC;

#EX6
SELECT 
    p.`id`,
    CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS 'full_name',
    p.`age`,
    p.`position`,
    p.`hire_date`
FROM
    `players` AS p
        JOIN
    `skills_data` AS sd ON p.`skills_data_id` = sd.`id`
WHERE
    p.`age` < 23 AND p.`position` = 'A'
        AND p.`hire_date` IS NULL
        AND sd.`strength` > 50
ORDER BY p.`salary` , p.`age`;

#EX7
SELECT 
    t.`name`,
    t.`established`,
    t.`fan_base`,
    (SELECT 
            COUNT(*)
        FROM
            `players`
        WHERE
            `team_id` = t.`id`) AS 'cnt'
FROM
    `teams` AS t
ORDER BY `cnt` DESC , t.`fan_base` DESC;

#EX8
SELECT
   MAX(sk.`speed`) AS 'max_speed', tow.`name` AS 'town_name'
FROM
    `players` AS p
       RIGHT JOIN
    `skills_data` AS sk ON p.`skills_data_id` = sk.`id`
      RIGHT JOIN
    `teams` AS t ON p.`team_id` = t.`id`
       RIGHT JOIN
    `stadiums` AS s ON t.`stadium_id` = s.`id`
       RIGHT JOIN
    `towns` AS tow ON s.`town_id` = tow.`id`
WHERE
    t.`name` != 'Devify'
    GROUP BY tow.`name`
ORDER BY `max_speed` DESC , tow.`name`;

#EX9
SELECT 
    c.`name`,
    COUNT(p.`id`) AS 'total_count_of_players',
    SUM(`salary`) AS 'total_sum_of_salaries'
FROM
    `players` AS p
        RIGHT JOIN
    `teams` AS t ON p.`team_id` = t.`id`
        JOIN
    `stadiums` AS s ON t.`stadium_id` = s.`id`
        JOIN
    `towns` ON s.`town_id` = towns.`id`
        RIGHT JOIN
    `countries` AS c ON towns.`country_id` = c.`id`
GROUP BY c.`name`
ORDER BY `total_count_of_players` DESC , c.`name`;

#EX10
DELIMITER $$
CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(p.`id`)
FROM `players` AS p
RIGHT JOIN `teams` AS t ON p.`team_id`=t.`id`
RIGHT JOIN `stadiums` AS s ON t.`stadium_id`= s.`id`
WHERE s.`name` = `stadium_name`);
END $$
DELIMITER ;
SELECT udf_stadium_players_count ('Jaxworks') as `count`; 
SELECT udf_stadium_players_count ('Linklinks') as `count`; 

#EX11
DELIMITER $$
CREATE PROCEDURE udp_find_playmaker (min_dribble_points INT, team_name VARCHAR(45))
DETERMINISTIC
BEGIN
	SELECT 
    CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS 'full_name',
    p.`age`,
    p.`salary`,
    sk.`dribbling`,
    sk.`speed`,
    t.`name`
FROM
    `players` AS p
        RIGHT JOIN
    `skills_data` AS sk ON p.`skills_data_id` = sk.`id`
        RIGHT JOIN
    `teams` AS t ON p.`team_id` = t.`id`
WHERE
    t.`name` = `team_name`
        AND sk.`dribbling` > `min_dribble_points`
        AND sk.`speed` > (SELECT 
            AVG(`speed`)
        FROM
            `skills_data`)
ORDER BY sk.`speed` DESC
LIMIT 1;
END $$
DELIMITER ;
CALL udp_find_playmaker (20, 'Skyble');