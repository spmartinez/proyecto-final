package com.sales.market.service;

import com.sales.market.model.ItemInventoryEntry;
import com.sales.market.vo.ItemInventoryEntryVO;
import org.springframework.stereotype.Service;

@Service
public interface ItemInventoryEntryService extends GenericService<ItemInventoryEntry>{

    ItemInventoryEntry addItemInventoryEntry(ItemInventoryEntryVO itemInventoryEntryVO);
}
