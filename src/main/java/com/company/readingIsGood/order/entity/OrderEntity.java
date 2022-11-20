package com.company.readingIsGood.order.entity;

import com.company.readingIsGood.customer.CustomerEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter@Setter
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date operationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "orderEntity",  fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<OrderDetailEntity> orderDetails;

}
