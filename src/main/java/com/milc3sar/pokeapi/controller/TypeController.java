package com.milc3sar.pokeapi.controller;

import com.milc3sar.pokeapi.domain.Type;
import com.milc3sar.pokeapi.service.ITypeService;
import com.milc3sar.pokeapi.util.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/type")
public class TypeController {

    @Autowired
    @Qualifier("type-service")
    private ITypeService typeService;

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<Type>> getListTypes() {
        List<Type> types = typeService.findAll();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Type> getType(@PathVariable Long id) {
        Optional<Type> searchType = Optional.ofNullable(typeService.findById(id));

        if (!searchType.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(searchType.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Object> saveType(@RequestBody Map<String, Object> data) {
        Type type = TypeUtil.mapToUtil(data);
        typeService.save(type);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateType(@PathVariable Long id, @RequestBody Map<String, Object> data) {
        Optional<Type> searchPokemon = Optional.ofNullable(typeService.findById(id));

        if (!searchPokemon.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Type type = TypeUtil.mapToUtil(data);
        type.setId(id);

        typeService.save(type);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> updatePokemon(@PathVariable Long id) {
        Optional<Type> searchType = Optional.ofNullable(typeService.findById(id));

        if (!searchType.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        typeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
