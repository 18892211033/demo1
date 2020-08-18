package com.isoft.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private Integer orderId;
    private Integer orderUserId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "Asia/Shanghai")
    private Date orderDate;
    private double orderPrice;
    private String orderState;
    private String orderUserName;
    private String orderUserPhone;
    private String orderAddress;
    private String orderNo;
}
