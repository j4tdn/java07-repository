-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: java07_shopping
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donhang` (
  `MaDH` int(11) NOT NULL,
  `DiaChiGiaoHang` text NOT NULL,
  `SoDTGiaoHang` varchar(255) NOT NULL,
  `NgayDatHang` date NOT NULL,
  `MaLHTT` int(11) NOT NULL,
  `MaKH` int(11) NOT NULL,
  PRIMARY KEY (`MaDH`),
  KEY `fk_DonHang_LHTT1_idx` (`MaLHTT`),
  KEY `fk_DonHang_KhachHang1_idx` (`MaKH`),
  CONSTRAINT `FK_DonHang_KhachHang` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_DonHang_LHTT` FOREIGN KEY (`MaLHTT`) REFERENCES `lhtt` (`MaLHTT`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
INSERT INTO `donhang` VALUES (1,'74 Nguyễn Đình Trọng - Đà nẵng','0325 363 125','2020-11-18',1,1),(2,'68 Nam Cao - Hòa Khánh','0214 3256 321','2020-11-16',1,2),(3,'98 Hoàng Hoa Thám - Đà nẵng','0258 369 147','2020-11-17',1,3);
/*!40000 ALTER TABLE `donhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giaohang`
--

DROP TABLE IF EXISTS `giaohang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giaohang` (
  `MaDH` int(11) NOT NULL,
  `MaTTDH` int(11) NOT NULL,
  `ThoiGian` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`MaDH`,`MaTTDH`),
  KEY `fk_DonHang_has_TTDH_TTDH1_idx` (`MaTTDH`),
  KEY `fk_DonHang_has_TTDH_DonHang1_idx` (`MaDH`),
  CONSTRAINT `FK_GiaoHang_DonHang` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_GiaoHang_TTDH` FOREIGN KEY (`MaTTDH`) REFERENCES `ttdh` (`MaTTDH`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giaohang`
--

LOCK TABLES `giaohang` WRITE;
/*!40000 ALTER TABLE `giaohang` DISABLE KEYS */;
INSERT INTO `giaohang` VALUES (1,1,'2020-11-21 13:32:44'),(1,2,'2020-11-21 17:32:44'),(1,3,'2020-11-22 08:32:44'),(2,1,'2020-11-20 08:32:44');
/*!40000 ALTER TABLE `giaohang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `MaHD` int(11) NOT NULL,
  `NgayXuat` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `PhiVanChuyen` float NOT NULL,
  `TongTien` float NOT NULL,
  `MaDH` int(11) NOT NULL,
  PRIMARY KEY (`MaHD`),
  KEY `fk_HoaDon_DonHang1_idx` (`MaDH`),
  CONSTRAINT `FK_HoaDon_DonHang` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `MaKH` int(11) NOT NULL,
  `TenKH` varchar(255) NOT NULL,
  `SoDienThoai` varchar(255) NOT NULL,
  `DiaChi` text NOT NULL,
  `Email` varchar(255) NOT NULL,
  `TaiKhoan` varchar(30) NOT NULL,
  `MatKhau` varchar(30) NOT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'Lê Văn Khách','0236 565 232','Nam Cao - Đà Nẵng','levankhach@gmail.com','khachle','******'),(2,'Lê Văn Hàng','0547 896 569','Lê Giao - Đà nẵng','levanhang@gmail.com','hangle','******'),(3,'Lê Khách Hàng','0458 363 251','Tôn Đức Thắng - Đà nẵng','lekhachhang@gmail.com','khle','******');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lhtt`
--

DROP TABLE IF EXISTS `lhtt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lhtt` (
  `MaLHTT` int(11) NOT NULL,
  `MoTa` varchar(255) NOT NULL,
  PRIMARY KEY (`MaLHTT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lhtt`
--

LOCK TABLES `lhtt` WRITE;
/*!40000 ALTER TABLE `lhtt` DISABLE KEYS */;
INSERT INTO `lhtt` VALUES (1,'Tiền mặt'),(2,'ATM nội địa'),(3,'ATM Quốc Tế'),(4,'Master card');
/*!40000 ALTER TABLE `lhtt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaihang`
--

DROP TABLE IF EXISTS `loaihang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaihang` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(255) NOT NULL,
  PRIMARY KEY (`MaLoai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaihang`
--

LOCK TABLES `loaihang` WRITE;
/*!40000 ALTER TABLE `loaihang` DISABLE KEYS */;
INSERT INTO `loaihang` VALUES (1,'Áo'),(2,'Quần'),(3,'Giày dép'),(4,'Thắt lưng'),(5,'Mũ,Nón');
/*!40000 ALTER TABLE `loaihang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mathang`
--

DROP TABLE IF EXISTS `mathang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mathang` (
  `MaMH` int(11) NOT NULL,
  `TenMH` varchar(255) NOT NULL,
  `GiaMua` float NOT NULL,
  `GiaBan` float NOT NULL,
  `MauSac` varchar(255) NOT NULL,
  `KichCo` varchar(30) NOT NULL,
  `MoTa` text,
  `SoLuong` int(11) NOT NULL,
  `MaLoai` int(11) NOT NULL,
  PRIMARY KEY (`MaMH`),
  KEY `fk_MatHang_LoaiHang1_idx` (`MaLoai`),
  CONSTRAINT `FK_MatHang_LoaiHang` FOREIGN KEY (`MaLoai`) REFERENCES `loaihang` (`MaLoai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mathang`
--

LOCK TABLES `mathang` WRITE;
/*!40000 ALTER TABLE `mathang` DISABLE KEYS */;
INSERT INTO `mathang` VALUES (1,'Áo sơ mi Nam',220,240,'Trắng','M',NULL,20,1),(2,'Áo sơ mi Nữ',180,260,'Xanh','XL',NULL,20,1),(3,'Quần tây Nam',350,390,'Trắng','M',NULL,40,2),(4,'Quần jean Nam',320,399,'Xanh','L',NULL,50,2),(5,'Quần jean Nữ',320,349,'Nâu','M',NULL,30,2),(6,'Giày thế thao Nam',1000,1200,'Trắng','XXL',NULL,28,3),(7,'Giày da Nữ',600,850,'Xanh','M',NULL,40,3),(8,'Thắt lưng Nam',100,179,'Trắng','L',NULL,120,4),(9,'Thắt lưng Nữ',200,240,'Nâu','M',NULL,60,4),(10,'Mũ thể thao Nam',80,129,'Đen','M',NULL,90,5);
/*!40000 ALTER TABLE `mathang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `MaNV` int(11) NOT NULL,
  `HoTen` varchar(255) NOT NULL,
  `SoDienThoai` varchar(255) NOT NULL,
  `DiaChi` text NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` bit(1) NOT NULL,
  `MaPB` int(11) NOT NULL,
  PRIMARY KEY (`MaNV`),
  KEY `FK_NhanVien_PhongBan_idx` (`MaPB`),
  CONSTRAINT `FK_NhanVien_PhongBan` FOREIGN KEY (`MaPB`) REFERENCES `phongban` (`MaPB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Lê Na','0396 978 012','Hòa Khánh - Đà nẵng','1990-02-17',_binary '',1),(2,'Văn Cao','0563 525 684','Hòa Khánh - Đà nẵng','1992-03-27',_binary '',1),(3,'Lê Tèo','0396 978 215','Hòa Khánh - Đà nẵng','1992-03-27',_binary '',1),(4,'Hoàng Bửu','0123 594 753','Nam Cao - Đà nẵng','1992-03-27',_binary '',2),(5,'Ngọc Thành','0164 745 358','Nam Cao - Đà nẵng','1992-03-27',_binary '',2),(6,'Công Danh','0563 325 777','Nam Cao - Đà nẵng','1992-03-27',_binary '',2),(7,'Văn Hoàng','0311 968 215','Lê Độ - Đà nẵng','1992-03-27',_binary '',3),(8,'Minh Lê','0302 978 215','Lê Độ - Đà nẵng','1992-03-27',_binary '',3),(9,'Bảo Lộc','0563 102 369','Âu Cơ - Đà nẵng','1992-03-27',_binary '',4),(10,'Hoàng Nam','0967 525 222','Âu Cơ - Đà nẵng','1992-03-27',_binary '',4);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phongban`
--

DROP TABLE IF EXISTS `phongban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phongban` (
  `MaPB` int(11) NOT NULL,
  `TenPB` varchar(255) NOT NULL,
  PRIMARY KEY (`MaPB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phongban`
--

LOCK TABLES `phongban` WRITE;
/*!40000 ALTER TABLE `phongban` DISABLE KEYS */;
INSERT INTO `phongban` VALUES (1,'Bộ phận quản lý'),(2,'Bộ phận nhân sự'),(3,'Bộ phận bảo vệ'),(4,'Bộ phận giao hàng');
/*!40000 ALTER TABLE `phongban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ttdh`
--

DROP TABLE IF EXISTS `ttdh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ttdh` (
  `MaTTDH` int(11) NOT NULL,
  `MoTa` varchar(255) NOT NULL,
  PRIMARY KEY (`MaTTDH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ttdh`
--

LOCK TABLES `ttdh` WRITE;
/*!40000 ALTER TABLE `ttdh` DISABLE KEYS */;
INSERT INTO `ttdh` VALUES (1,'Đã nhận thông tin đơn hàng'),(2,'Đang đóng gói'),(3,'Đã đóng gói'),(4,'Đang giao hàng'),(5,'Đã nhận hàng');
/*!40000 ALTER TABLE `ttdh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xulydonhang`
--

DROP TABLE IF EXISTS `xulydonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xulydonhang` (
  `MaDH` int(11) NOT NULL,
  `MaMH` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  PRIMARY KEY (`MaDH`,`MaMH`),
  KEY `fk_DonHang_has_MatHang_MatHang1_idx` (`MaMH`),
  KEY `fk_DonHang_has_MatHang_DonHang1_idx` (`MaDH`),
  CONSTRAINT `FK_XuLyDonHang_DonHang` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_XuLyDonHang_MatHang` FOREIGN KEY (`MaMH`) REFERENCES `mathang` (`MaMH`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xulydonhang`
--

LOCK TABLES `xulydonhang` WRITE;
/*!40000 ALTER TABLE `xulydonhang` DISABLE KEYS */;
INSERT INTO `xulydonhang` VALUES (1,1,1),(1,3,2),(1,4,3),(2,6,2),(2,8,1);
/*!40000 ALTER TABLE `xulydonhang` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-15 16:47:42
