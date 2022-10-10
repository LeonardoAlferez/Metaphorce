package com.lalferez.metaphorce;

import com.lalferez.metaphorce.modelo.entidades.Employees;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class MetaphorceApplication {

	public static void main(String[] args) {
		SpringApplication application =  new SpringApplication(MetaphorceApplication.class);
		application.setDefaultProperties(Collections.singletonMap("server.port", "8090"));
		application.run(args);


	}

}
