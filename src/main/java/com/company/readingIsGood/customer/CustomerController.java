package com.company.readingIsGood.customer;

import com.company.readingIsGood.customer.service.CustomerService;
import com.company.readingIsGood.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/customer/{customerNo}")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(
            @PathVariable int number,
            @RequestParam(defaultValue= "0", required = false)
                    Integer page ,
            @RequestParam(defaultValue= "5", required = false)
                    Integer pageSize
    ) throws Exception {
        Pageable paging = PageRequest.of(page, pageSize);

        List<Order> orders =
                customerService.getOrdersByCustomerNo(number, paging);

        return new ResponseEntity<List<Order>>(
                orders, HttpStatus.ACCEPTED);
    }
}
