package com.tang.tangshardingsphere.dao;

import com.tang.tangshardingsphere.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<OrderDao,Long> {

    OrderEntity findByOrderId(Long orderId);
}
