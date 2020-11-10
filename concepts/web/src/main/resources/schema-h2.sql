DROP TABLE IF EXISTS category;

CREATE SEQUENCE hibernate_sequence START WITH 100 INCREMENT BY 1;

CREATE TABLE category (
  id INT AUTO_INCREMENT  PRIMARY KEY,    
    name VARCHAR(10),
    description VARCHAR(50),
    PRIMARY KEY (ID)    
);
