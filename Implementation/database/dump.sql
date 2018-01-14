-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: travlendar
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
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `id` bigint(20) NOT NULL,
  `eventid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `starting_location` varchar(255) DEFAULT NULL,
  `ending_location` varchar(255) DEFAULT NULL,
  `nam` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `timeb` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `timee` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `event_state` varchar(255) DEFAULT NULL,
  `preflevel` varchar(255) DEFAULT NULL,
  `duration` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`eventid`),
  UNIQUE KEY `eventid` (`eventid`)
) ENGINE=InnoDB AUTO_INCREMENT=97532 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (12345,11223,'Piazza Duca d\'Aosta, 1, 20124 Milano MI, Italy','Porta Genova, Milano, Italy','Test event','test...','2018-02-20 08:00:00','2018-02-20 11:00:00','planned','MEDIUM',1634),(12345,54321,'Piazza Duca d\'Aosta, 1, 20124 Milano MI, Italy','Porta Genova, Milano, Italy','Test event','test...','2018-04-20 07:00:00','2018-04-20 10:00:00','planned','MEDIUM',1634),(12345,67890,'Piazza Duca d\'Aosta, 1, 20124 Milano MI, Italy','Porta Genova, Milano, Italy','Test event','test...','2018-01-20 08:00:00','2018-01-20 11:00:00','planned','MEDIUM',1634),(12345,97531,'Piazza Duca d\'Aosta, 1, 20124 Milano MI, Italy','Porta Genova, Milano, Italy','Test event','test...','2018-03-20 08:00:00','2018-03-20 11:00:00','planned','MEDIUM',1634);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_tickets`
--

DROP TABLE IF EXISTS `train_tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_tickets` (
  `id` bigint(20) NOT NULL,
  `ticketsid` varchar(255) NOT NULL,
  `ticket_type` varchar(255) DEFAULT NULL,
  `departure_location` varchar(255) DEFAULT NULL,
  `arrival_location` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `validity` int(11) DEFAULT NULL,
  `purchase_date` date DEFAULT NULL,
  `purchase_time` time DEFAULT NULL,
  `validation_date` date DEFAULT NULL,
  `validation_time` time DEFAULT NULL,
  `activated` tinyint(1) DEFAULT NULL,
  `lenght` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ticketsid`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_tickets`
--

LOCK TABLES `train_tickets` WRITE;
/*!40000 ALTER TABLE `train_tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `train_tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `urban_tickets`
--

DROP TABLE IF EXISTS `urban_tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `urban_tickets` (
  `id` bigint(20) NOT NULL,
  `ticketsid` varchar(255) NOT NULL,
  `ticket_type` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `validity` int(11) DEFAULT NULL,
  `purchase_date` date DEFAULT NULL,
  `purchase_time` time DEFAULT NULL,
  `validation_date` date DEFAULT NULL,
  `validation_time` time DEFAULT NULL,
  `activated` tinyint(1) DEFAULT NULL,
  `lenght` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ticketsid`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urban_tickets`
--

LOCK TABLES `urban_tickets` WRITE;
/*!40000 ALTER TABLE `urban_tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `urban_tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_settings`
--

DROP TABLE IF EXISTS `user_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_settings` (
  `id` bigint(20) NOT NULL,
  `car_preference_level` varchar(255) DEFAULT NULL,
  `bike_preference_level` varchar(255) DEFAULT NULL,
  `max_walk_distance` int(11) DEFAULT NULL,
  `car_availability` tinyint(1) DEFAULT NULL,
  `bike_availability` tinyint(1) DEFAULT NULL,
  `driver_licence` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_settings`
--

LOCK TABLES `user_settings` WRITE;
/*!40000 ALTER TABLE `user_settings` DISABLE KEYS */;
INSERT INTO `user_settings` VALUES (12345,'Low','Low',999,0,0,0);
/*!40000 ALTER TABLE `user_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `balance` bigint(20) DEFAULT NULL,
  `stripeId` varchar(255) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12346 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (12345,'test@polimi.it','password','Test','Travlendar+',1000,'cus_C5w5Wk4sLCK9BM');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-07 21:19:16
