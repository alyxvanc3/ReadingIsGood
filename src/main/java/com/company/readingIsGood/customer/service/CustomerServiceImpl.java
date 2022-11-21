package com.company.readingIsGood.customer.service;

import com.company.readingIsGood.customer.Customer;
import com.company.readingIsGood.customer.CustomerEntity;
import com.company.readingIsGood.customer.CustomerRepository;
import com.company.readingIsGood.order.model.Order;
import com.company.readingIsGood.order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
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
        log.info("Customer is saved");
    }

    @Override
    public Customer get(long id) {
        log.info("Get customer by id requested");
        return modelMapper.map(customerRepository.findById(id), Customer.class);
    }

    @Override
    public List<Order> getOrdersByCustomerId(long id, Pageable paging) {
        log.info("Returning orders of customers");
        CustomerEntity customer = customerRepository.findById(id).get();
        return orderService.getOrdersByCustomerId(modelMapper.map(customer, Customer.class), paging);
    }
}
