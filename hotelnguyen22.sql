-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: hotelnguyen22
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `username` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci NOT NULL,
  `role` int NOT NULL,
  PRIMARY KEY (`account_id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,0,'nguyen22','nguyen22',1),(1,1,'admin','admin',1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banking`
--

DROP TABLE IF EXISTS `banking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banking` (
  `id_card` int NOT NULL,
  `ccv` int NOT NULL,
  `wallet` int NOT NULL,
  PRIMARY KEY (`id_card`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banking`
--

LOCK TABLES `banking` WRITE;
/*!40000 ALTER TABLE `banking` DISABLE KEYS */;
INSERT INTO `banking` VALUES (11111111,111,30000000),(22222222,222,0),(33333333,333,300000000);
/*!40000 ALTER TABLE `banking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` bigint NOT NULL AUTO_INCREMENT,
  `checkin_date` datetime(6) DEFAULT NULL,
  `checkout_date` datetime(6) DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `momo`
--

DROP TABLE IF EXISTS `momo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `momo` (
  `phone` int NOT NULL,
  `ccv` int NOT NULL,
  `wallet` int NOT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `momo`
--

LOCK TABLES `momo` WRITE;
/*!40000 ALTER TABLE `momo` DISABLE KEYS */;
INSERT INTO `momo` VALUES (11111111,111,30000000),(22222222,222,0),(33333333,333,1000000000);
/*!40000 ALTER TABLE `momo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` bigint NOT NULL AUTO_INCREMENT,
  `booking_id` bigint DEFAULT NULL,
  `payment_date` datetime(6) DEFAULT NULL,
  `payment_type` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `room_id` bigint NOT NULL AUTO_INCREMENT,
  `status_id` bigint DEFAULT NULL,
  `roomnumber` int DEFAULT NULL,
  `location_floor` int DEFAULT NULL,
  `room_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `path` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=330 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (101,0,101,1,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room8.jpg'),(102,0,102,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(103,0,103,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room1.jpg'),(104,0,104,1,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(105,0,105,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room4.jpg'),(106,0,106,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(107,0,107,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room1.jpg'),(108,0,108,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(109,0,109,1,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room8.jpg'),(110,0,110,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(111,0,111,1,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room5.jpg'),(112,0,112,1,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(113,0,113,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room1.jpg'),(114,0,114,1,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(115,0,115,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room4.jpg'),(116,0,116,1,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(117,0,117,1,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room5.jpg'),(118,0,118,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(119,0,119,1,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room6.jpg'),(120,0,120,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(121,0,121,1,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room8.jpg'),(122,0,122,1,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(123,0,123,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room5.jpg'),(124,0,124,1,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(125,0,125,1,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room4.jpg'),(126,0,126,1,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(127,0,127,1,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room8.jpg'),(128,0,128,1,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(129,0,129,1,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room5.jpg'),(230,0,230,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(231,0,231,2,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room5.jpg'),(232,0,232,2,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(233,0,233,2,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room6.jpg'),(234,0,234,2,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(235,0,235,2,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room4.jpg'),(236,0,236,2,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(237,0,237,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room5.jpg'),(238,0,238,2,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(239,0,239,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room8.jpg'),(240,0,240,2,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(241,0,241,2,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room1.jpg'),(242,0,242,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(243,0,243,2,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room5.jpg'),(244,0,244,2,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(245,0,245,2,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room4.jpg'),(246,0,246,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(247,0,247,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room8.jpg'),(248,0,248,2,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(249,0,249,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room5.jpg'),(250,0,250,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(251,0,251,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room8.jpg'),(252,0,252,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(253,0,253,2,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room1.jpg'),(254,0,254,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(255,0,255,2,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room4.jpg'),(256,0,256,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(257,0,257,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room8.jpg'),(258,0,258,2,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(259,0,259,2,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room1.jpg'),(301,0,301,3,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room6.jpg'),(302,0,302,3,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(303,0,303,3,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room5.jpg'),(304,0,304,3,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(305,0,305,3,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room4.jpg'),(306,0,306,3,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(307,0,307,3,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room6.jpg'),(308,0,308,3,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(309,0,309,3,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room5.jpg'),(310,0,310,3,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(311,0,311,3,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room1.jpg'),(312,0,312,3,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(313,0,313,3,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room1.jpg'),(314,0,314,3,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(315,0,315,3,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room4.jpg'),(316,0,316,3,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(317,0,317,3,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room6.jpg'),(318,0,318,3,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(319,0,319,3,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room8.jpg'),(320,0,320,3,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(321,0,321,3,'Phòng VIP',400000,'Đây là phòng Luxury với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room5.jpg'),(322,0,322,3,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(323,0,323,3,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room8.jpg'),(324,0,324,3,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(325,0,325,3,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room4.jpg'),(326,0,326,3,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room7.jpg'),(327,0,327,3,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room5.jpg'),(328,0,328,3,'Phòng 2 người',240000,'Đây là phòng Double với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room2.jpg'),(329,0,329,3,'Phòng 4 người',300000,'Đây là phòng dành cho gia đình với 1 giường đôi kết hợp view biển siêu đẹp, có cái phòng tắm view có thể nhìn ra biển','room6.jpg');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomstatus`
--

DROP TABLE IF EXISTS `roomstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomstatus` (
  `status_id` int NOT NULL,
  `status_name` int NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomstatus`
--

LOCK TABLES `roomstatus` WRITE;
/*!40000 ALTER TABLE `roomstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `roomstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spring_session`
--

DROP TABLE IF EXISTS `spring_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spring_session` (
  `PRIMARY_ID` char(36) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci NOT NULL,
  `SESSION_ID` char(36) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci NOT NULL,
  `CREATION_TIME` bigint NOT NULL,
  `LAST_ACCESS_TIME` bigint NOT NULL,
  `MAX_INACTIVE_INTERVAL` int NOT NULL,
  `EXPIRY_TIME` bigint NOT NULL,
  `PRINCIPAL_NAME` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spring_session`
--

LOCK TABLES `spring_session` WRITE;
/*!40000 ALTER TABLE `spring_session` DISABLE KEYS */;
INSERT INTO `spring_session` VALUES ('2e8f5e4b-e416-4c20-9f56-639beb2e403d','df2e316a-89d1-4c96-8628-bd9f0d7699e6',1671122330195,1671122332181,1800,1671124132181,NULL);
/*!40000 ALTER TABLE `spring_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spring_session_attributes`
--

DROP TABLE IF EXISTS `spring_session_attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spring_session_attributes`
--

LOCK TABLES `spring_session_attributes` WRITE;
/*!40000 ALTER TABLE `spring_session_attributes` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session_attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `identity` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `confirmpassword` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` int DEFAULT NULL,
  `role` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mr4rtvun5wakeubj0tvjr98l8` (`email`),
  UNIQUE KEY `UK_nijxoy2hk6npm7lweieo2w56j` (`phone`),
  UNIQUE KEY `UK_8h620irpir8kcurgsdkhns8lt` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (3,'admin','','','administrator','','','','$2a$10$TaeJfdi6yozhqeqRu4B6.ea8cUdaJigz4mdKEEw9ic.HKjOLJCK7a','',1,'ROLE_ADMIN'),(8,'pasal2407','giaphat24072002@gmail.com','0147258369','driss','2002-12-24','828 Hồng Bàng , phường 14 , quận 6 , Tp.Hồ Chí Minh','01472583691','$2a$12$p/su0vLMxcOFhB8iKJn4W.HAQC0J0UZsZEn.np70Cla31VRUByt.G','$2a$12$EiUvnizxj3an4DH9lNlyy.bLDOd.opnI7pZjYBrW.P8dlbtUqPVFO',1,'ROLE_USER');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-16  0:12:10
