-- Users
INSERT INTO users (id, username, password, role)
    VALUES (1, 'admin', 'p4ssw0rd', 0);

INSERT INTO users (id, username, password, role)
    VALUES (2, 'player', 'p4ssw0rd', 1);
    
COMMIT;
