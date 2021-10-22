-- Inserts pokemons
INSERT INTO pokemon(name, height, weight) VALUES ("bulbasaur", 7, 69);
INSERT INTO pokemon(name, height, weight) VALUES ("ivysaur", 10, 130);
INSERT INTO pokemon(name, height, weight) VALUES ("venusaur", 20, 1000);
INSERT INTO pokemon(name, height, weight) VALUES ("charmander", 6, 85);
INSERT INTO pokemon(name, height, weight) VALUES ("charmeleon", 11, 190);

-- Inserts Types
INSERT INTO type(name) VALUES ("grass");

INSERT INTO pokemon_type(pokemon_id, type_id) VALUES (1,1);
INSERT INTO pokemon_type(pokemon_id, type_id) VALUES (2,1);
INSERT INTO pokemon_type(pokemon_id, type_id) VALUES (3,1);
