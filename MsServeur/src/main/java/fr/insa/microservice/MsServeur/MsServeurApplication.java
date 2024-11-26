package fr.insa.microservice.MsServeur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsServeurApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsServeurApplication.class, args);
	}

}
