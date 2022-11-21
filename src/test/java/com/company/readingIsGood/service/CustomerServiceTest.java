package com.company.readingIsGood.service;

import com.company.readingIsGood.customer.Customer;
import com.company.readingIsGood.customer.CustomerEntity;
import com.company.readingIsGood.customer.CustomerRepository;
import com.company.readingIsGood.customer.service.CustomerServiceImpl;
import com.company.readingIsGood.order.model.Order;
import com.company.readingIsGood.order.service.OrderService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    CustomerRepository customerRepository;

    @Mock
    OrderService orderService;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void saveCustomer_success() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setNumber(1);

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setNumber(1);
        customerEntity.setId(1);

        customerService.saveCustomer(customer);
    }

    @Test
    public void getOrdersByCustomerId_success() {
        int id = 1;
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setNumber(1);
        customerEntity.setId(1);

        List<Order> orders = new ArrayList<>();
        Optional<CustomerEntity> entity = Optional.of(customerEntity);

        when(customerRepository.findById(anyLong())).thenReturn(entity);

        when(orderService.getOrdersByCustomerId(any(), any())).thenReturn(orders);

        customerService.getOrdersByCustomerId(1, Pageable.unpaged());
        Assertions.assertEquals(Collections.EMPTY_LIST, orders);
    }

}
