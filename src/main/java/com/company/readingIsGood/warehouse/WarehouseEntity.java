package com.company.readingIsGood.warehouse;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "warehouse", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class WarehouseEntity {
    @Id
    private long id;

    @OneToMany(mappedBy = "warehouseId")
    private Set<WarehouseItemEntity> items;

}