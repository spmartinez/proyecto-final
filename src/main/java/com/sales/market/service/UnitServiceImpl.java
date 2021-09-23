package com.sales.market.service;

import com.sales.market.model.Unit;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.UnitRepository;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl extends GenericServiceImpl<Unit> implements UnitService{
    private final UnitRepository repository;

    public UnitServiceImpl(UnitRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Unit> getRepository() {
        return repository;
    }
}
