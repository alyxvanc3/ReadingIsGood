package com.company.readingIsGood.order.repository;

import com.company.readingIsGood.order.entity.OrderDetailEntity;
import com.company.readingIsGood.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailEntity, Long> {
    List<OrderDetailEntity> findAllByOrderEntity(OrderEntity order);
}
