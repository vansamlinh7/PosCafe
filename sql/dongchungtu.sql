-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 24, 2021 lúc 04:18 AM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `fasttrack_cafe`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dongchungtu`
--

CREATE TABLE `dongchungtu` (
  `ID` int(11) NOT NULL COMMENT 'Khóa chính, tự phát sinh, không trùng lặp',
  `SoCT` varchar(7) NOT NULL COMMENT '	\r\nKhóa phụ',
  `MaSP` varchar(20) NOT NULL COMMENT '	\r\nKhóa phụ',
  `MaDVT` varchar(7) NOT NULL,
  `SoLuong` float NOT NULL,
  `DonGia` float NOT NULL,
  `GioVao` datetime NOT NULL,
  `GioRa` datetime NOT NULL,
  `TraLai` float NOT NULL,
  `Giam` float NOT NULL,
  `GhiChu` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `dongchungtu`
--
ALTER TABLE `dongchungtu`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
