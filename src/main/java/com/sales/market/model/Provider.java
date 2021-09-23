package com.sales.market.model;

import com.sales.market.dto.ProviderDto;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class Provider extends ModelBase<ProviderDto> {
    @Column(unique = true)
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                '}';
    }
}