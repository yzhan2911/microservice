package fr.insa.microservice.serverConfig.ConfigClientMSPersonne.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class clientConfigRessource {
	@Value("${server.port}")
	private String serverPort;
	@Value("${db.connection}")
	private String connection;
	@Value("${db.username}")
	private String username;
	@GetMapping("/information")
	public String getAll() {
		return "serverPort:"+serverPort+"\n"+"connection :"+connection+"\n"+"dbusername:"+"dbusername"+"\n";
	}
}
