-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2021 at 03:16 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlythuvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `authorNumber` varchar(50) NOT NULL,
  `authorName` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `queQuan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `bookId` varchar(50) NOT NULL,
  `bookTitle` varchar(50) NOT NULL,
  `authorName` varchar(50) NOT NULL,
  `XBlan` varchar(50) NOT NULL,
  `theLoai` varchar(50) NOT NULL,
  `namXB` date NOT NULL,
  `tap` varchar(50) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `soLuong` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookId`, `bookTitle`, `authorName`, `XBlan`, `theLoai`, `namXB`, `tap`, `price`, `soLuong`) VALUES
('1', 'quy thu morello', 'phap su', '1', 'lol', '2001-10-01', '1', '3000', '1'),
('2', 'mu phu thuy rabadon', 'phap su', '1', 'lollllll', '2020-01-01', '2', '3600', '1'),
('3', 'sung hai tac', 'missFortune', '1', 'lolllll', '2020-01-01', '1', '3000', '1');

-- --------------------------------------------------------

--
-- Table structure for table `card`
--

CREATE TABLE `card` (
  `cardNumber` varchar(50) NOT NULL,
  `ngayCapThe` date NOT NULL,
  `loaiThe` varchar(50) NOT NULL,
  `CMND` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

CREATE TABLE `chucvu` (
  `MSCV` varchar(50) NOT NULL,
  `tenCV` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `CMND` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Age` int(100) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `PhoneNumber` varchar(50) NOT NULL,
  `MSPM` varchar(50) DEFAULT NULL,
  `mathedoc` varchar(50) DEFAULT NULL,
  `mathemuon` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`CMND`, `Name`, `Age`, `Address`, `PhoneNumber`, `MSPM`, `mathedoc`, `mathemuon`) VALUES
('1', 'zed', 20, 'ilonia', 'aaaaaa', NULL, NULL, NULL),
('11', 'viego', 20, 'quan dao bong dem', '1111', NULL, 'ddddd', 'eeeeee'),
('12', 'ggg', 20, 'gg', 'a', NULL, NULL, 'gg'),
('2', 'vvvvv', 20, 'vvvvv', 'vvvvv', NULL, NULL, NULL),
('3', 'akali', 20, 'ilonia', 'aaaaaasdv', NULL, NULL, NULL),
('4', 'kennen', 20, 'ilonia', '2345678', NULL, NULL, NULL),
('5', 'shen', 20, 'ilonia', 'aaaaaasdvassdfg', NULL, NULL, NULL),
('7', 'b', 22, 'c', 'c', NULL, 'c', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `MSNV` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gioiTinh` varchar(50) NOT NULL,
  `ngaySinh` date NOT NULL,
  `address` varchar(50) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `queQuan` varchar(50) NOT NULL,
  `salary` decimal(10,0) NOT NULL,
  `maKho` varchar(50) DEFAULT NULL,
  `MSCV` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`MSNV`, `name`, `gioiTinh`, `ngaySinh`, `address`, `phoneNumber`, `queQuan`, `salary`, `maKho`, `MSCV`) VALUES
('1', 'daxua', 'poi', '2001-01-01', 'ilonia', '000111002', 'ilonia', '9999', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `kho`
--

CREATE TABLE `kho` (
  `maKho` varchar(50) NOT NULL,
  `tenKho` varchar(50) NOT NULL,
  `theLoai` varchar(50) NOT NULL,
  `MSPX` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ncc`
--

CREATE TABLE `ncc` (
  `maNCC` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fax` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phieugiaoca`
--

CREATE TABLE `phieugiaoca` (
  `MSPGC` varchar(50) NOT NULL,
  `ngay` date NOT NULL,
  `ca` varchar(50) NOT NULL,
  `maQTN` varchar(50) NOT NULL,
  `MSNV` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phieumuon`
--

CREATE TABLE `phieumuon` (
  `MSPM` varchar(50) NOT NULL,
  `NgayBD` date NOT NULL,
  `NgayKT` date NOT NULL,
  `tongTien` decimal(10,2) NOT NULL,
  `CMND` varchar(50) NOT NULL,
  `bookId` varchar(50) NOT NULL,
  `maQTN` varchar(50) NOT NULL,
  `MSNV` varchar(50) NOT NULL,
  `cardNumber` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MSPN` varchar(50) NOT NULL,
  `ngayNhap` date NOT NULL,
  `tongGiaTri` decimal(10,0) NOT NULL,
  `maNCC` varchar(50) NOT NULL,
  `MSNV` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MSPX` varchar(50) NOT NULL,
  `ngayXuat` date NOT NULL,
  `tongGiaTri` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `quaytn`
--

CREATE TABLE `quaytn` (
  `maQTN` varchar(50) NOT NULL,
  `tenQTN` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `thekho`
--

CREATE TABLE `thekho` (
  `maThe` varchar(50) NOT NULL,
  `ngayPhatSinh` date NOT NULL,
  `MSPN` varchar(50) NOT NULL,
  `MSPM` varchar(50) NOT NULL,
  `maKho` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`authorNumber`),
  ADD KEY `fk9` (`authorName`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bookId`),
  ADD KEY `theLoai` (`theLoai`),
  ADD KEY `authorName` (`authorName`);

--
-- Indexes for table `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`cardNumber`),
  ADD KEY `fk2` (`CMND`);

--
-- Indexes for table `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`MSCV`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`CMND`),
  ADD KEY `fk1` (`MSPM`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`MSNV`),
  ADD KEY `fk11` (`maKho`),
  ADD KEY `fk12` (`MSCV`);

--
-- Indexes for table `kho`
--
ALTER TABLE `kho`
  ADD PRIMARY KEY (`maKho`),
  ADD KEY `fk8` (`theLoai`),
  ADD KEY `fk10` (`MSPX`);

--
-- Indexes for table `ncc`
--
ALTER TABLE `ncc`
  ADD PRIMARY KEY (`maNCC`);

--
-- Indexes for table `phieugiaoca`
--
ALTER TABLE `phieugiaoca`
  ADD PRIMARY KEY (`MSPGC`),
  ADD KEY `fk13` (`MSNV`);

--
-- Indexes for table `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD PRIMARY KEY (`MSPM`),
  ADD KEY `fk3` (`maQTN`),
  ADD KEY `fk4` (`MSNV`),
  ADD KEY `fk5` (`bookId`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MSPN`),
  ADD KEY `fk14` (`MSNV`),
  ADD KEY `fk20` (`maNCC`);

--
-- Indexes for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`MSPX`);

--
-- Indexes for table `quaytn`
--
ALTER TABLE `quaytn`
  ADD PRIMARY KEY (`maQTN`);

--
-- Indexes for table `thekho`
--
ALTER TABLE `thekho`
  ADD PRIMARY KEY (`maThe`),
  ADD KEY `fk6` (`MSPM`),
  ADD KEY `fk19` (`MSPN`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `author`
--
ALTER TABLE `author`
  ADD CONSTRAINT `fk9` FOREIGN KEY (`authorName`) REFERENCES `book` (`authorName`) ON UPDATE CASCADE;

--
-- Constraints for table `card`
--
ALTER TABLE `card`
  ADD CONSTRAINT `fk2` FOREIGN KEY (`CMND`) REFERENCES `customers` (`CMND`) ON UPDATE CASCADE;

--
-- Constraints for table `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`MSPM`) REFERENCES `phieumuon` (`MSPM`) ON UPDATE CASCADE;

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fk11` FOREIGN KEY (`maKho`) REFERENCES `kho` (`maKho`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk12` FOREIGN KEY (`MSCV`) REFERENCES `chucvu` (`MSCV`) ON UPDATE CASCADE;

--
-- Constraints for table `kho`
--
ALTER TABLE `kho`
  ADD CONSTRAINT `fk10` FOREIGN KEY (`MSPX`) REFERENCES `phieuxuat` (`MSPX`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk8` FOREIGN KEY (`theLoai`) REFERENCES `book` (`theLoai`) ON UPDATE CASCADE;

--
-- Constraints for table `phieugiaoca`
--
ALTER TABLE `phieugiaoca`
  ADD CONSTRAINT `fk13` FOREIGN KEY (`MSNV`) REFERENCES `employee` (`MSNV`) ON UPDATE CASCADE;

--
-- Constraints for table `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD CONSTRAINT `fk3` FOREIGN KEY (`maQTN`) REFERENCES `quaytn` (`maQTN`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk4` FOREIGN KEY (`MSNV`) REFERENCES `employee` (`MSNV`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk5` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`) ON UPDATE CASCADE;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `fk14` FOREIGN KEY (`MSNV`) REFERENCES `employee` (`MSNV`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk20` FOREIGN KEY (`maNCC`) REFERENCES `ncc` (`maNCC`) ON UPDATE CASCADE;

--
-- Constraints for table `thekho`
--
ALTER TABLE `thekho`
  ADD CONSTRAINT `fk19` FOREIGN KEY (`MSPN`) REFERENCES `phieunhap` (`MSPN`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk6` FOREIGN KEY (`MSPM`) REFERENCES `phieumuon` (`MSPM`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
