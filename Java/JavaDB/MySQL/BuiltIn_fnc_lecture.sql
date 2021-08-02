#EX1
SELECT `title` FROM `books`
WHERE SUBSTRING(title,1,3)='The'
ORDER BY `id` ASC;

#EX2
SELECT REPLACE(`title`,'The','***') AS 'Title' FROM `books`
WHERE SUBSTRING(`title`,1,3)='The'
ORDER BY `id` ASC;

#EX3
SELECT ROUND(SUM(`cost`),2) FROM `books`;

#EX4
SELECT CONCAT_WS(' ',`first_name`,`last_name`) AS 'Full Name',
timestampdiff(day, `born`,`died`) AS 'Days Lived'
FROM `authors`;

#EX4
SELECT `title` FROM `books`
WHERE `title` LIKE "%Harry%"
ORDER BY id;