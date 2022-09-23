-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: catalogo_profesores
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `IdP` int(11) NOT NULL AUTO_INCREMENT,
  `IdProfesor` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `ApellidoPaterno` varchar(45) NOT NULL,
  `ApellidoMaterno` varchar(45) NOT NULL,
  `RFC` varchar(13) NOT NULL,
  PRIMARY KEY (`IdP`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,12,'juan','as','as','as'),(2,32,'fasd','fsf','dsf','dfs');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesorimparteunidad`
--

DROP TABLE IF EXISTS `profesorimparteunidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesorimparteunidad` (
  `IdProfesorImparteUnidad` int(11) NOT NULL AUTO_INCREMENT,
  `IdP` int(11) NOT NULL,
  `IdUA` int(11) NOT NULL,
  PRIMARY KEY (`IdProfesorImparteUnidad`),
  KEY `idUnidadAprendizaje_idx` (`IdUA`),
  KEY `idProfesor_idx` (`IdP`),
  CONSTRAINT `IdP` FOREIGN KEY (`IdP`) REFERENCES `profesor` (`IdP`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `IdUnidadAprendizaje` FOREIGN KEY (`IdUA`) REFERENCES `unidadaprendizaje` (`IdUA`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesorimparteunidad`
--

LOCK TABLES `profesorimparteunidad` WRITE;
/*!40000 ALTER TABLE `profesorimparteunidad` DISABLE KEYS */;
INSERT INTO `profesorimparteunidad` VALUES (1,1,1),(2,1,2),(3,2,1),(4,2,2);
/*!40000 ALTER TABLE `profesorimparteunidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidadaprendizaje`
--

DROP TABLE IF EXISTS `unidadaprendizaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidadaprendizaje` (
  `IdUA` int(11) NOT NULL AUTO_INCREMENT,
  `IdUnidadAprendizaje` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `HorasClase` int(11) NOT NULL,
  `HorasTaller` int(11) NOT NULL,
  `HorasLaboratorio` int(11) NOT NULL,
  PRIMARY KEY (`IdUA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadaprendizaje`
--

LOCK TABLES `unidadaprendizaje` WRITE;
/*!40000 ALTER TABLE `unidadaprendizaje` DISABLE KEYS */;
INSERT INTO `unidadaprendizaje` VALUES (1,10,'Matematicas',10,2,0),(2,20,'Fisica',2,5,6);
/*!40000 ALTER TABLE `unidadaprendizaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `IdUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `NameUsuario` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'catalogo_profesores'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-23  0:48:08
