package com.company.readingIsGood.order.repository;

import com.company.readingIsGood.order.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long> {
    List<OrderDetailsEntity> findAllByOrderId(long orderId);
}
