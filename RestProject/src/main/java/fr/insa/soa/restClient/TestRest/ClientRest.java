package fr.insa.soa.restClient.TestRest;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;

public class ClientRest {
	public static void main (String []args) {
		Client client=ClientBuilder.newClient();
		Response reponse=client.target("http://localhost:8080/RestProject/webapi/mission").request().get();
		System.out.println(reponse.readEntity(String.class));
		}
}
