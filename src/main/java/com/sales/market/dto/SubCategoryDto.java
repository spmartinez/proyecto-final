package com.sales.market.dto;

import com.sales.market.model.SubCategory;

public class SubCategoryDto extends DtoBase<SubCategory> {
    private String name;
    private String code;
    // otra forma
    private Long categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
