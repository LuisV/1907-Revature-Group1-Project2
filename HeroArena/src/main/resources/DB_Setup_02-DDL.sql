-- Start with a clean slate
DROP TABLE USERS CASCADE CONSTRAINTS;

DROP SEQUENCE USER_SEQ;


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
    max_health number(4),
    rarity number(5,2)
);


-- Create sequences to generate primary keys
CREATE SEQUENCE USER_SEQ INCREMENT BY 1 START WITH 3;  -- Manually inserting 2 entries to start.
CREATE SEQUENCE GLADIATOR_SEQ INCREMENT BY 1 START WITH 3;  -- Manually inserting 2 entries to start.
