package com.company.readingIsGood.order.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter
public class Order {
    private long id;
    private Date operationDate;
    private long customerId;
    private List<OrderDetail> orderDetails = new ArrayList<>();
}
