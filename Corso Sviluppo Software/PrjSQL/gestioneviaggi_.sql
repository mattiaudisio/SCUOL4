USE gestioneviaggi_mattia;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: gestioneviaggi_guido
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
-- Table structure for table `agenzie`
--

DROP TABLE IF EXISTS `agenzie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agenzie` (
  `agenziaId` int NOT NULL AUTO_INCREMENT,
  `ragioneSociale` varchar(45) NOT NULL,
  PRIMARY KEY (`agenziaId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenzie`
--

LOCK TABLES `agenzie` WRITE;
/*!40000 ALTER TABLE `agenzie` DISABLE KEYS */;
INSERT INTO `agenzie` VALUES (1,'abc'),(2,'werrrr');
/*!40000 ALTER TABLE `agenzie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localita`
--

DROP TABLE IF EXISTS `localita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localita` (
  `localitaID` int NOT NULL AUTO_INCREMENT,
  `localita` varchar(45) NOT NULL,
  `provincia` varchar(4) NOT NULL,
  PRIMARY KEY (`localitaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localita`
--

LOCK TABLES `localita` WRITE;
/*!40000 ALTER TABLE `localita` DISABLE KEYS */;
/*!40000 ALTER TABLE `localita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazioni`
--

DROP TABLE IF EXISTS `prenotazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazioni` (
  `prenotazioneID` int NOT NULL AUTO_INCREMENT,
  `agenziaViaggiId` int DEFAULT NULL,
  `ViaggioID` int DEFAULT NULL,
  `Posti` int DEFAULT '0',
  `prenotati` tinyint DEFAULT '0',
  `Acquistati` tinyint DEFAULT '0',
  `Costo` decimal(10,2) DEFAULT '0.00',
  `Totale` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`prenotazioneID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazioni`
--

LOCK TABLES `prenotazioni` WRITE;
/*!40000 ALTER TABLE `prenotazioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `prenotazioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viaggi`
--

DROP TABLE IF EXISTS `viaggi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viaggi` (
  `viaggioId` int NOT NULL AUTO_INCREMENT,
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
  `CostoPrenotazione` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`viaggioId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaggi`
--

LOCK TABLES `viaggi` WRITE;
/*!40000 ALTER TABLE `viaggi` DISABLE KEYS */;
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

-- Dump completed on 2021-03-15 13:22:59
