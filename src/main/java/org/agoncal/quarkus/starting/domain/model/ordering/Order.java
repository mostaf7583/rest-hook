package org.agoncal.quarkus.starting.domain.model.ordering;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import org.agoncal.quarkus.starting.domain.model.catalog.Book;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Orders") // <-- ADD THIS LINE to rename the table to Orders
public class Order extends PanacheEntity {

    private UUID userId;
    // FIX: Add the @ManyToMany annotation
    @ManyToMany
    @JoinTable(name = "Orders_Books_Junction") // Optional: Renames the join table
    private List<Book> books;

    private BigDecimal totalPrice;
    private OrderStatus status;

    public Order(UUID userId, List<Book> books) {
        this.userId = userId;
        this.books = books;
        this.totalPrice = calculateTotal(books);
        this.status = OrderStatus.PENDING;
    }

    public Order() {
    }

    private BigDecimal calculateTotal(List<Book> books) {
        return books.stream().map(book -> book.price).map(BigDecimal::valueOf).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}


