package com.sales.market.dto;

import com.sales.market.model.ItemInventory;
import com.sales.market.model.ItemInventoryEntry;
import com.sales.market.model.MovementType;
import com.sales.market.model.ProviderItem;

import java.math.BigDecimal;

public class ItemInventoryEntryDto extends DtoBase<ItemInventoryEntry>{
    private Long itemInventoryId;
    private Long providerItemId;
    private MovementType movementType;
    private BigDecimal quantity; // representan la cantidad de instancias de venta o compra
    private String itemInstanceSkus; //representa una lista del sku de las instancias de elementos involucrados

    public Long getItemInventoryId() {
        return itemInventoryId;
    }

    public void setItemInventoryId(Long itemInventoryId) {
        this.itemInventoryId = itemInventoryId;
    }

    public Long getProviderItemId() {
        return providerItemId;
    }

    public void setProviderItemId(Long providerItemId) {
        this.providerItemId = providerItemId;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getItemInstanceSkus() {
        return itemInstanceSkus;
    }

    public void setItemInstanceSkus(String itemInstanceSkus) {
        this.itemInstanceSkus = itemInstanceSkus;
    }
}
