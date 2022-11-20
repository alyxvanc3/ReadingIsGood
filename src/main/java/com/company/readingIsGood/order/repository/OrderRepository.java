package com.company.readingIsGood.order.repository;

import com.company.readingIsGood.order.OrderEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

   List<OrderEntity> findAllByCustomer(int customer_id, Pageable page);

    @Query(value = "SELECT t FROM OrderEntity t where t.operationDate BETWEEN :startDate AND :endDate")
    List<OrderEntity> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate")Date endDate);
}
