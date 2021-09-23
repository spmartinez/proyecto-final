package com.sales.market.service;

import com.sales.market.mail.EmailService;
import com.sales.market.model.ItemInventoryEntry;
import com.sales.market.model.MovementType;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.ItemInventoryEntryRepository;
import com.sales.market.vo.ItemInventoryEntryVO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ItemInventoryEntryServiceImpl extends GenericServiceImpl<ItemInventoryEntry> implements ItemInventoryEntryService {
    private final ItemInventoryEntryRepository repository;
    private final ProviderItemService providerService;
    private final EmailService emailService;
    private final ItemInventoryService itemInventoryService;


    public ItemInventoryEntryServiceImpl(ItemInventoryEntryRepository repository, ProviderItemService providerService, EmailService emailService, ItemInventoryService itemInventoryService) {
        this.repository = repository;
        this.providerService = providerService;
        this.emailService = emailService;
        this.itemInventoryService = itemInventoryService;
    }

    @Override
    protected GenericRepository<ItemInventoryEntry> getRepository() {
        return repository;
    }



    private void sendAlertMessage(String subject, String message, ItemInventoryEntry itemInventoryEntry) {
        String email = itemInventoryEntry.getProviderItem().getProvider().getEmail();
        emailService.sendSimpleMessage(email, subject, message);
    }

    @Override
    public ItemInventoryEntry addItemInventoryEntry(ItemInventoryEntryVO itemInventoryEntryVO) {
        ItemInventoryEntry itemInventoryEntry = new ItemInventoryEntry();
        itemInventoryEntry.setMovementType(itemInventoryEntryVO.getMovementType());
        itemInventoryEntry.setQuantity(itemInventoryEntryVO.getQuantity());
        itemInventoryEntry.setItemInstanceSkus(itemInventoryEntryVO.getItemInstanceSkus());
        itemInventoryEntry.setItemInventory(itemInventoryService.findById(itemInventoryEntryVO.getItemInventoryId()));
        itemInventoryEntry.setProviderItem(providerService.findById(itemInventoryEntryVO.getProviderItemId()));
        ItemInventoryEntry response = repository.save(itemInventoryEntry);
        if ( !changeItemInventory(itemInventoryEntry) ) {
            throw new UnsupportedOperationException("la cantidad de items no es suficiente");
        }
        return response;
    }

    private boolean changeItemInventory(ItemInventoryEntry itemInventoryEntry) {
        boolean res = false;
        BigDecimal quantityStock = itemInventoryEntry.getItemInventory().getStockQuantity();
        BigDecimal quantityEntry = itemInventoryEntry.getQuantity();
//        System.out.println(":D"+itemInventoryEntry.getMovementType());
        if (itemInventoryEntry.getMovementType().equals(MovementType.REMOVED) ||
                itemInventoryEntry.getMovementType().equals(MovementType.SALE)){
//            System.out.println("D:");
            if (compareTwoBigDecimals( quantityStock , quantityEntry )){
                res = true;
                itemInventoryService.subtractStockQuantity(itemInventoryEntry.getItemInventory().getId(), quantityEntry);
                if ( compareTwoBigDecimals( itemInventoryEntry.getItemInventory().getLowerBoundThreshold(), quantityStock.subtract(quantityEntry))) {
                    sendAlertMessage("Lower Bound Threshold", "do you have a lower threshold",itemInventoryEntry);
                }
            }
        } else if (itemInventoryEntry.getMovementType().equals(MovementType.BUY)){
            res = true;
            itemInventoryService.addStockQuantity(itemInventoryEntry.getItemInventory().getId(), quantityEntry);
            if ( compareTwoBigDecimals( quantityStock.add(quantityEntry), itemInventoryEntry.getItemInventory().getUpperBoundThreshold())) {
                sendAlertMessage("Upper Bound Threshold", "do you have an upper threshold",itemInventoryEntry);
            }
        }
        return res;
    }

    // one >= two
    public boolean compareTwoBigDecimals(BigDecimal one, BigDecimal two) {
        return one.compareTo(two) >= 0;
    }
}
