/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.5.5-10.1.13-MariaDB : Database - studenttestsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`studenttestsystem` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `studenttestsystem`;

/*Table structure for table `admin_signup` */

DROP TABLE IF EXISTS `admin_signup`;

CREATE TABLE `admin_signup` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `Name` char(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Gender` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `admin_signup` */

insert  into `admin_signup`(`id`,`Name`,`Username`,`Email`,`Password`,`Gender`) values (1,'Saif Ur Rehman','saif21','saifurrehmankhan21@gmail.com','03074554223','Male');

/*Table structure for table `questions` */

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `ID` int(3) NOT NULL AUTO_INCREMENT,
  `Question` varchar(500) NOT NULL,
  `a` varchar(100) NOT NULL,
  `b` varchar(100) NOT NULL,
  `c` varchar(100) NOT NULL,
  `d` varchar(100) NOT NULL,
  `correct` varchar(150) NOT NULL,
  `Difficulty` char(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `questions` */

insert  into `questions`(`ID`,`Question`,`a`,`b`,`c`,`d`,`correct`,`Difficulty`) values (1,'What is the square of 4?','4','8','16','32','C','Easy'),(2,'What is cube of 3?		','3','9','18','27','D','Easy'),(3,'How many days in a week ?','7','6','9','8','A','Easy'),(4,'How many hours in a week ?','150','200','210','168','D','Medium'),(5,'CPU stands for what ?','Centeral Processing Unit','Centeral Part Unit','Centeral Process Unit','None of above.','A','Easy'),(6,'Structured Programming language is ?','Java','C','C++','None of above.','B','Easy'),(7,'What is the purpose of Database?','It store data','It increase speed','It increase reliablity.','None of above.','A','Medium'),(8,'5 x 6 =','30','35','28','32','B','Easy'),(9,'5 x 10 =','50','45','55','52','A','Easy'),(10,'Convert 70ml into liter.','0.07','0.7','0.007','7','A','Easy'),(11,'Convert 4500g into kg.','450','45','4.5','.45','C','Easy');

/*Table structure for table `student_signup` */

DROP TABLE IF EXISTS `student_signup`;

CREATE TABLE `student_signup` (
  `id` int(5) NOT NULL,
  `Name` char(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Gender` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student_signup` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
