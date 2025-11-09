package org.agoncal.quarkus.starting.infrastructure.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.data.repository.Query;
import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.quarkus.starting.domain.model.catalog.Book;
@ApplicationScoped
public class ReactiveBookRepository implements PanacheRepository<Book> {

    @Query("select b from Book b where b.title = :title")
    public Uni<Book> findByTitle(String title) {
        return find("title", title).firstResult();
    }


}

