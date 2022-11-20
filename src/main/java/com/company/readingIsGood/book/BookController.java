package com.company.readingIsGood.book;

import com.company.readingIsGood.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;

    @PostMapping(path = "/book")
    public void addBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @PutMapping(path = "/book")
    public Book updateQuantity(@RequestBody Book book) {

        return bookService.updateQuantity(book);

    }
}
