-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema scuola
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema scuola
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `scuola` DEFAULT CHARACTER SET utf8 ;
USE `scuola` ;

-- -----------------------------------------------------
-- Table `scuola`.`corso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scuola`.`corso` (
  `idCorso` INT NOT NULL,
  `nome` VARCHAR(20) NULL DEFAULT NULL,
  `numeroOre` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idCorso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `scuola`.`docenti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scuola`.`docenti` (
  `idDocenti` INT NOT NULL,
  `nomeDocente` VARCHAR(20) NULL DEFAULT NULL,
  `cognomeDocente` VARCHAR(20) NULL DEFAULT NULL,
  `CFDocente` CHAR(16) NULL DEFAULT NULL,
  `dataNascitaDocente` DATE NULL DEFAULT NULL,
  `genereDocente` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`idDocenti`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `scuola`.`docenticorso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scuola`.`docenticorso` (
  `idDocenti` INT NOT NULL,
  `idCorso` INT NOT NULL,
  PRIMARY KEY (`idDocenti`, `idCorso`),
  INDEX `fk_docenti_has_corso_corso1_idx` (`idCorso` ASC) VISIBLE,
  INDEX `fk_docenti_has_corso_docenti1_idx` (`idDocenti` ASC) VISIBLE,
  CONSTRAINT `fk_docenti_has_corso_corso1`
    FOREIGN KEY (`idCorso`)
    REFERENCES `scuola`.`corso` (`idCorso`),
  CONSTRAINT `fk_docenti_has_corso_docenti1`
    FOREIGN KEY (`idDocenti`)
    REFERENCES `scuola`.`docenti` (`idDocenti`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `scuola`.`studente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scuola`.`studente` (
  `idStudente` INT NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `cognome` VARCHAR(45) NULL DEFAULT NULL,
  `CF` CHAR(16) NULL DEFAULT NULL,
  `dataNascita` DATE NULL DEFAULT NULL,
  `genere` INT NULL DEFAULT NULL,
  `idCorso` INT NOT NULL,
  PRIMARY KEY (`idStudente`),
  INDEX `fk_studente_corso_idx` (`idCorso` ASC) VISIBLE,
  CONSTRAINT `fk_studente_corso`
    FOREIGN KEY (`idCorso`)
    REFERENCES `scuola`.`corso` (`idCorso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `scuola`.`Voto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scuola`.`Voto` (
  `idCorso` INT NOT NULL,
  `idStudente` INT NOT NULL,
  `valoreVoto` FLOAT NOT NULL,
  `dataVoto` DATETIME NOT NULL,
  PRIMARY KEY (`idCorso`, `idStudente`, `dataVoto`),
  INDEX `fk_corso_has_studente_studente1_idx` (`idStudente` ASC) VISIBLE,
  INDEX `fk_corso_has_studente_corso1_idx` (`idCorso` ASC) VISIBLE,
  CONSTRAINT `fk_corso_has_studente_corso1`
    FOREIGN KEY (`idCorso`)
    REFERENCES `scuola`.`corso` (`idCorso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_corso_has_studente_studente1`
    FOREIGN KEY (`idStudente`)
    REFERENCES `scuola`.`studente` (`idStudente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
