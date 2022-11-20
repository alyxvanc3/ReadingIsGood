package com.company.readingIsGood.statistics;

import com.company.readingIsGood.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/statistics/{customerId}")
    public List<Statistics> getCustomerStatistics(@PathVariable long customerId) {
        return statisticsService.getCustomerStatistics(customerId);

    }
}
