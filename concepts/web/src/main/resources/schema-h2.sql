-- DROP TABLE IF EXISTS role;
-- CREATE TABLE  `role` (
--   role_id int(11) NOT NULL auto_increment,
--   role varchar(255) default NULL,
--   PRIMARY KEY  (role_id)
-- ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
--
-- DROP TABLE IF EXISTS user;
-- CREATE TABLE  user (
--   id int(11) NOT NULL auto_increment,
--   firstname varchar(255) NOT NULL,
--   lastname varchar(255) NOT NULL,
--   email varchar(255) NOT NULL,
--   password varchar(255) NOT NULL,
--   active int(11) default NULL,
--   PRIMARY KEY  (id)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
--
-- DROP TABLE IF EXISTS user_role;
-- CREATE TABLE  user_role (
--   user_id int(11) NOT NULL,
--   role_id int(11) NOT NULL,
--   PRIMARY KEY  (user_id,role_id),
--   KEY user_role_key (role_id),
--   CONSTRAINT user_userrole FOREIGN KEY (user_id) REFERENCES user (id),
--   CONSTRAINT role_userrole FOREIGN KEY (role_id) REFERENCES role (role_id)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);

INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
VALUES ('namhm',
'$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu',
'ROLE_USER', 1);

INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
VALUES ('admin',
'$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy',
'ROLE_ADMIN', 1);

CREATE TABLE `students` (
  `STUDENT_ID` int(11) NOT NULL,
  `FIRST_NAME` varchar(20) DEFAULT NULL,
  `LAST_NAME` varchar(20) DEFAULT NULL,
  `U_PASS` int(11) DEFAULT NULL,
  `CREDITS_TAKEN` int(11) DEFAULT NULL,
  PRIMARY KEY(`STUDENT_ID`)
);

CREATE TABLE `professors` (
  `PROFESSOR_ID` int(11) NOT NULL,
  `FIRST_NAME` varchar(20) DEFAULT NULL,
  `LAST_NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`PROFESSOR_ID`);
);

CREATE TABLE `courses` (
  `COURSE_ID` int(11) NOT NULL,
  `SHORT_NAME` varchar(10) DEFAULT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `DEPARTMENT` varchar(10) DEFAULT NULL,
  `CREDITS` int(11) DEFAULT NULL,
  `GRADUATE` bit(1) DEFAULT NULL,
  PRIMARY KEY (`COURSE_ID`);
);

CREATE TABLE `classes` (
  `CLASS_ID` int(11) NOT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  `PROFESSOR_ID` int(11) DEFAULT NULL
  PRIMARY KEY (`CLASS_ID`),
  FOREIGN KEY (`COURSE_ID`) REFERENCES `courses`(`COURSE_ID`),
  FOREIGN KEY (`PROFESSOR_ID`) REFERENCES `professors`(`PROFESSOR_ID`)
);

CREATE TABLE `tuition` (
  `TUITION_ID` int(11) NOT NULL,
  `STUDENT_ID` int(11) DEFAULT NULL,
  `MONEY_DUE` int(11) DEFAULT NULL,
  `QUARTER` varchar(10) DEFAULT NULL
  PRIMARY KEY(`TUITION_ID`),
  FOREIGN KEY (`STUDENT_ID`) REFERENCES `students`(`STUDENT_ID`)
);

CREATE TABLE `grades` (
  `COURSE_ID` int(11) DEFAULT NULL,
  `CLASS_ID` int(11) NOT NULL,
  `GRADES_EARNED` float DEFAULT NULL,
  `STUDENT_ID` int(11) NOT NULL,
  PRIMARY KEY (`CLASS_ID`, `STUDENT_ID`),
  FOREIGN KEY (`STUDENT_ID`) REFERENCES `students`(`STUDENT_ID`)
);