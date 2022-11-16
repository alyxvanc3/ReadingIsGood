package com.company.readingIsGood.warehouse;

import com.company.readingIsGood.book.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class Warehouse {
    private long id;
    private Map<Book, Integer> books;
}
