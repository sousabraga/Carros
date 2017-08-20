package br.com.livro.carros.rest;

import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("userInfo")
public class UserInfoResource {

	@Context
	private SecurityContext securityContext;

	@GET
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
	public String userInfo() {
		if (securityContext == null) 
			throw new NotAuthorizedException("Acesso não autorizado");
		
		String name = securityContext.getUserPrincipal().getName();
		
		if (securityContext.isUserInRole("admin"))
			return "Você é um administrador: " + name;
		
		if (securityContext.isUserInRole("user"))
			return "Você é um usuário: " + name;
	
		return "Nenhum dos dois";
	}
	
}
