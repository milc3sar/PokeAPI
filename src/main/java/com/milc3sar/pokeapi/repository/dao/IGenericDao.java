package com.milc3sar.pokeapi.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface IGenericDao<T extends Serializable> extends JpaRepository<T, Long> {
}
