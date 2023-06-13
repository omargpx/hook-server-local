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
-- Table structure for table `tmp_log_customer`
--

DROP TABLE IF EXISTS `tmp_log_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tmp_log_customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `body` varchar(255) DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `user_db` varchar(45) DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_log_customer`
--

LOCK TABLES `tmp_log_customer` WRITE;
/*!40000 ALTER TABLE `tmp_log_customer` DISABLE KEYS */;
INSERT INTO `tmp_log_customer` VALUES (1,'INSERT INTO TMA_CUSTOMERS VALUES(\'1\',\'gus test\',\'1111111\',\'frente al instituto..\',\'Jr. Bolivar 421\',\'1\',\'1\',\'1\');',1,'hook@localhost','2023-05-22 19:14:05'),(2,'UPDATE TMA_CUSTOMERS SET id_customer=\'1\',no_customer=\'gus test\',nu_identificacion=\'1111111\',de_reference=\'frente al instituto FELISIDAS\',di_customer=\'Jr. Bolivar 421\',id_cus_business=\'1\',id_cus_routes=\'1\',id_cus_district=\'1\');',1,'hook@localhost','2023-05-22 19:23:28'),(3,'DELETE FROM TMA_CUSTOMERS WHERE id_customer=\'1\');',1,'hook@localhost','2023-05-22 19:27:40'),(4,'INSERT INTO TMA_CUSTOMERS VALUES(\'1\',\'gus test\',\'1111111\',\'frente al instituto FELISIDAS\',\'Jr. Bolivar 421\',\'1\',\'1\',\'1\');',1,'hook@localhost','2023-05-22 19:28:05'),(5,'DELETE FROM TMA_CUSTOMERS WHERE id_customer=\'1\');',1,'hook@localhost','2023-05-22 19:28:22'),(6,'INSERT INTO TMA_CUSTOMERS VALUES(\'1\',\'Testing person\',\'75968423\',\'La Molina\',\'Av. Tupac ruperto 542\',\'1\',\'3\',\'25\');',1,'hook@localhost','2023-05-24 23:08:07'),(7,'INSERT INTO TMA_CUSTOMERS VALUES(\'3\',\'Test 2\',\'AP23-749914192\',\'Las flores\',\'Av. Tupac ruperto 532\',\'1\',\'3\',\'25\');',3,'hook@localhost','2023-05-30 20:44:11'),(8,'DELETE FROM TMA_CUSTOMERS WHERE id_customer=\'3\');',3,'hook@localhost','2023-05-30 21:02:38'),(9,'INSERT INTO TMA_CUSTOMERS VALUES(\'4\',\'Test 2\',\'11968423\',\'Las flores\',\'Av. Tupac ruperto 532\',\'1\',\'3\',\'25\');',4,'hook@localhost','2023-05-31 02:36:38'),(10,'UPDATE TMA_CUSTOMERS SET id_customer=\'4\', no_customer=\'Test 2\', nu_identification=\'11968423\', de_reference=\'Las flores\', di_customer=\'Av. Tupac ruperto 532\', id_cus_business=\'1\', id_cus_routes\'3\', id_cus_district\'25\');',4,'hook@localhost','2023-05-31 03:01:22'),(11,'UPDATE TMA_CUSTOMERS SET id_customer=\'4\', no_customer=\'Test 2\', nu_identification=\'11968423\', de_reference=\'Las flores\', di_customer=\'Av. Tupac ruperto 532\', id_cus_business=\'1\', id_cus_routes\'3\', id_cus_location\'6\', id_cus_district\'25\');',4,'hook@localhost','2023-05-31 03:03:31'),(12,'UPDATE TMA_CUSTOMERS SET id_customer=\'1\', no_customer=\'Testing person\', nu_identification=\'75968423\', de_reference=\'La Molina\', di_customer=\'Av. Tupac ruperto 542\', id_cus_business=\'1\', id_cus_routes\'3\', id_cus_location\'1\', id_cus_district\'25\');',1,'hook@localhost','2023-06-02 00:31:26'),(13,'UPDATE TMA_CUSTOMERS SET id_customer=\'4\', no_customer=\'Test 2\', nu_identification=\'11968423\', de_reference=\'Las flores\', di_customer=\'Av. Tupac ruperto 532\', id_cus_business=\'1\', id_cus_routes\'3\', id_cus_location\'7\', id_cus_district\'25\');',4,'hook@localhost','2023-06-05 06:04:48'),(14,'UPDATE TMA_CUSTOMERS SET id_customer=\'4\', no_customer=\'Test 2\', nu_identification=\'11968423\', de_reference=\'Las flores\', di_customer=\'Av. Tupac ruperto 532\', id_cus_business=\'1\', id_cus_routes\'3\', id_cus_location\'7\', id_cus_district\'25\');',4,'hook@localhost','2023-06-11 23:53:41'),(15,'UPDATE TMA_CUSTOMERS SET id_customer=\'4\', no_customer=\'Test 2\', nu_identification=\'11968423\', de_reference=\'Las flores\', di_customer=\'Av. Tupac ruperto 532\', id_cus_business=\'1\', id_cus_routes\'3\', id_cus_location\'7\', id_cus_district\'25\');',4,'hook@localhost','2023-06-12 00:03:51'),(16,'UPDATE TMA_CUSTOMERS SET id_customer=\'4\', no_customer=\'Test 2\', nu_identification=\'11968423\', de_reference=\'Las flores\', di_customer=\'Av. Tupac ruperto 532\', id_cus_business=\'1\', id_cus_routes\'3\', id_cus_location\'7\', id_cus_district\'25\');',4,'hook@localhost','2023-06-12 05:59:23'),(17,'UPDATE TMA_CUSTOMERS SET id_customer=\'4\', no_customer=\'Test 2\', nu_identification=\'11968423\', de_reference=\'Las flores\', di_customer=\'Av. Tupac ruperto 532\', id_cus_business=\'1\', id_cus_routes\'3\', id_cus_location\'7\', id_cus_district\'25\');',4,'hook@localhost','2023-06-12 05:59:29'),(18,'UPDATE TMA_CUSTOMERS SET id_customer=\'4\', no_customer=\'Test 2\', nu_identification=\'11968423\', de_reference=\'Las flores\', di_customer=\'Av. Tupac ruperto 532\', id_cus_business=\'1\', id_cus_routes\'3\', id_cus_location\'7\', id_cus_district\'25\');',4,'hook@localhost','2023-06-12 05:59:35'),(19,'UPDATE TMA_CUSTOMERS SET id_customer=\'4\', no_customer=\'Test 2\', nu_identification=\'11968423\', de_reference=\'Las flores\', di_customer=\'Av. Tupac ruperto 532\', id_cus_business=\'1\', id_cus_routes\'3\', id_cus_location\'8\', id_cus_district\'25\');',4,'hook@localhost','2023-06-12 06:03:55'),(20,'UPDATE TMA_CUSTOMERS SET id_customer=\'4\', no_customer=\'Test 2\', nu_identification=\'11968423\', de_reference=\'Las flores\', di_customer=\'Av. Tupac ruperto 532\', id_cus_business=\'1\', id_cus_routes\'3\', id_cus_location\'8\', id_cus_district\'25\');',4,'hook@localhost','2023-06-12 17:35:31'),(21,'UPDATE TMA_CUSTOMERS SET id_customer=\'4\', no_customer=\'Test 2\', nu_identification=\'11968423\', de_reference=\'Las flores\', di_customer=\'Av. Tupac ruperto 532\', id_cus_business=\'1\', id_cus_routes\'3\', id_cus_location\'8\', id_cus_district\'25\');',4,'hook@localhost','2023-06-12 17:35:44'),(22,'INSERT INTO TMA_CUSTOMERS VALUES(\'9\',\'Test 2asdasdad\',\'119681423\',\'Las flores\',\'Av. Tupac ruperto 532\',\'1\',\'3\',\'25\');',9,'hook@localhost','2023-06-12 22:16:29'),(23,'INSERT INTO TMA_CUSTOMERS VALUES(\'10\',\'Test 2asdasdad\',\'119231423\',\'Las flores\',\'Av. Tupac ruperto 532\',\'1\',\'3\',\'25\');',10,'hook@localhost','2023-06-12 22:16:53'),(24,'INSERT INTO TMA_CUSTOMERS VALUES(\'11\',\'David Prada\',\'74228776\',\'Al frente de carnicería San Martín \',\'Av. cuzco\',\'1\',\'2\',\'670\');',11,'hook@localhost','2023-06-12 22:26:32'),(25,'INSERT INTO TMA_CUSTOMERS VALUES(\'12\',\'jjkkkknn\',\'00008888\',\'vhjbbjgcg\',\'ycgbhgc\',\'1\',\'6\',\'764\');',12,'hook@localhost','2023-06-12 22:39:31'),(26,'INSERT INTO TMA_CUSTOMERS VALUES(\'13\',\'Roberto 001\',\'00086356\',\'frente a la plaza de armas\',\'Av. pamashto\',\'1\',\'6\',\'1733\');',13,'hook@localhost','2023-06-12 23:53:13');
/*!40000 ALTER TABLE `tmp_log_customer` ENABLE KEYS */;
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
