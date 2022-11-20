package com.company.readingIsGood.order.service;

import com.company.readingIsGood.customer.Customer;
import com.company.readingIsGood.order.model.Order;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface OrderService {

    List<Order> getOrdersByCustomerId(Customer customer, Pageable pageable);

    void saveOrder(Order order);

    Order getOrderById(long orderId);

    List<Order> getOrdersByDate(Date startDate, Date endDate);
}
