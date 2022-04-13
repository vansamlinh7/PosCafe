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
-- Cấu trúc bảng cho bảng `chungtu`
--

CREATE TABLE `chungtu` (
  `SoCT` varchar(7) NOT NULL COMMENT 'Khóa chính, tự phát sinh, không trùng lặp',
  `NgayCT` datetime NOT NULL,
  `Loai` tinyint(4) NOT NULL COMMENT '0 – nhập, 1 – xuất, 2 – bán lẻ, 3 – thu, 4 – chi, 5 – đơn đặt hàng',
  `SoBan` varchar(5) NOT NULL,
  `MaKH` varchar(7) NOT NULL,
  `SoKhach` int(11) NOT NULL,
  `NoiDung` varchar(225) NOT NULL,
  `MaThuNgan` varchar(5) NOT NULL,
  `MaNhanVien` varchar(5) NOT NULL,
  `Giam` float NOT NULL,
  `ThueVAT` float NOT NULL,
  `PhiPV` float NOT NULL,
  `Sotien` float NOT NULL,
  `Tratruoc` float NOT NULL,
  `ConNo` float NOT NULL,
  `NgayDat` datetime NOT NULL,
  `TrangThai` tinyint(4) NOT NULL COMMENT '	\r\n0 – đơn hàng/ bill chưa in; 1 – đã thanh toán'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chungtu`
--
ALTER TABLE `chungtu`
  ADD PRIMARY KEY (`SoCT`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
