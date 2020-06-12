-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 02, 2020 at 05:17 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubes`
--

-- --------------------------------------------------------

--
-- Table structure for table `BerkasLamaran`
--

CREATE TABLE `BerkasLamaran` (
  `id` int(5) NOT NULL,
  `pengalaman` varchar(255) NOT NULL,
  `edukasi` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `idLamaran` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Lowongan`
--

CREATE TABLE `Lowongan` (
  `id` int(5) NOT NULL,
  `jenisPekerjaan` varchar(255) NOT NULL,
  `requirment` varchar(255) NOT NULL,
  `idPerusahaan` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pelamar`
--

CREATE TABLE `pelamar` (
  `id` int(5) NOT NULL,
  `name` varchar(255) NOT NULL,
  `tanggal` varchar(255) NOT NULL,
  `bl` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `perusahaan`
--

CREATE TABLE `perusahaan` (
  `id` int(5) NOT NULL,
  `namep` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `tanggal` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `BerkasLamaran`
--
ALTER TABLE `BerkasLamaran`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idLamaran` (`idLamaran`);

--
-- Indexes for table `Lowongan`
--
ALTER TABLE `Lowongan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPerusahaan` (`idPerusahaan`);

--
-- Indexes for table `pelamar`
--
ALTER TABLE `pelamar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bl_id` (`bl`);

--
-- Indexes for table `perusahaan`
--
ALTER TABLE `perusahaan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `BerkasLamaran`
--
ALTER TABLE `BerkasLamaran`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Lowongan`
--
ALTER TABLE `Lowongan`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pelamar`
--
ALTER TABLE `pelamar`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `perusahaan`
--
ALTER TABLE `perusahaan`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `BerkasLamaran`
--
ALTER TABLE `BerkasLamaran`
  ADD CONSTRAINT `idLamaran` FOREIGN KEY (`idLamaran`) REFERENCES `Lowongan` (`id`);

--
-- Constraints for table `Lowongan`
--
ALTER TABLE `Lowongan`
  ADD CONSTRAINT `idPerusahaan` FOREIGN KEY (`idPerusahaan`) REFERENCES `perusahaan` (`id`);

--
-- Constraints for table `pelamar`
--
ALTER TABLE `pelamar`
  ADD CONSTRAINT `bl_id` FOREIGN KEY (`bl`) REFERENCES `BerkasLamaran` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
