package com.company.readingIsGood.book.service;

import com.company.readingIsGood.book.Book;
import com.company.readingIsGood.book.BookEntity;
import com.company.readingIsGood.book.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveBook(Book book) {
        BookEntity bookEntity = modelMapper.map(book, BookEntity.class);
        bookRepository.save(bookEntity);
    }

    @Override
    public Book updateQuantity(int isbn, int quantity) {
        List<BookEntity> bookList = bookRepository.findByIsbn(isbn);

        if(bookList.size() == 1) {
            BookEntity book = bookList.get(0);
            if(book.getQuantity() != quantity) {
                book.setQuantity(quantity);
                BookEntity bookEntity = bookRepository.save(book);

                return modelMapper.map(bookEntity, Book.class);
            }
        }

        return null;
    }
}
