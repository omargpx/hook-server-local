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
-- Table structure for table `tax_department`
--

DROP TABLE IF EXISTS `tax_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tax_department` (
  `id_department` int NOT NULL,
  `no_department` varchar(45) NOT NULL,
  PRIMARY KEY (`id_department`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax_department`
--

LOCK TABLES `tax_department` WRITE;
/*!40000 ALTER TABLE `tax_department` DISABLE KEYS */;
INSERT INTO `tax_department` VALUES (1,'AMAZONAS'),(2,'ANCASH'),(3,'APURIMAC'),(4,'AREQUIPA'),(5,'AYACUCHO'),(6,'CAJAMARCA'),(7,'CALLAO'),(8,'CUSCO'),(9,'HUANCAVELICA'),(10,'HUANUCO'),(11,'ICA'),(12,'JUNIN'),(13,'LA LIBERTAD'),(14,'LAMBAYEQUE'),(15,'LIMA'),(16,'LORETO'),(17,'MADRE DE DIOS'),(18,'MOQUEGUA'),(19,'PASCO'),(20,'PIURA'),(21,'PUNO'),(22,'SAN MARTIN'),(23,'TACNA'),(24,'TUMBES'),(25,'UCAYALI');
/*!40000 ALTER TABLE `tax_department` ENABLE KEYS */;
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
