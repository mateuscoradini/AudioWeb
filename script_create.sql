-- MySQL Script generated by MySQL Workbench
-- 02/14/16 12:20:34
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tb_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `name` VARCHAR(70) NOT NULL,
  `email` VARCHAR(70) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `insert_date` DATETIME NULL,
  `enabled` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_user_role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NULL,
  `role_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC),
  INDEX `role_id_idx` (`role_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`tb_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `mydb`.`tb_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_project` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL,
  `scope` VARCHAR(45) NULL,
  `enabled` TINYINT NULL,
  `insert_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_audio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_audio` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `filename` VARCHAR(100) NULL,
  `enabled` TINYINT(1) NULL,
  `insert_date` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_project_audio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_project_audio` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `project_id` BIGINT NULL,
  `audio_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `audio_id_idx` (`audio_id` ASC),
  CONSTRAINT `audio_id`
    FOREIGN KEY (`audio_id`)
    REFERENCES `mydb`.`tb_audio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `mydb`.`tb_project` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_audio_stream`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_audio_stream` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `audio_id` BIGINT NOT NULL,
  `audio_stream` LONGBLOB NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `audio_id_UNIQUE` (`audio_id` ASC),
  CONSTRAINT `audio_stream_audio_id`
    FOREIGN KEY (`audio_id`)
    REFERENCES `mydb`.`tb_audio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_audio_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_audio_role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `audio_id` BIGINT NULL,
  `audio_role_key` VARCHAR(100) NULL,
  `user_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `audio_role_user_id_idx` (`user_id` ASC),
  INDEX `audio_role_audio_id_idx` (`audio_id` ASC),
  CONSTRAINT `audio_role_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`tb_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `audio_role_audio_id`
    FOREIGN KEY (`audio_id`)
    REFERENCES `mydb`.`tb_audio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_user_audio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_user_audio` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NULL,
  `audio_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `audio_id_idx` (`audio_id` ASC),
  CONSTRAINT `user_audio_audio_id`
    FOREIGN KEY (`audio_id`)
    REFERENCES `mydb`.`tb_audio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_audio_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`tb_user` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
