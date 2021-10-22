package com.milc3sar.pokeapi.controller;

import com.milc3sar.pokeapi.domain.Pokemon;
import com.milc3sar.pokeapi.service.IPokemonService;
import com.milc3sar.pokeapi.util.PokemonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pokemon")
public class PokemonController {

    @Autowired
    @Qualifier(value = "pokemon-service")
    private IPokemonService pokemonService;

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<Pokemon>> getListPokemon() {
        List<Pokemon> pokemons = pokemonService.findAll();
        return new ResponseEntity<>(pokemons, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable Long id) {
        Optional<Pokemon> searchPokemon = Optional.ofNullable(pokemonService.findById(id));

        if (!searchPokemon.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(searchPokemon.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Object> savePokemon(@RequestBody Map<String, Object> data) {
        Pokemon pokemon = PokemonUtil.mapToPokemon(data);
        pokemonService.save(pokemon);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updatePokemon(@PathVariable Long id, @RequestBody Map<String, Object> data) {
        Optional<Pokemon> searchPokemon = Optional.ofNullable(pokemonService.findById(id));

        if (!searchPokemon.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Pokemon pokemon = PokemonUtil.mapToPokemon(data);
        pokemon.setId(id);

        pokemonService.save(pokemon);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> updatePokemon(@PathVariable Long id) {
        Optional<Pokemon> searchPokemon = Optional.ofNullable(pokemonService.findById(id));

        if (!searchPokemon.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        pokemonService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
