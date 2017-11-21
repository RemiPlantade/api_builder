-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: api_builder
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `conducteur`
--

DROP TABLE IF EXISTS `conducteur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conducteur` (
  `idconducteur` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `age` date DEFAULT NULL,
  PRIMARY KEY (`idconducteur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conducteur`
--

LOCK TABLES `conducteur` WRITE;
/*!40000 ALTER TABLE `conducteur` DISABLE KEYS */;
INSERT INTO `conducteur` (`idconducteur`, `nom`, `prenom`, `age`) VALUES (1,'Plantade','remi',NULL);
/*!40000 ALTER TABLE `conducteur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roue`
--

DROP TABLE IF EXISTS `roue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roue` (
  `idroue` int(11) NOT NULL AUTO_INCREMENT,
  `rayon` decimal(10,0) DEFAULT NULL,
  `largeur` double DEFAULT NULL,
  PRIMARY KEY (`idroue`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roue`
--

LOCK TABLES `roue` WRITE;
/*!40000 ALTER TABLE `roue` DISABLE KEYS */;
INSERT INTO `roue` (`idroue`, `rayon`, `largeur`) VALUES (1,20,10),(2,2,43),(3,15,21),(4,178,5121.5);
/*!40000 ALTER TABLE `roue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voiture`
--

DROP TABLE IF EXISTS `voiture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voiture` (
  `idvoiture` int(11) NOT NULL AUTO_INCREMENT,
  `marque` varchar(45) DEFAULT NULL,
  `immat` varchar(45) DEFAULT NULL,
  `datecircul` date DEFAULT NULL,
  `idconducteur` int(11) DEFAULT NULL,
  PRIMARY KEY (`idvoiture`),
  UNIQUE KEY `immat_UNIQUE` (`immat`),
  KEY `fk_voit_cond_idx` (`idconducteur`),
  CONSTRAINT `fk_voit_cond` FOREIGN KEY (`idconducteur`) REFERENCES `conducteur` (`idconducteur`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voiture`
--

LOCK TABLES `voiture` WRITE;
/*!40000 ALTER TABLE `voiture` DISABLE KEYS */;
INSERT INTO `voiture` (`idvoiture`, `marque`, `immat`, `datecircul`, `idconducteur`) VALUES (1,'Dacia','0x162 12',NULL,NULL);
/*!40000 ALTER TABLE `voiture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voiture_roue`
--

DROP TABLE IF EXISTS `voiture_roue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voiture_roue` (
  `id_voiture` int(11) NOT NULL,
  `id_roue` int(11) NOT NULL,
  KEY `fk_link_voit_idx` (`id_voiture`),
  KEY `fk_link_roue_idx` (`id_roue`),
  CONSTRAINT `fk_link_roue` FOREIGN KEY (`id_roue`) REFERENCES `roue` (`idroue`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_link_voit` FOREIGN KEY (`id_voiture`) REFERENCES `voiture` (`idvoiture`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voiture_roue`
--

LOCK TABLES `voiture_roue` WRITE;
/*!40000 ALTER TABLE `voiture_roue` DISABLE KEYS */;
INSERT INTO `voiture_roue` (`id_voiture`, `id_roue`) VALUES (1,2),(1,1),(1,3),(1,4);
/*!40000 ALTER TABLE `voiture_roue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-20 13:56:49
