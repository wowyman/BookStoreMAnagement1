-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2021 at 05:26 PM
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
  `soLuong` varchar(50) NOT NULL,
  `tenKho` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookId`, `bookTitle`, `authorName`, `XBlan`, `theLoai`, `namXB`, `tap`, `price`, `soLuong`, `tenKho`) VALUES
('1', 'quy thu morello', 'phap su', '1', 'lol', '2001-10-01', '1', '3000', '1', NULL),
('2', 'mu phu thuy rabadon', 'phap su', '1', 'lollllll', '2020-01-01', '2', '3600', '1', NULL),
('4', 'ssss', 'sssss', '1', 'sss', '2020-02-02', '1', '111', '1', '3');

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

--
-- Dumping data for table `chucvu`
--

INSERT INTO `chucvu` (`MSCV`, `tenCV`) VALUES
('2', 'chainsawman'),
('1', 'chairman');

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
('4', 'kennen', 20, 'ilonia', '2345678', NULL, NULL, NULL),
('5', 'shen', 20, 'ilonia', 'aaaaaasdvassdfg', NULL, NULL, NULL),
('7', 'b', 22, 'c', 'c', NULL, 'c', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `MSNV` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
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
('1', 'daxua', 'poi', '2001-01-01', 'ilonia', '000111002', 'ilonia', '9999', '2', NULL),
('2', 'ffff', 'nam', '2021-03-30', 'ffff', '2021-03-30', 'Viet Nam', '5555', '2', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `kho`
--

CREATE TABLE `kho` (
  `maKho` varchar(50) NOT NULL,
  `tenKho` varchar(50) NOT NULL,
  `theLoai` varchar(50) NOT NULL,
  `MSPX` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kho`
--

INSERT INTO `kho` (`maKho`, `tenKho`, `theLoai`, `MSPX`) VALUES
('1', '1', 'lol', NULL),
('2', '2', 'lollllll', NULL),
('3', '3', 'lolllll', NULL),
('4', '4', 'lollllll', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `USERID` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`USERID`, `pass`) VALUES
('user', '123');

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

--
-- Dumping data for table `ncc`
--

INSERT INTO `ncc` (`maNCC`, `name`, `address`, `phoneNumber`, `email`, `fax`) VALUES
('1', 'ffff', 'ffff', 'fff', 'ffff', 'ffff'),
('2', '222', '11222', '1122', '1112', '111222'),
('4', 'ccc', 'ccc', 'ccc', 'ccc', 'cccc');

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

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `quyensudung` varchar(50) NOT NULL,
  `tendangnhap` varchar(50) NOT NULL,
  `matkhau` varchar(50) NOT NULL,
  `tenCV` varchar(50) DEFAULT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`quyensudung`, `tendangnhap`, `matkhau`, `tenCV`, `name`) VALUES
('admin', 'aaa', 'aaa', 'chairman', 'ffff'),
('nhân viên', 'd', 'ddd', 'chairman', 'daxua'),
('nhân viên', 'dd', 'dd', 'chainsawman', 'ffff');

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
  ADD KEY `authorName` (`authorName`),
  ADD KEY `tenKho` (`tenKho`);

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
  ADD PRIMARY KEY (`MSCV`),
  ADD KEY `tenCV` (`tenCV`);

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
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `fk11` (`maKho`),
  ADD KEY `fk12` (`MSCV`);

--
-- Indexes for table `kho`
--
ALTER TABLE `kho`
  ADD PRIMARY KEY (`maKho`),
  ADD KEY `fk10` (`MSPX`),
  ADD KEY `tenKho` (`tenKho`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`USERID`);

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
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`tendangnhap`),
  ADD KEY `l` (`name`),
  ADD KEY `fff` (`tenCV`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `author`
--
ALTER TABLE `author`
  ADD CONSTRAINT `fk9` FOREIGN KEY (`authorName`) REFERENCES `book` (`authorName`) ON UPDATE CASCADE;

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `fk8` FOREIGN KEY (`tenKho`) REFERENCES `kho` (`tenKho`) ON UPDATE CASCADE;

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
  ADD CONSTRAINT `fk10` FOREIGN KEY (`MSPX`) REFERENCES `phieuxuat` (`MSPX`) ON UPDATE CASCADE;

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

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fff` FOREIGN KEY (`tenCV`) REFERENCES `chucvu` (`tenCV`) ON UPDATE CASCADE,
  ADD CONSTRAINT `l` FOREIGN KEY (`name`) REFERENCES `employee` (`name`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
