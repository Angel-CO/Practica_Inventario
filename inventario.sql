-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: inventario
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `clave` varchar(10) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  `unidad` varchar(20) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  PRIMARY KEY (`clave`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES ('aaa','La lechera','Leche condensada Nestlé 387g','Lata',50,21.5),('bbb','Coca-Cola','Refresco de cola 500 ml','Botella',30,11),('ccc','Lala','Leche Lala entera 1 l','Caja',30,21.9),('ddd','Nutrioli','Aceite puro de soya DHA 850 ml','Botella',50,36.9),('eee','Ariel','Detergente en polvo 800 g','Bolsa',40,32),('fff','Alpura','Yoghurt Alpura con fresa 1 kg','Bote',50,28.8),('ggg','Bimbo Blanco','Pan blanco extra grande 740g','Paquete',45,41),('hhh','Peñafiel','Agua mineral 2 l','Botella',40,20);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_venta`
--

DROP TABLE IF EXISTS `producto_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_venta` (
  `claveVenta` varchar(8) NOT NULL,
  `claveProducto` varchar(10) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`claveVenta`,`claveProducto`),
  KEY `fk_producto_venta_2` (`claveProducto`),
  CONSTRAINT `fk_producto_venta_1` FOREIGN KEY (`claveVenta`) REFERENCES `venta` (`clave`),
  CONSTRAINT `fk_producto_venta_2` FOREIGN KEY (`claveProducto`) REFERENCES `producto` (`clave`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_venta`
--

LOCK TABLES `producto_venta` WRITE;
/*!40000 ALTER TABLE `producto_venta` DISABLE KEYS */;
INSERT INTO `producto_venta` VALUES ('03:53:30','ggg',5),('10:30:30','bbb',2),('10:30:30','ccc',1),('11:30:30','ddd',5),('11:30:30','eee',2),('12:30:30','aaa',3),('12:30:30','fff',1);
/*!40000 ALTER TABLE `producto_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `clave` varchar(8) NOT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`clave`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES ('03:53:30','2020-03-17'),('10:30:30','2020-04-03'),('11:30:30','2020-04-03'),('12:30:30','2020-04-03');
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-21 14:20:10
