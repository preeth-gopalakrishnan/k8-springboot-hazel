package com.example.k8springboothazel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class K8SpringbootHazelApplication {

	public static void main(String[] args) {
		SpringApplication.run(K8SpringbootHazelApplication.class, args);
	}

}
