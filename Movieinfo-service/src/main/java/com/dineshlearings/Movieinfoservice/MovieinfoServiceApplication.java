package com.dineshlearings.Movieinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieinfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieinfoServiceApplication.class, args);
	}

}
