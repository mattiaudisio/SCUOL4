-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: asl
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
-- Table structure for table `pazienti`
--

DROP TABLE IF EXISTS `pazienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pazienti` (
  `codiceFiscale` varchar(16) NOT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `data_nascita` date DEFAULT NULL,
  `luogo_nascita` varchar(45) DEFAULT NULL,
  `indirizzo` varchar(45) DEFAULT NULL,
  `dataMedico` date DEFAULT NULL,
  `Medici_codice` int NOT NULL,
  PRIMARY KEY (`codiceFiscale`),
  KEY `fk_Pazienti_Medici_idx` (`Medici_codice`),
  CONSTRAINT `fk_Pazienti_Medici` FOREIGN KEY (`Medici_codice`) REFERENCES `medici` (`codice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pazienti`
--

LOCK TABLES `pazienti` WRITE;
/*!40000 ALTER TABLE `pazienti` DISABLE KEYS */;
INSERT INTO `pazienti` VALUES ('123456789','Zappettini','Giovannantonio ','1995-02-10','Palermo','Via Dante 78','2021-02-04',2),('7fghfhfghrt','Scognamillo','Angelita ','1986-06-25','Bernezzo','Corso Dante 50','2021-02-04',4),('asfeweqwreres','Appolloni ','Oreglio','2001-10-24','Torino','Viale Luigi 23','2021-02-04',1),('bvnntydht','Mastrobuono','Antonico ','2004-06-08','Asti','Piazza Luce 14','2021-02-04',1),('erytretytgfh','Olmi','Mariettina ','1949-05-29','Perugia','Corso Stalin 25','2021-02-04',1),('gfgggg','Ceci','Roldo ','1984-09-27','Parigi','Via Manzoni 14','2021-02-04',6),('hfdgjhgkjhgfk','Della Rovere','Concetta ','1971-10-28','Bologna','Piazza Luigi 23','2021-02-04',1),('rtyyjyt7','Munarin','Furio ','1963-01-01','RoccaBruna','Corso Nizza 14','2021-02-04',5),('uiyuewtertdg','Zuino','Erna ','2002-12-24','Como','Via Italia 64','2021-02-04',2);
/*!40000 ALTER TABLE `pazienti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-04 11:24:37
