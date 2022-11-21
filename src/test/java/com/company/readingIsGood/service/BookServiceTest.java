package com.company.readingIsGood.service;

import com.company.readingIsGood.book.Book;
import com.company.readingIsGood.book.BookEntity;
import com.company.readingIsGood.book.BookRepository;
import com.company.readingIsGood.book.service.BookServiceImpl;
import com.company.readingIsGood.customer.CustomerRepository;
import com.company.readingIsGood.customer.service.CustomerServiceImpl;
import com.company.readingIsGood.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    BookRepository bookRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void updateQuantity_success() {
        Book book = new Book();
        book.setId(1);
        book.setIsbn(1);
        book.setQuantity(2);

        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(1);
        bookEntity.setIsbn(1);

        when(bookRepository.findByIsbn(anyInt())).thenReturn(bookEntity);
        when(bookRepository.save(any(BookEntity.class))).thenReturn(bookEntity);

        bookService.updateQuantity(book);
    }

}
