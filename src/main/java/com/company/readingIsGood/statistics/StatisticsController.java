package com.company.readingIsGood.statistics;

import com.company.readingIsGood.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/statistics/{customerId}")
    public List<Statistics> getCustomerStatistics(@PathVariable long customerId) {
        return statisticsService.getCustomerStatistics(customerId);

    }
}
