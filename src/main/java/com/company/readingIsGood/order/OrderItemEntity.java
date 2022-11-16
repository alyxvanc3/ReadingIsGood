package com.company.readingIsGood.order;

import javax.persistence.*;

@Entity
@Table(name = "orderItem", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class OrderItemEntity {
    @Id
    private long id;

    private long bookId;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = OrderEntity.class)
    @JoinColumn(name = "fk_order", nullable=false)
    private long orderId;
}
