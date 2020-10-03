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
  `MaPB` INT NOT NULL,
  `TenPB` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`MaPB`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07_shopping`.`nhanvien`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`nhanvien` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`nhanvien` (
  `MaNV` INT NOT NULL,
  `HoTen` VARCHAR(255) NOT NULL,
  `SDT` VARCHAR(45) NOT NULL,
  `DiaChi` TEXT NOT NULL,
  `GioiTinh` BIT(1) NOT NULL,
  `MaPB` INT NOT NULL,
  PRIMARY KEY (`MaNV`, `MaPB`),
  INDEX `fk_nhanvien_phongban1_idx` (`MaPB` ASC) VISIBLE,
  CONSTRAINT `fk_nhanvien_phongban1`
    FOREIGN KEY (`MaPB`)
    REFERENCES `java07_shopping`.`phongban` (`MaPB`)
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
  `TenKh` VARCHAR(255) NOT NULL,
  `SDT` VARCHAR(30) NOT NULL,
  `DiaChi` TEXT NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `TaiKhoan` VARCHAR(255) NOT NULL,
  `MatKhau` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaKH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`LHTT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`LHTT` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`LHTT` (
  `MaLHTT` INT NOT NULL,
  `Mota` VARCHAR(255) NULL,
  PRIMARY KEY (`MaLHTT`))
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
  PRIMARY KEY (`MaHD`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`DonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`DonHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`DonHang` (
  `MaDH` INT NOT NULL,
  `DiaChiGIaoHang` TEXT NOT NULL,
  `SDTGiaoHang` VARCHAR(45) NOT NULL,
  `NgayDatHang` DATE NOT NULL,
  `KhachHang_MaKH` INT NOT NULL,
  `nhanvien_MaNV` INT NOT NULL,
  `nhanvien_MaPB` INT NOT NULL,
  `LHTT_MaLHTT` INT NOT NULL,
  `HoaDon_MaHD` INT NOT NULL,
  PRIMARY KEY (`MaDH`, `KhachHang_MaKH`, `nhanvien_MaNV`, `nhanvien_MaPB`, `LHTT_MaLHTT`, `HoaDon_MaHD`),
  INDEX `fk_DonHang_KhachHang1_idx` (`KhachHang_MaKH` ASC) VISIBLE,
  INDEX `fk_DonHang_nhanvien1_idx` (`nhanvien_MaNV` ASC, `nhanvien_MaPB` ASC) VISIBLE,
  INDEX `fk_DonHang_LHTT1_idx` (`LHTT_MaLHTT` ASC) VISIBLE,
  INDEX `fk_DonHang_HoaDon1_idx` (`HoaDon_MaHD` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_KhachHang1`
    FOREIGN KEY (`KhachHang_MaKH`)
    REFERENCES `java07_shopping`.`KhachHang` (`MaKH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_nhanvien1`
    FOREIGN KEY (`nhanvien_MaNV` , `nhanvien_MaPB`)
    REFERENCES `java07_shopping`.`nhanvien` (`MaNV` , `MaPB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_LHTT1`
    FOREIGN KEY (`LHTT_MaLHTT`)
    REFERENCES `java07_shopping`.`LHTT` (`MaLHTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_HoaDon1`
    FOREIGN KEY (`HoaDon_MaHD`)
    REFERENCES `java07_shopping`.`HoaDon` (`MaHD`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`LoaiHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`LoaiHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`LoaiHang` (
  `MaLH` INT NOT NULL,
  `TenLH` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLH`))
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
  `MauSac` VARCHAR(255) NOT NULL,
  `KichCo` VARCHAR(255) NOT NULL,
  `MoTa` TEXT NOT NULL,
  `SoLuong` INT NOT NULL,
  `LoaiHang_MaLH` INT NOT NULL,
  PRIMARY KEY (`MaMH`, `LoaiHang_MaLH`),
  INDEX `fk_MatHang_LoaiHang1_idx` (`LoaiHang_MaLH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_LoaiHang1`
    FOREIGN KEY (`LoaiHang_MaLH`)
    REFERENCES `java07_shopping`.`LoaiHang` (`MaLH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`XuLyDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`XuLyDonHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`XuLyDonHang` (
  `DonHang_MaDH` INT NOT NULL,
  `MatHang_MaMH` INT NOT NULL,
  `MatHang_LoaiHang_MaLH` INT NOT NULL,
  `SoLuong` INT NOT NULL,
  PRIMARY KEY (`DonHang_MaDH`, `MatHang_MaMH`, `MatHang_LoaiHang_MaLH`),
  INDEX `fk_DonHang_has_MatHang_MatHang1_idx` (`MatHang_MaMH` ASC, `MatHang_LoaiHang_MaLH` ASC) VISIBLE,
  INDEX `fk_DonHang_has_MatHang_DonHang1_idx` (`DonHang_MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_has_MatHang_DonHang1`
    FOREIGN KEY (`DonHang_MaDH`)
    REFERENCES `java07_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_has_MatHang_MatHang1`
    FOREIGN KEY (`MatHang_MaMH` , `MatHang_LoaiHang_MaLH`)
    REFERENCES `java07_shopping`.`MatHang` (`MaMH` , `LoaiHang_MaLH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`TTDH`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`TTDH` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`TTDH` (
  `MaTTDH` INT NOT NULL,
  `MoTa` VARCHAR(255) NULL,
  PRIMARY KEY (`MaTTDH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`GiaoHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`GiaoHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`GiaoHang` (
  `ThoiGian` INT NOT NULL,
  `TTDH_MaTTDH` INT NOT NULL,
  `DonHang_MaDH` INT NOT NULL,
  PRIMARY KEY (`TTDH_MaTTDH`, `DonHang_MaDH`),
  INDEX `fk_GiaoHang_DonHang1_idx` (`DonHang_MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_GiaoHang_TTDH1`
    FOREIGN KEY (`TTDH_MaTTDH`)
    REFERENCES `java07_shopping`.`TTDH` (`MaTTDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GiaoHang_DonHang1`
    FOREIGN KEY (`DonHang_MaDH`)
    REFERENCES `java07_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
