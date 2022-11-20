package com.company.readingIsGood.statistics.service;

import com.company.readingIsGood.customer.service.CustomerService;
import com.company.readingIsGood.order.model.Order;
import com.company.readingIsGood.order.model.OrderDetail;
import com.company.readingIsGood.statistics.Statistics;
import com.company.readingIsGood.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private CustomerService customerService;

    @Override
    public List<Statistics> getCustomerStatistics(long customerId) {

        List<Order> orders = customerService.getOrdersByCustomerId(customerId, Pageable.unpaged());

        List<Statistics> statisticsList = new ArrayList<>();

        Map<Integer, List<Order>> orderMap = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getOperationDate().getMonth()));

        int totalBookCount = 0;
        int totalPurchaseAmount = 0;

        for (Integer month : orderMap.keySet()) {
            List<Order> monthlyOrders = orderMap.get(month);

            Statistics statistics = new Statistics();
            statistics.setMonth(Utility.getMonth(month));

            totalBookCount = 0;
            totalPurchaseAmount = 0;

            statistics.setTotalOrderCount(monthlyOrders.size());

            for (Order orderItem: monthlyOrders) {
                List<OrderDetail> orderItemDetails = orderItem.getOrderDetails();

                for(OrderDetail orderItemDetail : orderItemDetails) {
                    totalBookCount += orderItemDetail.getQuantity();
                    totalPurchaseAmount += orderItemDetail.getBook().getPrice() * orderItemDetail.getQuantity();
                }
            }

            statistics.setTotalBookCount(totalBookCount);
            statistics.setTotalPurchasedAmount(totalPurchaseAmount);

            statisticsList.add(statistics);
        }

        return statisticsList;
    }
}
