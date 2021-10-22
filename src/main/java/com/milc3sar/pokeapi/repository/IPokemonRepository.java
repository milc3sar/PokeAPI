package com.milc3sar.pokeapi.repository;

import com.milc3sar.pokeapi.domain.Pokemon;
import com.milc3sar.pokeapi.repository.dao.IGenericDao;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPokemonRepository extends IGenericDao<Pokemon> {
    List<Pokemon> findByName(@Param("name") String name);
}