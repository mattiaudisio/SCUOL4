-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: gestioneviaggi_mattia
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `viaggi`
--

DROP TABLE IF EXISTS `viaggi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viaggi` (
  `viaggiID` int NOT NULL AUTO_INCREMENT,
  `PartLocalitaID` int DEFAULT NULL,
  `PartData` date DEFAULT NULL,
  `PartOra` time DEFAULT NULL,
  `ArrivoLocalitaID` int DEFAULT NULL,
  `ArrivoData` date DEFAULT NULL,
  `ArrivoOra` time DEFAULT NULL,
  `NrPosti` int DEFAULT '0',
  `NrPrenotati` int DEFAULT '0',
  `NrConfermati` int DEFAULT '0',
  `CostoPosto` decimal(10,2) DEFAULT '0.00',
  `CostoPostoPrenotazione` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`viaggiID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaggi`
--

LOCK TABLES `viaggi` WRITE;
/*!40000 ALTER TABLE `viaggi` DISABLE KEYS */;
INSERT INTO `viaggi` VALUES (1,5,'2021-06-08','00:45:00',1,'2021-06-10','00:45:00',7,8,9,2.00,3.00),(3,1,'2021-08-09','16:45:00',6,'2021-08-09','16:45:00',9,8,7,40.00,500.00),(5,5,'2021-03-26','18:10:00',1,'2021-03-27','18:10:00',9,5,6,4.00,3.00),(6,5,'2021-03-26','22:10:00',1,'2021-03-27','11:15:00',9,5,6,4.00,3.00);
/*!40000 ALTER TABLE `viaggi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-09 12:20:59
