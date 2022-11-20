package com.company.readingIsGood.order;

import com.company.readingIsGood.order.model.Order;
import com.company.readingIsGood.order.service.OrderService;
import com.company.readingIsGood.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/order")
    public void addOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @GetMapping(path = "/order")
    public ResponseEntity<Order> getOrderById(@RequestParam Long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @GetMapping(path = "/order/date")
    public List<Order> getOrdersByDateInterval(@RequestParam String startDate,
                                                @RequestParam String endDate) throws ParseException {

        return orderService.getOrdersByDate(Utility.getDateFromString(startDate),
                Utility.getDateFromString(endDate));
    }
}
