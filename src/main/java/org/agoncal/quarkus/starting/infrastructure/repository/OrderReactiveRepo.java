package org.agoncal.quarkus.starting.infrastructure.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.quarkus.starting.domain.model.catalog.Book;
import org.agoncal.quarkus.starting.domain.model.ordering.Order;

@ApplicationScoped
public class OrderReactiveRepo implements PanacheRepository<Order> {

}
