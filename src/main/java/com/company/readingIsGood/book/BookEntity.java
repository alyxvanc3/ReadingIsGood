package com.company.readingIsGood.book;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "book", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class BookEntity {
    @Id
    private long id;
    private double price;

}
