package fr.insa.microservice.serverConfig.ConfigClientMSPersonne.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class clientConfigRessource {
	@Value("${server.port}")
	private String serverPort;
	@Value("${db.connection}")
	private String typeConnectionDeDB;
	@Value("${db.host}")
	private String dbHost;
	@Value("${db.port}")
	private String dbPort;
	@GetMapping("/information")
	public String getAll() {
		return "serverPort:"+serverPort+"\n"+"typeConnectionDeDB :"+typeConnectionDeDB+"\n"+"dbHost:"+"dbHost"+"\n"+"dbPort:"+dbPort;
	}
}
