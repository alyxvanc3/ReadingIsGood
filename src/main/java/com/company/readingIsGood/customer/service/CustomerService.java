package com.company.readingIsGood.customer.service;

import com.company.readingIsGood.customer.Customer;
import com.company.readingIsGood.order.model.Order;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);

    Customer get(long id);

    List<Order> getOrdersByCustomerId(long id, Pageable paging);

}
