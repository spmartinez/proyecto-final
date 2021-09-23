package com.sales.market.model;

import com.sales.market.dto.UnitDto;

import javax.persistence.Entity;

@Entity

public class Unit extends ModelBase<UnitDto> {

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
