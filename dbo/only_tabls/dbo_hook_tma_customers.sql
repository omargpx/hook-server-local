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
-- Table structure for table `tma_customers`
--

DROP TABLE IF EXISTS `tma_customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tma_customers` (
  `id_customer` int NOT NULL AUTO_INCREMENT,
  `no_customer` varchar(95) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `nu_identification` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `de_reference` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `di_customer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
  `es_sale` bit(1) DEFAULT b'0',
  `id_cus_routes` int NOT NULL,
  `id_cus_district` int NOT NULL,
  `id_cus_location` int DEFAULT NULL,
  `id_cus_business` int NOT NULL,
  PRIMARY KEY (`id_customer`),
  UNIQUE KEY `NU_IDENTIFICACION_UNIQUE` (`nu_identification`),
  KEY `fk_TMA_CUSTOMERS_TMV_COMPANY_ROUTES1_idx` (`id_cus_routes`),
  KEY `fk_tma_customers_tax_district1_idx` (`id_cus_district`),
  KEY `fk_tma_customer_location_idx` (`id_cus_location`),
  KEY `fk_tma_business_customers_idx` (`id_cus_business`),
  CONSTRAINT `fk_tma_business_customers` FOREIGN KEY (`id_cus_business`) REFERENCES `tma_business` (`id_business`),
  CONSTRAINT `fk_tma_customer_location` FOREIGN KEY (`id_cus_location`) REFERENCES `tax_locations` (`id_location`),
  CONSTRAINT `fk_tma_customers_tax_district1` FOREIGN KEY (`id_cus_district`) REFERENCES `tax_district` (`id_district`),
  CONSTRAINT `fk_TMA_CUSTOMERS_TMV_COMPANY_ROUTES1` FOREIGN KEY (`id_cus_routes`) REFERENCES `tax_routes` (`id_route`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tma_customers`
--

LOCK TABLES `tma_customers` WRITE;
/*!40000 ALTER TABLE `tma_customers` DISABLE KEYS */;
INSERT INTO `tma_customers` VALUES (1,'Testing person','75968423','La Molina','Av. Tupac ruperto 542',_binary '',3,25,1,1),(4,'Test 2','11968423','Las flores','Av. Tupac ruperto 532',_binary '\0',3,25,8,1),(9,'Test 2asdasdad','119681423','Las flores','Av. Tupac ruperto 532',_binary '\0',3,25,NULL,1),(10,'Test 2asdasdad','119231423','Las flores','Av. Tupac ruperto 532',_binary '\0',3,25,NULL,1),(11,'David Prada','74228776','Al frente de carnicería San Martín ','Av. cuzco',_binary '\0',2,670,NULL,1),(12,'jjkkkknn','00008888','vhjbbjgcg','ycgbhgc',_binary '\0',6,764,NULL,1),(13,'Roberto 001','00086356','frente a la plaza de armas','Av. pamashto',_binary '\0',6,1733,NULL,1);
/*!40000 ALTER TABLE `tma_customers` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `TRG_INSERT_CUSTOMERS` AFTER INSERT ON `tma_customers` FOR EACH ROW BEGIN
  DECLARE log_body VARCHAR(255);
  
  -- Generar la línea de código ejecutada
  SET log_body = CONCAT(
    'INSERT INTO TMA_CUSTOMERS VALUES(''',
    NEW.id_customer, ''',''',
    NEW.no_customer, ''',''',
    NEW.nu_identification, ''',''',
    NEW.de_reference, ''',''',
    NEW.di_customer, ''',''',
    NEW.id_cus_business, ''',''',
    NEW.id_cus_routes, ''',''',
    NEW.id_cus_district, ''');'
  );
  
  -- Insertar los detalles en la tabla log_customer
  INSERT INTO tmp_log_customer (body, customer_id,user_db)
  VALUES (log_body, NEW.id_customer,USER());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `TRG_UPDATE_CUSTOMERS` AFTER UPDATE ON `tma_customers` FOR EACH ROW BEGIN
  DECLARE log_body VARCHAR(255);
  
  -- Generar la línea de código ejecutada
  SET log_body = CONCAT(
    'UPDATE TMA_CUSTOMERS SET id_customer=''',
    NEW.id_customer, ''', no_customer=''',
    NEW.no_customer, ''', nu_identification=''',
    NEW.nu_identification, ''', de_reference=''',
    NEW.de_reference, ''', di_customer=''',
    NEW.di_customer, ''', id_cus_business=''',
    NEW.id_cus_business, ''', id_cus_routes''',
    NEW.id_cus_routes, ''', id_cus_location''',
    NEW.id_cus_location, ''', id_cus_district''',
    NEW.id_cus_district, ''');'
  );
  
  -- Insertar los detalles en la tabla log_customer
  INSERT INTO tmp_log_customer (body, customer_id,user_db)
  VALUES (log_body, NEW.id_customer,USER());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `TRG_DELETE_CUSTOMERS` AFTER DELETE ON `tma_customers` FOR EACH ROW BEGIN
  DECLARE log_body VARCHAR(255);
  
  -- Generar la línea de código ejecutada
  SET log_body = CONCAT(
    'DELETE FROM TMA_CUSTOMERS WHERE id_customer=''',
    old.id_customer,''');'
  );
  
  -- Insertar los detalles en la tabla log_customer
  INSERT INTO tmp_log_customer (body, customer_id,user_db)
  VALUES (log_body, old.id_customer,USER());
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
