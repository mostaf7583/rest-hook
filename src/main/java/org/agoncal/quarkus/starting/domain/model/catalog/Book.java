package org.agoncal.quarkus.starting.domain.model.catalog;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book extends PanacheEntity {



    @Column(nullable = false)
    public String title;

    public String isbn;
    public Double price;
    public Integer stockQuantity;

    @ManyToOne
    public Author author;



    public void decreaseStock(int qty) {
        if (qty <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (stockQuantity < qty) throw new IllegalStateException("Insufficient stock");
        this.stockQuantity -= qty;
    }

}