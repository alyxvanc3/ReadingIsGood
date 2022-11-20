package com.company.readingIsGood.order.service;

import com.company.readingIsGood.order.Order;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface OrderService {

    List<Order> getOrdersByCustomerNo(int customerNo, Pageable pageable);

    void saveOrder(Order order);

    Order getOrderById(long orderId);

    List<Order> getOrdersByDate(Date startDate, Date endDate);
}
