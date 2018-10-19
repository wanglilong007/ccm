SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `bank` CASCADE
;

DROP TABLE IF EXISTS `transaction` CASCADE
;

DROP TABLE IF EXISTS `user` CASCADE
;

DROP TABLE IF EXISTS `credit_card` CASCADE
;

CREATE TABLE `bank`
(
	`id` VARCHAR(50),
	`name` VARCHAR(50),
	`phone` VARCHAR(50)
)
;

CREATE TABLE `transaction`
(
	`id` VARCHAR(50) NOT NULL,
	`credit_card_id` VARCHAR(50) NOT NULL,
	`amount` INTEGER NOT NULL,
	`time` TIMESTAMP(0),
	`merchant` VARCHAR(200)
)
;

CREATE TABLE `user`
(
	`id` VARCHAR(50) NOT NULL,
	`name` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	`phone` VARCHAR(50),
	`email` VARCHAR(50)
)
;

CREATE TABLE `credit_card`
(
	`id` VARCHAR(50) NOT NULL,
	`bank_id` VARCHAR(100) NOT NULL,
	`number` VARCHAR(50) NOT NULL,
	`owner_id` VARCHAR(100) NOT NULL,
	`statement_data` DATE,
	`payment_date` DATE
)
;

SET FOREIGN_KEY_CHECKS=1;
