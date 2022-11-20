package com.company.readingIsGood.order.model;

import com.company.readingIsGood.book.Book;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderDetail {
    private long id;
    private long orderId;
    private Book book;
    private int quantity;
}
