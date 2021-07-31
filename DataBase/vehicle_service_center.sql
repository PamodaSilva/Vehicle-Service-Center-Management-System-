-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 31, 2021 at 08:03 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vehicle service center`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `NIC` char(13) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `TPHome` char(11) NOT NULL,
  `TPMobile` char(11) NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`NIC`, `Name`, `Address`, `TPHome`, `TPMobile`, `Email`) VALUES
('98657412V', 'Namal', 'Panadura', '014528974', '071458963', 'namal123@gmail.com'),
('99471528V', 'Pamoda', 'Kalutara', '0342256897', '0714562536', 'pamoda123@gmail.com'),
('99954671V', 'Sunil', 'Matara', '03455692871', '07145896235', 'Sunil123@gmail.com'),
('99985745V', 'Danu', 'Horana', '0342569387', '0714562869', 'danuperera@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Pay_ID` int(11) NOT NULL,
  `Service ID` char(20) NOT NULL,
  `Vehicle Number` char(20) NOT NULL,
  `Bill` int(11) DEFAULT NULL,
  `Service Type` char(50) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Pay_ID`, `Service ID`, `Vehicle Number`, `Bill`, `Service Type`, `Date`) VALUES
(2, 'SE01', 'CHE31425', 5000, 'Cleanning', '2021-07-14'),
(3, 'SE02', 'CAS123456', 8900, 'Repairing', '2020-07-13'),
(5, 'SE03', 'DFA12345', 5500, 'Cleanning', '2021-08-25'),
(6, 'SE04', 'YAW647382', 12000, 'Repairing', '2021-07-23');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `Service ID` char(10) NOT NULL,
  `Vehicle Number` char(20) NOT NULL,
  `Model` char(30) NOT NULL,
  `Model Number` char(30) NOT NULL,
  `Owner NIC` char(14) NOT NULL,
  `Owner Name` varchar(255) NOT NULL,
  `Date` date NOT NULL,
  `Service Type` varchar(255) NOT NULL,
  `Bill Amount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`Service ID`, `Vehicle Number`, `Model`, `Model Number`, `Owner NIC`, `Owner Name`, `Date`, `Service Type`, `Bill Amount`) VALUES
('SE01', 'CHE31425', 'Suzuki', 'QW12347', '994578123V', 'Kasun', '2021-07-14', 'Cleanning', 5000),
('SE02', 'CAS123456', 'Audi', 'SDR425162', '85469713V', 'Jon', '2020-07-13', 'Repairing', 8900),
('SE03', 'DFA12345', 'D1', 'LKOIJ9875D', '66857412V', 'Dumal', '2021-08-25', 'Cleanning', 5500),
('SE04', 'YAW647382', 'Kiwi', 'RTEY63748H', '72548613V', 'Gayan', '2021-07-23', 'Repairing', 12000);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `Vehicle Number` char(20) NOT NULL,
  `Owner NIC` char(13) NOT NULL,
  `Owner Name` varchar(255) NOT NULL,
  `Vehicle Model` char(50) NOT NULL,
  `Model Number` char(20) NOT NULL,
  `Fuel Type` char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`Vehicle Number`, `Owner NIC`, `Owner Name`, `Vehicle Model`, `Model Number`, `Fuel Type`) VALUES
('CHA1234', '998876234V', 'Kasun', 'Aluto', '1234ert567', 'Petrol'),
('CHD13243', '69874555V', 'Mala', 'Kiwi', '1234DFRTG', 'Petrol'),
('CNA45623', '12345676V', 'Saman', 'Kiwi', '123QWE456', 'Petrol');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`NIC`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Pay_ID`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`Service ID`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`Vehicle Number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Pay_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
