package com.sales.market.service;

import com.sales.market.model.ItemInventory;
import com.sales.market.model.ItemInventoryEntry;
import com.sales.market.model.MovementType;
import com.sales.market.vo.ItemInventoryEntryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.math.BigDecimal;

@SpringBootTest
class ItemInventoryEntryServiceImplTest {

    @Autowired
    private ItemInventoryEntryService itemInventoryEntryService;

    @Autowired
    private ItemInventoryService itemInventoryService;

    @Test
    void addItemInventoryEntry() {
        ItemInventoryEntryVO itemInventoryEntryVO = new ItemInventoryEntryVO();
        itemInventoryEntryVO.setItemInventoryId(1L);
        itemInventoryEntryVO.setProviderItemId(1L);
        itemInventoryEntryVO.setItemInstanceSkus(""+Math.random()*1000);
        itemInventoryEntryVO.setMovementType(MovementType.SALE);
        itemInventoryEntryVO.setQuantity(new BigDecimal("2"));

        ItemInventoryEntry itemInventoryEntry = new ItemInventoryEntry();
        itemInventoryEntry = itemInventoryEntryService.addItemInventoryEntry(itemInventoryEntryVO);

        itemInventoryEntryVO.setItemInstanceSkus(""+Math.random()*1000);
        itemInventoryEntry = itemInventoryEntryService.addItemInventoryEntry(itemInventoryEntryVO);

        itemInventoryEntryVO.setMovementType(MovementType.BUY);
        itemInventoryEntryVO.setQuantity(new BigDecimal("10"));
        itemInventoryEntryVO.setItemInstanceSkus(""+Math.random()*1000);
        itemInventoryEntry = itemInventoryEntryService.addItemInventoryEntry(itemInventoryEntryVO);

        itemInventoryEntryVO.setItemInstanceSkus(""+Math.random()*1000);
        itemInventoryEntry = itemInventoryEntryService.addItemInventoryEntry(itemInventoryEntryVO);

        ItemInventory itemInventory = itemInventoryService.findById(1L);

        Assert.assertEquals(itemInventory.getStockQuantity(), new BigDecimal("21.00"));

    }
}