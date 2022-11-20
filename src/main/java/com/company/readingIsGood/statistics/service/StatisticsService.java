package com.company.readingIsGood.statistics.service;

import com.company.readingIsGood.statistics.Statistics;

import java.util.List;

public interface StatisticsService {
    List<Statistics> getCustomerStatistics(long customerId);
}
