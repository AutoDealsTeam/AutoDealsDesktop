-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2024 at 09:28 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_autodeals2`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_cicilan`
--

CREATE TABLE `tb_cicilan` (
  `id_cicilan` varchar(20) CHARACTER SET utf8mb4 NOT NULL,
  `bunga` double NOT NULL,
  `id_pembayaran` varchar(20) CHARACTER SET utf8mb4 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cicilan`
--

INSERT INTO `tb_cicilan` (`id_cicilan`, `bunga`, `id_pembayaran`) VALUES
('BC001', 24, 'P02');

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_cicilan`
--

CREATE TABLE `tb_detail_cicilan` (
  `kode_bayar` int(11) NOT NULL,
  `bulan` int(11) NOT NULL,
  `angsuran_bunga` int(11) NOT NULL,
  `angsuran_pokok` int(11) NOT NULL,
  `total_angsuran` int(11) NOT NULL,
  `sisa_cicilan` int(11) NOT NULL,
  `status` enum('Bayar','Belum') NOT NULL,
  `id_konfirmasi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_detail_cicilan`
--

INSERT INTO `tb_detail_cicilan` (`kode_bayar`, `bulan`, `angsuran_bunga`, `angsuran_pokok`, `total_angsuran`, `sisa_cicilan`, `status`, `id_konfirmasi`) VALUES
(1, 0, 333, 166666, 166999, 1832501, 'Bayar', 1),
(2, 1, 333, 166666, 166999, 1832501, 'Bayar', 1),
(3, 2, 333, 166666, 166999, 1832501, 'Bayar', 1),
(4, 0, 333, 166666, 166999, 1832501, 'Bayar', 1),
(5, 1, 333, 166666, 166999, 1832501, 'Bayar', 1),
(6, 2, 333, 166666, 166999, 1832501, 'Bayar', 1),
(7, 0, 333, 166666, 166999, 1832501, 'Bayar', 1),
(8, 1, 333, 166666, 166999, 1832501, 'Bayar', 1),
(9, 2, 333, 166666, 166999, 1832501, 'Bayar', 1),
(10, 0, 333, 166666, 166999, 1832501, 'Bayar', 1),
(11, 1, 333, 166666, 166999, 1832501, 'Bayar', 1),
(12, 2, 333, 166666, 166999, 1832501, 'Bayar', 1),
(13, 0, 333, 166666, 166999, 1832501, 'Belum', 1),
(14, 1, 333, 166666, 166999, 1665502, 'Belum', 1),
(15, 2, 333, 166666, 166999, 1498503, 'Belum', 1),
(16, 3, 333, 166666, 166999, 1331504, 'Belum', 1),
(17, 4, 333, 166666, 166999, 1164505, 'Belum', 1),
(18, 5, 333, 166666, 166999, 997506, 'Belum', 1),
(19, 6, 333, 166666, 166999, 830507, 'Belum', 1),
(20, 7, 333, 166666, 166999, 663508, 'Belum', 1),
(21, 8, 333, 166666, 166999, 496509, 'Belum', 1),
(22, 9, 333, 166666, 166999, 329510, 'Belum', 1),
(23, 10, 333, 166666, 166999, 162511, 'Belum', 1),
(24, 11, 333, 166666, 166999, -4488, 'Belum', 1),
(25, 12, 333, 166666, 166999, -171487, 'Belum', 1),
(26, 1, 333, 166666, 166999, 1828001, 'Belum', 3),
(27, 2, 333, 166666, 166999, 1661002, 'Belum', 3),
(28, 3, 333, 166666, 166999, 1494003, 'Belum', 3),
(29, 4, 333, 166666, 166999, 1327004, 'Belum', 3),
(30, 5, 333, 166666, 166999, 1160005, 'Belum', 3),
(31, 6, 333, 166666, 166999, 993006, 'Belum', 3),
(32, 7, 333, 166666, 166999, 826007, 'Belum', 3),
(33, 8, 333, 166666, 166999, 659008, 'Belum', 3),
(34, 9, 333, 166666, 166999, 492009, 'Belum', 3),
(35, 10, 333, 166666, 166999, 325010, 'Belum', 3),
(36, 11, 333, 166666, 166999, 158011, 'Belum', 3),
(37, 12, 333, 166666, 166999, -8988, 'Belum', 3),
(38, 1, 333, 166666, 166999, 1828001, 'Belum', 3),
(39, 2, 333, 166666, 166999, 1661002, 'Belum', 3),
(40, 3, 333, 166666, 166999, 1494003, 'Belum', 3),
(41, 4, 333, 166666, 166999, 1327004, 'Belum', 3),
(42, 5, 333, 166666, 166999, 1160005, 'Belum', 3),
(43, 6, 333, 166666, 166999, 993006, 'Belum', 3),
(44, 7, 333, 166666, 166999, 826007, 'Belum', 3),
(45, 8, 333, 166666, 166999, 659008, 'Belum', 3),
(46, 9, 333, 166666, 166999, 492009, 'Belum', 3),
(47, 10, 333, 166666, 166999, 325010, 'Belum', 3),
(48, 11, 333, 166666, 166999, 158011, 'Belum', 3),
(49, 12, 333, 166666, 166999, -8988, 'Belum', 3),
(50, 1, 333, 166666, 166999, 1828001, 'Belum', 3),
(51, 2, 333, 166666, 166999, 1661002, 'Belum', 3),
(52, 3, 333, 166666, 166999, 1494003, 'Belum', 3),
(53, 4, 333, 166666, 166999, 1327004, 'Belum', 3),
(54, 5, 333, 166666, 166999, 1160005, 'Belum', 3),
(55, 6, 333, 166666, 166999, 993006, 'Belum', 3),
(56, 7, 333, 166666, 166999, 826007, 'Belum', 3),
(57, 8, 333, 166666, 166999, 659008, 'Belum', 3),
(58, 9, 333, 166666, 166999, 492009, 'Belum', 3),
(59, 10, 333, 166666, 166999, 325010, 'Belum', 3),
(60, 11, 333, 166666, 166999, 158011, 'Belum', 3),
(61, 12, 333, 166666, 166999, -8988, 'Belum', 3),
(62, 13, 333, 166666, 166999, -175987, 'Belum', 3),
(63, 14, 333, 166666, 166999, -342986, 'Belum', 3),
(64, 15, 333, 166666, 166999, -509985, 'Belum', 3),
(65, 16, 333, 166666, 166999, -676984, 'Belum', 3),
(66, 17, 333, 166666, 166999, -843983, 'Belum', 3),
(67, 18, 333, 166666, 166999, -1010982, 'Belum', 3),
(68, 19, 333, 166666, 166999, -1177981, 'Belum', 3),
(69, 20, 333, 166666, 166999, -1344980, 'Belum', 3),
(70, 21, 333, 166666, 166999, -1511979, 'Belum', 3),
(71, 22, 333, 166666, 166999, -1678978, 'Belum', 3),
(72, 23, 333, 166666, 166999, -1845977, 'Belum', 3),
(73, 24, 333, 166666, 166999, -2012976, 'Belum', 3),
(74, 1, 333, 166666, 166999, 1828001, 'Belum', 3),
(75, 2, 333, 166666, 166999, 1661002, 'Belum', 3),
(76, 3, 333, 166666, 166999, 1494003, 'Belum', 3),
(77, 4, 333, 166666, 166999, 1327004, 'Belum', 3),
(78, 5, 333, 166666, 166999, 1160005, 'Belum', 3),
(79, 6, 333, 166666, 166999, 993006, 'Belum', 3),
(80, 7, 333, 166666, 166999, 826007, 'Belum', 3),
(81, 8, 333, 166666, 166999, 659008, 'Belum', 3),
(82, 9, 333, 166666, 166999, 492009, 'Belum', 3),
(83, 10, 333, 166666, 166999, 325010, 'Belum', 3),
(84, 11, 333, 166666, 166999, 158011, 'Belum', 3),
(85, 12, 333, 166666, 166999, -8988, 'Belum', 3),
(86, 13, 333, 166666, 166999, -175987, 'Belum', 3),
(87, 14, 333, 166666, 166999, -342986, 'Belum', 3),
(88, 15, 333, 166666, 166999, -509985, 'Belum', 3),
(89, 16, 333, 166666, 166999, -676984, 'Belum', 3),
(90, 17, 333, 166666, 166999, -843983, 'Belum', 3),
(91, 18, 333, 166666, 166999, -1010982, 'Belum', 3),
(92, 19, 333, 166666, 166999, -1177981, 'Belum', 3),
(93, 20, 333, 166666, 166999, -1344980, 'Belum', 3),
(94, 21, 333, 166666, 166999, -1511979, 'Belum', 3),
(95, 22, 333, 166666, 166999, -1678978, 'Belum', 3),
(96, 23, 333, 166666, 166999, -1845977, 'Belum', 3),
(97, 24, 333, 166666, 166999, -2012976, 'Belum', 3),
(98, 1, 167, 83333, 83500, 1911500, 'Belum', 3),
(99, 2, 167, 83333, 83500, 1828000, 'Belum', 3),
(100, 3, 167, 83333, 83500, 1744500, 'Belum', 3),
(101, 4, 167, 83333, 83500, 1661000, 'Belum', 3),
(102, 5, 167, 83333, 83500, 1577500, 'Belum', 3),
(103, 6, 167, 83333, 83500, 1494000, 'Belum', 3),
(104, 7, 167, 83333, 83500, 1410500, 'Belum', 3),
(105, 8, 167, 83333, 83500, 1327000, 'Belum', 3),
(106, 9, 167, 83333, 83500, 1243500, 'Belum', 3),
(107, 10, 167, 83333, 83500, 1160000, 'Belum', 3),
(108, 11, 167, 83333, 83500, 1076500, 'Belum', 3),
(109, 12, 167, 83333, 83500, 993000, 'Belum', 3),
(110, 13, 167, 83333, 83500, 909500, 'Belum', 3),
(111, 14, 167, 83333, 83500, 826000, 'Belum', 3),
(112, 15, 167, 83333, 83500, 742500, 'Belum', 3),
(113, 16, 167, 83333, 83500, 659000, 'Belum', 3),
(114, 17, 167, 83333, 83500, 575500, 'Belum', 3),
(115, 18, 167, 83333, 83500, 492000, 'Belum', 3),
(116, 19, 167, 83333, 83500, 408500, 'Belum', 3),
(117, 20, 167, 83333, 83500, 325000, 'Belum', 3),
(118, 21, 167, 83333, 83500, 241500, 'Belum', 3),
(119, 22, 167, 83333, 83500, 158000, 'Belum', 3),
(120, 23, 167, 83333, 83500, 74500, 'Belum', 3),
(121, 24, 167, 83333, 83500, -9000, 'Belum', 3),
(122, 1, 40000, 166666, 206666, 1792834, 'Belum', 1),
(123, 2, 40000, 166666, 206666, 1586168, 'Belum', 1),
(124, 3, 40000, 166666, 206666, 1379502, 'Belum', 1),
(125, 4, 40000, 166666, 206666, 1172836, 'Belum', 1),
(126, 5, 40000, 166666, 206666, 966170, 'Belum', 1),
(127, 6, 40000, 166666, 206666, 759504, 'Belum', 1),
(128, 7, 40000, 166666, 206666, 552838, 'Belum', 1),
(129, 8, 40000, 166666, 206666, 346172, 'Belum', 1),
(130, 9, 40000, 166666, 206666, 139506, 'Belum', 1),
(131, 10, 40000, 166666, 206666, -67160, 'Belum', 1),
(132, 11, 40000, 166666, 206666, -273826, 'Belum', 1),
(133, 12, 40000, 166666, 206666, -480492, 'Belum', 1),
(134, 1, 20000, 83333, 103333, 896667, 'Belum', 4),
(135, 2, 20000, 83333, 103333, 793334, 'Belum', 4),
(136, 3, 20000, 83333, 103333, 690001, 'Belum', 4),
(137, 4, 20000, 83333, 103333, 586668, 'Belum', 4),
(138, 5, 20000, 83333, 103333, 483335, 'Belum', 4),
(139, 6, 20000, 83333, 103333, 380002, 'Belum', 4),
(140, 7, 20000, 83333, 103333, 276669, 'Belum', 4),
(141, 8, 20000, 83333, 103333, 173336, 'Belum', 4),
(142, 9, 20000, 83333, 103333, 70003, 'Belum', 4),
(143, 10, 20000, 83333, 103333, -33330, 'Belum', 4),
(144, 11, 20000, 83333, 103333, -136663, 'Belum', 4),
(145, 12, 20000, 83333, 103333, -239996, 'Belum', 4),
(146, 1, 20000, 83333, 103333, 896667, 'Belum', 4),
(147, 2, 20000, 83333, 103333, 793334, 'Belum', 4),
(148, 3, 20000, 83333, 103333, 690001, 'Belum', 4),
(149, 4, 20000, 83333, 103333, 586668, 'Belum', 4),
(150, 5, 20000, 83333, 103333, 483335, 'Belum', 4),
(151, 6, 20000, 83333, 103333, 380002, 'Belum', 4),
(152, 7, 20000, 83333, 103333, 276669, 'Belum', 4),
(153, 8, 20000, 83333, 103333, 173336, 'Belum', 4),
(154, 9, 20000, 83333, 103333, 70003, 'Belum', 4),
(155, 10, 20000, 83333, 103333, -33330, 'Belum', 4),
(156, 11, 20000, 83333, 103333, -136663, 'Belum', 4),
(157, 12, 20000, 83333, 103333, -239996, 'Belum', 4),
(158, 1, 20000, 83333, 103333, 916667, 'Bayar', 4),
(159, 2, 20000, 83333, 103333, 833334, 'Belum', 4),
(160, 3, 20000, 83333, 103333, 750001, 'Belum', 4),
(161, 4, 20000, 83333, 103333, 666668, 'Belum', 4),
(162, 5, 20000, 83333, 103333, 583335, 'Belum', 4),
(163, 6, 20000, 83333, 103333, 500002, 'Belum', 4),
(164, 7, 20000, 83333, 103333, 416669, 'Belum', 4),
(165, 8, 20000, 83333, 103333, 333336, 'Belum', 4),
(166, 9, 20000, 83333, 103333, 250003, 'Belum', 4),
(167, 10, 20000, 83333, 103333, 166670, 'Belum', 4),
(168, 11, 20000, 83333, 103333, 83337, 'Belum', 4),
(169, 12, 20000, 83333, 103333, 4, 'Belum', 4),
(170, 1, 40000, 166666, 206666, 1833334, 'Bayar', 5),
(171, 2, 40000, 166666, 206666, 1666668, 'Bayar', 5),
(172, 3, 40000, 166666, 206666, 1500002, 'Belum', 5),
(173, 4, 40000, 166666, 206666, 1333336, 'Belum', 5),
(174, 5, 40000, 166666, 206666, 1166670, 'Belum', 5),
(175, 6, 40000, 166666, 206666, 1000004, 'Belum', 5),
(176, 7, 40000, 166666, 206666, 833338, 'Belum', 5),
(177, 8, 40000, 166666, 206666, 666672, 'Belum', 5),
(178, 9, 40000, 166666, 206666, 500006, 'Belum', 5),
(179, 10, 40000, 166666, 206666, 333340, 'Belum', 5),
(180, 11, 40000, 166666, 206666, 166674, 'Belum', 5),
(181, 12, 40000, 166666, 206666, 8, 'Belum', 5),
(182, 1, 2000, 8333, 10333, 86667, 'Belum', 6),
(183, 2, 2000, 8333, 10333, 78334, 'Belum', 6),
(184, 3, 2000, 8333, 10333, 70001, 'Belum', 6),
(185, 4, 2000, 8333, 10333, 61668, 'Belum', 6),
(186, 5, 2000, 8333, 10333, 53335, 'Belum', 6),
(187, 6, 2000, 8333, 10333, 45002, 'Belum', 6),
(188, 7, 2000, 8333, 10333, 36669, 'Belum', 6),
(189, 8, 2000, 8333, 10333, 28336, 'Belum', 6),
(190, 9, 2000, 8333, 10333, 20003, 'Belum', 6),
(191, 10, 2000, 8333, 10333, 11670, 'Belum', 6),
(192, 11, 2000, 8333, 10333, 3337, 'Belum', 6),
(193, 12, 2000, 8333, 10333, -4996, 'Belum', 6),
(194, 1, 1900, 7916, 9816, 87084, 'Belum', 6),
(195, 2, 1900, 7916, 9816, 79168, 'Belum', 6),
(196, 3, 1900, 7916, 9816, 71252, 'Belum', 6),
(197, 4, 1900, 7916, 9816, 63336, 'Belum', 6),
(198, 5, 1900, 7916, 9816, 55420, 'Belum', 6),
(199, 6, 1900, 7916, 9816, 47504, 'Belum', 6),
(200, 7, 1900, 7916, 9816, 39588, 'Belum', 6),
(201, 8, 1900, 7916, 9816, 31672, 'Belum', 6),
(202, 9, 1900, 7916, 9816, 23756, 'Belum', 6),
(203, 10, 1900, 7916, 9816, 15840, 'Belum', 6),
(204, 11, 1900, 7916, 9816, 7924, 'Belum', 6),
(205, 12, 1900, 7916, 9816, 8, 'Belum', 6),
(206, 1, 30000, 125000, 155000, 1375000, 'Bayar', 7),
(207, 2, 30000, 125000, 155000, 1250000, 'Bayar', 7),
(208, 3, 30000, 125000, 155000, 1125000, 'Belum', 7),
(209, 4, 30000, 125000, 155000, 1000000, 'Belum', 7),
(210, 5, 30000, 125000, 155000, 875000, 'Belum', 7),
(211, 6, 30000, 125000, 155000, 750000, 'Belum', 7),
(212, 7, 30000, 125000, 155000, 625000, 'Belum', 7),
(213, 8, 30000, 125000, 155000, 500000, 'Belum', 7),
(214, 9, 30000, 125000, 155000, 375000, 'Belum', 7),
(215, 10, 30000, 125000, 155000, 250000, 'Belum', 7),
(216, 11, 30000, 125000, 155000, 125000, 'Belum', 7),
(217, 12, 30000, 125000, 155000, 0, 'Belum', 7),
(218, 1, 1990, 8291, 10281, 91209, 'Bayar', 8),
(219, 2, 1990, 8291, 10281, 82918, 'Belum', 8),
(220, 3, 1990, 8291, 10281, 74627, 'Belum', 8),
(221, 4, 1990, 8291, 10281, 66336, 'Belum', 8),
(222, 5, 1990, 8291, 10281, 58045, 'Belum', 8),
(223, 6, 1990, 8291, 10281, 49754, 'Belum', 8),
(224, 7, 1990, 8291, 10281, 41463, 'Belum', 8),
(225, 8, 1990, 8291, 10281, 33172, 'Belum', 8),
(226, 9, 1990, 8291, 10281, 24881, 'Belum', 8),
(227, 10, 1990, 8291, 10281, 16590, 'Belum', 8),
(228, 11, 1990, 8291, 10281, 8299, 'Belum', 8),
(229, 12, 1990, 8291, 10281, 8, 'Belum', 8),
(230, 1, 38000, 158333, 196333, 1741667, 'Bayar', 9),
(231, 2, 38000, 158333, 196333, 1583334, 'Belum', 9),
(232, 3, 38000, 158333, 196333, 1425001, 'Belum', 9),
(233, 4, 38000, 158333, 196333, 1266668, 'Belum', 9),
(234, 5, 38000, 158333, 196333, 1108335, 'Belum', 9),
(235, 6, 38000, 158333, 196333, 950002, 'Belum', 9),
(236, 7, 38000, 158333, 196333, 791669, 'Belum', 9),
(237, 8, 38000, 158333, 196333, 633336, 'Belum', 9),
(238, 9, 38000, 158333, 196333, 475003, 'Belum', 9),
(239, 10, 38000, 158333, 196333, 316670, 'Belum', 9),
(240, 11, 38000, 158333, 196333, 158337, 'Belum', 9),
(241, 12, 38000, 158333, 196333, 4, 'Belum', 9),
(242, 1, 38000, 158333, 196333, 1741667, 'Belum', 9),
(243, 2, 38000, 158333, 196333, 1583334, 'Belum', 9),
(244, 3, 38000, 158333, 196333, 1425001, 'Belum', 9),
(245, 4, 38000, 158333, 196333, 1266668, 'Belum', 9),
(246, 5, 38000, 158333, 196333, 1108335, 'Belum', 9),
(247, 6, 38000, 158333, 196333, 950002, 'Belum', 9),
(248, 7, 38000, 158333, 196333, 791669, 'Belum', 9),
(249, 8, 38000, 158333, 196333, 633336, 'Belum', 9),
(250, 9, 38000, 158333, 196333, 475003, 'Belum', 9),
(251, 10, 38000, 158333, 196333, 316670, 'Belum', 9),
(252, 11, 38000, 158333, 196333, 158337, 'Belum', 9),
(253, 12, 38000, 158333, 196333, 4, 'Belum', 9),
(254, 13, 38000, 158333, 196333, -158329, 'Belum', 9),
(255, 14, 38000, 158333, 196333, -316662, 'Belum', 9),
(256, 15, 38000, 158333, 196333, -474995, 'Belum', 9),
(257, 16, 38000, 158333, 196333, -633328, 'Belum', 9),
(258, 17, 38000, 158333, 196333, -791661, 'Belum', 9),
(259, 18, 38000, 158333, 196333, -949994, 'Belum', 9),
(260, 19, 38000, 158333, 196333, -1108327, 'Belum', 9),
(261, 20, 38000, 158333, 196333, -1266660, 'Belum', 9),
(262, 21, 38000, 158333, 196333, -1424993, 'Belum', 9),
(263, 22, 38000, 158333, 196333, -1583326, 'Belum', 9),
(264, 23, 38000, 158333, 196333, -1741659, 'Belum', 9),
(265, 24, 38000, 158333, 196333, -1899992, 'Belum', 9),
(266, 1, 3592000, 14966666, 18558666, 164633334, 'Bayar', 10),
(267, 2, 3592000, 14966666, 18558666, 149666668, 'Belum', 10),
(268, 3, 3592000, 14966666, 18558666, 134700002, 'Belum', 10),
(269, 4, 3592000, 14966666, 18558666, 119733336, 'Belum', 10),
(270, 5, 3592000, 14966666, 18558666, 104766670, 'Belum', 10),
(271, 6, 3592000, 14966666, 18558666, 89800004, 'Belum', 10),
(272, 7, 3592000, 14966666, 18558666, 74833338, 'Belum', 10),
(273, 8, 3592000, 14966666, 18558666, 59866672, 'Belum', 10),
(274, 9, 3592000, 14966666, 18558666, 44900006, 'Belum', 10),
(275, 10, 3592000, 14966666, 18558666, 29933340, 'Belum', 10),
(276, 11, 3592000, 14966666, 18558666, 14966674, 'Belum', 10),
(277, 12, 3592000, 14966666, 18558666, 8, 'Belum', 10);

-- --------------------------------------------------------

--
-- Table structure for table `tb_histori`
--

CREATE TABLE `tb_histori` (
  `kode_riwayat` int(11) NOT NULL,
  `tgl_lunas` date NOT NULL,
  `id_pembelian` varchar(20) NOT NULL,
  `sisa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_histori`
--

INSERT INTO `tb_histori` (`kode_riwayat`, `tgl_lunas`, `id_pembelian`, `sisa`) VALUES
(1, '2023-12-17', 'TR004', 0),
(2, '2023-12-18', 'TR011', 0),
(3, '2023-12-29', 'TR018', 0),
(4, '2023-12-29', 'TR022', 0),
(5, '2023-12-29', 'TR023', 0),
(6, '2023-12-29', 'TR024', 0),
(7, '2023-12-29', 'TR025', 0),
(8, '2023-12-29', 'TR026', 0),
(9, '2023-12-29', 'TR027', 0),
(10, '2023-12-29', 'TR028', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tb_konfirmasi`
--

CREATE TABLE `tb_konfirmasi` (
  `id_konfirmasi` int(11) NOT NULL,
  `dp_cicilan` int(11) NOT NULL,
  `sisa_cicilan` int(11) NOT NULL,
  `status_cicilan` enum('Menyicil','Lunas') NOT NULL,
  `total_cicilan` int(11) NOT NULL,
  `lama_cicilan` enum('12','24','36','48') DEFAULT NULL,
  `id_pembelian` varchar(20) CHARACTER SET utf8mb4 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_konfirmasi`
--

INSERT INTO `tb_konfirmasi` (`id_konfirmasi`, `dp_cicilan`, `sisa_cicilan`, `status_cicilan`, `total_cicilan`, `lama_cicilan`, `id_pembelian`) VALUES
(1, 500, 1832501, 'Menyicil', 206666, '12', 'TR008'),
(2, 500, 999500, 'Menyicil', 27833, '36', 'TR009'),
(3, 5000, 1995000, 'Menyicil', 83500, '24', 'TR010'),
(4, 500000, 1000000, 'Menyicil', 103333, '12', 'TR014'),
(5, 500000, 166666, 'Menyicil', 206666, '12', 'TR015'),
(6, 5000, 95000, 'Menyicil', 9816, '12', 'TR016'),
(7, 500000, 1250000, 'Menyicil', 155000, '12', 'TR017'),
(8, 500, 91209, 'Menyicil', 10281, '12', 'TR019'),
(9, 100000, 1741667, 'Menyicil', 196333, '24', 'TR020'),
(10, 400000, 164633334, 'Menyicil', 18558666, '12', 'TR021');

-- --------------------------------------------------------

--
-- Table structure for table `tb_merek`
--

CREATE TABLE `tb_merek` (
  `id_merek` varchar(12) NOT NULL,
  `nama_merek` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_merek`
--

INSERT INTO `tb_merek` (`id_merek`, `nama_merek`) VALUES
('M01', 'Toyota'),
('M02', 'Honda'),
('M03', 'Avanza1');

-- --------------------------------------------------------

--
-- Table structure for table `tb_mobil`
--

CREATE TABLE `tb_mobil` (
  `id_mobil` varchar(20) NOT NULL,
  `warna` varchar(20) NOT NULL,
  `tahun_dirilis` varchar(4) NOT NULL,
  `harga_mobil` int(11) NOT NULL,
  `nama_mobil` varchar(255) NOT NULL,
  `id_merek` varchar(12) NOT NULL,
  `stok` int(11) NOT NULL,
  `hitung_beli` int(11) NOT NULL,
  `username` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_mobil`
--

INSERT INTO `tb_mobil` (`id_mobil`, `warna`, `tahun_dirilis`, `harga_mobil`, `nama_mobil`, `id_merek`, `stok`, `hitung_beli`, `username`) VALUES
('MB001', 'hitam', '2022', 1000000, 'Toyota Seri 1', 'M02', 0, 0, 'daweda'),
('MB002', 'orange', '2020', 20000000, 'lamborgini', 'M02', 0, 6, 'daweda'),
('MB003', 'Silver', '2019', 100000, 'Alphard', 'M01', 0, 0, 'daweda'),
('MB004', 'Merah', '2021', 180000000, 'Ayla', 'M02', 1, 0, 'daweda');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pembayaran`
--

CREATE TABLE `tb_pembayaran` (
  `id_pembayaran` varchar(20) NOT NULL,
  `opsi_pembayaran` enum('Lunas','Cicil') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_pembayaran`
--

INSERT INTO `tb_pembayaran` (`id_pembayaran`, `opsi_pembayaran`) VALUES
('P01', 'Lunas'),
('P02', 'Cicil');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pembeli`
--

CREATE TABLE `tb_pembeli` (
  `nik` varchar(18) NOT NULL,
  `nama_pembeli` varchar(30) NOT NULL,
  `nama_ibu` varchar(30) NOT NULL,
  `telp_pembeli` varchar(13) NOT NULL,
  `tgl_lahir_pembeli` date DEFAULT NULL,
  `alamat_pembeli` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_pembeli`
--

INSERT INTO `tb_pembeli` (`nik`, `nama_pembeli`, `nama_ibu`, `telp_pembeli`, `tgl_lahir_pembeli`, `alamat_pembeli`) VALUES
('12', '12', '12', '12', '2023-12-12', '12'),
('212212', 'viaaa', 'ibu via', '0807789684099', '2023-12-29', 'jimbaran'),
('5103030810040002', 'purnami', 'ibu purnami', '087899509360', '2023-11-01', 'Gianyar timur'),
('5103030810040005', 'putrawan', 'siti', '087899509360', '2023-11-14', 'Denpasar Utara'),
('5103030810040007', 'weda', 'ibu weda', '087899509369', '2016-11-02', 'Jalan Weda'),
('5103030810040010', 'via', 'ibu via', '087899509369', '2005-07-06', 'Jalan kuta'),
('510403000440404', 'Ni Komang Ari', 'Ni Kadek Ari', '0895410971147', '2004-04-04', 'Jln. Sakura, Gianyar'),
('9', 'Unta', 'ibu unta', '0873339999090', '2021-12-29', 'jlniii'),
('988899009090909', 'Igusti Putrawan Bagus', 'ibu putrawan', '0873338866557', '2004-12-29', 'jln.kebenaran');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pembelian`
--

CREATE TABLE `tb_pembelian` (
  `id_pembelian` varchar(20) NOT NULL,
  `tgl_pembelian` date NOT NULL,
  `id_mobil` varchar(20) NOT NULL,
  `nik` varchar(18) NOT NULL,
  `id_pembayaran` varchar(20) NOT NULL,
  `username_petugas` varchar(30) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlah_uang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_pembelian`
--

INSERT INTO `tb_pembelian` (`id_pembelian`, `tgl_pembelian`, `id_mobil`, `nik`, `id_pembayaran`, `username_petugas`, `harga`, `jumlah_uang`) VALUES
('TR001', '2023-12-17', 'MB002', '5103030810040002', 'P01', 'wed', 2000000, 2000000),
('TR002', '2023-12-17', 'MB001', '5103030810040002', 'P01', 'wed', 1000000, 1000000),
('TR003', '2023-12-18', 'MB001', '5103030810040002', 'P01', 'wed', 1000000, 1000000),
('TR004', '2023-12-17', 'MB002', '5103030810040002', 'P01', 'wed', 2000000, 2000000),
('TR006', '2023-12-17', 'MB002', '5103030810040002', 'P02', 'wed', 2000000, 4000),
('TR007', '2023-12-17', 'MB002', '5103030810040002', 'P02', 'wed', 2000000, 300),
('TR008', '2023-12-17', 'MB002', '5103030810040002', 'P02', 'wed', 2000000, 500),
('TR009', '2023-12-17', 'MB001', '5103030810040002', 'P02', 'wed', 1000000, 500),
('TR010', '2023-12-17', 'MB002', '5103030810040002', 'P02', 'wed', 2000000, 5000),
('TR011', '2023-12-18', 'MB002', '5103030810040002', 'P01', 'wed', 2000000, 2000000),
('TR012', '2023-12-25', 'MB002', '5103030810040002', 'P02', 'wed', 2000000, 500000),
('TR013', '2023-12-25', 'MB002', '5103030810040002', 'P02', 'wed', 2000000, 500000),
('TR014', '2023-12-25', 'MB001', '5103030810040002', 'P02', 'wed', 1000000, 500000),
('TR015', '2023-12-26', 'MB002', '5103030810040007', 'P02', 'wed', 2000000, 500000),
('TR016', '2023-12-28', 'MB003', '5103030810040007', 'P02', 'wed', 100000, 5000),
('TR017', '2023-12-28', 'MB002', '9', 'P02', 'wed', 2000000, 500000),
('TR018', '2023-12-29', 'MB002', '510403000440404', 'P01', 'wed', 2000000, 2000000),
('TR019', '2023-12-29', 'MB003', '510403000440404', 'P02', 'wed', 100000, 500),
('TR020', '2023-12-12', 'MB002', '12', 'P02', 'wed', 2000000, 100000),
('TR021', '2023-12-29', 'MB004', '212212', 'P02', 'wed', 180000000, 400000),
('TR022', '2023-12-29', 'MB002', '12', 'P01', 'wed', 20000000, 20000000),
('TR023', '2023-12-29', 'MB002', '12', 'P01', 'wed', 20000000, 20000000),
('TR024', '2023-12-29', 'MB002', '12', 'P01', 'wed', 20000000, 20000000),
('TR025', '2023-12-29', 'MB002', '12', 'P01', 'wed', 20000000, 20000000),
('TR026', '2023-12-29', 'MB002', '12', 'P01', 'wed', 20000000, 20000000),
('TR027', '2023-12-29', 'MB002', '12', 'P01', 'wed', 20000000, 20000000),
('TR028', '2023-12-29', 'MB002', '12', 'P01', 'wed', 20000000, 20000000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_petugas`
--

CREATE TABLE `tb_petugas` (
  `username_petugas` varchar(12) NOT NULL,
  `pass_petugas` varchar(30) DEFAULT NULL,
  `nama_petugas` varchar(255) NOT NULL,
  `username` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_petugas`
--

INSERT INTO `tb_petugas` (`username_petugas`, `pass_petugas`, `nama_petugas`, `username`) VALUES
('wanwan', 'topgl', 'wawan', 'daweda'),
('wed', 'wed', 'wed', 'daweda'),
('wee', 'wan', 'wan', 'daweda');

-- --------------------------------------------------------

--
-- Table structure for table `tb_users`
--

CREATE TABLE `tb_users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jabatan` enum('Admin','Owner') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_users`
--

INSERT INTO `tb_users` (`username`, `password`, `nama`, `jabatan`) VALUES
('daweda', 'weda123', 'Weda', 'Admin'),
('wawan', 'wanwan123', 'Putrawan', 'Owner');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_cicilan`
--
ALTER TABLE `tb_cicilan`
  ADD PRIMARY KEY (`id_cicilan`),
  ADD KEY `id_pembayaran` (`id_pembayaran`);

--
-- Indexes for table `tb_detail_cicilan`
--
ALTER TABLE `tb_detail_cicilan`
  ADD PRIMARY KEY (`kode_bayar`),
  ADD KEY `id_konfirmasi` (`id_konfirmasi`);

--
-- Indexes for table `tb_histori`
--
ALTER TABLE `tb_histori`
  ADD PRIMARY KEY (`kode_riwayat`),
  ADD KEY `id_pembelian` (`id_pembelian`);

--
-- Indexes for table `tb_konfirmasi`
--
ALTER TABLE `tb_konfirmasi`
  ADD PRIMARY KEY (`id_konfirmasi`),
  ADD KEY `id_pembayaran` (`id_pembelian`);

--
-- Indexes for table `tb_merek`
--
ALTER TABLE `tb_merek`
  ADD PRIMARY KEY (`id_merek`);

--
-- Indexes for table `tb_mobil`
--
ALTER TABLE `tb_mobil`
  ADD PRIMARY KEY (`id_mobil`),
  ADD KEY `id_merek` (`id_merek`),
  ADD KEY `user_admin` (`username`);

--
-- Indexes for table `tb_pembayaran`
--
ALTER TABLE `tb_pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`);

--
-- Indexes for table `tb_pembeli`
--
ALTER TABLE `tb_pembeli`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `tb_pembelian`
--
ALTER TABLE `tb_pembelian`
  ADD PRIMARY KEY (`id_pembelian`),
  ADD KEY `username_petugas` (`username_petugas`),
  ADD KEY `nik` (`nik`),
  ADD KEY `id_pembayaran` (`id_pembayaran`),
  ADD KEY `id_mobil` (`id_mobil`);

--
-- Indexes for table `tb_petugas`
--
ALTER TABLE `tb_petugas`
  ADD PRIMARY KEY (`username_petugas`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `tb_users`
--
ALTER TABLE `tb_users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_detail_cicilan`
--
ALTER TABLE `tb_detail_cicilan`
  MODIFY `kode_bayar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=278;

--
-- AUTO_INCREMENT for table `tb_histori`
--
ALTER TABLE `tb_histori`
  MODIFY `kode_riwayat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tb_konfirmasi`
--
ALTER TABLE `tb_konfirmasi`
  MODIFY `id_konfirmasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_cicilan`
--
ALTER TABLE `tb_cicilan`
  ADD CONSTRAINT `id_pembayaran` FOREIGN KEY (`id_pembayaran`) REFERENCES `tb_pembayaran` (`id_pembayaran`),
  ADD CONSTRAINT `tb_cicilan_ibfk_1` FOREIGN KEY (`id_pembayaran`) REFERENCES `tb_pembayaran` (`id_pembayaran`);

--
-- Constraints for table `tb_detail_cicilan`
--
ALTER TABLE `tb_detail_cicilan`
  ADD CONSTRAINT `tb_detail_cicilan_ibfk_1` FOREIGN KEY (`id_konfirmasi`) REFERENCES `tb_konfirmasi` (`id_konfirmasi`);

--
-- Constraints for table `tb_histori`
--
ALTER TABLE `tb_histori`
  ADD CONSTRAINT `tb_histori_ibfk_1` FOREIGN KEY (`id_pembelian`) REFERENCES `tb_pembelian` (`id_pembelian`);

--
-- Constraints for table `tb_konfirmasi`
--
ALTER TABLE `tb_konfirmasi`
  ADD CONSTRAINT `tb_konfirmasi_ibfk_1` FOREIGN KEY (`id_pembelian`) REFERENCES `tb_pembelian` (`id_pembelian`);

--
-- Constraints for table `tb_mobil`
--
ALTER TABLE `tb_mobil`
  ADD CONSTRAINT `tb_mobil_ibfk_1` FOREIGN KEY (`id_merek`) REFERENCES `tb_merek` (`id_merek`),
  ADD CONSTRAINT `tb_mobil_ibfk_2` FOREIGN KEY (`username`) REFERENCES `tb_users` (`username`);

--
-- Constraints for table `tb_pembelian`
--
ALTER TABLE `tb_pembelian`
  ADD CONSTRAINT `tb_pembelian_ibfk_3` FOREIGN KEY (`username_petugas`) REFERENCES `tb_petugas` (`username_petugas`),
  ADD CONSTRAINT `tb_pembelian_ibfk_4` FOREIGN KEY (`nik`) REFERENCES `tb_pembeli` (`nik`),
  ADD CONSTRAINT `tb_pembelian_ibfk_6` FOREIGN KEY (`id_pembayaran`) REFERENCES `tb_pembayaran` (`id_pembayaran`),
  ADD CONSTRAINT `tb_pembelian_ibfk_7` FOREIGN KEY (`id_mobil`) REFERENCES `tb_mobil` (`id_mobil`);

--
-- Constraints for table `tb_petugas`
--
ALTER TABLE `tb_petugas`
  ADD CONSTRAINT `tb_petugas_ibfk_1` FOREIGN KEY (`username`) REFERENCES `tb_users` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
