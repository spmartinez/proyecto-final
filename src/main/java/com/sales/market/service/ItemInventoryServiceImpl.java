package com.sales.market.service;

import com.sales.market.model.ItemInventory;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.ItemInventoryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ItemInventoryServiceImpl extends GenericServiceImpl<ItemInventory> implements ItemInventoryService {

    private final ItemInventoryRepository repository;
    private final ProviderItemService providerService;

    public ItemInventoryServiceImpl(ItemInventoryRepository repository, ProviderItemService providerService) {
        this.repository = repository;
        this.providerService = providerService;
    }

    @Override
    protected GenericRepository<ItemInventory> getRepository() {
        return repository;
    }

    @Override
    public ItemInventory subtractStockQuantity(Long id, BigDecimal stockQuantity) {
        ItemInventory itemInventory = repository.getById(id);
        itemInventory.setStockQuantity(itemInventory.getStockQuantity().subtract(stockQuantity));
        itemInventory = repository.save(itemInventory);
        return itemInventory;
    }

    @Override
    public ItemInventory addStockQuantity(Long id, BigDecimal stockQuantity) {
        ItemInventory itemInventory = repository.getById(id);
        itemInventory.setStockQuantity(itemInventory.getStockQuantity().add(stockQuantity));
        itemInventory = repository.save(itemInventory);
        return itemInventory;
    }

    /*@Override
    public List<String> sendAlertMessage(Long idAlertMessage) {

        ArrayList<String> response = new ArrayList<>();

        List<Provider> providerList = ProviderService.getBirthdayBoys();

        AlertMessage alertMessage = repository.getById(idAlertMessage);

        String message = alertMessage.getDescription();

        String copyMessage;

        for (Provider provider : providerList) {
            copyMessage = message;

            copyMessage = copyMessage.replace("<name>", provider.getName());

            response.add(provider.getName());

            emailService.sendSimpleMessage(provider.getEmail(), "Promotion", copyMessage);
        }
        return response;
    }*/
}
