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
-- Table structure for table `tmv_vehicle_routes`
--

DROP TABLE IF EXISTS `tmv_vehicle_routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tmv_vehicle_routes` (
  `id_vehicle_route` int NOT NULL AUTO_INCREMENT,
  `no_vehicle_route` varchar(75) DEFAULT NULL,
  `id_vr_vehicle` int NOT NULL,
  `id_vr_route` int NOT NULL,
  `date_init` datetime DEFAULT NULL,
  `date_end` datetime DEFAULT NULL,
  `date_execution` date DEFAULT NULL,
  PRIMARY KEY (`id_vehicle_route`),
  KEY `fk_tmv_vehicle_routes_tax_vehicles1_idx` (`id_vr_vehicle`),
  KEY `fk_tmv_vehicle_routes_tax_routes1_idx` (`id_vr_route`),
  CONSTRAINT `fk_tmv_vehicle_routes_tax_routes1` FOREIGN KEY (`id_vr_route`) REFERENCES `tax_routes` (`id_route`),
  CONSTRAINT `fk_tmv_vehicle_routes_tax_vehicles1` FOREIGN KEY (`id_vr_vehicle`) REFERENCES `tax_vehicles` (`id_vehicle`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmv_vehicle_routes`
--

LOCK TABLES `tmv_vehicle_routes` WRITE;
/*!40000 ALTER TABLE `tmv_vehicle_routes` DISABLE KEYS */;
INSERT INTO `tmv_vehicle_routes` VALUES (1,'something',1,4,'2023-05-15 13:35:06','2023-05-18 07:24:35','2023-05-15'),(2,'something actualizado',2,4,'2023-06-12 19:27:32','2023-05-18 07:24:35','2023-05-15'),(3,'bundle_name1',2,3,NULL,NULL,'2023-06-15'),(4,'bundle_name1',2,3,NULL,NULL,'2023-06-15'),(5,'bundle_name1',2,3,NULL,NULL,'2023-06-15');
/*!40000 ALTER TABLE `tmv_vehicle_routes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-13  1:41:32
