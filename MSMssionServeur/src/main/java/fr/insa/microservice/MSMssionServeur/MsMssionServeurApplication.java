package fr.insa.microservice.MSMssionServeur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class MsMssionServeurApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMssionServeurApplication.class, args);
	}

}
