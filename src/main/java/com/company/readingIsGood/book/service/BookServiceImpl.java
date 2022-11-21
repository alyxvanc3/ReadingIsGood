package com.company.readingIsGood.book.service;

import com.company.readingIsGood.book.Book;
import com.company.readingIsGood.book.BookEntity;
import com.company.readingIsGood.book.BookRepository;
import com.company.readingIsGood.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveBook(Book book) {
        BookEntity bookEntity = modelMapper.map(book, BookEntity.class);
        bookRepository.save(bookEntity);
        log.info("Book is saved");
    }

    @Override
    public Book updateQuantity(Book book) {
        BookEntity bookEntity = bookRepository.findByIsbn(book.getIsbn());

        if(bookEntity == null) {
            throw new NotFoundException("Book Not Found.");
        }

        bookEntity.setQuantity(book.getQuantity());
        bookRepository.save(bookEntity);
        log.info("Book quantity changed");
        return modelMapper.map(bookEntity, Book.class);
    }
}
