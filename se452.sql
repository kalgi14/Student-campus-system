-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2020 at 10:09 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `se452`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `ADMIN_ID` int(11) NOT NULL,
  `FIRST_NAME` varchar(20) DEFAULT NULL,
  `LAST_NAME` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`ADMIN_ID`, `FIRST_NAME`, `LAST_NAME`) VALUES
(1, 'Hugh', 'Jackman'),
(2, 'Jackie', 'Chan'),
(3, 'Bill', 'Gates');

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `CLASS_ID` int(11) NOT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  `PROFESSOR_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`CLASS_ID`, `COURSE_ID`, `PROFESSOR_ID`) VALUES
(1, 452, 1),
(2, 352, 1),
(3, 471, 3),
(4, 371, 3);

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `COURSE_ID` int(11) NOT NULL,
  `SHORT_NAME` varchar(10) DEFAULT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `DEPARTMENT` varchar(10) DEFAULT NULL,
  `CREDITS` int(11) DEFAULT NULL,
  `GRADUATE` bit(1) DEFAULT NULL,
  `courseID` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`COURSE_ID`, `SHORT_NAME`, `NAME`, `DEPARTMENT`, `CREDITS`, `GRADUATE`, `courseID`, `id`) VALUES
(335, 'CSC335', 'Distributed Systems', 'CDM', 4, b'0', 0, 0),
(352, 'CSC352', 'Object Oriented Enterprise Computing', 'CDM', 4, b'0', 0, 0),
(371, 'CSC371', 'Mobile Appplication Development for iOS', 'CDM', 4, b'0', 0, 0),
(435, 'CSC435', 'Distributed Systems', 'CDM', 4, b'1', 0, 0),
(452, 'CSC452', 'Object Oriented Enterprise Computing', 'CDM', 4, b'1', 0, 0),
(471, 'CSC471', 'Mobile Appplication Development for iOS', 'CDM', 4, b'1', 0, 0),
(555, 'FIN555', 'Financial Management', 'BUSS', 4, b'1', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `enrollment`
--

CREATE TABLE `enrollment` (
  `id` int(11) NOT NULL,
  `CLASS_ID` int(11) NOT NULL,
  `STUDENT_ID` int(11) NOT NULL,
  `active` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enrollment`
--

INSERT INTO `enrollment` (`id`, `CLASS_ID`, `STUDENT_ID`, `active`) VALUES
(1, 1, 1, 1),
(2, 1, 4, 1),
(3, 2, 3, 1),
(4, 3, 2, 1),
(5, 4, 5, 1),
(6, 4, 1, 1),
(7, 4, 2, 1),
(8, 4, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `grades`
--

CREATE TABLE `grades` (
  `COURSE_ID` int(11) DEFAULT NULL,
  `CLASS_ID` int(11) NOT NULL,
  `GRADES_EARNED` float DEFAULT NULL,
  `STUDENT_ID` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grades`
--

INSERT INTO `grades` (`COURSE_ID`, `CLASS_ID`, `GRADES_EARNED`, `STUDENT_ID`, `id`) VALUES
(452, 1, 4, 1, 0),
(452, 1, 4, 2, 0),
(452, 1, 4, 3, 0),
(452, 1, 4, 4, 0),
(452, 1, 4, 5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `PAYMENT_ID` int(11) NOT NULL,
  `TUITION_ID` int(11) DEFAULT NULL,
  `AMOUNT_PAID` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`PAYMENT_ID`, `TUITION_ID`, `AMOUNT_PAID`) VALUES
(111, 11, 5),
(222, 22, 100),
(333, 33, 30),
(444, 44, 65),
(555, 55, 500);

-- --------------------------------------------------------

--
-- Table structure for table `professors`
--

CREATE TABLE `professors` (
  `PROFESSOR_ID` int(11) NOT NULL,
  `FIRST_NAME` varchar(20) DEFAULT NULL,
  `LAST_NAME` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `professors`
--

INSERT INTO `professors` (`PROFESSOR_ID`, `FIRST_NAME`, `LAST_NAME`) VALUES
(1, 'Ken', 'Yu'),
(2, 'Joesph', 'Phillips'),
(3, 'Clark', 'Elliott');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `STUDENT_ID` int(11) NOT NULL,
  `FIRST_NAME` varchar(20) DEFAULT NULL,
  `LAST_NAME` varchar(20) DEFAULT NULL,
  `U_PASS` int(11) DEFAULT NULL,
  `CREDITS_TAKEN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`STUDENT_ID`, `FIRST_NAME`, `LAST_NAME`, `U_PASS`, `CREDITS_TAKEN`) VALUES
(1, 'Kevin', 'Lee', 11111, 0),
(2, 'Kalgi', 'Pawar', 22222, 0),
(3, 'Arta', 'Khademinejad', 33333, 0),
(4, 'Christopher', 'Gibson', 44444, 0),
(5, 'Yunfei', 'Shi', 55555, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tuition`
--

CREATE TABLE `tuition` (
  `id` int(11) NOT NULL,
  `TUITION_ID` int(11) NOT NULL,
  `STUDENT_ID` int(11) NOT NULL,
  `MONEY_DUE` int(11) NOT NULL,
  `QUARTER` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tuition`
--

INSERT INTO `tuition` (`id`, `TUITION_ID`, `STUDENT_ID`, `MONEY_DUE`, `QUARTER`) VALUES
(1, 111, 1, 1, 'Fall'),
(2, 222, 2, 2, 'Fall'),
(3, 333, 3, 3, 'winter'),
(4, 444, 4, 4, 'winter'),
(5, 555, 5, 5, 'spring');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `professor_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  `STUDENT_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `user_id`, `admin_id`, `professor_id`, `username`, `password`, `role`, `enabled`, `STUDENT_ID`) VALUES
(1, 0, 0, 0, 'namhm', '$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu', 'ROLE_USER', 1, NULL),
(2, 0, 0, 0, 'admin', '$2a$10$fPoB2cqnFUCBKotoKhBmm.0f2vu6n3VT1ALK7YSIyd4IR6nbj3JwC', 'ROLE_ADMIN', 1, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`ADMIN_ID`);

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`CLASS_ID`),
  ADD KEY `COURSE_ID` (`COURSE_ID`),
  ADD KEY `PROFESSOR_ID` (`PROFESSOR_ID`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`COURSE_ID`);

--
-- Indexes for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `CLASS_ID_2` (`CLASS_ID`,`STUDENT_ID`),
  ADD KEY `STUDENT_ID` (`STUDENT_ID`),
  ADD KEY `CLASS_ID` (`CLASS_ID`) USING BTREE;

--
-- Indexes for table `grades`
--
ALTER TABLE `grades`
  ADD PRIMARY KEY (`CLASS_ID`,`STUDENT_ID`),
  ADD KEY `STUDENT_ID` (`STUDENT_ID`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`PAYMENT_ID`),
  ADD KEY `TUITION_ID` (`TUITION_ID`);

--
-- Indexes for table `professors`
--
ALTER TABLE `professors`
  ADD PRIMARY KEY (`PROFESSOR_ID`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`STUDENT_ID`);

--
-- Indexes for table `tuition`
--
ALTER TABLE `tuition`
  ADD PRIMARY KEY (`id`),
  ADD KEY `TUITION_ID` (`TUITION_ID`,`STUDENT_ID`),
  ADD KEY `STUDENT_ID` (`STUDENT_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `admin_id` (`admin_id`),
  ADD KEY `professor_id` (`professor_id`),
  ADD KEY `FK6mjyxb92dnfdr6lmmbnuatl92` (`STUDENT_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `enrollment`
--
ALTER TABLE `enrollment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `tuition`
--
ALTER TABLE `tuition`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`COURSE_ID`) REFERENCES `courses` (`COURSE_ID`),
  ADD CONSTRAINT `classes_ibfk_2` FOREIGN KEY (`PROFESSOR_ID`) REFERENCES `professors` (`PROFESSOR_ID`);

--
-- Constraints for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD CONSTRAINT `enrollment_ibfk_1` FOREIGN KEY (`CLASS_ID`) REFERENCES `classes` (`CLASS_ID`),
  ADD CONSTRAINT `enrollment_ibfk_2` FOREIGN KEY (`STUDENT_ID`) REFERENCES `students` (`STUDENT_ID`);

--
-- Constraints for table `grades`
--
ALTER TABLE `grades`
  ADD CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`CLASS_ID`) REFERENCES `classes` (`CLASS_ID`),
  ADD CONSTRAINT `grades_ibfk_2` FOREIGN KEY (`STUDENT_ID`) REFERENCES `students` (`STUDENT_ID`);

--
-- Constraints for table `tuition`
--
ALTER TABLE `tuition`
  ADD CONSTRAINT `tuition_ibfk_1` FOREIGN KEY (`STUDENT_ID`) REFERENCES `students` (`STUDENT_ID`),
  ADD CONSTRAINT `tuition_ibfk_2` FOREIGN KEY (`TUITION_ID`) REFERENCES `payments` (`PAYMENT_ID`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK6mjyxb92dnfdr6lmmbnuatl92` FOREIGN KEY (`STUDENT_ID`) REFERENCES `students` (`STUDENT_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
