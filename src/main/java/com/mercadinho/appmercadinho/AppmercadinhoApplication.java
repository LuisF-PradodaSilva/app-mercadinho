package com.mercadinho.appmercadinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.mercadinho.domains", "com.mercadinho.domains,enums"})
@ComponentScan(basePackages = "com.mercadinho")
@EnableJpaRepositories(basePackages = "com.mercadinho.repositories")
@SpringBootApplication
public class AppmercadinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppmercadinhoApplication.class, args);
	}

}
