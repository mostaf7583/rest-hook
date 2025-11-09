package org.agoncal.quarkus.starting.api;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.agoncal.quarkus.starting.domain.model.catalog.Book;
import org.agoncal.quarkus.starting.domain.services.BookDomainService;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
@Inject
    BookDomainService bookDomainService;
    @POST
    public Uni<RestResponse<List<Book>>> create(List<Book> books) {
        return bookDomainService.saveBooks(books)
                .replaceWith(RestResponse.status(Response.Status.CREATED, books));
    }
@GET

    public Uni<List<Book>> getAllBooks() {
    return bookDomainService.getAllBooks();
}
@GET
    @Path("/stream")

    public Uni<List<Book>> getAllBooksStream() {
        return bookDomainService.getAllBooks();
    }


}
