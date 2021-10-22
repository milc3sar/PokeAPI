package com.milc3sar.pokeapi.util;

import com.milc3sar.pokeapi.domain.Pokemon;

import java.util.Map;

public class PokemonUtil {

    public static Pokemon mapToPokemon(Map<String, Object> data) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(data.get("name").toString());
        pokemon.setHeight((Integer) data.get("height"));
        pokemon.setWeight((Integer) data.get("weight"));
        return pokemon;
    }
}
