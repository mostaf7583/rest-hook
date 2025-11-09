package org.agoncal.quarkus.starting.domain.services;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.agoncal.quarkus.starting.domain.model.catalog.Book;
import org.agoncal.quarkus.starting.infrastructure.repository.ReactiveBookRepository;

import java.util.List;

@ApplicationScoped
public class BookDomainService {
    @Inject
    ReactiveBookRepository reactiveBookRepository;


    public Uni<Void> saveBooks(List<Book>books)
    {
        return Panache.withTransaction(()-> reactiveBookRepository.persist(books));
    }
    public Uni<List<Book>> getAllBooks() {
        // The correct method for streaming a Multi is streamAll()
        return (Uni<List<Book>>) reactiveBookRepository.listAll();
    }



}
