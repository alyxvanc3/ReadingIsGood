package com.company.readingIsGood.book;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Book {
    private long id;
    private int isbn;
    private int quantity;
    private double price;
}
