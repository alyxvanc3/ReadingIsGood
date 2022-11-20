package com.company.readingIsGood.customer.service;

import com.company.readingIsGood.customer.Customer;
import com.company.readingIsGood.customer.CustomerEntity;
import com.company.readingIsGood.customer.CustomerRepository;
import com.company.readingIsGood.order.Order;
import com.company.readingIsGood.order.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCustomer(Customer customer) {
        CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }

    @Override
    public List<Order> getOrdersByCustomerNo(int no, Pageable paging) {
        return orderService.getOrdersByCustomerNo(no, paging);
    }
}
