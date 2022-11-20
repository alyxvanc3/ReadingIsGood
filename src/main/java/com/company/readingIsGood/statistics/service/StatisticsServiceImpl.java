package com.company.readingIsGood.statistics.service;

import com.company.readingIsGood.customer.service.CustomerService;
import com.company.readingIsGood.order.model.Order;
import com.company.readingIsGood.statistics.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private CustomerService customerService;

    @Override
    public List<Statistics> getCustomerStatistics(long customerId) {

        List<Order> orders = customerService.getOrdersByCustomerId(customerId, Pageable.unpaged());

        List<Statistics> statisticsList = new ArrayList<>();

        Map<Integer, List<Order>> orderMap = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getOperationDate().getMonth()));


        return null;
    }
}
