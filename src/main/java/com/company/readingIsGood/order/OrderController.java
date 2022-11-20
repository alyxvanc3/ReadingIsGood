package com.company.readingIsGood.order;

import com.company.readingIsGood.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/order")
    public void saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @GetMapping(path = "/order/{orderId}")
    public Order getOrderById(@PathVariable long orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping(path = "/order/{startDate}/{endDate}")
    public ResponseEntity<List<Order>> getOrder(@PathVariable Date startDate,
                                                @PathVariable Date endDate) {

        orderService.getOrdersByDate(startDate, endDate);

        return null;
    }
}
