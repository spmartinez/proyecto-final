package com.sales.market.vo;

import com.sales.market.model.ItemInventory;
import com.sales.market.model.MovementType;
import com.sales.market.model.ProviderItem;

import javax.persistence.OneToOne;
import java.math.BigDecimal;

public class ItemInventoryEntryVO {
    private Long itemInventoryId;
    private Long providerItemId;
    private MovementType movementType;
    private BigDecimal quantity;
    private String itemInstanceSkus;

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
