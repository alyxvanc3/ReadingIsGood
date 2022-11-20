package com.company.readingIsGood.order;

import com.company.readingIsGood.customer.CustomerEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date operationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "orderId",  fetch = FetchType.LAZY)
    private List<OrderDetailsEntity> orderDetails;

}
