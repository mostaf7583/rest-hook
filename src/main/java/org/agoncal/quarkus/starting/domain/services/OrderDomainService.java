package org.agoncal.quarkus.starting.domain.services;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.agoncal.quarkus.starting.domain.model.catalog.Book;
import org.agoncal.quarkus.starting.domain.model.ordering.Order;
import org.agoncal.quarkus.starting.infrastructure.repository.OrderReactiveRepo;

import java.util.List;

@ApplicationScoped
public class OrderDomainService {
    @Inject
    OrderReactiveRepo orderReactiveRepository;


    public Uni<Void> creatingOrders(List<Order>orders)
    {
        return Panache.withTransaction(()-> orderReactiveRepository.persist(orders));
    }
    public Uni<List<Order>> GetAllOrders() {
        // The correct method for streaming a Multi is streamAll()
        return (Uni<List<Order>>) orderReactiveRepository.listAll();
    }



}
