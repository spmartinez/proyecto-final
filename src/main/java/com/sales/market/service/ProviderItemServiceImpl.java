package com.sales.market.service;


import com.sales.market.model.Item;
import com.sales.market.model.ProviderItem;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.ProviderItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ProviderItemServiceImpl extends GenericServiceImpl<ProviderItem> implements ProviderItemService {
    private final ProviderItemRepository repository;

    public ProviderItemServiceImpl(ProviderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<ProviderItem> getRepository() {
        return repository;
    }

}
