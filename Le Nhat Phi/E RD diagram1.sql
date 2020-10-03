-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`PHONGBAN`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PHONGBAN` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PHONGBAN` (
  `MaPB` INT NOT NULL,
  `TenPB` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaPB`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`NHANVIEN`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`NHANVIEN` ;

CREATE TABLE IF NOT EXISTS `mydb`.`NHANVIEN` (
  `MaNV` INT NOT NULL,
  `HoTen` VARCHAR(255) NOT NULL,
  `SoDT` VARCHAR(30) NOT NULL,
  `DiaChi` TEXT NOT NULL,
  `NgaySinh` DATE NOT NULL,
  `GioiTinh` BIT(1) NOT NULL,
  `MaPB` INT NOT NULL,
  PRIMARY KEY (`MaNV`, `MaPB`),
  CONSTRAINT `FK_NHANVIEN_PHONGBAN`
    FOREIGN KEY (`MaPB`)
    REFERENCES `mydb`.`PHONGBAN` (`MaPB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_NHANVIEN_PHONGBAN_idx` ON `mydb`.`NHANVIEN` (`MaPB` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`KHACHHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`KHACHHANG` ;

CREATE TABLE IF NOT EXISTS `mydb`.`KHACHHANG` (
  `Makh` INT NOT NULL,
  `TenKH` VARCHAR(255) NOT NULL,
  `SDT` VARCHAR(30) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `TaiKhoan` VARCHAR(255) NOT NULL,
  `MatKhau` VARCHAR(255) NULL,
  PRIMARY KEY (`Makh`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`LOAIHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LOAIHANG` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LOAIHANG` (
  `MaLoai` INT NOT NULL,
  `TenLoai` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLoai`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`MATHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`MATHANG` ;

CREATE TABLE IF NOT EXISTS `mydb`.`MATHANG` (
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
  CONSTRAINT `FK_MATHANG_MALOAI`
    FOREIGN KEY (`MaLoai`)
    REFERENCES `mydb`.`LOAIHANG` (`MaLoai`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_MATHANG_LOAIHANG1_idx` ON `mydb`.`MATHANG` (`MaLoai` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`LOAIHINHTHANHTOAN`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LOAIHINHTHANHTOAN` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LOAIHINHTHANHTOAN` (
  `MaLHTT` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLHTT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`DONHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DONHANG` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DONHANG` (
  `MaDH` INT NOT NULL,
  `DiaChiGH` VARCHAR(255) NOT NULL,
  `SDTGH` VARCHAR(255) NOT NULL,
  `NgayDatHang` DATE NOT NULL,
  `MaKH` INT NOT NULL,
  `MaLHTT` INT NOT NULL,
  PRIMARY KEY (`MaDH`, `MaKH`, `MaLHTT`),
  CONSTRAINT `FK_DONHANG_KHACHHANG`
    FOREIGN KEY (`MaKH`)
    REFERENCES `mydb`.`KHACHHANG` (`Makh`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_DONHANG_LHTT`
    FOREIGN KEY (`MaLHTT`)
    REFERENCES `mydb`.`LOAIHINHTHANHTOAN` (`MaLHTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_DONHANG_KHACHHANG1_idx` ON `mydb`.`DONHANG` (`MaKH` ASC) VISIBLE;

CREATE INDEX `fk_DONHANG_LOAIHINHTHANHTOAN1_idx` ON `mydb`.`DONHANG` (`MaLHTT` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`HOADON`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`HOADON` ;

CREATE TABLE IF NOT EXISTS `mydb`.`HOADON` (
  `MaHD` INT NOT NULL,
  `NgayXuat` DATE NOT NULL,
  `PhiVC` DOUBLE NOT NULL,
  `TongTien` DOUBLE NOT NULL,
  `MaDH` INT NOT NULL,
  PRIMARY KEY (`MaHD`, `MaDH`),
  CONSTRAINT `FK_HOADON_DONHANG`
    FOREIGN KEY (`MaDH`)
    REFERENCES `mydb`.`DONHANG` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_HOADON_DONHANG1_idx` ON `mydb`.`HOADON` (`MaDH` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`TINHTRANGDONHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TINHTRANGDONHANG` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TINHTRANGDONHANG` (
  `MaTTDH` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaTTDH`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`GiaoHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`GiaoHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`GiaoHang` (
  `MaDh` INT NOT NULL,
  `MaTTDH` INT NOT NULL,
  `ThoiGian` DATE NULL,
  PRIMARY KEY (`MaDh`, `MaTTDH`),
  CONSTRAINT `fk_DONHANG_has_TINHTRANGDONHANG_DONHANG1`
    FOREIGN KEY (`MaDh`)
    REFERENCES `mydb`.`DONHANG` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DONHANG_has_TINHTRANGDONHANG_TINHTRANGDONHANG1`
    FOREIGN KEY (`MaTTDH`)
    REFERENCES `mydb`.`TINHTRANGDONHANG` (`MaTTDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_DONHANG_has_TINHTRANGDONHANG_TINHTRANGDONHANG1_idx` ON `mydb`.`GiaoHang` (`MaTTDH` ASC) VISIBLE;

CREATE INDEX `fk_DONHANG_has_TINHTRANGDONHANG_DONHANG1_idx` ON `mydb`.`GiaoHang` (`MaDh` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`XULYDONHANG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`XULYDONHANG` ;

CREATE TABLE IF NOT EXISTS `mydb`.`XULYDONHANG` (
  `MaDH` INT NOT NULL,
  `MaKH` INT NOT NULL,
  `SoLuong` INT NOT NULL,
  PRIMARY KEY (`MaDH`, `MaKH`),
  CONSTRAINT `fk_DONHANG_has_MATHANG_DONHANG1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `mydb`.`DONHANG` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DONHANG_has_MATHANG_MATHANG1`
    FOREIGN KEY (`MaKH`)
    REFERENCES `mydb`.`MATHANG` (`MaMH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_DONHANG_has_MATHANG_MATHANG1_idx` ON `mydb`.`XULYDONHANG` (`MaKH` ASC) VISIBLE;

CREATE INDEX `fk_DONHANG_has_MATHANG_DONHANG1_idx` ON `mydb`.`XULYDONHANG` (`MaDH` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
