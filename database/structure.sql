-- MySQL Script generated by MySQL Workbench
-- 06/10/16 12:59:27
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema CompraProduto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CompraProduto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CompraProduto` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `CompraProduto` ;

-- -----------------------------------------------------
-- Table `CompraProduto`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CompraProduto`.`Cliente` (
  `idCliente` INT NOT NULL COMMENT '',
  `nome` VARCHAR(90) NOT NULL COMMENT '',
  PRIMARY KEY (`idCliente`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CompraProduto`.`Compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CompraProduto`.`Compra` (
  `idCompra` INT NOT NULL COMMENT '',
  `idCliente` INT NOT NULL COMMENT '',
  `data` DATE NOT NULL COMMENT '',
  `time` TIME NOT NULL COMMENT '',
  PRIMARY KEY (`idCompra`)  COMMENT '',
  INDEX `fk_Compra_Cliente1_idx` (`idCliente` ASC)  COMMENT '',
  CONSTRAINT `fk_Compra_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `CompraProduto`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CompraProduto`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CompraProduto`.`Produto` (
  `idProduto` INT NOT NULL COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idProduto`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CompraProduto`.`ItemCompra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CompraProduto`.`ItemCompra` (
  `idCompra` INT NOT NULL COMMENT '',
  `idProduto` INT NOT NULL COMMENT '',
  `quantidade` INT NOT NULL COMMENT '',
  `valorUnitario` REAL NOT NULL COMMENT '',
  PRIMARY KEY (`idCompra`, `idProduto`)  COMMENT '',
  INDEX `fk_Compra_has_Produto_Produto1_idx` (`idProduto` ASC)  COMMENT '',
  INDEX `fk_Compra_has_Produto_Compra_idx` (`idCompra` ASC)  COMMENT '',
  CONSTRAINT `fk_Compra_has_Produto_Compra`
    FOREIGN KEY (`idCompra`)
    REFERENCES `CompraProduto`.`Compra` (`idCompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_has_Produto_Produto1`
    FOREIGN KEY (`idProduto`)
    REFERENCES `CompraProduto`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
