package com.milc3sar.pokeapi.service.impl;

import com.milc3sar.pokeapi.domain.Pokemon;
import com.milc3sar.pokeapi.repository.IPokemonRepository;
import com.milc3sar.pokeapi.repository.dao.IGenericDao;
import com.milc3sar.pokeapi.service.IPokemonService;
import org.springframework.stereotype.Service;

@Service("pokemon-service")
public class PokemonServiceImpl extends GenericServiceImpl<Pokemon> implements IPokemonService {

    private IPokemonRepository pokemonRepository;

    public PokemonServiceImpl(IGenericDao<Pokemon> dao) {
        super(dao);
    }
}
