-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Clientes` (
  `NºCliente` INT NOT NULL,
  `NombreYApellidos` VARCHAR(100) NOT NULL,
  `DNI/NIF` VARCHAR(45) NULL,
  `DirecciónDeCliente` VARCHAR(100) NOT NULL,
  `Provincia` VARCHAR(45) NOT NULL,
  `Telefono` INT NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`NºCliente`),
  UNIQUE INDEX `NºCliente_UNIQUE` (`NºCliente` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pedidos` (
  `NºPedido` INT NOT NULL,
  `Fecha_de_pedido` DATE NOT NULL,
  `Fecha_de_entrega` DATE NOT NULL,
  `Entregado` VARCHAR(1) BINARY NULL,
  `Clientes_NºCliente` INT NOT NULL,
  `NombreYApellidos` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`NºPedido`),
  INDEX `fk_Pedidos_Clientes1_idx` (`Clientes_NºCliente` ASC) VISIBLE,
  UNIQUE INDEX `NºPedido_UNIQUE` (`NºPedido` ASC) VISIBLE,
  CONSTRAINT `fk_Pedidos_Clientes1`
    FOREIGN KEY (`Clientes_NºCliente`)
    REFERENCES `mydb`.`Clientes` (`NºCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Materiales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Materiales` (
  `Referencia` INT NOT NULL,
  `Descripcion` VARCHAR(200) NOT NULL,
  `Precio` DOUBLE NULL,
  PRIMARY KEY (`Referencia`),
  UNIQUE INDEX `Referencia_UNIQUE` (`Referencia` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Suelas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Suelas` (
  `Referencia` INT NOT NULL,
  `Descripcion` VARCHAR(200) NOT NULL,
  `Precio` DOUBLE NULL,
  PRIMARY KEY (`Referencia`),
  UNIQUE INDEX `Referencia_UNIQUE` (`Referencia` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Herrajes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Herrajes` (
  `Referencia` INT NOT NULL,
  `Descripcion` VARCHAR(200) NOT NULL,
  `Precio` DOUBLE NULL,
  PRIMARY KEY (`Referencia`),
  UNIQUE INDEX `Referencia_UNIQUE` (`Referencia` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Articulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Articulos` (
  `Referencia` INT NOT NULL,
  `Serie` INT NOT NULL,
  `Descripcion` VARCHAR(200) NOT NULL,
  `CantidadMaterial` INT NOT NULL,
  `CantidadHerraje` INT NOT NULL,
  `Precio` DOUBLE NULL,
  `Suelas_Referencia` INT NOT NULL,
  PRIMARY KEY (`Referencia`),
  INDEX `fk_Articulos_Suelas1_idx` (`Suelas_Referencia` ASC) VISIBLE,
  CONSTRAINT `fk_Articulos_Suelas1`
    FOREIGN KEY (`Suelas_Referencia`)
    REFERENCES `mydb`.`Suelas` (`Referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DesgloseDePedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DesgloseDePedidos` (
  `NºPedido` INT NOT NULL,
  `Serie` INT NOT NULL,
  `Color` INT NULL,
  `Articulos_Referencia` INT NOT NULL,
  `Pedidos_Clientes_NºCliente` INT NOT NULL,
  `5` INT NULL,
  `6` INT NULL,
  `7` INT NULL,
  `8` INT NULL,
  `9` INT NULL,
  `0` INT NULL,
  `1` INT NULL,
  `2` INT NULL,
  `3` INT NULL,
  `4` INT NULL,
  PRIMARY KEY (`NºPedido`),
  INDEX `fk_DesgloseDepedidos_Articulos1_idx` (`Articulos_Referencia` ASC) VISIBLE,
  INDEX `fk_DesgloseDepedidos_Pedidos1_idx` (`Pedidos_Clientes_NºCliente` ASC) VISIBLE,
  CONSTRAINT `fk_DesgloseDepedidos_Articulos1`
    FOREIGN KEY (`Articulos_Referencia`)
    REFERENCES `mydb`.`Articulos` (`Referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DesgloseDepedidos_Pedidos1`
    FOREIGN KEY (`Pedidos_Clientes_NºCliente`)
    REFERENCES `mydb`.`Pedidos` (`Clientes_NºCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Envios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Envios` (
  `NºEnvio` INT NOT NULL,
  `NombreCliente` VARCHAR(45) NOT NULL,
  `DireccionDeEnvio` VARCHAR(100) NOT NULL,
  `PoblacionDeEnvio` VARCHAR(45) NOT NULL,
  `CPDeEnvio` VARCHAR(45) NOT NULL,
  `ProvinciaDeEnvio` VARCHAR(45) NOT NULL,
  `TelefonoDeEnvio` INT NULL,
  `Clientes_NºCliente` INT NOT NULL,
  PRIMARY KEY (`NºEnvio`),
  INDEX `fk_Envios_Clientes1_idx` (`Clientes_NºCliente` ASC) VISIBLE,
  UNIQUE INDEX `NºEnvio_UNIQUE` (`NºEnvio` ASC) VISIBLE,
  CONSTRAINT `fk_Envios_Clientes1`
    FOREIGN KEY (`Clientes_NºCliente`)
    REFERENCES `mydb`.`Clientes` (`NºCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Series`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Series` (
  `NºDeSerie` INT NOT NULL,
  `Descripcion` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`NºDeSerie`),
  UNIQUE INDEX `NºDeSerie_UNIQUE` (`NºDeSerie` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DesgloseDepedidos_has_Series`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DesgloseDepedidos_has_Series` (
  `DesgloseDepedidos_NºPedido` INT NOT NULL,
  `Series_NºDeSerie` INT NOT NULL,
  PRIMARY KEY (`DesgloseDepedidos_NºPedido`, `Series_NºDeSerie`),
  INDEX `fk_DesgloseDepedidos_has_Series_Series1_idx` (`Series_NºDeSerie` ASC) VISIBLE,
  INDEX `fk_DesgloseDepedidos_has_Series_DesgloseDepedidos1_idx` (`DesgloseDepedidos_NºPedido` ASC) VISIBLE,
  CONSTRAINT `fk_DesgloseDepedidos_has_Series_DesgloseDepedidos1`
    FOREIGN KEY (`DesgloseDepedidos_NºPedido`)
    REFERENCES `mydb`.`DesgloseDePedidos` (`NºPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DesgloseDepedidos_has_Series_Series1`
    FOREIGN KEY (`Series_NºDeSerie`)
    REFERENCES `mydb`.`Series` (`NºDeSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Materiales_has_Articulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Materiales_has_Articulos` (
  `Materiales_Referencia` INT NOT NULL,
  `Articulos_Referencia` INT NOT NULL,
  PRIMARY KEY (`Materiales_Referencia`, `Articulos_Referencia`),
  INDEX `fk_Materiales_has_Articulos_Articulos1_idx` (`Articulos_Referencia` ASC) VISIBLE,
  INDEX `fk_Materiales_has_Articulos_Materiales1_idx` (`Materiales_Referencia` ASC) VISIBLE,
  CONSTRAINT `fk_Materiales_has_Articulos_Materiales1`
    FOREIGN KEY (`Materiales_Referencia`)
    REFERENCES `mydb`.`Materiales` (`Referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Materiales_has_Articulos_Articulos1`
    FOREIGN KEY (`Articulos_Referencia`)
    REFERENCES `mydb`.`Articulos` (`Referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Articulos_has_Herrajes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Articulos_has_Herrajes` (
  `Articulos_Referencia` INT NOT NULL,
  `Herrajes_Referencia` INT NOT NULL,
  PRIMARY KEY (`Articulos_Referencia`, `Herrajes_Referencia`),
  INDEX `fk_Articulos_has_Herrajes_Herrajes1_idx` (`Herrajes_Referencia` ASC) VISIBLE,
  INDEX `fk_Articulos_has_Herrajes_Articulos1_idx` (`Articulos_Referencia` ASC) VISIBLE,
  CONSTRAINT `fk_Articulos_has_Herrajes_Articulos1`
    FOREIGN KEY (`Articulos_Referencia`)
    REFERENCES `mydb`.`Articulos` (`Referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Articulos_has_Herrajes_Herrajes1`
    FOREIGN KEY (`Herrajes_Referencia`)
    REFERENCES `mydb`.`Herrajes` (`Referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
