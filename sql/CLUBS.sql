drop database clubs;
create database clubs;
USE clubs;
create table if not exists USERS
(
ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
DATE_CREATED datetime,
DATE_UPDATED datetime,
IS_DELETED boolean,
FIRST_NAME varchar(30),
LAST_NAME varchar(30),
MIDDLE_NAME varchar(30),
SITY_ID int,
BIRTHDAY datetime,
ROLE_ID int,
LOGIN varchar (30),
PASS varchar (30)
);

create table if not exists CLUBS
(
ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
CLUB_NAME varchar(30),
BIRTHDAY datetime,
DATE_CREATED datetime,
DATE_UPDATED datetime,
IS_DELETED boolean
);

create table if not exists ROLES
(
ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
ROLE varchar(30)
);

create table if not exists CONTACTS
(
ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
USER_ID int,
CLUB_NAME varchar(30),
CONTACT_TYPE_ID int,
CONTACT varchar(50),
DATE_CREATED datetime,
DATE_UPDATED datetime,
IS_DELETED boolean
);

create table if not exists CONTACT_TYPES
(
ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
CONTACT_TYPE varchar(30)
);

create table if not exists ADDRESS
(
ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
USER_ID int,
ADDRESS varchar(250)
);

create table if not exists COACHES
(
ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
USER_ID int,
CLUB_ID int,
SPECIALITY varchar(250)
);

create table if not exists GAMES
(
ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
DATE_CREATED datetime,
DATE_UPDATED datetime,
IS_DELETED boolean,
WINNER_ID int,
RESULT int
);

create table if not exists SETS
(
ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
GAME_ID int not null,
DATE_CREATED datetime,
DATE_UPDATED datetime,
IS_DELETED boolean,
WINNER_ID int,
RESULT int
);

create table if not exists PLAYERS
(
ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
GAME_ID int not null,
USER_ID int not null
);

insert into ROLES (ID, ROLE) values 
(1, "guest"),
(2, "user"),
(3, "god"),
(4, "admin"),
(5, "seo");

insert into CONTACT_TYPES (ID, CONTACT_TYPE) values 
(1, "email"),
(2, "mobile_phone"),
(3, "home_phone"),
(4, "skype"),
(5, "viber");

insert into CLUBS (ID, CLUB_NAME, BIRTHDAY, DATE_CREATED, DATE_UPDATED, IS_DELETED) values
(1, "Latino", '2010-09-01', NOW(), NOW(), false),
(2, "Dancer", '2006-09-01', NOW(), NOW(), false),
(3, "Dinamo Dance", '2009-04-01', NOW(), NOW(), false),
(4, "Dance Academy", '2011-09-01', NOW(), NOW(), false);

insert into USERS (ID, DATE_CREATED, DATE_UPDATED, IS_DELETED, FIRST_NAME, LAST_NAME, MIDDLE_NAME, SITY_ID, BIRTHDAY, ROLE_ID, LOGIN, PASS) values
(1, NOW(), NOW(), false, "Алексей", "Калачев", null, null, '1985-08-01', 3, "kala4", "kala4");

