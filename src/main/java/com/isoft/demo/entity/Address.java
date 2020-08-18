package com.isoft.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private Integer addrId;
    private String addrProvincer;
    private String addrCity;
    private String addrArea;
    private String addrDetail;
    private Integer addrUserId;
    private String addrUserPhone;
    private String addrNickName;
    private String addrState;
}
