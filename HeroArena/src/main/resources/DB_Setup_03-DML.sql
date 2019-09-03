-- Users
INSERT INTO users (id, username, password, role)
    SELECT user_seq.nextVal, 'admin', 'p4ssw0rd', 0 FROM dual;

INSERT INTO users (id, username, password, role)
    SELECT user_seq.nextVal, 'player', 'p4ssw0rd', 1 FROM dual;


-- Gladiators
INSERT INTO gladiator (id, name, strength, dexterity, vitality, max_health, rarity)
    SELECT gladiator_seq.nextVal, 'King Cobra',  5, 3, 0, 15, .3 FROM dual;
    
INSERT INTO gladiator (id, name, strength, dexterity, vitality, max_health, rarity)
    SELECT gladiator_seq.nextVal, 'Shadow Lord',  3, 5, 0, 12, .3 FROM dual;


-- Items
INSERT INTO items (id, name, description)
    SELECT item_seq.nextVal, 'Small Healing Potion', 'Restores 30% health to a hero of your choice.' FROM dual;

INSERT INTO items (id, name, description)
    SELECT item_seq.nextVal, 'Medium Healing Potion', 'Restores 65% health to a hero of your choice.' FROM dual;

INSERT INTO items (id, name, description)
    SELECT item_seq.nextVal, 'Large Healing Potion', 'Completely restores the health of a hero of your choice.' FROM dual;


-- Player items
INSERT INTO player_items (player_id, item_id, amount)
    VALUES ((SELECT id FROM users WHERE username = 'player'),
            (SELECT id FROM items WHERE name like 'Small%'),
            2);

INSERT INTO player_items (player_id, item_id, amount)
    VALUES ((SELECT id FROM users WHERE username = 'player'),
            (SELECT id FROM items WHERE name like 'Large%'),
            1);


COMMIT;
