package br.com.cominotti.jsnack.server.rest;

import br.com.cominotti.jsnack.server.application.query.GetSnacksQuery;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/snacks/")
public class SnacksEndpoint {

	@Inject
	private GetSnacksQuery getSnacksQuery;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSnacks() {
		return Response.ok(getSnacksQuery.run()).build();
	}
}