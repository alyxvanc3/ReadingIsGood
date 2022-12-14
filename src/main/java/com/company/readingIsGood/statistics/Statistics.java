package com.company.readingIsGood.statistics;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Statistics {
    private String month;
    private int totalOrderCount;
    private int totalBookCount;
    private double totalPurchasedAmount;
}
