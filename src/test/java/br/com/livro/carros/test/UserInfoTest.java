package br.com.livro.carros.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import br.com.livro.carros.rest.GsonMessageBodyHandler;
import junit.framework.TestCase;

public class UserInfoTest extends TestCase {

	private final String URL = "http://localhost:8080/carros/rest/userInfo";
	
	public void testUserInfoLogInUser() {
		Client client = getClient("user", "user");
		
		WebTarget target = client.target(URL);
		
		Response response = target.request().get();
		
		String result = response.readEntity(String.class);
		
		assertEquals("Você é um usuário: user", result);
	}
	
	public void testUserInfoLogInAdmin() {
		Client client = getClient("admin", "admin");
		
		WebTarget target = client.target(URL);
		
		String result = target.request().get(String.class);
		
		assertEquals("Você é um administrador: admin", result);
	}
	
	public void testUserInfoLogAcessoNegado() {
		Client client = getClient("xpto", "xpto");
		
		WebTarget target = client.target(URL);
		
		Response response = target.request().get();
		
		// Acesso Negado
		assertEquals(401, response.getStatus());
	}
	
	private Client getClient(String userName, String password) {
		// Cria o cliente da API
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		
		// Autentica o usuário admin
		client.register(HttpAuthenticationFeature.basic(userName, password));
		
		// Registra o parser com o Google-GSON
		client.register(GsonMessageBodyHandler.class);
		
		return client;
	}
}
