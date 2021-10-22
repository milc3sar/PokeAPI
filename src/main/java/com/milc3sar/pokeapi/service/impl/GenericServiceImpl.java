package com.milc3sar.pokeapi.service.impl;

import com.milc3sar.pokeapi.repository.dao.IGenericDao;
import com.milc3sar.pokeapi.service.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class GenericServiceImpl<T extends Serializable> implements IGenericService<T> {

    private IGenericDao<T> dao;

    @Autowired
    public GenericServiceImpl(IGenericDao<T> dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return (List<T>) dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(T entity) {
        dao.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        dao.deleteById(id);
    }
}
