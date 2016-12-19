-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: hms
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `guests`
--

DROP TABLE IF EXISTS `guests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `phonenum` varchar(25) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `cardnumber` varchar(45) DEFAULT NULL,
  `cardholdername` varchar(45) DEFAULT NULL,
  `cardexpiry` date DEFAULT NULL,
  `checkin` date DEFAULT NULL,
  `checkout` date DEFAULT NULL,
  `occupants_number` int(11) DEFAULT NULL,
  `room_number` int(11) DEFAULT NULL,
  `paidamount` double DEFAULT NULL,
  `totalamount` double DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `zipcode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guests`
--

LOCK TABLES `guests` WRITE;
/*!40000 ALTER TABLE `guests` DISABLE KEYS */;
INSERT INTO `guests` VALUES (1,'a','a','','a','378282246310005','a','2017-12-01','2016-12-13','2016-12-15',1,209,0,480,'a','a','',''),(2,'a','a','','a','378282246310005','f','2017-12-31','2016-12-13','2016-12-15',1,104,0,140,'a','a','',''),(3,'a','a','','a','378282246310005','a','2017-12-31','2016-12-13','2016-12-15',1,104,0,140,'a','a','',''),(4,'sDd','sa','ghj','ghgj','378282246310005','sdd','2017-12-31','2016-12-18','2016-12-20',1,305,0,740,'df','d','',''),(7,'damir','ad','','afag','378282246310005','damir','2019-12-31','2016-12-23','2016-12-28',5,310,0,1950,'sf','','','');
/*!40000 ALTER TABLE `guests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomdetails`
--

DROP TABLE IF EXISTS `roomdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roomdetails` (
  `room_no` int(11) NOT NULL,
  `typeofbed` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `typeofroom` varchar(45) DEFAULT NULL,
  `availability` int(11) DEFAULT NULL,
  PRIMARY KEY (`room_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomdetails`
--

LOCK TABLES `roomdetails` WRITE;
/*!40000 ALTER TABLE `roomdetails` DISABLE KEYS */;
INSERT INTO `roomdetails` VALUES (102,1,50,'Standard',1),(103,2,70,'Standard',1),(104,2,70,'Standard',1),(105,2,70,'Standard',1),(106,3,90,'Standard',1),(107,3,90,'Standard',1),(108,3,90,'Standard',1),(109,3,90,'Standard',1),(110,3,90,'Standard',1),(201,1,200,'Superior',1),(202,1,200,'Superior',1),(203,2,220,'Superior',1),(204,2,220,'Superior',1),(205,2,220,'Superior',1),(206,3,240,'Superior',1),(207,3,240,'Superior',1),(208,3,240,'Deluxe',1),(209,3,240,'Superior',1),(210,3,240,'Superior',1),(301,1,350,'Deluxe',1),(302,1,350,'Deluxe',1),(303,2,370,'Deluxe',1),(304,2,370,'Deluxe',1),(305,2,370,'Deluxe',1),(306,3,390,'Deluxe',1),(307,3,390,'Deluxe',1),(308,3,390,'Deluxe',1),(310,3,390,'Deluxe',1),(401,1,400,'Standard',1);
/*!40000 ALTER TABLE `roomdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `isManager` int(11) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `phonenumber` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `zipcode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','admin',1,'Administrator',NULL,NULL,'activendedicated@gmail.com',NULL,NULL,NULL,NULL),('damir','1234',0,'damir','aloev','15161654','damir','uzb','sam','s','1354643'),('sample','123',0,'aziz','m','j','j','a','j','j','j'),('user','user',1,'s','f','f','f','f','f','f','f');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-19 19:50:47
