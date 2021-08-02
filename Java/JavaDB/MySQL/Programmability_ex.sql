#EX1
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_salary_above_35000` ()
BEGIN
	SELECT e.`first_name`,e.`last_name` FROM `employees` AS e
	WHERE e.`salary`>35000
	ORDER BY e.`first_name`,e.`last_name`,e.`employee_id`;
END$$
DELIMITER ;
CALL `usp_get_employees_salary_above_35000`

#EX2
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_salary_above` (salary_level DECIMAL(19,4))
BEGIN
	SELECT e.`first_name`,e.`last_name` FROM `employees` AS e
    WHERE e.`salary` >= `salary_level`
    ORDER BY e.`first_name`,e.`last_name`,e.`employee_id`;
END $$
DELIMITER ;
CALL `usp_get_employees_salary_above` (20000);

#EX3
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with  (town_prefix VARCHAR(20))
BEGIN
	SELECT `name` AS `town_name` FROM `towns`
    WHERE `name` like CONCAT(`town_prefix`,'%')
    ORDER BY `name`;
END $$
DELIMITER ;
CALL `usp_get_towns_starting_with`('b');

#EX4
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town (param_town_name VARCHAR(25))
BEGIN
	SELECT e.`first_name`, e.`last_name` FROM `towns` AS t
    JOIN `addresses` AS a ON t.`town_id`=a.`town_id`
    JOIN `employees` AS e ON e.`address_id` = a.`address_id`
    WHERE t.`name` = param_town_name
    ORDER BY e.`first_name`,e.`last_name`,e.`employee_id`;
END $$
DELIMITER ;
CALL `usp_get_employees_from_town`('Sofia');

#EX5
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level (param_salary DECIMAL(19,4))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
	DECLARE salary_level VARCHAR(10);
    IF `param_salary` < 30000 THEN SET salary_level :='Low';
    ELSEIF (`param_salary` <= 50000) THEN SET salary_level :='Average';
    ELSE SET salary_level :='High';
    END IF;
    RETURN `salary_level`;
END $$
DELIMITER ;
SELECT ufn_get_salary_level(20000);

#EX6
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level (salary_level VARCHAR(10))
BEGIN
	SELECT e.`first_name`, e.`last_name` FROM `employees` AS e
    WHERE salary_level = (SELECT ufn_get_salary_level(e.`salary`))
    ORDER BY e.`first_name` DESC, e.`last_name` DESC;
END $$
DELIMITER ;
CALL `usp_get_employees_by_salary_level`('High');

#EX7
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS BIT
DETERMINISTIC
BEGIN
	RETURN (SELECT `word` REGEXP(CONCAT('^[',`set_of_letters`,']+$')));
END $$
DELIMITER ;
SELECT ufn_is_word_comprised ('oistmiahf','Sofia');#1
SELECT ufn_is_word_comprised ('oistmiahf','halves');#0

#bank_db
#EX8
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name ()
BEGIN
SELECT CONCAT_WS(' ',a.`first_name`,a.`last_name`) AS 'full_name' FROM `account_holders` AS a
ORDER BY `full_name`,a.`id`;
END $$
DELIMITER ;
CALL usp_get_holders_full_name;

#EX9*

#EX10
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value (balance DECIMAL (19,4),interest DECIMAL(19,4),years INT)
RETURNS DECIMAL (19,4)
DETERMINISTIC
BEGIN
RETURN balance * POW((1+interest),years);
END $$
DELIMITER ;
SELECT ufn_calculate_future_value(1000,0.5,5);

#EX11
DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(acc_id INT,interest DECIMAL(19,4))
BEGIN
	SELECT a.`id` AS 'account_id',ah.`first_name`,
    ah.`last_name`,a.`balance` AS 'current_balance',
    (SELECT ufn_calculate_future_value(a.`balance`,interest,5)) AS 'balance_in_5_years'
    FROM `account_holders` AS ah
    JOIN `accounts` AS a ON ah.`id`=a.`account_holder_id`
    WHERE `acc_id`=a.`id`;
END $$
DELIMITER ;
CALL usp_calculate_future_value_for_account(1,0.1);

#EX12
DELIMITER $$
CREATE PROCEDURE `usp_deposit_money`(`account_id` INT, `money_amount` DECIMAL(10, 4))
BEGIN
	START TRANSACTION;
    IF(`money_amount` <= 0)
    THEN
    ROLLBACK;
    ELSE
		UPDATE `accounts`
        SET `balance` = `balance` + `money_amount`
        WHERE `id` = `account_id`;
        END IF;
END $$

#EX13
DELIMITER $$
CREATE PROCEDURE `usp_withdraw_money`(`account_id` INT, `money_amount` DECIMAL(20, 4))
BEGIN
	START TRANSACTION;
    IF(`money_amount` <= 0 OR
    (SELECT `balance` FROM `accounts`
    WHERE `id` = `account_id`) <  `money_amount`)
    THEN
    ROLLBACK;
    ELSE
		UPDATE `accounts` AS a
		SET `balance` = `balance` - `money_amount`
		WHERE `id` = `account_id`;
	END IF;
END $$

#EX14
DELIMITER $$
CREATE PROCEDURE `usp_transfer_money`(`from_account_id` INT, `to_account_id` INT, `amount` DECIMAL(20, 4))
BEGIN
    IF
    (SELECT `id` FROM `accounts` WHERE `id` = `from_account_id`) IS NOT NULL
    AND
    (SELECT `id` FROM `accounts` WHERE `id` = `to_account_id`) IS NOT NULL
    AND `amount` > 0
    AND `from_account_id` <> `to_account_id`
    THEN
    START TRANSACTION;
		UPDATE `accounts`
        SET `balance` = `balance` - `amount`
        WHERE `id` = `from_account_id`;
        UPDATE `accounts`
        SET `balance` = `balance` + `amount`
        WHERE `id` = `to_account_id`;
        
		IF (SELECT `balance` FROM `accounts` WHERE `id` = `from_account_id`) < `amount`
		THEN
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
	END IF;
END $$
 



