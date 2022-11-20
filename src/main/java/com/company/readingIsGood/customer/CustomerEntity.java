package com.company.readingIsGood.customer;

import com.company.readingIsGood.order.entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter@Setter
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int number;

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;
}
