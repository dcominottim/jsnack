package br.com.cominotti.jsnack.server.rest;

import br.com.cominotti.jsnack.server.application.query.GetIngredientsQuery;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/snacks/ingredients")
public class IngredientsEndpoint {

    @Inject
    private GetIngredientsQuery getIngredientsQuery;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIngredients() {
        return Response.ok(getIngredientsQuery.run()).build();
    }
}
