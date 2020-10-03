-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema java07_shopping
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema java07_shopping
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `java07_shopping` DEFAULT CHARACTER SET utf8 ;
USE `java07_shopping` ;

-- -----------------------------------------------------
-- Table `java07_shopping`.`PhongBan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`PhongBan` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`PhongBan` (
  `MaPB` INT NOT NULL,
  `TenPB` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaPB`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`NhanVien`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`NhanVien` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`NhanVien` (
  `MaNV` INT NOT NULL,
  `HoTen` VARCHAR(45) NOT NULL,
  `SDT` VARCHAR(30) NOT NULL,
  `DiaChi` VARCHAR(45) NOT NULL,
  `NgaySinh` DATE NOT NULL,
  `GioiTinh` BIT NOT NULL,
  `MaPB` INT NOT NULL,
  PRIMARY KEY (`MaNV`, `MaPB`),
  INDEX `fk_NhanVien_PhongBan_idx` (`MaPB` ASC) VISIBLE,
  CONSTRAINT `fk_NhanVien_PhongBan`
    FOREIGN KEY (`MaPB`)
    REFERENCES `java07_shopping`.`PhongBan` (`MaPB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`LoaiHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`LoaiHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`LoaiHang` (
  `MaLH` INT NOT NULL,
  `TenLoai` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaLH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`MatHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`MatHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`MatHang` (
  `MaMH` INT NOT NULL,
  `TenMH` VARCHAR(45) NOT NULL,
  `GiaMua` FLOAT NOT NULL,
  `GiaBan` FLOAT NOT NULL,
  `MauSac` VARCHAR(45) NOT NULL,
  `KichCo` VARCHAR(5) NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  `SoLuong` INT NOT NULL,
  `MaLH` INT NOT NULL,
  PRIMARY KEY (`MaMH`, `MaLH`),
  INDEX `fk_MatHang_LoaiHang1_idx` (`MaLH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_LoaiHang1`
    FOREIGN KEY (`MaLH`)
    REFERENCES `java07_shopping`.`LoaiHang` (`MaLH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`KhachHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`KhachHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`KhachHang` (
  `MaKH` INT NOT NULL,
  `HoTen` VARCHAR(45) NOT NULL,
  `SDT` VARCHAR(30) NOT NULL,
  `DiaChi` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `TaiKhoan` VARCHAR(45) NOT NULL,
  `MatKhau` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaKH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`LoaiHinhThanhToan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`LoaiHinhThanhToan` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`LoaiHinhThanhToan` (
  `MaLHTT` INT NOT NULL,
  `MoTa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaLHTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`DonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`DonHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`DonHang` (
  `MaDH` INT NOT NULL,
  `DiaChiGiaoHang` VARCHAR(45) NOT NULL,
  `SDTGiaoHang` VARCHAR(30) NOT NULL,
  `NgayDatHang` DATE NOT NULL,
  `MaKH` INT NOT NULL,
  `MaLHTT` INT NOT NULL,
  `MaNV` INT NOT NULL,
  PRIMARY KEY (`MaDH`, `MaKH`, `MaLHTT`, `MaNV`),
  INDEX `fk_DonHang_KhachHang1_idx` (`MaKH` ASC) VISIBLE,
  INDEX `fk_DonHang_LoaiHinhThanhToan1_idx` (`MaLHTT` ASC) VISIBLE,
  INDEX `fk_DonHang_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_KhachHang1`
    FOREIGN KEY (`MaKH`)
    REFERENCES `java07_shopping`.`KhachHang` (`MaKH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_LoaiHinhThanhToan1`
    FOREIGN KEY (`MaLHTT`)
    REFERENCES `java07_shopping`.`LoaiHinhThanhToan` (`MaLHTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java07_shopping`.`NhanVien` (`MaNV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`TinhTrangDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`TinhTrangDonHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`TinhTrangDonHang` (
  `MaTTDH` INT NOT NULL,
  `MoTa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaTTDH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`HoaDon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`HoaDon` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`HoaDon` (
  `MaHD` INT NOT NULL,
  `NgayXuat` DATE NOT NULL,
  `PhiVanChuyen` FLOAT NOT NULL,
  `TongTien` FLOAT NOT NULL,
  `MaDH` INT NOT NULL,
  `MaNV` INT NOT NULL,
  PRIMARY KEY (`MaHD`, `MaDH`, `MaNV`),
  INDEX `fk_HoaDon_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  INDEX `fk_HoaDon_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  CONSTRAINT `fk_HoaDon_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java07_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HoaDon_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java07_shopping`.`NhanVien` (`MaNV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`GiaoHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`GiaoHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`GiaoHang` (
  `MaTTDH` INT NOT NULL,
  `MaDH` INT NOT NULL,
  `ThoiGian` DATE NOT NULL,
  PRIMARY KEY (`MaTTDH`, `MaDH`),
  INDEX `fk_TinhTrangDonHang_has_DonHang_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  INDEX `fk_TinhTrangDonHang_has_DonHang_TinhTrangDonHang1_idx` (`MaTTDH` ASC) VISIBLE,
  CONSTRAINT `fk_TinhTrangDonHang_has_DonHang_TinhTrangDonHang1`
    FOREIGN KEY (`MaTTDH`)
    REFERENCES `java07_shopping`.`TinhTrangDonHang` (`MaTTDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TinhTrangDonHang_has_DonHang_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java07_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java07_shopping`.`XuLyDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`XuLyDonHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`XuLyDonHang` (
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
