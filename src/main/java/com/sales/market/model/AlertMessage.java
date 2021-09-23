package com.sales.market.model;

import javax.persistence.Entity;

@Entity
public class AlertMessage extends ModelBase{
    private String description;

    public String getDescription() {
        return description;
    }
}