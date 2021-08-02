#EX1
CREATE TABLE `mountains`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)
);

CREATE TABLE `peaks`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45),
`mountain_id` INT
);

ALTER TABLE `peaks`
ADD CONSTRAINT `fk_peaks_mountains`
FOREIGN KEY (mountain_id)
REFERENCES mountains(id);

#EX2
SELECT 
    c.id AS driver_id,
    v.vehicle_type,
    CONCAT(first_name, ' ', last_name)
FROM
    `campers` AS c
        JOIN
    `vehicles` AS v ON v.driver_id = c.id;
    
#EX3
SELECT 
    r.`starting_point`,
    r.`end_point`,
    r.`leader_id`,
    CONCAT(c.first_name, ' ', c.last_name)
FROM
    `routes` AS r
        JOIN
    `campers` AS c ON r.leader_id = c.id;

#EX4
CREATE TABLE `mountains`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)
);

CREATE TABLE `peaks`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45),
`mountain_id` INT,
CONSTRAINT `fk_peaks_mountains`
FOREIGN KEY (mountain_id)
REFERENCES mountains(id)
ON DELETE CASCADE
);

#EX5    