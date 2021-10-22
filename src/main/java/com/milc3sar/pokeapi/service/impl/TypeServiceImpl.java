package com.milc3sar.pokeapi.service.impl;

import com.milc3sar.pokeapi.domain.Type;
import com.milc3sar.pokeapi.repository.ITypeRepository;
import com.milc3sar.pokeapi.repository.dao.IGenericDao;
import com.milc3sar.pokeapi.service.ITypeService;
import org.springframework.stereotype.Service;

@Service("type-service")
public class TypeServiceImpl extends GenericServiceImpl<Type> implements ITypeService {

    private ITypeRepository typeRepository;

    public TypeServiceImpl(IGenericDao<Type> dao) {
        super(dao);
    }
}
