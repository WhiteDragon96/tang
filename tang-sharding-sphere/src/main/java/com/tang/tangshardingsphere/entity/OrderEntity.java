package com.tang.tangshardingsphere.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class OrderEntity {

    @Id
    private Long orderId;

    private Integer userId;
}
