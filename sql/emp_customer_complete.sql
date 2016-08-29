-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.16-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table test.customers
CREATE TABLE IF NOT EXISTS `customers` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `AGE` int(11) NOT NULL,
  `ADDRESS` char(25) DEFAULT NULL,
  `SALARY` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table test.customers: ~6 rows (approximately)
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` (`ID`, `NAME`, `AGE`, `ADDRESS`, `SALARY`) VALUES
	(1, 'Muqtar', 27, 'Ahmedabad', 2000.00),
	(2, 'Azhar', 25, 'Delhi', 1500.00),
	(3, 'Nisar', 28, 'Kota', 2000.00),
	(4, 'Umaima', 2, 'Mumbai', 6500.00),
	(5, 'Adil', 20, 'Bhopal', 8500.00),
	(6, 'Sana', 18, 'MP', 4500.00);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;


-- Dumping structure for view test.customer_order_view
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `customer_order_view` (
	`ID` INT(11) NOT NULL,
	`NAME` VARCHAR(20) NOT NULL COLLATE 'latin1_swedish_ci',
	`AMOUNT` DOUBLE NULL
) ENGINE=MyISAM;


-- Dumping structure for table test.department
CREATE TABLE IF NOT EXISTS `department` (
  `DNO` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`DNO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table test.department: ~5 rows (approximately)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`DNO`, `dname`) VALUES
	(1, 'IT'),
	(2, 'Finance'),
	(3, 'Legal'),
	(4, 'OTHERS'),
	(5, 'DOCTOR');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


-- Dumping structure for table test.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `EID` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) DEFAULT NULL,
  `deptid` int(11) DEFAULT NULL,
  PRIMARY KEY (`EID`),
  KEY `FK_DEPTID` (`deptid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table test.employee: ~7 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`EID`, `ename`, `deptid`) VALUES
	(1, 'Muqtar', 1),
	(2, 'Azhar', 3),
	(3, 'Nisar', 2),
	(4, 'Imran', 1),
	(5, 'Ishrat', 2),
	(6, 'SYED IMRAN', 5),
	(7, 'ADIL', 6),
	(8, 'Hasheem', 2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


-- Dumping structure for table test.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `OID` varchar(20) NOT NULL,
  `ODATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CUSTOMER_ID` int(11) NOT NULL,
  `AMOUNT` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`OID`),
  KEY `CUSTOMER_ID` (`CUSTOMER_ID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customers` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table test.orders: ~3 rows (approximately)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`OID`, `ODATE`, `CUSTOMER_ID`, `AMOUNT`) VALUES
	('101', '2016-07-26 17:10:48', 1, '1000'),
	('102', '2016-07-26 17:12:46', 3, '1500'),
	('103', '2016-07-26 17:12:57', 4, '500'),
	('104', '2016-07-26 17:13:23', 4, '800');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;


-- Dumping structure for view test.order_amount
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `order_amount` (
	`AMOUNT` DOUBLE NULL,
	`CUSTOMER_ID` INT(11) NOT NULL
) ENGINE=MyISAM;


-- Dumping structure for view test.customer_order_view
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `customer_order_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` VIEW `customer_order_view` AS SELECT C.ID, C.NAME, V.AMOUNT
FROM CUSTOMERS C, ORDER_AMOUNT V
WHERE C.ID = V.CUSTOMER_ID ;


-- Dumping structure for view test.order_amount
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `order_amount`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` VIEW `order_amount` AS SELECT SUM(O.AMOUNT) AS AMOUNT, O.CUSTOMER_ID 
FROM ORDERS O
GROUP BY O.CUSTOMER_ID ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
