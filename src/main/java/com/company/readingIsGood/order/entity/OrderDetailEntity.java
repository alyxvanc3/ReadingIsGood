package com.company.readingIsGood.order.entity;

import com.company.readingIsGood.book.BookEntity;
import com.company.readingIsGood.order.entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
@Table(name = "orderDetail", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "book_id")
    private BookEntity book;

    private int quantity;
}
