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
-- Table structure for table `tax_delivery`
--

DROP TABLE IF EXISTS `tax_delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tax_delivery` (
  `id_delivery` int NOT NULL AUTO_INCREMENT,
  `time` varchar(25) DEFAULT NULL,
  `nu_difficulty` char(1) DEFAULT '1',
  `ti_pay` char(1) DEFAULT '1',
  `desc_delivery` varchar(255) DEFAULT NULL,
  `id_delivery_vehicle_route` int NOT NULL,
  `id_delivery_customer` int NOT NULL,
  PRIMARY KEY (`id_delivery`),
  KEY `fk_tax_entrega_tmv_vehicle_routes1_idx` (`id_delivery_vehicle_route`),
  KEY `fk_tax_launch_tma_customers1_idx` (`id_delivery_customer`),
  CONSTRAINT `fk_tax_entrega_tmv_vehicle_routes1` FOREIGN KEY (`id_delivery_vehicle_route`) REFERENCES `tmv_vehicle_routes` (`id_vehicle_route`),
  CONSTRAINT `fk_tax_launch_tma_customers1` FOREIGN KEY (`id_delivery_customer`) REFERENCES `tma_customers` (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax_delivery`
--

LOCK TABLES `tax_delivery` WRITE;
/*!40000 ALTER TABLE `tax_delivery` DISABLE KEYS */;
INSERT INTO `tax_delivery` VALUES (1,'15 mins','1','2',NULL,1,1),(2,'35 mins','3','2',NULL,1,4),(4,'52 mins','1','2',NULL,2,4),(5,'52 mins','6','2',NULL,2,4),(6,'52 mins','6','2',NULL,2,4),(7,'52 mins','6','2',NULL,2,4),(8,'52 mins','6','2','jajajajja',2,4);
/*!40000 ALTER TABLE `tax_delivery` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `TRG_DELIVERY_SALE_CUSTOMER` AFTER INSERT ON `tax_delivery` FOR EACH ROW BEGIN
  -- actualziar el estado sale del customer a false
  UPDATE tma_customers SET es_sale=false where id_customer = NEW.id_delivery_customer;
END */;;
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

-- Dump completed on 2023-06-13  1:41:32
