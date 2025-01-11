create table users(username varchar_ignorecase(50) not null primary key,password varchar_ignorecase(500) not null,enabled boolean not null);
create table authorities (username varchar_ignorecase(50) not null,authority varchar_ignorecase(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);


INSERT IGNORE INTO users (username, password, enabled) VALUES ('user', '{noop}eeshu', '1');
INSERT IGNORE INTO authorities (username, authority) VALUES ('user', 'read');
INSERT IGNORE INTO users (username, password, enabled) VALUES ('user', '{bcrypt}$2a$12$R1.9hU81Jc4SEV5FTK36Yea.UY5YFAACai0qZWEX5YGvee5DyMASe', '1');
INSERT IGNORE INTO authorities (username, authority) VALUES ('admin', 'admin');
====================================================================

CREATE TABLE customer(id int NOT NULL AUTO_INCREMENT,
email varchar(45) NOT NULL,
pwd varchar(250) NOT NULL,
role varchar(45) NOT NULL,
PRIMARY KEY(id)
);
INSERT INTO customer(email,pwd,role)VALUES("eeshunarayan15@gmail.com","{noop}eeshu","read");
INSERT INTO customer(email,pwd,role)VALUES("eeshunarayan15@gmail.com","{bcrypt}$2a$12$R1.9hU81Jc4SEV5FTK36Yea.UY5YFAACai0qZWEX5YGvee5DyMASe","read");
UPDATE customer 
SET email = "eeshunarayan16@gmail.com" 
WHERE email = "eeshunarayan15@gmail.com";
