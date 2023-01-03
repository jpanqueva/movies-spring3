package com.moviesjjpanqueva.moviesjjpanqueva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.moviesjjpanqueva.moviesjjpanqueva"})
@EntityScan("com.moviesjjpanqueva.moviesjjpanqueva")
public class MoviesJjpanquevaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesJjpanquevaApplication.class, args);
	}

}
