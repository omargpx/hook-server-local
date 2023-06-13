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
-- Table structure for table `tma_business`
--

DROP TABLE IF EXISTS `tma_business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tma_business` (
  `id_business` int NOT NULL AUTO_INCREMENT,
  `no_business` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `nu_ruc` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `id_bss_district` int NOT NULL,
  `no_zone` varchar(85) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
  `di_business` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
  PRIMARY KEY (`id_business`),
  UNIQUE KEY `NU_RUC_UNIQUE` (`nu_ruc`),
  KEY `fk_tma_business_tax_district1_idx` (`id_bss_district`),
  CONSTRAINT `fk_tma_business_tax_district1` FOREIGN KEY (`id_bss_district`) REFERENCES `tax_district` (`id_district`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tma_business`
--

LOCK TABLES `tma_business` WRITE;
/*!40000 ALTER TABLE `tma_business` DISABLE KEYS */;
INSERT INTO `tma_business` VALUES (1,'Araujo Prada','20601474825',1702,'NO PRECISA','PRO.AV GRAU NRO. S/N (KM1 FTE EXPLANADA PORTON AZUL)  SAN ');
/*!40000 ALTER TABLE `tma_business` ENABLE KEYS */;
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
