DROP USER heroarena CASCADE;

CREATE USER heroarena
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT CONNECT TO heroarena;
GRANT RESOURCE TO heroarena;
GRANT CREATE SESSION TO heroarena;
GRANT CREATE TABLE TO heroarena;
GRANT CREATE VIEW TO heroarena;
