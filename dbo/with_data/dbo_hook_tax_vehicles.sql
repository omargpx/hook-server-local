-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbo_hook
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `tax_vehicles`
--

DROP TABLE IF EXISTS `tax_vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tax_vehicles` (
  `id_vehicle` int NOT NULL AUTO_INCREMENT,
  `co_vehicle` varchar(45) NOT NULL,
  `nu_wheels` int NOT NULL,
  `identifier_plate` varchar(15) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `id_vehicles_business` int NOT NULL,
  PRIMARY KEY (`id_vehicle`),
  KEY `fk_tax_vehicles_tma_business1_idx` (`id_vehicles_business`),
  CONSTRAINT `fk_tax_vehicles_tma_business1` FOREIGN KEY (`id_vehicles_business`) REFERENCES `tma_business` (`id_business`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax_vehicles`
--

LOCK TABLES `tax_vehicles` WRITE;
/*!40000 ALTER TABLE `tax_vehicles` DISABLE KEYS */;
INSERT INTO `tax_vehicles` VALUES (1,'AP23-ADañsLa',4,'PE-2424','VOLVO',1),(2,'AP23-ajdQWs',4,'PE-7505','MERCEDES-BENZ',1);
/*!40000 ALTER TABLE `tax_vehicles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-13  1:42:12
