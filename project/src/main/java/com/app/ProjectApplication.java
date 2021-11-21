package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages ="com.app" ):def config :SC ny default searchesfor Spring Beans
//controller, rest controller, service n dao
//@EntityScan(basePackages = "com.app"): def config : Hibernate will search under com.app
//(curnt pkg)& its sub packages for Entity classes : packagesToScan
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
