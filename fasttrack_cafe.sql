-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 15, 2021 at 04:40 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fasttrack-cafe`
--

-- --------------------------------------------------------

--
-- Table structure for table `Authorities`
--

CREATE TABLE `Authorities` (
  `authority_id` bigint(20) NOT NULL,
  `authority` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_locked` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Authorities`
--

INSERT INTO `Authorities` (`authority_id`, `authority`, `is_locked`) VALUES
(1, 'ROLE_ADMIN', 0);

-- --------------------------------------------------------

--
-- Table structure for table `BangGia`
--

CREATE TABLE `BangGia` (
  `ID` int(11) NOT NULL,
  `MaSP` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaBG` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DonGia` float NOT NULL,
  `Giam` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `BangGia`
--

INSERT INTO `BangGia` (`ID`, `MaSP`, `MaBG`, `DonGia`, `Giam`) VALUES
(1, '00001', 'BG1', 10000, 0),
(2, '00002', 'BG1', 12000, 0),
(3, '00003', 'BG1', 15000, 0),
(4, '00004', 'BG1', 20000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `DonViTinh`
--

CREATE TABLE `DonViTinh` (
  `MaDVT` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MacDinh` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `DonViTinh`
--

INSERT INTO `DonViTinh` (`MaDVT`, `MacDinh`) VALUES
('Hop', 0),
('Kg', 1);

-- --------------------------------------------------------

--
-- Table structure for table `DVTKhac`
--

CREATE TABLE `DVTKhac` (
  `ID` int(11) NOT NULL,
  `MaSP` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaDVT` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `QuyDoi` float NOT NULL,
  `isMenu` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `GroupSanPham`
--

CREATE TABLE `GroupSanPham` (
  `ID` int(11) NOT NULL,
  `MaSP` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenGroup` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `GroupSanPham`
--

INSERT INTO `GroupSanPham` (`ID`, `MaSP`, `TenGroup`) VALUES
(1, '00001', 'Cafe sữa');

-- --------------------------------------------------------

--
-- Table structure for table `LoaiBangGia`
--

CREATE TABLE `LoaiBangGia` (
  `MaBG` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenBG` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MacDinh` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `LoaiBangGia`
--

INSERT INTO `LoaiBangGia` (`MaBG`, `TenBG`, `MacDinh`) VALUES
('BG1', 'Bảng giá bán ngày thường', 1),
('BG2', 'Bảng giá ngày lễ', 0),
('BG3', 'Bảng giá ngày tết', 0);

-- --------------------------------------------------------

--
-- Table structure for table `NhomDonViSP`
--

CREATE TABLE `NhomDonViSP` (
  `ID` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNhom` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `NhomDonViSP`
--

INSERT INTO `NhomDonViSP` (`ID`, `TenNhom`) VALUES
('00001', 'Coffee sữa'),
('00004', 'Coffee muối');

-- --------------------------------------------------------

--
-- Table structure for table `NhomHang`
--

CREATE TABLE `NhomHang` (
  `MaNhom` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaCha` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNhom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LoaiNhom` tinyint(4) NOT NULL COMMENT '	\r\n0 – hàng hóa, 1 – nguyên liệu, 2 – sản phẩm chế biến, 3 – dịch vụ tính theo giờ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `NhomHang`
--

INSERT INTO `NhomHang` (`MaNhom`, `MaCha`, `TenNhom`, `LoaiNhom`) VALUES
('00000', '', 'Dịch Vụ', 1),
('00001', '', 'Sản phẩm', 1),
('00002', '00001', 'Coffe', 1),
('00003', '00001', 'Trà sữa', 1),
('00004', '00001', 'Kem', 1),
('00005', '00001', 'Ăn vặt', 1);

-- --------------------------------------------------------

--
-- Table structure for table `SanPham`
--

CREATE TABLE `SanPham` (
  `MaSP` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNhom` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `GroupID` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MaDVT` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SLDK` float NOT NULL COMMENT '	\r\nSố lượng tồn kho đầu kỳ',
  `GTDK` float NOT NULL COMMENT '	\r\nGiá vốn tồn kho đầu kỳ',
  `TrangThai` tinyint(4) NOT NULL DEFAULT 1,
  `isMenu` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `SanPham`
--

INSERT INTO `SanPham` (`MaSP`, `MaNhom`, `TenSP`, `GroupID`, `MaDVT`, `SLDK`, `GTDK`, `TrangThai`, `isMenu`) VALUES
('00001', '00002', 'Coffee sữa Size L', '00001', 'ly', 100, 100000, 1, 1),
('00002', '00002', 'Coffee sữa Size M', '00001', 'ly', 100, 100000, 1, 1),
('00003', '00002', 'Coffee sài gòn', '00003', 'ly', 100, 100000, 1, 1),
('00004', '00002', 'Coffee muối Size L', '00004', 'ly', 100, 100000, 1, 1),
('00005', '00002', 'Coffee muối Size M', '00004', 'ly', 100, 100000, 1, 1),
('00006', '00003', 'Trà sữa trân châu đường đen', '00006', 'ly', 100, 100000, 1, 1),
('00007', '00003', 'Trà sữa kem chese', '00007', 'ly', 100, 100000, 1, 1),
('00008', '00003', 'Trà sữa thạch dâu', '00008', 'ly', 100, 100000, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `ThanhPhan`
--

CREATE TABLE `ThanhPhan` (
  `ID` int(11) NOT NULL,
  `MaSP` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaDVT` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaTP` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaDVTTP` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ThuocTinh`
--

CREATE TABLE `ThuocTinh` (
  `ID` int(11) NOT NULL,
  `TenThuocTinh` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ThuocTinh`
--

INSERT INTO `ThuocTinh` (`ID`, `TenThuocTinh`) VALUES
(1, 'Kích thước');

-- --------------------------------------------------------

--
-- Table structure for table `ThuocTinhSanPham`
--

CREATE TABLE `ThuocTinhSanPham` (
  `MaThuocTinh` int(11) NOT NULL,
  `MaSP` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ThuocTinhSanPham`
--

INSERT INTO `ThuocTinhSanPham` (`MaThuocTinh`, `MaSP`) VALUES
(1, '00001'),
(1, '00002'),
(1, '00004'),
(1, '00005');

-- --------------------------------------------------------

--
-- Table structure for table `UserAuthorities`
--

CREATE TABLE `UserAuthorities` (
  `user_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `UserAuthorities`
--

INSERT INTO `UserAuthorities` (`user_id`, `authority_id`) VALUES
(1, 1),
(2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `user_id` bigint(20) NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `account_expired` tinyint(1) NOT NULL,
  `account_locked` tinyint(1) NOT NULL,
  `credentials_expired` tinyint(1) NOT NULL,
  `has_avatar` tinyint(1) NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`user_id`, `username`, `email`, `first_name`, `last_name`, `enabled`, `account_expired`, `account_locked`, `credentials_expired`, `has_avatar`, `password`) VALUES
(1, 'longtran', 'tranhuulongcit@gmail.com', 'Long', 'Tran', 1, 0, 0, 0, 1, '$2a$10$5KM.7hvmyImWGClcwkwp1.MK8HttgJEOYvo4khJk65xetnGVlsxz.'),
(2, 'fasttrack', 'tranhuulongcit@gmail.com', 'Long', 'Tran', 1, 0, 0, 0, 1, '$2a$10$cDw0Q32f3IkBWXwbGTTJ5ehe7b.u1hbqWyMQ3SSsvqEIRWUrVGkhe');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Authorities`
--
ALTER TABLE `Authorities`
  ADD PRIMARY KEY (`authority_id`);

--
-- Indexes for table `BangGia`
--
ALTER TABLE `BangGia`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `DonViTinh`
--
ALTER TABLE `DonViTinh`
  ADD PRIMARY KEY (`MaDVT`);

--
-- Indexes for table `DVTKhac`
--
ALTER TABLE `DVTKhac`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `GroupSanPham`
--
ALTER TABLE `GroupSanPham`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `LoaiBangGia`
--
ALTER TABLE `LoaiBangGia`
  ADD PRIMARY KEY (`MaBG`);

--
-- Indexes for table `NhomDonViSP`
--
ALTER TABLE `NhomDonViSP`
  ADD PRIMARY KEY (`ID`) USING BTREE;

--
-- Indexes for table `NhomHang`
--
ALTER TABLE `NhomHang`
  ADD PRIMARY KEY (`MaNhom`);

--
-- Indexes for table `SanPham`
--
ALTER TABLE `SanPham`
  ADD PRIMARY KEY (`MaSP`);

--
-- Indexes for table `ThanhPhan`
--
ALTER TABLE `ThanhPhan`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ThuocTinh`
--
ALTER TABLE `ThuocTinh`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ThuocTinhSanPham`
--
ALTER TABLE `ThuocTinhSanPham`
  ADD PRIMARY KEY (`MaThuocTinh`,`MaSP`) USING BTREE;

--
-- Indexes for table `UserAuthorities`
--
ALTER TABLE `UserAuthorities`
  ADD PRIMARY KEY (`user_id`,`authority_id`) USING BTREE;

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`,`email`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `BangGia`
--
ALTER TABLE `BangGia`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `DVTKhac`
--
ALTER TABLE `DVTKhac`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `GroupSanPham`
--
ALTER TABLE `GroupSanPham`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `ThanhPhan`
--
ALTER TABLE `ThanhPhan`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ThuocTinh`
--
ALTER TABLE `ThuocTinh`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
