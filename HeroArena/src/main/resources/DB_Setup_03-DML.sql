-- Users
INSERT INTO users (id, username, password, role)
    VALUES (1, 'admin', 'p4ssw0rd', 0);

INSERT INTO users (id, username, password, role)
    VALUES (2, 'player', 'p4ssw0rd', 1);
    
INSERT INTO gladiator (id, name, strength, dexterity, vitality, max_health, rarity) VALUES (1, 'King Cobra',  5, 3, 0, 15, .3 );
INSERT INTO gladiator (id, name, strength, dexterity, vitality, max_health, rarity) VALUES (1, 'Shadow Lord',  3, 5, 0, 12, .3 );

    
COMMIT;
