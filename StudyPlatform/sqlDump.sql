CREATE DATABASE  IF NOT EXISTS `proiectbd` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proiectbd`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: proiectbd
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activitate`
--

DROP TABLE IF EXISTS `activitate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activitate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idC` int DEFAULT NULL,
  `nume` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idC` (`idC`),
  CONSTRAINT `activitate_ibfk_1` FOREIGN KEY (`idC`) REFERENCES `curs` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activitate`
--

LOCK TABLES `activitate` WRITE;
/*!40000 ALTER TABLE `activitate` DISABLE KEYS */;
INSERT INTO `activitate` VALUES (1,1,'Curs'),(2,1,'Laborator'),(3,1,'Colocviu'),(4,1,'Examen');
/*!40000 ALTER TABLE `activitate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(20) DEFAULT NULL,
  `prenume` varchar(20) DEFAULT NULL,
  `cnp` varchar(13) DEFAULT NULL,
  `adresa` varchar(255) DEFAULT NULL,
  `telefon` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `iban` varchar(24) DEFAULT NULL,
  `nrContract` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Apostu','Iulian','5030000000001','1F','0700000001','apostuiulian11@gmail.com','RO0000000000000000000001',1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignarigrup`
--

DROP TABLE IF EXISTS `asignarigrup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignarigrup` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idCG` int DEFAULT NULL,
  `idS` int DEFAULT NULL,
  `idP` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCG` (`idCG`),
  KEY `idS` (`idS`),
  KEY `idP` (`idP`),
  CONSTRAINT `asignarigrup_ibfk_1` FOREIGN KEY (`idCG`) REFERENCES `calendargrup` (`id`),
  CONSTRAINT `asignarigrup_ibfk_2` FOREIGN KEY (`idS`) REFERENCES `student` (`id`),
  CONSTRAINT `asignarigrup_ibfk_3` FOREIGN KEY (`idP`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignarigrup`
--

LOCK TABLES `asignarigrup` WRITE;
/*!40000 ALTER TABLE `asignarigrup` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignarigrup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignaristudenti`
--

DROP TABLE IF EXISTS `asignaristudenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignaristudenti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idCa` int NOT NULL,
  `idS` int NOT NULL,
  `startDateA` date DEFAULT NULL,
  `startTimeA` time DEFAULT NULL,
  `endDateA` date DEFAULT NULL,
  `endTimeA` time DEFAULT NULL,
  `startA` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCa` (`idCa`),
  KEY `idS` (`idS`),
  CONSTRAINT `asignaristudenti_ibfk_1` FOREIGN KEY (`idCa`) REFERENCES `calendar` (`id`),
  CONSTRAINT `asignaristudenti_ibfk_2` FOREIGN KEY (`idS`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignaristudenti`
--

LOCK TABLES `asignaristudenti` WRITE;
/*!40000 ALTER TABLE `asignaristudenti` DISABLE KEYS */;
INSERT INTO `asignaristudenti` VALUES (1,1,3,'2023-01-17','14:00:00','2023-01-17','15:50:00','2023-01-17 14:00:00');
/*!40000 ALTER TABLE `asignaristudenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendar`
--

DROP TABLE IF EXISTS `calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendar` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idA` int NOT NULL,
  `startDate` date NOT NULL,
  `startTime` time NOT NULL,
  `endDate` date NOT NULL,
  `endTime` time NOT NULL,
  `start` datetime GENERATED ALWAYS AS (concat(`startDate`,_utf8mb4' ',`startTime`)) VIRTUAL,
  PRIMARY KEY (`id`),
  KEY `idA` (`idA`),
  CONSTRAINT `calendar_ibfk_1` FOREIGN KEY (`idA`) REFERENCES `activitate` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendar`
--

LOCK TABLES `calendar` WRITE;
/*!40000 ALTER TABLE `calendar` DISABLE KEYS */;
INSERT INTO `calendar` (`id`, `idA`, `startDate`, `startTime`, `endDate`, `endTime`) VALUES (1,1,'2023-01-17','14:00:00','2023-01-17','15:50:00');
/*!40000 ALTER TABLE `calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendargrup`
--

DROP TABLE IF EXISTS `calendargrup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendargrup` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idG` int DEFAULT NULL,
  `startDate` date NOT NULL,
  `startTime` time NOT NULL,
  `start` datetime GENERATED ALWAYS AS (concat(`startDate`,_utf8mb4' ',`startTime`)) VIRTUAL,
  `anunt` datetime DEFAULT NULL,
  `timp` int DEFAULT NULL,
  `nrMin` int DEFAULT NULL,
  `nrStud` int DEFAULT NULL,
  `nume` varchar(20) DEFAULT NULL,
  `expirata` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idG` (`idG`),
  CONSTRAINT `calendargrup_ibfk_1` FOREIGN KEY (`idG`) REFERENCES `grup` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendargrup`
--

LOCK TABLES `calendargrup` WRITE;
/*!40000 ALTER TABLE `calendargrup` DISABLE KEYS */;
INSERT INTO `calendargrup` (`id`, `idG`, `startDate`, `startTime`, `anunt`, `timp`, `nrMin`, `nrStud`, `nume`, `expirata`) VALUES (1,1,'2023-01-14','18:00:00','2023-01-13 02:31:51',4,2,0,'AprofundCuProfCAN',1);
/*!40000 ALTER TABLE `calendargrup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog`
--

DROP TABLE IF EXISTS `catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idA` int DEFAULT NULL,
  `idS` int DEFAULT NULL,
  `nota` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idA` (`idA`),
  KEY `idS` (`idS`),
  CONSTRAINT `catalog_ibfk_1` FOREIGN KEY (`idA`) REFERENCES `activitate` (`id`),
  CONSTRAINT `catalog_ibfk_2` FOREIGN KEY (`idS`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog`
--

LOCK TABLES `catalog` WRITE;
/*!40000 ALTER TABLE `catalog` DISABLE KEYS */;
INSERT INTO `catalog` VALUES (1,1,3,2);
/*!40000 ALTER TABLE `catalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contractari`
--

DROP TABLE IF EXISTS `contractari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contractari` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idC` int NOT NULL,
  `idS` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idC` (`idC`),
  KEY `idS` (`idS`),
  CONSTRAINT `contractari_ibfk_1` FOREIGN KEY (`idC`) REFERENCES `curs` (`id`),
  CONSTRAINT `contractari_ibfk_2` FOREIGN KEY (`idS`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contractari`
--

LOCK TABLES `contractari` WRITE;
/*!40000 ALTER TABLE `contractari` DISABLE KEYS */;
INSERT INTO `contractari` VALUES (1,1,3);
/*!40000 ALTER TABLE `contractari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curs`
--

DROP TABLE IF EXISTS `curs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idM` int NOT NULL,
  `idProf` int DEFAULT NULL,
  `nrStud` int DEFAULT NULL,
  `maxStud` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idM` (`idM`),
  KEY `idProf` (`idProf`),
  CONSTRAINT `curs_ibfk_1` FOREIGN KEY (`idM`) REFERENCES `materie` (`id`),
  CONSTRAINT `curs_ibfk_2` FOREIGN KEY (`idProf`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curs`
--

LOCK TABLES `curs` WRITE;
/*!40000 ALTER TABLE `curs` DISABLE KEYS */;
INSERT INTO `curs` VALUES (1,1,1,1,4);
/*!40000 ALTER TABLE `curs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grup`
--

DROP TABLE IF EXISTS `grup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grup` (
  `id` int NOT NULL,
  `idM` int NOT NULL,
  `idS` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idM` (`idM`),
  KEY `idS` (`idS`),
  CONSTRAINT `grup_ibfk_1` FOREIGN KEY (`idM`) REFERENCES `materie` (`id`),
  CONSTRAINT `grup_ibfk_2` FOREIGN KEY (`idS`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grup`
--

LOCK TABLES `grup` WRITE;
/*!40000 ALTER TABLE `grup` DISABLE KEYS */;
INSERT INTO `grup` VALUES (1,1,3);
/*!40000 ALTER TABLE `grup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materie`
--

DROP TABLE IF EXISTS `materie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descriere` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materie`
--

LOCK TABLES `materie` WRITE;
/*!40000 ALTER TABLE `materie` DISABLE KEYS */;
INSERT INTO `materie` VALUES (1,'CAN'),(2,'POO'),(3,'MES'),(4,'MSI'),(5,'BD'),(6,'AF');
/*!40000 ALTER TABLE `materie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(20) DEFAULT NULL,
  `prenume` varchar(20) DEFAULT NULL,
  `cnp` varchar(13) DEFAULT NULL,
  `adresa` varchar(255) DEFAULT NULL,
  `telefon` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `iban` varchar(24) DEFAULT NULL,
  `nrContract` int DEFAULT NULL,
  `departament` varchar(10) DEFAULT NULL,
  `nrOrePred` int DEFAULT NULL,
  `oreMin` int DEFAULT NULL,
  `oreMax` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'Peculea','Adrian','5000000000001','ClujN','0710000000','Adrian.Peculea@cs.utcluj.ro','RO1000000000000000000000',2,'CS',0,4,10),(2,'Brehar','Raluca','5000000000002','ClujN','0710000001','Raluca.Brehar@cs.utcluj.ro','RO1000000000000000000001',3,'CS',0,8,14),(3,'Giosan','Ioan','5000000000003','ClujN','0710000002','Ioan.Giosan@cs.utcluj.ro','RO1000000000000000000002',4,'CS',0,6,12),(4,'Munteanu','Radu','5000000000004','ClujN','0710000003','Radu.Munteanu@ethm.utcluj.ro','RO1000000000000000000003',5,'ETHM',0,2,8),(5,'Gavrea','Ioan','5000000000005','ClujN','0710000004','Ioan.Gavrea@math.utcluj.ro','RO1000000000000000000004',6,'MATH',0,4,10),(6,'Potolea','Rodica','5000000000006','ClujN','0710000005','Rodica.Potolea@cs.utcluj.ro','RO1000000000000000000005',7,'CS',0,8,16),(7,'Oprisa','Ciprian','5000000000007','ClujN','0710000006','Ciprian.Oprisa@cs.utcluj.ro','RO1000000000000000000006',8,'CS',0,8,18),(8,'Ivan','Cosmina','5000000000008','ClujN','0710000007','Cosmina.Ivan@cs.utcluj.ro','RO1000000000000000000007',9,'CS',0,6,12);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(20) DEFAULT NULL,
  `prenume` varchar(20) DEFAULT NULL,
  `cnp` varchar(13) DEFAULT NULL,
  `adresa` varchar(255) DEFAULT NULL,
  `telefon` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `iban` varchar(24) DEFAULT NULL,
  `nrContract` int DEFAULT NULL,
  `an` int DEFAULT NULL,
  `nrOre` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Nistor','Sebastian','5100000000000','Sinaia, Gorj','0375546862','sebinistor@gmail.com','RO04MEBP0MT4208QOMI0ALNO',1000,2,26),(2,'Munteanu','Igor','5100000000001','Băile Tușnad, Brașov','0741666614','igormunte@gmail.com','RO35QIHY67WA029M9E5H6TJZ',1001,1,28),(3,'Florescu','Ana','5100000000002','Frasin, Vâlcea','0784080865','anaflorescu@gmail.com','RO33QZLVRT5FJFQGC8UY6WL5',1002,3,22),(4,'Gheorghiu','Cristi','5100000000003','Sebeș, Dolj','0719930993','cristighe@gmail.com','RO14HGOZ2P523E7MNU81IF01',1003,4,18),(5,'Dimitrescu','Lucia','5100000000004','Vânju Mare, Olt','0248181826','luciadumi@gmail.com','RO07NWOUJZL12ML3S6AZ253S',1004,2,22),(6,'Tamas','Sergiu','5100000000005','Mun. Turda, Sibiu','0256569760','sergiutami@gmail.com','RO65FMSYK8U78R05CV7M6745',1005,1,20);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `super_admin`
--

DROP TABLE IF EXISTS `super_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `super_admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(20) DEFAULT NULL,
  `prenume` varchar(20) DEFAULT NULL,
  `cnp` varchar(13) DEFAULT NULL,
  `adresa` varchar(255) DEFAULT NULL,
  `telefon` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `iban` varchar(24) DEFAULT NULL,
  `nrContract` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `super_admin`
--

LOCK TABLES `super_admin` WRITE;
/*!40000 ALTER TABLE `super_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `super_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'proiectbd'
--
/*!50106 SET @save_time_zone= @@TIME_ZONE */ ;
/*!50106 DROP EVENT IF EXISTS `Activit` */;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`anaflorescu@gmail.com`@`localhost`*/ /*!50106 EVENT `Activit` ON SCHEDULE AT '2023-01-13 01:00:02' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'Activit'); update calendargrup set expirata = 1; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `aprof` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`oanapavel@gmail.com`@`localhost`*/ /*!50106 EVENT `aprof` ON SCHEDULE AT '2022-12-24 17:53:13' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'aprof'); delete from calendargrup where calendargrup.nume = 'aprof' and nrStud<nrMin; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `AprofCuProf` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`anaflorescu@gmail.com`@`localhost`*/ /*!50106 EVENT `AprofCuProf` ON SCHEDULE AT '2023-01-13 02:25:03' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'AprofCuProf'); update calendargrup set expirata = 1; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `Aprofundare` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`oanapavel@gmail.com`@`localhost`*/ /*!50106 EVENT `Aprofundare` ON SCHEDULE AT '2022-12-24 18:04:24' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'Aprofundare'); delete from calendargrup where calendargrup.nume = 'Aprofundare' and nrStud<nrMin; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `Aprofundare12` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`anaflorescu@gmail.com`@`localhost`*/ /*!50106 EVENT `Aprofundare12` ON SCHEDULE AT '2023-01-13 00:56:04' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'Aprofundare12'); update calendargrup set expirata = 1; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `Aprofundare123` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`anaflorescu@gmail.com`@`localhost`*/ /*!50106 EVENT `Aprofundare123` ON SCHEDULE AT '2023-01-13 00:55:27' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'Aprofundare123'); update calendargrup set expirata = 1; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `Aprofundare1234` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`anaflorescu@gmail.com`@`localhost`*/ /*!50106 EVENT `Aprofundare1234` ON SCHEDULE AT '2023-01-13 00:57:10' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'Aprofundare1234'); update calendargrup set expirata = 1; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `Aprofundare12345` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`anaflorescu@gmail.com`@`localhost`*/ /*!50106 EVENT `Aprofundare12345` ON SCHEDULE AT '2023-01-13 00:57:22' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'Aprofundare12345'); update calendargrup set expirata = 1; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `AprofundareCuProf` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`anaflorescu@gmail.com`@`localhost`*/ /*!50106 EVENT `AprofundareCuProf` ON SCHEDULE AT '2023-01-13 02:15:20' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'AprofundareCuProf'); update calendargrup set expirata = 1; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `AprofundareCuProf1` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`anaflorescu@gmail.com`@`localhost`*/ /*!50106 EVENT `AprofundareCuProf1` ON SCHEDULE AT '2023-01-13 02:16:52' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'AprofundareCuProf1'); update calendargrup set expirata = 1; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `AprofundareCuProfu` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`anaflorescu@gmail.com`@`localhost`*/ /*!50106 EVENT `AprofundareCuProfu` ON SCHEDULE AT '2023-01-13 02:06:03' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'AprofundareCuProfu'); update calendargrup set expirata = 1; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `AprofundareCuProfu1` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`anaflorescu@gmail.com`@`localhost`*/ /*!50106 EVENT `AprofundareCuProfu1` ON SCHEDULE AT '2023-01-13 02:08:25' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'AprofundareCuProfu1'); update calendargrup set expirata = 1; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `AprofundCuProf` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`anaflorescu@gmail.com`@`localhost`*/ /*!50106 EVENT `AprofundCuProf` ON SCHEDULE AT '2023-01-13 02:20:57' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'AprofundCuProf'); update calendargrup set expirata = 1; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `AprofundCuProfCAN` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`anaflorescu@gmail.com`@`localhost`*/ /*!50106 EVENT `AprofundCuProfCAN` ON SCHEDULE AT '2023-01-13 02:35:51' ON COMPLETION PRESERVE DISABLE DO BEGIN delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = 'AprofundCuProfCAN'); update calendargrup set expirata = 1; END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
DELIMITER ;
/*!50106 SET TIME_ZONE= @save_time_zone */ ;

--
-- Dumping routines for database 'proiectbd'
--
/*!50003 DROP PROCEDURE IF EXISTS `adaugaNota` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adaugaNota`(nume varchar(20), prenume varchar(20), activitate varchar(20), nota float, idProf int, pondere float)
BEGIN
Set @idStud =(Select id from student where student.nume=nume and student.prenume=prenume); 
if(EXISTS(Select contractari.idS from contractari join curs on(curs.id=contractari.idC) where curs.idProf=idProf and idS=@idStud)) then
if(EXISTS(select * from asignaristudenti join calendar on (asignaristudenti.idCa=calendar.id) where calendar.idA=(Select activitate.id from activitate join Curs on(activitate.idC=curs.id) join contractari on (contractari.idC=curs.id) join Materie 
on (curs.idM=materie.id) where activitate.nume=activitate and curs.idProf = idProf and contractari.idS=@idStud) and asignaristudenti.idS=@idStud))then
if(NOT EXISTS(SELECT nota from Catalog where idS=@idStud and Catalog.idA=
(Select activitate.id from activitate join Curs on(activitate.idC=curs.id) join contractari on (contractari.idC=curs.id) join Materie 
on (curs.idM=materie.id) where activitate.nume=activitate and curs.idProf = idProf and contractari.idS=@idStud)))then
Set @idAct =(Select activitate.id from activitate join curs on(curs.id=activitate.idC) where curs.idProf=idProf and activitate.nume=activitate);
insert into Catalog(idA, idS, nota) values (@idAct, @idStud, nota*pondere);
end if;
end if;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `asigneazaGrupActivitate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `asigneazaGrupActivitate`(nume varchar(20), idS int)
BEGIN
Set @anunt = (Select anunt from calendargrup where calendargrup.nume=nume);
Set @timp = (Select timp from calendargrup where calendargrup.nume=nume);
SET @nrMin = (Select nrMin from calendargrup where calendargrup.nume=nume);
SET @startA = (Select start from calendargrup where calendargrup.nume=nume);
if(@startA>now())then
insert into asignarigrup (idCG, idS) values((Select id from calendargrup where calendargrup.nume=nume), idS);
update calendargrup SET nrStud=nrStud+1;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `asigneazaGrupActivitateProf` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `asigneazaGrupActivitateProf`(nume varchar(20), idPr int)
BEGIN
SET @startA = (Select start from calendargrup where calendargrup.nume=nume);
if(@startA>now())then
insert into asignarigrup (idCG, idP) values((Select id from calendargrup where calendargrup.nume=nume), idPr);
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `asigneazaProfesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `asigneazaProfesor`(nume varchar(20), prenume varchar(20), departament varchar(10), materie varchar(20), activitate varchar(20), nrMaxStud int)
BEGIN
IF(departament=(Select Profesor.departament from Profesor where Profesor.nume = nume and Profesor.prenume=prenume LIMIT 1)) then
begin
if(NOT EXISTS(Select idM, idProf from Curs where idM = (Select id from Materie where Materie.descriere = materie LIMIT 1) and idProf = 
(Select id from Profesor where Profesor.nume = nume and Profesor.prenume=prenume and Profesor.departament=departament LIMIT 1)LIMIT 1)) 
then
insert into Curs(idM, idProf, nrStud, maxStud) values ((Select id from Materie where Materie.descriere = materie LIMIT 1),
 (Select id from Profesor where Profesor.nume = nume and Profesor.prenume=prenume and Profesor.departament=departament LIMIT 1), 0, nrMaxStud);
 end IF;
 insert into Activitate (idC, nume) values ((Select id from Curs where idM = 
 (Select id from Materie where Materie.descriere = materie LIMIT 1) and 
 idProf = (Select id from Profesor where Profesor.nume = nume and Profesor.prenume=prenume and Profesor.departament=departament LIMIT 1)LIMIT 1),  activitate);
 end;
 END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `asigneazaStudentA` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `asigneazaStudentA`(nume varchar(20), prenume varchar(20), materie varchar(20), activitate varchar(20))
BEGIN

Set @idStud = (select id from student where Student.nume=nume and student.prenume=prenume);

if(EXISTS(Select * from calendar join Activitate on(Calendar.idA = Activitate.id) join Curs on(Activitate.idC=Curs.id) 
join contractari on(curs.id=contractari.idC) join Materie on(Curs.idM=Materie.id) where idS=@idStud and Materie.descriere=materie and activitate.nume=activitate))then

Set @idCalendar = (Select Calendar.id from Calendar join Activitate on (Calendar.idA = Activitate.id) join Curs on (Activitate.idC = Curs.id)
join Contractari on (Curs.id = Contractari.idC) join Materie on (Curs.idM = Materie.id) where contractari.idS = @idStud and Materie.descriere=materie and
Activitate.nume = activitate and start not in (Select startA from asignaristudenti where idS = @idStud) limit 1);

insert into asignaristudenti (idCa, idS, startDateA, startTimeA, endDateA,endTimeA, startA) values(@idCalendar, @idStud, 
(Select startDate from calendar where id=@idCalendar), (Select startTime from calendar where id=@idCalendar),
(Select endDate from calendar where id=@idCalendar), (Select endTime from calendar where id=@idCalendar), 
(Select start from calendar where id=@idCalendar));
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `asigneazaStudentC` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `asigneazaStudentC`(nume varchar(20), prenume varchar(20), materie varchar(20))
BEGIN
if(exists(Select id from Student where Student.nume=nume and Student.prenume=prenume)) then
if(EXISTS(SELECT idM, count(idM) from Curs where idM = (select id from Materie where Materie.descriere = materie) Group By idM Having count(idM)>1)) then
SET @idProff = (Select idProf from curs where idM = (select id from Materie where Materie.descriere = materie Limit 1) and 
nrStud = (Select min(nrStud) from curs where idM = (select id from Materie where Materie.descriere = materie Limit 1)Limit 1)Limit 1);
SET @idCC = (select id from curs where Curs.idProf=@idProff);
insert into Contractari(idC, idS) values (@idCC, (Select id from Student where Student.nume=nume and Student.prenume=prenume));
Update Curs Set nrStud=nrStud+1 where Curs.id = @idCC;
else 
SET @idCC = (Select id from Curs where idM = (select id from Materie where Materie.descriere = materie));
insert into Contractari(idC, idS) values (@idcc,
(Select id from Student where Student.nume=nume and Student.prenume=prenume));
Update Curs Set nrStud=nrStud+1 where id = @idCC;
end if;
end if;
if((Select nrStud from curs where id=@idCC)>(Select maxStud from curs where id=@idCC))
then
delete from contractari where idS = (Select id from student where Student.nume=nume and Student.prenume=prenume);
Update Curs Set nrStud=nrStud-1 where id = @idCC;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inscriereGrup` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inscriereGrup`(materie varchar(20), idStud int)
BEGIN
if(NOT EXISTS(Select * from Grup where idS=idStud and idM=(Select id from materie where materie.descriere=materie)))then
if(EXISTS(Select * from materie where materie.descriere=materie))then
if(Exists(Select * from student where student.id=idStud))then
if(EXISTS(Select * from contractari join Curs on (curs.id=contractari.idC) where contractari.idS=idStud and curs.idM=
(Select id from materie where materie.descriere=materie))) then
insert into Grup(id, idM, idS) values((select id from materie where materie.descriere=materie), (select id from materie where materie.descriere=materie), idStud);
end if;
end if;
end if;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertAdmin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertAdmin`(
nume varchar(20),
prenume varchar(20),
cnp varchar(13), 
adresa varchar(50),
telefon varchar(10),
email varchar(30),
iban varchar(24),
nrContract int)
BEGIN
 DECLARE `_HOST` CHAR(14) DEFAULT '@\'localhost\'';
if(NOT EXISTS(SELECT * from Admin where Admin.cnp = cnp and Admin.nrContract=nrContract)) then
begin
    insert into Admin (nume, prenume, cnp, adresa, telefon, email, iban, nrContract) values (nume, prenume, cnp, adresa, telefon, email, iban, nrContract);
    end;
    end if;
    SET email := CONCAT('\'', REPLACE(TRIM(email), CHAR(39), CONCAT(CHAR(92), CHAR(39))), '\'');
    SET @sql := CONCAT('CREATE USER IF NOT EXISTS', email, `_HOST`, ' IDENTIFIED BY ''admin''');
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    SET @sql := CONCAT('GRANT Admin TO ', email, `_HOST`);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
	SET @sql := CONCAT('SET DEFAULT ROLE Admin TO ', email, `_HOST`);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
    FLUSH PRIVILEGES;
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertProfesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProfesor`(
nume varchar(20),
prenume varchar(20),
cnp varchar(13), 
adresa varchar(50),
telefon varchar(10),
email varchar(30),
iban varchar(24),
nrContract int,
departament varchar(10),
nrOrePred int,
oreMin int,
oreMax int)
BEGIN
 DECLARE `_HOST` CHAR(14) DEFAULT '@\'localhost\'';
if(NOT EXISTS(SELECT * from Profesor where Profesor.cnp = cnp and Profesor.nrContract=nrContract)) then
begin
    insert into Profesor (nume, prenume, cnp, adresa, telefon, email, iban, nrContract, departament, nrOrePred, oreMin, oreMax) values (nume, prenume, cnp, adresa, telefon, email, iban, nrContract, departament, nrOrePred, oreMin, oreMax);
    end;
    end if;
    SET email := CONCAT('\'', REPLACE(TRIM(email), CHAR(39), CONCAT(CHAR(92), CHAR(39))), '\'');
    SET @sql := CONCAT('CREATE USER IF NOT EXISTS', email, `_HOST`, ' IDENTIFIED BY ''profesor''');
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    SET @sql := CONCAT('GRANT Profesor TO ', email, `_HOST`);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
	SET @sql := CONCAT('SET DEFAULT ROLE Profesor TO ', email, `_HOST`);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
    FLUSH PRIVILEGES;
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertStudent`(
nume varchar(20),
prenume varchar(20),
cnp varchar(13), 
adresa varchar(50),
telefon varchar(10),
email varchar(30),
iban varchar(24),
nrContract int, 
an int, nrOre int)
BEGIN
 DECLARE `_HOST` CHAR(14) DEFAULT '@\'localhost\'';
if(NOT EXISTS(SELECT * from Student where Student.cnp = cnp and Student.nrContract=nrContract)) then
begin
    insert into Student (nume, prenume, cnp, adresa, telefon, email, iban, nrContract, an, nrOre) values (nume, prenume, cnp, adresa, telefon, email, iban, nrContract, an, nrOre);
    end;
    end if;
    SET email := CONCAT('\'', REPLACE(TRIM(email), CHAR(39), CONCAT(CHAR(92), CHAR(39))), '\'');
    SET @sql := CONCAT('CREATE USER IF NOT EXISTS', email, `_HOST`, ' IDENTIFIED BY ''student''');
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    SET @sql := CONCAT('GRANT Student TO ', email, `_HOST`);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
	SET @sql := CONCAT('SET DEFAULT ROLE Student TO ', email, `_HOST`);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
    FLUSH PRIVILEGES;
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertSuper_Admin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSuper_Admin`(
nume varchar(20),
prenume varchar(20),
cnp varchar(13), 
adresa varchar(50),
telefon varchar(10),
email varchar(30),
iban varchar(24),
nrContract int)
BEGIN
 DECLARE `_HOST` CHAR(14) DEFAULT '@\'localhost\'';
if(NOT EXISTS(SELECT * from Super_Admin where Super_Admin.cnp = cnp and Super_Admin.nrContract=nrContract)) then
begin
    insert into Super_Admin (nume, prenume, cnp, adresa, telefon, email, iban, nrContract) values (nume, prenume, cnp, adresa, telefon, email, iban, nrContract);
    end;
    end if;
    SET email := CONCAT('\'', REPLACE(TRIM(email), CHAR(39), CONCAT(CHAR(92), CHAR(39))), '\'');
    SET @sql := CONCAT('CREATE USER IF NOT EXISTS', email, `_HOST`, ' IDENTIFIED BY ''Sadmin''');
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    SET @sql := CONCAT('GRANT Super_Admin TO ', email, `_HOST`);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
	SET @sql := CONCAT('SET DEFAULT ROLE Super_Admin TO ', email, `_HOST`);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
    FLUSH PRIVILEGES;
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `programeazaActivitate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `programeazaActivitate`(num varchar(20), idPr int, startD date, startT time, endD date, endT time)
BEGIN
if((Concat(startD, " ", startT)>NOW())) then
insert into calendar(idA, startDate, startTime, endDate, endTime) values ((Select id from activitate where activitate.nume=num and idC=
(Select id from curs where idProf = idPr)), startD, startT, endD, endT);
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `programeazaActivitateGrup` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `programeazaActivitateGrup`(nume varchar(20), startD DATE, startT TIME, idGr int, nrMinS int, timpValidare int)
BEGIN
if(NOT EXISTS(Select * from calendargrup where calendargrup.nume=nume)) then
insert into calendargrup(idG, startDate, startTime, anunt, timp, nrMin, nume, nrStud, expirata) values(idGr, startD, startT, NOW(), timpValidare, nrMinS, nume, 0, 0);
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateProfesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateProfesor`(emailOld varchar(50),	
nume varchar(20),
prenume varchar(20),
cnp varchar(13), 
adresa varchar(255),
telefon varchar(10),
email varchar(50),
iban varchar(24),
nrContract int,
departament VARCHAR(10),
nrOrePred int,
oreMin int,
oreMax int)
BEGIN
 DECLARE `_HOST` CHAR(14) DEFAULT '@\'localhost\'';
UPDATE PROFESOR SET profesor.nume = nume, profesor.prenume = prenume, profesor.cnp = cnp, profesor.adresa=adresa, profesor.telefon=telefon,
profesor.email=email, profesor.iban=iban, profesor.nrContract=nrContract, profesor.departament=departament, profesor.nrOrePred=nrOrePred,
profesor.oreMin=oreMin, profesor.oreMax=oreMax;
    SET emailOld := CONCAT('\'', REPLACE(TRIM(emailOld), CHAR(39), CONCAT(CHAR(92), CHAR(39))), '\'');
    SET email := CONCAT('\'', REPLACE(TRIM(email), CHAR(39), CONCAT(CHAR(92), CHAR(39))), '\'');
    SET @sql := CONCAT('RENAME USER ', emailOld, `_HOST`, ' TO ', email, `_HOST`);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
    FLUSH PRIVILEGES;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateStudent`(emailOld varchar(50),	
nume varchar(20),
prenume varchar(20),
cnp varchar(13), 
adresa varchar(255),
telefon varchar(10),
email varchar(50),
iban varchar(24),
nrContract int,
an int,
nrOre int)
BEGIN
 DECLARE `_HOST` CHAR(14) DEFAULT '@\'localhost\'';
UPDATE student SET student.nume = nume, student.prenume = prenume, student.cnp = cnp, student.adresa=adresa, student.telefon=telefon,
student.email=email, student.iban=iban, student.nrContract=nrContract, student.an=an, student.nrOre=nrOre;
    SET emailOld := CONCAT('\'', REPLACE(TRIM(emailOld), CHAR(39), CONCAT(CHAR(92), CHAR(39))), '\'');
    SET email := CONCAT('\'', REPLACE(TRIM(email), CHAR(39), CONCAT(CHAR(92), CHAR(39))), '\'');
    SET @sql := CONCAT('RENAME USER ', emailOld, `_HOST`, ' TO ', email, `_HOST`);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
    FLUSH PRIVILEGES;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-19 22:17:34
