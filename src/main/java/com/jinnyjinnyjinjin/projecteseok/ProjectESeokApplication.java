package com.jinnyjinnyjinjin.projecteseok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class ProjectESeokApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectESeokApplication.class, args);
	}

}
