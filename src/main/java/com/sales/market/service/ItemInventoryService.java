package com.sales.market.service;

import com.sales.market.dto.ItemInventoryDto;
import com.sales.market.model.ItemInventory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public interface ItemInventoryService extends GenericService<ItemInventory> {
    //List<String> sendAlertMessage(Long idAlertMessage);
    ItemInventory subtractStockQuantity(Long id, BigDecimal stockQuantity);

    ItemInventory addStockQuantity(Long id, BigDecimal stockQuantity);
}
