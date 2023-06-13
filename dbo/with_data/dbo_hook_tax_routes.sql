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
-- Table structure for table `tax_routes`
--

DROP TABLE IF EXISTS `tax_routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tax_routes` (
  `id_route` int NOT NULL AUTO_INCREMENT,
  `co_route` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `no_route` varchar(85) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `id_rou_business` int NOT NULL,
  PRIMARY KEY (`id_route`),
  KEY `fk_TMV_COMPANY_ROUTES_TMA_BUSINESS1_idx` (`id_rou_business`),
  CONSTRAINT `fk_TMV_COMPANY_ROUTES_TMA_BUSINESS1` FOREIGN KEY (`id_rou_business`) REFERENCES `tma_business` (`id_business`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax_routes`
--

LOCK TABLES `tax_routes` WRITE;
/*!40000 ALTER TABLE `tax_routes` DISABLE KEYS */;
INSERT INTO `tax_routes` VALUES (1,'YTL','yantalo',1),(2,'RCK','rocke',1),(3,'MBB','moyobamba',1),(4,'MRN','marona',1),(5,'PCZ','pacayzapa',1),(6,'ROJ','rioja',1),(7,'POS','posic',1),(8,'YRS','yorongos',1),(9,'NUN','nueva union',1),(10,'SRT','soritor',1),(11,'NRJ','naranjos',1),(12,'NRL','naranjillos',1),(13,'YRC','yuracyacu',1),(14,'VCT','valle la conquista',1),(15,'PLB','pueblo libre',1),(16,'JPL','jepelacio',1);
/*!40000 ALTER TABLE `tax_routes` ENABLE KEYS */;
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
