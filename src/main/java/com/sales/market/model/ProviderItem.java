package com.sales.market.model;

import com.sales.market.dto.ProviderItemDto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class ProviderItem extends ModelBase<ProviderItemDto> {

    @OneToOne
    private Provider provider;
    @OneToOne
    private Item item;
    @OneToOne
    private Unit unit;
    private BigDecimal itemPrice;

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
