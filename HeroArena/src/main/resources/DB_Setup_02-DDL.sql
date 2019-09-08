-- Start with a clean slate
DROP TABLE users CASCADE CONSTRAINTS;
DROP TABLE gladiator CASCADE CONSTRAINTS;
DROP TABLE character CASCADE CONSTRAINTS;
DROP TABLE items CASCADE CONSTRAINTS;
DROP TABLE player_items CASCADE CONSTRAINTS;

DROP SEQUENCE user_seq;
DROP SEQUENCE gladiator_seq;
DROP SEQUENCE character_seq;
DROP SEQUENCE item_seq;


-- Create Tables

CREATE TABLE users (
    id NUMBER(20) PRIMARY KEY,
    username VARCHAR2(25) UNIQUE NOT NULL,
    password VARCHAR2(25) NOT NULL,
    banned number(1) default 0,
    role NUMBER(1) DEFAULT 1 NOT NULL   -- For now,  0 == admin, 1 == player
);

CREATE TABLE character(
    "ID" NUMBER(20,0) PRIMARY KEY, 
	"NAME" VARCHAR2(32 BYTE), 
	"DESCRIPTION" VARCHAR2(128 BYTE), 
	"BASE_HEALTH" NUMBER(4,0), 
	"BASE_STRENGTH" NUMBER(4,0), 
	"BASE_DEXTERITY" NUMBER(4,0), 
	"BASE_VITALITY" NUMBER(4,0), 
	"RARITY" VARCHAR2(24 BYTE) DEFAULT 'common');

CREATE TABLE gladiator (
    id number(20) PRIMARY KEY,
    player_id number(20) NOT NULL,
    character_id number(20) DEFAULT NULL,
    name varchar2(36) NOT NULL,
    strength number(4) NOT NULL,
    dexterity number(4) NOT NULL,
    vitality number(4) NOT NULL,
    current_level number(4) DEFAULT 1,
    current_health number(4) NOT NULL,
    max_health number(4) NOT NULL,
    experience number(4) DEFAULT 0,
    CONSTRAINT gladiator_character_fk FOREIGN KEY (character_id) REFERENCES character (id),
    CONSTRAINT gladiator_player_fk FOREIGN KEY (player_id) REFERENCES users (id)
);

CREATE TABLE items (
    id NUMBER(20) PRIMARY KEY,
    name VARCHAR2(30) NOT NULL,
    description VARCHAR2(150) NOT NULL,
    effect_health NUMBER(3) DEFAULT 0 NOT NULL,
    effect_xp NUMBER(3) DEFAULT 0 NOT NULL,
    price NUMBER(10) CHECK (price >= 0) NOT NULL
);

CREATE TABLE player_items (
    player_id NUMBER(20),
    item_id NUMBER(20),
    amount NUMBER(3) CHECK (amount >= 0) NOT NULL,
    CONSTRAINT inventory_pk PRIMARY KEY (player_id, item_id),
    CONSTRAINT inventory_player_fk FOREIGN KEY (player_id) REFERENCES users (id),
    CONSTRAINT inventory_item_fk FOREIGN KEY (item_id) REFERENCES items (id)
);

-- Create sequences to generate primary keys
CREATE SEQUENCE user_seq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE gladiator_seq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE character_seq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE item_seq INCREMENT BY 1 START WITH 1;
