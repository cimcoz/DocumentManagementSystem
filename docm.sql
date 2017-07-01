-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2017 at 02:14 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `docm`
--

-- --------------------------------------------------------

--
-- Table structure for table `assocbspos`
--

CREATE TABLE IF NOT EXISTS `assocbspos` (
  `bsid` int(11) NOT NULL,
  `posid` int(11) NOT NULL,
  PRIMARY KEY (`bsid`,`posid`),
  KEY `posid` (`posid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `businesspartner`
--

CREATE TABLE IF NOT EXISTS `businesspartner` (
  `BpID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) NOT NULL,
  `City` varchar(30) NOT NULL,
  `AccountNumber` varchar(30) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  PRIMARY KEY (`BpID`),
  KEY `zip` (`zip`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `businesspartner`
--

INSERT INTO `businesspartner` (`BpID`, `Name`, `City`, `AccountNumber`, `Address`, `zip`) VALUES
(1, 'Partner 1', 'Belgrade', '122334', 'Todora Dukina 78', 11000),
(2, 'ssd', 'Belgrade', '333', 'fsdfs', 11000),
(3, 'hjkjhk', 'Belgrade', '8778', 'hkhjk', 11000),
(4, 'klkjkl', 'Belgrade', '0-089', 'kl;lk', 11000),
(5, 'ghj', 'Belgrade', 'ghj', 'ghj', 11000),
(6, 'cvbnvb', 'Belgrade', 'tt55', 'hvbhbv', 11000),
(7, 'fsd', 'Belgrade', '111', 'da', 11000),
(8, 'fsd', 'Novi Sad', '111', 'da', 12000),
(9, 'df', 'Belgrade', 'sdf', 'sdf', 11000);

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `Zip` int(11) NOT NULL,
  `CityName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Zip`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`Zip`, `CityName`) VALUES
(11000, 'Belgrade'),
(12000, 'Novi Sad');

-- --------------------------------------------------------

--
-- Table structure for table `positions`
--

CREATE TABLE IF NOT EXISTS `positions` (
  `posID` int(11) NOT NULL AUTO_INCREMENT,
  `posName` varchar(30) NOT NULL,
  `posDescription` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`posID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `positions`
--

INSERT INTO `positions` (`posID`, `posName`, `posDescription`) VALUES
(1, 'jgj', 'ghj');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assocbspos`
--
ALTER TABLE `assocbspos`
  ADD CONSTRAINT `assocbspos_ibfk_1` FOREIGN KEY (`bsid`) REFERENCES `businesspartner` (`BpID`),
  ADD CONSTRAINT `assocbspos_ibfk_2` FOREIGN KEY (`posid`) REFERENCES `positions` (`posID`);

--
-- Constraints for table `businesspartner`
--
ALTER TABLE `businesspartner`
  ADD CONSTRAINT `businesspartner_ibfk_1` FOREIGN KEY (`zip`) REFERENCES `city` (`Zip`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
