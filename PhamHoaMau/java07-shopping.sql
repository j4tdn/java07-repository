-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema java07-shopping
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema java07-shopping
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `java07-shopping` DEFAULT CHARACTER SET utf8 ;
USE `java07-shopping` ;

-- -----------------------------------------------------
-- Table `java07-shopping`.`KHACHHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07-shopping`.`KHACHHANG` ;

CREATE TABLE IF NOT EXISTS `java07-shopping`.`KHACHHANG` (
  `Makh` INT NOT NULL,
  `TenKH` VARCHAR(255) NOT NULL,
  `SDT` VARCHAR(30) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `TaiKhoan` VARCHAR(255) NOT NULL,
  `MatKhau` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Makh`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07-shopping`.`LOAIHINHTHANHTOAN`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07-shopping`.`LOAIHINHTHANHTOAN` ;

CREATE TABLE IF NOT EXISTS `java07-shopping`.`LOAIHINHTHANHTOAN` (
  `MaLHTT` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLHTT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07-shopping`.`PHONGBAN`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07-shopping`.`PHONGBAN` ;

CREATE TABLE IF NOT EXISTS `java07-shopping`.`PHONGBAN` (
  `MaPB` INT NOT NULL,
  `TenPB` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaPB`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07-shopping`.`NHANVIEN`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07-shopping`.`NHANVIEN` ;

CREATE TABLE IF NOT EXISTS `java07-shopping`.`NHANVIEN` (
  `MaNV` INT NOT NULL,
  `HoTen` VARCHAR(255) NOT NULL,
  `SoDT` VARCHAR(30) NOT NULL,
  `DiaChi` TEXT NOT NULL,
  `NgaySinh` DATE NOT NULL,
  `GioiTinh` BIT(1) NOT NULL,
  `MaPB` INT NOT NULL,
  PRIMARY KEY (`MaNV`, `MaPB`),
  INDEX `fk_NHANVIEN_PHONGBAN_idx` (`MaPB` ASC) VISIBLE,
  CONSTRAINT `FK_NHANVIEN_PHONGBAN`
    FOREIGN KEY (`MaPB`)
    REFERENCES `java07-shopping`.`PHONGBAN` (`MaPB`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07-shopping`.`DONHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07-shopping`.`DONHANG` ;

CREATE TABLE IF NOT EXISTS `java07-shopping`.`DONHANG` (
  `MaDH` INT NOT NULL,
  `DiaChiGH` VARCHAR(255) NOT NULL,
  `SDTGH` VARCHAR(255) NOT NULL,
  `NgayDatHang` DATE NOT NULL,
  `MaKH` INT NOT NULL,
  `MaLHTT` INT NOT NULL,
  `MaNV` INT NOT NULL,
  `MaPB` INT NOT NULL,
  PRIMARY KEY (`MaDH`, `MaKH`, `MaLHTT`, `MaNV`, `MaPB`),
  INDEX `fk_DONHANG_KHACHHANG1_idx` (`MaKH` ASC) VISIBLE,
  INDEX `fk_DONHANG_LOAIHINHTHANHTOAN1_idx` (`MaLHTT` ASC) VISIBLE,
  INDEX `fk_DONHANG_NHANVIEN1_idx` (`MaNV` ASC, `MaPB` ASC) VISIBLE,
  CONSTRAINT `FK_DONHANG_KHACHHANG`
    FOREIGN KEY (`MaKH`)
    REFERENCES `java07-shopping`.`KHACHHANG` (`Makh`),
  CONSTRAINT `FK_DONHANG_LHTT`
    FOREIGN KEY (`MaLHTT`)
    REFERENCES `java07-shopping`.`LOAIHINHTHANHTOAN` (`MaLHTT`),
  CONSTRAINT `fk_DONHANG_NHANVIEN1`
    FOREIGN KEY (`MaNV` , `MaPB`)
    REFERENCES `java07-shopping`.`NHANVIEN` (`MaNV` , `MaPB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07-shopping`.`TRINHTRANGDONHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07-shopping`.`TRINHTRANGDONHANG` ;

CREATE TABLE IF NOT EXISTS `java07-shopping`.`TRINHTRANGDONHANG` (
  `MaTTDH` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaTTDH`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07-shopping`.`GIAOHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07-shopping`.`GIAOHANG` ;

CREATE TABLE IF NOT EXISTS `java07-shopping`.`GIAOHANG` (
  `MaDh` INT NOT NULL,
  `MaTTDH` INT NOT NULL,
  `ThoiGian` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`MaDh`, `MaTTDH`),
  INDEX `fk_DONHANG_has_TINHTRANGDONHANG_TINHTRANGDONHANG1_idx` (`MaTTDH` ASC) VISIBLE,
  INDEX `fk_DONHANG_has_TINHTRANGDONHANG_DONHANG1_idx` (`MaDh` ASC) VISIBLE,
  CONSTRAINT `fk_DONHANG_has_TINHTRANGDONHANG_DONHANG1`
    FOREIGN KEY (`MaDh`)
    REFERENCES `java07-shopping`.`DONHANG` (`MaDH`),
  CONSTRAINT `fk_DONHANG_has_TINHTRANGDONHANG_TINHTRANGDONHANG1`
    FOREIGN KEY (`MaTTDH`)
    REFERENCES `java07-shopping`.`TRINHTRANGDONHANG` (`MaTTDH`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07-shopping`.`HOADON`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07-shopping`.`HOADON` ;

CREATE TABLE IF NOT EXISTS `java07-shopping`.`HOADON` (
  `MaHD` INT NOT NULL,
  `NgayXuat` DATE NOT NULL,
  `PhiVC` DOUBLE NOT NULL,
  `TongTien` DOUBLE NOT NULL,
  `MaDH` INT NOT NULL,
  `MaNV` INT NOT NULL,
  `MaPB` INT NOT NULL,
  PRIMARY KEY (`MaHD`, `MaDH`, `MaNV`, `MaPB`),
  INDEX `fk_HOADON_DONHANG1_idx` (`MaDH` ASC) VISIBLE,
  INDEX `fk_HOADON_NHANVIEN1_idx` (`MaNV` ASC, `MaPB` ASC) VISIBLE,
  CONSTRAINT `FK_HOADON_DONHANG`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java07-shopping`.`DONHANG` (`MaDH`),
  CONSTRAINT `fk_HOADON_NHANVIEN1`
    FOREIGN KEY (`MaNV` , `MaPB`)
    REFERENCES `java07-shopping`.`NHANVIEN` (`MaNV` , `MaPB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07-shopping`.`LOAIHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07-shopping`.`LOAIHANG` ;

CREATE TABLE IF NOT EXISTS `java07-shopping`.`LOAIHANG` (
  `MaLoai` INT NOT NULL,
  `TenLoai` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLoai`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07-shopping`.`MATHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07-shopping`.`MATHANG` ;

CREATE TABLE IF NOT EXISTS `java07-shopping`.`MATHANG` (
  `MaMH` INT NOT NULL,
  `TenMH` VARCHAR(255) NOT NULL,
  `GiaMua` DOUBLE NOT NULL,
  `GiaBan` DOUBLE NOT NULL,
  `MauSac` VARCHAR(45) NOT NULL,
  `KichCo` VARCHAR(45) NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  `SoLuong` INT NOT NULL,
  `MATHANGcol` VARCHAR(45) NOT NULL,
  `MaLoai` INT NOT NULL,
  PRIMARY KEY (`MaMH`, `MaLoai`),
  INDEX `fk_MATHANG_LOAIHANG1_idx` (`MaLoai` ASC) VISIBLE,
  CONSTRAINT `FK_MATHANG_MALOAI`
    FOREIGN KEY (`MaLoai`)
    REFERENCES `java07-shopping`.`LOAIHANG` (`MaLoai`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07-shopping`.`XULYDONHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07-shopping`.`XULYDONHANG` ;

CREATE TABLE IF NOT EXISTS `java07-shopping`.`XULYDONHANG` (
  `MaDH` INT NOT NULL,
  `MaKH` INT NOT NULL,
  `SoLuong` INT NOT NULL,
  PRIMARY KEY (`MaDH`, `MaKH`),
  INDEX `fk_DONHANG_has_MATHANG_MATHANG1_idx` (`MaKH` ASC) VISIBLE,
  INDEX `fk_DONHANG_has_MATHANG_DONHANG1_idx` (`MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_DONHANG_has_MATHANG_DONHANG1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java07-shopping`.`DONHANG` (`MaDH`),
  CONSTRAINT `fk_DONHANG_has_MATHANG_MATHANG1`
    FOREIGN KEY (`MaKH`)
    REFERENCES `java07-shopping`.`MATHANG` (`MaMH`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
