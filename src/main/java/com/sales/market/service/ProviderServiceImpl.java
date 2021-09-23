package com.sales.market.service;

import com.sales.market.model.Provider;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.ProviderRepository;
import org.springframework.stereotype.Service;


@Service
public class ProviderServiceImpl extends GenericServiceImpl<Provider> implements ProviderService {
    private final ProviderRepository repository;

    public ProviderServiceImpl(ProviderRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Provider> getRepository() {
        return repository;
    }
}
