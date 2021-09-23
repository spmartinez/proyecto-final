package com.sales.market.dto;

import com.sales.market.model.Item;
import com.sales.market.model.ItemInstance;
import com.sales.market.model.ItemInventory;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ItemInventoryDto extends DtoBase<ItemInventory> {
    private Long itemId;
    private BigDecimal stockQuantity;
    private BigDecimal lowerBoundThreshold;
    private BigDecimal upperBoundThreshold;
    private BigDecimal totalPrice;
    private Set<ItemInstance> itemInstances;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(BigDecimal stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public BigDecimal getLowerBoundThreshold() {
        return lowerBoundThreshold;
    }

    public void setLowerBoundThreshold(BigDecimal lowerBoundThreshold) {
        this.lowerBoundThreshold = lowerBoundThreshold;
    }

    public BigDecimal getUpperBoundThreshold() {
        return upperBoundThreshold;
    }

    public void setUpperBoundThreshold(BigDecimal upperBoundThreshold) {
        this.upperBoundThreshold = upperBoundThreshold;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<ItemInstance> getItemInstances() {
        return itemInstances;
    }

    public void setItemInstances(Set<ItemInstance> itemInstances) {
        this.itemInstances = itemInstances;
    }
}
