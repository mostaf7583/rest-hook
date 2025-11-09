package org.agoncal.quarkus.starting.domain.model.catalog;


import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Author extends PanacheEntity {
    public String name;
    public String email;
    @OneToMany(mappedBy = "author")
    public List<Book> books = new ArrayList<>();
}
