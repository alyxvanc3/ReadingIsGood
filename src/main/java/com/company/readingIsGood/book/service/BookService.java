package com.company.readingIsGood.book.service;

import com.company.readingIsGood.book.Book;

public interface BookService {

    void saveBook(Book book);

    Book updateQuantity(Book book);

}
