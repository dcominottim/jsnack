package br.com.cominotti.jsnack.server.rest;

import br.com.cominotti.jsnack.server.application.command.PlaceCustomSnackOrderCommand;
import br.com.cominotti.jsnack.server.application.command.PlaceSnackOrderCommand;
import br.com.cominotti.jsnack.server.resource.PlaceCustomSnackOrderRs;
import br.com.cominotti.jsnack.server.resource.PlaceSnackOrderRs;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("orders/")
public class OrdersEndpoint {

    @Inject
    private PlaceSnackOrderCommand placeSnackOrderCommand;

    @Inject
    private PlaceCustomSnackOrderCommand placeCustomSnackOrderCommand;


    @POST
    @Path("placeOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public Response placeOrder(PlaceSnackOrderRs input) {
        placeSnackOrderCommand.run(input);
        return Response.status(201).build();
    }

    @POST
    @Path("placeCustomOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public Response placeCustomOrder(PlaceCustomSnackOrderRs input) {
        placeCustomSnackOrderCommand.run(input);
        return Response.status(201).build();
    }
}
