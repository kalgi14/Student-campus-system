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