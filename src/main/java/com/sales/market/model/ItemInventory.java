/**
 * @author: Edson A. Terceros T.
 */

package com.sales.market.model;

import com.sales.market.dto.ItemInventoryDto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ItemInventory extends ModelBase<ItemInventoryDto>{
    @OneToOne
    private Item item;
    private BigDecimal stockQuantity;
    private BigDecimal lowerBoundThreshold;
    private BigDecimal upperBoundThreshold;
    private BigDecimal totalPrice;
    @OneToMany(mappedBy = "itemInventory", fetch = FetchType.EAGER)
    private Set<ItemInstance> itemInstances = new HashSet<>();

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
