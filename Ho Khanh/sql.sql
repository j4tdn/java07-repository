-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema java07_shopping
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `java07_shopping` ;

-- -----------------------------------------------------
-- Schema java07_shopping
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `java07_shopping` DEFAULT CHARACTER SET utf8 ;
USE `java07_shopping` ;

-- -----------------------------------------------------
-- Table `java07_shopping`.`phongban`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`phongban` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`phongban` (
  `MAPB` INT NOT NULL,
  `TENPB` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MAPB`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07_shopping`.`nhanvien`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`nhanvien` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`nhanvien` (
  `MANV` INT NOT NULL,
  `HoTen` VARCHAR(255) NOT NULL,
  `SDT` VARCHAR(45) NOT NULL,
  `DiaChi` TEXT NOT NULL,
  `NgaySinh` DATE NOT NULL,
  `GioiTinh` BIT(1) NOT NULL,
  `MAPB` INT NOT NULL,
  PRIMARY KEY (`MANV`, `MAPB`),
  INDEX `fk_nhanvien_phongban_idx` (`MAPB` ASC) VISIBLE,
  CONSTRAINT `fk_nhanvien_phongban`
    FOREIGN KEY (`MAPB`)
    REFERENCES `java07_shopping`.`phongban` (`MAPB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07_shopping`.`KhachHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`KhachHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`KhachHang` (
  `MaKH` INT NOT NULL,
  `TenKH` VARCHAR(255) NOT NULL,
  `DiaChi` TEXT NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `TaiKhoan` VARCHAR(255) NOT NULL,
  `MatKhau` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaKH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`LoaiHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`LoaiHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`LoaiHang` (
  `MaLoai` INT NOT NULL,
  `TenLoai` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLoai`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`MatHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`MatHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`MatHang` (
  `MaMH` INT NOT NULL,
  `TenMH` VARCHAR(255) NOT NULL,
  `GiaMua` DOUBLE NOT NULL,
  `GiaBan` DOUBLE NOT NULL,
  `MauSac` VARCHAR(45) NOT NULL,
  `KichCo` VARCHAR(45) NOT NULL,
  `MoTa` TEXT NOT NULL,
  `SoLuong` INT NOT NULL,
  `MaLoai` INT NOT NULL,
  PRIMARY KEY (`MaMH`, `MaLoai`),
  INDEX `fk_MatHang_LoaiHang1_idx` (`MaLoai` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_LoaiHang1`
    FOREIGN KEY (`MaLoai`)
    REFERENCES `java07_shopping`.`LoaiHang` (`MaLoai`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`LHTT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`LHTT` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`LHTT` (
  `MaLHTT` INT NOT NULL,
  `MoTa` TEXT NOT NULL,
  PRIMARY KEY (`MaLHTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`TTDH`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`TTDH` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`TTDH` (
  `MaTTDH` INT NOT NULL,
  `MoTa` TEXT NOT NULL,
  PRIMARY KEY (`MaTTDH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`DonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`DonHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`DonHang` (
  `MaDH` INT NOT NULL,
  `DiaChiGiaoHang` TEXT NOT NULL,
  `SDTGiaoHang` VARCHAR(45) NOT NULL,
  `NgayDatHang` DATE NOT NULL,
  `MaKH` INT NOT NULL,
  `MaLHTT` INT NOT NULL,
  `MANV` INT NOT NULL,
  PRIMARY KEY (`MaDH`, `MaKH`, `MaLHTT`, `MANV`),
  INDEX `fk_DonHang_KhachHang1_idx` (`MaKH` ASC) VISIBLE,
  INDEX `fk_DonHang_LHTT1_idx` (`MaLHTT` ASC) VISIBLE,
  INDEX `fk_DonHang_nhanvien1_idx` (`MANV` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_KhachHang1`
    FOREIGN KEY (`MaKH`)
    REFERENCES `java07_shopping`.`KhachHang` (`MaKH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_LHTT1`
    FOREIGN KEY (`MaLHTT`)
    REFERENCES `java07_shopping`.`LHTT` (`MaLHTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_nhanvien1`
    FOREIGN KEY (`MANV`)
    REFERENCES `java07_shopping`.`nhanvien` (`MANV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`HoaDon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`HoaDon` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`HoaDon` (
  `MaHD` INT NOT NULL,
  `NgayXuat` DATE NOT NULL,
  `PhiVanChuyen` DOUBLE NOT NULL,
  `TongTien` DOUBLE NOT NULL,
  `MaDH` INT NOT NULL,
  `MANV` INT NOT NULL,
  PRIMARY KEY (`MaHD`, `MaDH`, `MANV`),
  INDEX `fk_HoaDon_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  INDEX `fk_HoaDon_nhanvien1_idx` (`MANV` ASC) VISIBLE,
  CONSTRAINT `fk_HoaDon_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java07_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HoaDon_nhanvien1`
    FOREIGN KEY (`MANV`)
    REFERENCES `java07_shopping`.`nhanvien` (`MANV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`XyLyDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`XyLyDonHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`XyLyDonHang` (
  `MaDH` INT NOT NULL,
  `MaMH` INT NOT NULL,
  `SoLuong` INT NOT NULL,
  PRIMARY KEY (`MaDH`, `MaMH`),
  INDEX `fk_DonHang_has_MatHang_MatHang1_idx` (`MaMH` ASC) VISIBLE,
  INDEX `fk_DonHang_has_MatHang_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_has_MatHang_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java07_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_has_MatHang_MatHang1`
    FOREIGN KEY (`MaMH`)
    REFERENCES `java07_shopping`.`MatHang` (`MaMH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`GiaoHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`GiaoHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`GiaoHang` (
  `MaDH` INT NOT NULL,
  `MaTTDH` INT NOT NULL,
  `ThoiGian` DATE NOT NULL,
  PRIMARY KEY (`MaDH`, `MaTTDH`),
  INDEX `fk_DonHang_has_TTDH_TTDH1_idx` (`MaTTDH` ASC) VISIBLE,
  INDEX `fk_DonHang_has_TTDH_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_has_TTDH_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java07_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_has_TTDH_TTDH1`
    FOREIGN KEY (`MaTTDH`)
    REFERENCES `java07_shopping`.`TTDH` (`MaTTDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
