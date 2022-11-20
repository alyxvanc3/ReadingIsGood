package com.company.readingIsGood.customer.service;

import com.company.readingIsGood.customer.Customer;
import com.company.readingIsGood.order.Order;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);

    List<Order> getOrdersByCustomerNo(int number, Pageable paging);

}
