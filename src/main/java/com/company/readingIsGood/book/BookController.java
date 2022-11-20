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

    @PutMapping(path = "/book/{isbn}/{quantity}")
    public Book updateQuantity(@PathVariable int isbn,
                               @PathVariable int quantity) {

        return bookService.updateQuantity(isbn, quantity);

    }
}
