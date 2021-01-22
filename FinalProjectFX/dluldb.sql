-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2021 at 08:28 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dluldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `lokasi`
--

CREATE TABLE `lokasi` (
  `id_lokasi` int(11) NOT NULL,
  `Nama_lokasi` char(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lokasi`
--

INSERT INTO `lokasi` (`id_lokasi`, `Nama_lokasi`) VALUES
(5, 'Lampung Barat'),
(4, 'Lampung Selatan'),
(2, 'Lampung Tengah'),
(3, 'Lampung Timur'),
(1, 'Lampung Utara'),
(11, 'Mesuji'),
(7, 'Metro'),
(6, 'Pesawaran'),
(14, 'Pesisir Barat'),
(8, 'Pringsewu'),
(13, 'Tanggamus'),
(9, 'Tulang Bawang'),
(10, 'Tulang Bawang Barat'),
(12, 'Way Kanan');

-- --------------------------------------------------------

--
-- Table structure for table `penerima`
--

CREATE TABLE `penerima` (
  `id_penerima` int(11) NOT NULL,
  `nama` char(255) NOT NULL,
  `alamat` char(255) NOT NULL,
  `no_hp` char(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penerima`
--

INSERT INTO `penerima` (`id_penerima`, `nama`, `alamat`, `no_hp`) VALUES
(1001, 'DAUD', 'man', '021254565854'),
(1002, 'DINA', 'Stadion', '085156548046'),
(1003, 'DINI', 'lalala', '085655585545'),
(1004, 'Ebi', 'Natar', '08995454545');

-- --------------------------------------------------------

--
-- Table structure for table `pengirim`
--

CREATE TABLE `pengirim` (
  `id_pengirim` int(11) NOT NULL,
  `nama_pengirim` char(255) NOT NULL,
  `alamat` char(255) NOT NULL,
  `no_hp` char(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengirim`
--

INSERT INTO `pengirim` (`id_pengirim`, `nama_pengirim`, `alamat`, `no_hp`) VALUES
(1001, 'Doni', 'UNILA', '085658575985'),
(1002, 'JESS', 'kemiling', '085456585124'),
(1003, 'Deni', 'mantab', '08545854555'),
(1004, 'Fadhil', 'Kemiling', '085658905678');

-- --------------------------------------------------------

--
-- Table structure for table `pengiriman`
--

CREATE TABLE `pengiriman` (
  `id_pengiriman` int(11) NOT NULL,
  `jenis_pengiriman` char(255) NOT NULL,
  `lokasi_tujuan` char(255) NOT NULL,
  `id_lokasi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengiriman`
--

INSERT INTO `pengiriman` (`id_pengiriman`, `jenis_pengiriman`, `lokasi_tujuan`, `id_lokasi`) VALUES
(1001, 'Reguler', 'Lampung Utara', 1),
(1002, 'Express', 'Lampung Utara', 1),
(1003, 'Reguler', 'Lampung Utara', 1),
(1004, 'Express', 'Lampung Selatan', 4);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_pengirim` int(11) DEFAULT NULL,
  `id_penerima` int(11) DEFAULT NULL,
  `id_lokasi` int(11) DEFAULT NULL,
  `id_pengiriman` int(11) DEFAULT NULL,
  `Harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_pengirim`, `id_penerima`, `id_lokasi`, `id_pengiriman`, `Harga`) VALUES
(1001, 1001, 1001, 1, 1001, 35000),
(1002, 1002, 1002, 1, 1002, 70000),
(1003, 1003, 1003, 1, 1003, 35000),
(1004, 1004, 1004, 4, 1004, 10000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `lokasi`
--
ALTER TABLE `lokasi`
  ADD PRIMARY KEY (`id_lokasi`),
  ADD UNIQUE KEY `Nama_lokasi` (`Nama_lokasi`);

--
-- Indexes for table `penerima`
--
ALTER TABLE `penerima`
  ADD PRIMARY KEY (`id_penerima`);

--
-- Indexes for table `pengirim`
--
ALTER TABLE `pengirim`
  ADD PRIMARY KEY (`id_pengirim`);

--
-- Indexes for table `pengiriman`
--
ALTER TABLE `pengiriman`
  ADD PRIMARY KEY (`id_pengiriman`),
  ADD KEY `id_lokasi` (`id_lokasi`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `transaksi_ibfk_1` (`id_pengirim`),
  ADD KEY `transaksi_ibfk_2` (`id_pengiriman`),
  ADD KEY `transaksi_ibfk_3` (`id_penerima`),
  ADD KEY `transaksi_ibfk_4` (`id_lokasi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pengirim`
--
ALTER TABLE `pengirim`
  MODIFY `id_pengirim` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1005;

--
-- AUTO_INCREMENT for table `pengiriman`
--
ALTER TABLE `pengiriman`
  MODIFY `id_pengiriman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1005;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1005;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pengiriman`
--
ALTER TABLE `pengiriman`
  ADD CONSTRAINT `pengiriman_ibfk_1` FOREIGN KEY (`id_lokasi`) REFERENCES `lokasi` (`id_lokasi`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_pengirim`) REFERENCES `pengirim` (`id_pengirim`) ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_pengiriman`) REFERENCES `pengiriman` (`id_pengiriman`) ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`id_penerima`) REFERENCES `penerima` (`id_penerima`) ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_4` FOREIGN KEY (`id_lokasi`) REFERENCES `lokasi` (`id_lokasi`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
