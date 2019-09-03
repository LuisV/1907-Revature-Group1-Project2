-- Start with a clean slate
DROP TABLE users CASCADE CONSTRAINTS;
DROP TABLE gladiator CASCADE CONSTRAINTS;
DROP TABLE items CASCADE CONSTRAINTS;
DROP TABLE player_items CASCADE CONSTRAINTS;

DROP SEQUENCE user_seq;
DROP SEQUENCE gladiator_seq;
DROP SEQUENCE item_seq;


-- Create Tables

CREATE TABLE users (
    id NUMBER(20) PRIMARY KEY,
    username VARCHAR2(25) UNIQUE NOT NULL,
    password VARCHAR2(25) NOT NULL,
    role NUMBER(1) DEFAULT 1 NOT NULL   -- For now,  0 == admin, 1 == player
);

CREATE TABLE gladiator (
    id number(20) PRIMARY KEY,
    name varchar2(36),
    strength number(4),
    dexterity number(4),
    vitality number(4),
    level number(4),
    current_health number(4),
    max_health number(4),
    experience number(4),
    rarity number(5,2)
);

CREATE TABLE items (
    id NUMBER(20) PRIMARY KEY,
    name VARCHAR2(30) NOT NULL,
    description VARCHAR2(150) NOT NULL
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
CREATE SEQUENCE Gladiator_Seq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE item_seq INCREMENT BY 1 START WITH 1;
