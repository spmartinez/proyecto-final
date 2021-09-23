package com.sales.market.controller;

import com.sales.market.dto.ItemInventoryEntryDto;
import com.sales.market.model.ItemInventoryEntry;
import com.sales.market.service.GenericService;
import com.sales.market.service.ItemInventoryEntryService;
import com.sales.market.vo.ItemInventoryEntryVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemsinventoryentry")
public class ItemInventoryEntryController extends GenericController<ItemInventoryEntry, ItemInventoryEntryDto> {
    private ItemInventoryEntryService service;

    public ItemInventoryEntryController(ItemInventoryEntryService service) {
        this.service =   service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @PostMapping("/additeminventoryentry")
    public ItemInventoryEntryDto addItemInventoryEntry(@RequestBody ItemInventoryEntryVO element) {

        return toDto(service.addItemInventoryEntry(element));
    }
}