package com.sales.market.dto;

import com.sales.market.model.AlertMessage;

public class AlertMessageDto extends DtoBase<AlertMessage> {
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }


}