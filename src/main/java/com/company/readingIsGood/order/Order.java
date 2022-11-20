package com.company.readingIsGood.order;

import com.company.readingIsGood.book.Book;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class Order {
    private long id;
    private Date operationDate;
    private int customerNo;
    private Map<Book, Integer> books = new HashMap<>();
}
