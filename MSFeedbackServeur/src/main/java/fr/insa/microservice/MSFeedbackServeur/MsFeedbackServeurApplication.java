package fr.insa.microservice.MSFeedbackServeur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class MsFeedbackServeurApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFeedbackServeurApplication.class, args);
	}

}
