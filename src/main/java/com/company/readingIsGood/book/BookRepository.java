package com.company.readingIsGood.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    BookEntity findByIsbn(int isbn);

}
