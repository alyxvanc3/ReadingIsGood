package com.company.readingIsGood.order;

import com.company.readingIsGood.warehouse.WarehouseItemEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "orders", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class OrderEntity {
    @Id
    private long id;
    private LocalDate date;
    private long customerId;

    @OneToMany(mappedBy = "orderId")
    private Set<OrderItemEntity> items;

}
