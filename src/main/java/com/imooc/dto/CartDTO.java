package com.imooc.dto;

import lombok.Data;

/* 购物车 */
@Data
public class CartDTO {

    /* 商品 Id*/
    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
