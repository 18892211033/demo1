package com.isoft.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {
    private Integer cartId;
    private Integer cartGoods;
    private Integer cartNum;
    private double cartPrice;
    private Integer cartUserId;
}
