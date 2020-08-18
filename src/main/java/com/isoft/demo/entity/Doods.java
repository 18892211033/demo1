package com.isoft.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doods implements Serializable {
    private Integer goodsId;
    private String goodName;
    private double goosPrice;
    private Integer goodsNum;
    private String goodsType;
    private Integer goodsMemory;
    private String goodsColor;
    private String goodsImgUrl;
    private String goodsState;
}
