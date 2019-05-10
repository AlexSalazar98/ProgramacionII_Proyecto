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
  `NCliente` INT NOT NULL,
  `NombreYApellidos` VARCHAR(100) NOT NULL,
  `DNI_NIF` VARCHAR(45) NULL,
  `DireccionDeCliente` VARCHAR(100) NOT NULL,
  `Provincia` VARCHAR(45) NOT NULL,
  `Telefono` INT NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`NCliente`),
  UNIQUE INDEX `NºCliente_UNIQUE` (`NCliente` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pedidos` (
  `NPedido` INT NOT NULL,
  `Fecha_de_pedido` DATE NOT NULL,
  `Fecha_de_entrega` DATE NOT NULL,
  `Entregado` TINYINT(1) NULL,
  `NombreYApellidos` VARCHAR(200) NOT NULL,
  `Clientes_NCliente` INT NULL,
  PRIMARY KEY (`NPedido`),
  UNIQUE INDEX `NºPedido_UNIQUE` (`NPedido` ASC) VISIBLE,
  INDEX `fk_Pedidos_Clientes1_idx` (`Clientes_NCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Pedidos_Clientes1`
    FOREIGN KEY (`Clientes_NCliente`)
    REFERENCES `mydb`.`Clientes` (`NCliente`)
    ON DELETE SET NULL
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
  `Suelas_Referencia` INT NULL,
  PRIMARY KEY (`Referencia`),
  INDEX `fk_Articulos_Suelas1_idx` (`Suelas_Referencia` ASC) VISIBLE,
  CONSTRAINT `fk_Articulos_Suelas1`
    FOREIGN KEY (`Suelas_Referencia`)
    REFERENCES `mydb`.`Suelas` (`Referencia`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DesgloseDePedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DesgloseDePedidos` (
  `NPedidoD` INT NOT NULL,
  `Serie` INT NOT NULL,
  `Color` INT NULL,
  `Articulos_Referencia` INT NULL,
  `P5` INT NULL,
  `P6` INT NULL,
  `P7` INT NULL,
  `P8` INT NULL,
  `P9` INT NULL,
  `P0` INT NULL,
  `P1` INT NULL,
  `P2` INT NULL,
  `P3` INT NULL,
  `P4` INT NULL,
  `Pedidos_NPedido` INT NULL,
  `CantidadTotalPies` INT NOT NULL,
  PRIMARY KEY (`NPedidoD`),
  INDEX `fk_DesgloseDepedidos_Articulos1_idx` (`Articulos_Referencia` ASC) VISIBLE,
  INDEX `fk_DesgloseDePedidos_Pedidos1_idx` (`Pedidos_NPedido` ASC) VISIBLE,
  CONSTRAINT `fk_DesgloseDepedidos_Articulos1`
    FOREIGN KEY (`Articulos_Referencia`)
    REFERENCES `mydb`.`Articulos` (`Referencia`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DesgloseDePedidos_Pedidos1`
    FOREIGN KEY (`Pedidos_NPedido`)
    REFERENCES `mydb`.`Pedidos` (`NPedido`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Envios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Envios` (
  `NEnvio` INT NOT NULL,
  `NombreCliente` VARCHAR(45) NOT NULL,
  `DireccionDeEnvio` VARCHAR(100) NOT NULL,
  `PoblacionDeEnvio` VARCHAR(45) NOT NULL,
  `CPDeEnvio` INT NOT NULL,
  `ProvinciaDeEnvio` VARCHAR(45) NOT NULL,
  `TelefonoDeEnvio` INT NULL,
  `Clientes_NCliente` INT NULL,
  PRIMARY KEY (`NEnvio`),
  INDEX `fk_Envios_Clientes1_idx` (`Clientes_NCliente` ASC) VISIBLE,
  UNIQUE INDEX `NºEnvio_UNIQUE` (`NEnvio` ASC) VISIBLE,
  CONSTRAINT `fk_Envios_Clientes1`
    FOREIGN KEY (`Clientes_NCliente`)
    REFERENCES `mydb`.`Clientes` (`NCliente`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Series`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Series` (
  `NDeSerie` INT NOT NULL,
  `Descripcion` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`NDeSerie`),
  UNIQUE INDEX `NºDeSerie_UNIQUE` (`NDeSerie` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DesgloseDepedidos_has_Series`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DesgloseDepedidos_has_Series` (
  `DesgloseDepedidos_NPedido` INT NOT NULL,
  `Series_NDeSerie` INT NOT NULL,
  PRIMARY KEY (`DesgloseDepedidos_NPedido`, `Series_NDeSerie`),
  INDEX `fk_DesgloseDepedidos_has_Series_Series1_idx` (`Series_NDeSerie` ASC) VISIBLE,
  INDEX `fk_DesgloseDepedidos_has_Series_DesgloseDepedidos1_idx` (`DesgloseDepedidos_NPedido` ASC) VISIBLE,
  CONSTRAINT `fk_DesgloseDepedidos_has_Series_DesgloseDepedidos1`
    FOREIGN KEY (`DesgloseDepedidos_NPedido`)
    REFERENCES `mydb`.`DesgloseDePedidos` (`NPedidoD`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DesgloseDepedidos_has_Series_Series1`
    FOREIGN KEY (`Series_NDeSerie`)
    REFERENCES `mydb`.`Series` (`NDeSerie`)
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
