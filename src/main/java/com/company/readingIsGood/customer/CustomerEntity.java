package com.company.readingIsGood.customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "customer", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class CustomerEntity {
    @Id
    private long id;
}
