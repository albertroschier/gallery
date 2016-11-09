CREATE TABLE album (
albumid bigint NOT NULL AUTO_INCREMENT,
name varchar(50) DEFAULT NULL,
PRIMARY KEY (albumid));

CREATE TABLE image (
imageid bigint NOT NULL AUTO_INCREMENT,
albumid bigint DEFAULT NULL,
name varchar(50) DEFAULT NULL,
filepath varchar(128) NOT NULL,
PRIMARY KEY (imageid),
FOREIGN KEY ( albumid ) REFERENCES album(albumid));

CREATE TABLE imagegroup (
imagegroupid bigint NOT NULL,
name varchar(40) DEFAULT NULL,
PRIMARY KEY (imagegroupid));