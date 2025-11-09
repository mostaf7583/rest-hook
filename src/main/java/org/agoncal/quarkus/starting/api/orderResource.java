package org.agoncal.quarkus.starting.api;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.agoncal.quarkus.starting.domain.model.catalog.Book;
import org.agoncal.quarkus.starting.domain.model.ordering.Order;
import org.agoncal.quarkus.starting.domain.services.OrderDomainService;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/order")

public class orderResource {
    @Inject OrderDomainService orderDomainService;

    @GET
    public Uni<List<Order>> GetAllOrders() {
        return orderDomainService.GetAllOrders();
    }
    @POST
    public Uni<RestResponse<List<Order>>> create(List<Order>  orders) {
        return orderDomainService.creatingOrders(orders)   .replaceWith(RestResponse.status(Response.Status.CREATED, orders));
    }
}
