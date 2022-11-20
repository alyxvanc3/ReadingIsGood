package com.company.readingIsGood.order.repository;

import com.company.readingIsGood.customer.Customer;
import com.company.readingIsGood.customer.CustomerEntity;
import com.company.readingIsGood.order.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

   Page<OrderEntity> findAllByCustomer(CustomerEntity customer, Pageable page);

    @Query(value = "SELECT t FROM OrderEntity t where t.operationDate BETWEEN :startDate AND :endDate")
    List<OrderEntity> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate")Date endDate);
}
