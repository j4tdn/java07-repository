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
-- Table `java07_shopping`.`PhongBan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`PhongBan` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`PhongBan` (
  `MaPB` INT NOT NULL,
  `TenPB` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaPB`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07_shopping`.`NhanVien`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`NhanVien` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`NhanVien` (
  `MaNV` INT NOT NULL,
  `HoTen` VARCHAR(255) NOT NULL,
  `SDT` VARCHAR(30) NOT NULL,
  `DiaChi` TEXT NOT NULL,
  `NgaySinh` DATE NOT NULL,
  `GioiTinh` BIT(1) NOT NULL,
  `MaPB` INT NOT NULL,
  PRIMARY KEY (`MaNV`, `MaPB`),
  INDEX `fk_NhanVien_PhongBan1_idx` (`MaPB` ASC) VISIBLE,
  CONSTRAINT `fk_NhanVien_PhongBan1`
    FOREIGN KEY (`MaPB`)
    REFERENCES `java07_shopping`.`PhongBan` (`MaPB`)
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
  `SDT` VARCHAR(30) NOT NULL,
  `DiaChi` TEXT NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `TaiKhoan` VARCHAR(255) NOT NULL,
  `MatKhau` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaKH`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07_shopping`.`LoaiHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`LoaiHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`LoaiHang` (
  `MaLoai` INT NOT NULL,
  `TenLoai` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLoai`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


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
  `MaLoai` INT NOT NULL,
  PRIMARY KEY (`MaMH`, `MaLoai`),
  INDEX `fk_MatHang_LoaiHang_idx` (`MaLoai` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_LoaiHang`
    FOREIGN KEY (`MaLoai`)
    REFERENCES `java07_shopping`.`LoaiHang` (`MaLoai`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07_shopping`.`LHTT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`LHTT` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`LHTT` (
  `MaLHTT` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLHTT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07_shopping`.`TTDH`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`TTDH` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`TTDH` (
  `MaTTDH` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaTTDH`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07_shopping`.`HoaDon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`HoaDon` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`HoaDon` (
  `MaHD` INT NOT NULL,
  `NgayXuat` DATE NOT NULL,
  `PhiVanChuyen` DOUBLE NOT NULL,
  `TongTien` DOUBLE NOT NULL,
  `MaNV` INT NOT NULL,
  PRIMARY KEY (`MaHD`, `MaNV`),
  INDEX `fk_HoaDon_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  CONSTRAINT `fk_HoaDon_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java07_shopping`.`NhanVien` (`MaNV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07_shopping`.`DonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`DonHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`DonHang` (
  `MaDH` INT NOT NULL,
  `DiaChiGiaoHang` TEXT NOT NULL,
  `SDTGiaoHang` VARCHAR(30) NOT NULL,
  `NgayDatHang` DATE NOT NULL,
  `MaNV` INT NOT NULL,
  `MaKH` INT NOT NULL,
  `MaLHTT` INT NOT NULL,
  `MaHD` INT NOT NULL,
  PRIMARY KEY (`MaDH`, `MaNV`, `MaKH`, `MaLHTT`, `MaHD`),
  INDEX `fk_DonHang_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  INDEX `fk_DonHang_KhachHang1_idx` (`MaKH` ASC) VISIBLE,
  INDEX `fk_DonHang_LHTT1_idx` (`MaLHTT` ASC) VISIBLE,
  INDEX `fk_DonHang_HoaDon1_idx` (`MaHD` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java07_shopping`.`NhanVien` (`MaNV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
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
  CONSTRAINT `fk_DonHang_HoaDon1`
    FOREIGN KEY (`MaHD`)
    REFERENCES `java07_shopping`.`HoaDon` (`MaHD`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07_shopping`.`GiaoHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`GiaoHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`GiaoHang` (
  `MaTTDH` INT NOT NULL,
  `MaDH` INT NOT NULL,
  `ThoiGian` DATE NOT NULL,
  PRIMARY KEY (`MaTTDH`, `MaDH`),
  INDEX `fk_TTDH_has_DonHang_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  INDEX `fk_TTDH_has_DonHang_TTDH1_idx` (`MaTTDH` ASC) VISIBLE,
  CONSTRAINT `fk_TTDH_has_DonHang_TTDH1`
    FOREIGN KEY (`MaTTDH`)
    REFERENCES `java07_shopping`.`TTDH` (`MaTTDH`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_TTDH_has_DonHang_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java07_shopping`.`DonHang` (`MaDH`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java07_shopping`.`XuLyDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java07_shopping`.`XuLyDonHang` ;

CREATE TABLE IF NOT EXISTS `java07_shopping`.`XuLyDonHang` (
  `MaMH` INT NOT NULL,
  `MaDH` INT NOT NULL,
  `SoLuong` INT NOT NULL,
  PRIMARY KEY (`MaMH`, `MaDH`),
  INDEX `fk_MatHang_has_DonHang_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  INDEX `fk_MatHang_has_DonHang_MatHang1_idx` (`MaMH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_has_DonHang_MatHang1`
    FOREIGN KEY (`MaMH`)
    REFERENCES `java07_shopping`.`MatHang` (`MaMH`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_MatHang_has_DonHang_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java07_shopping`.`DonHang` (`MaDH`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
