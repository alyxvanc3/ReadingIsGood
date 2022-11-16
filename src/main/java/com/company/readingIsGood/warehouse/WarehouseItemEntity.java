package com.company.readingIsGood.warehouse;

import javax.persistence.*;

@Entity
@Table(name = "warehouseItem", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class WarehouseItemEntity {
    @Id
    private long id;

    private long bookId;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = WarehouseEntity.class)
    @JoinColumn(name = "fk_warehouse", nullable=false)
    private long warehouseId;
}
