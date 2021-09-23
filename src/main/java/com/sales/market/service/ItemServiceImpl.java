/**
 * @author: Edson A. Terceros T.
 */

package com.sales.market.service;

import com.sales.market.model.Item;
import com.sales.market.model.SubCategory;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item> implements ItemService {
    private final ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Item> getRepository() {
        return repository;
    }

    @Override
    public Item findById(Long id){
        return repository.findById(id).orElse(null);
    }
}
