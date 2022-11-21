package com.company.readingIsGood.customer;

import com.company.readingIsGood.customer.service.CustomerService;
import com.company.readingIsGood.order.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @PostMapping(path = "/customer")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @GetMapping(path = "/customer/order/{customerId}")
    public List<Order> getOrdersByCustomerId(
            @PathVariable long customerId,
            @PageableDefault(size = 20) Pageable pageable)
    {
        return customerService.getOrdersByCustomerId(customerId, pageable);
    }
}
