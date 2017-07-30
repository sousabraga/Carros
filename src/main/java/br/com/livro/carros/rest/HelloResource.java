package br.com.livro.carros.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.livro.carros.domain.Response;

@Path("/hello")
public class HelloResource {

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML + ";charset=UTF-8")
	public String helloHTML() {
		return "<b>Hello World HTML!</b>";
	}
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String helloTextPlain() {
		return "Hello World Text!";
	}
	
	@GET
	@Consumes({MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	public Response helloXML() {
		return Response.Ok("Hello World XML!");
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloJSON() {
		return Response.Ok("Hello World JSON!");
	}
	
	/*@GET
	public String get() {
		return "HTTP GET";
	}
	
	@POST
	public String post() {
		return "HTTP POST";
	}
	
	@PUT
	public String put() {
		return "HTTP PUT";
	}
	
	@DELETE
	public String delete() {
		return "HTTP DELETE";
	}*/
	
}
