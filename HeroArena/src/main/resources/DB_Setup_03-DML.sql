-- Users
INSERT INTO users (id, username, password, role)
    SELECT user_seq.nextVal, 'admin', 'p4ssw0rd', 0 FROM dual;

INSERT INTO users (id, username, password, role)
    SELECT user_seq.nextVal, 'player', 'p4ssw0rd', 1 FROM dual;

INSERT INTO users (id, username, password, role)
    SELECT user_seq.nextVal, 'player2', 'p4ssw0rd', 1 FROM dual;


--Characters
INSERT INTO character (id, name, description, base_strength, base_dexterity, base_vitality, base_health, rarity)
    SELECT gladiator_seq.nextVal,
           'King Cobra','The most feared king in all of Egypt. Rules with an iron fist!',  6, 4, 0, 14, 'Rare' FROM dual;

INSERT INTO character (id, name, description, base_strength, base_dexterity, base_vitality, base_health, rarity)
    SELECT gladiator_seq.nextVal,
           'Shadow Lord','You wont see him coming. Attacks from the void!',  5, 6, 0, 10, 'Rare' FROM dual;

INSERT INTO character (id, name, description, base_strength, base_dexterity, base_vitality, base_health, rarity)
    SELECT gladiator_seq.nextVal,
           'Iron Giant','Big Giant guy made of Iron! What more could you want?',  7, 2, 0, 18, 'Epic' FROM dual;


-- Gladiators
INSERT INTO gladiator (id, player_id, name, strength, dexterity, vitality, current_level, current_health, max_health, experience)
    SELECT gladiator_seq.nextVal,
           (SELECT id FROM users WHERE username = 'player'),
           'King Cobra',  6, 4, 1, 1, 10, 15, 0 FROM dual;
    
INSERT INTO gladiator (id, player_id, name, strength, dexterity, vitality, current_level, current_health, max_health, experience)
    SELECT gladiator_seq.nextVal,
           (SELECT id FROM users WHERE username = 'player'),
           'Shadow Lord',  3, 5, 1, 4, 12, 12, 157 FROM dual;

INSERT INTO gladiator (id, player_id, name, strength, dexterity, vitality, current_level, current_health, max_health, experience)
    SELECT gladiator_seq.nextVal,
           (SELECT id FROM users WHERE username = 'player2'),
           'Shadow Lord Henry',  3, 6, 3, 5, 9, 15, 17 FROM dual;

INSERT INTO gladiator (id, player_id, name, strength, dexterity, vitality, current_level, current_health, max_health, experience)
    SELECT gladiator_seq.nextVal,
    (SELECT id FROM users WHERE username = 'player2'),
    'Shadow Lord Hannah',  3, 6, 3, 5, 14, 15, 17 FROM dual;

INSERT INTO gladiator (id, player_id, name, strength, dexterity, vitality, current_level, current_health, max_health, experience)
    SELECT gladiator_seq.nextVal,
    (SELECT id FROM users WHERE username = 'player2'),
    'Shadow Lord Harold',  3, 6, 3, 5, 15, 15, 17 FROM dual;

-- Items
INSERT INTO items (id, name, description, effect_health, effect_xp, price)
    SELECT item_seq.nextVal, 'Small Healing Potion', 'Restores 30% health to a hero of your choice.',
    30, 0, 10 FROM dual;

INSERT INTO items (id, name, description, effect_health, effect_xp, price)
    SELECT item_seq.nextVal, 'Medium Healing Potion', 'Restores 65% health to a hero of your choice.',
    65, 0, 20 FROM dual;

INSERT INTO items (id, name, description, effect_health, effect_xp, price)
    SELECT item_seq.nextVal, 'Large Healing Potion', 'Completely restores the health of a hero of your choice.',
    100, 0, 30 FROM dual;


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
