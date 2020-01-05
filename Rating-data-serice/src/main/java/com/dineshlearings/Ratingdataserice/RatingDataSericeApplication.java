package com.dineshlearings.Ratingdataserice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingDataSericeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingDataSericeApplication.class, args);
	}

}
