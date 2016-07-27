package com.iot.jpa.boot;

import javax.ws.rs.ApplicationPath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages = { "com.iot.jpa.entity" })
@EnableJpaRepositories(basePackages = { "com.iot.jpa.rest" })
@EnableWebMvc
@ComponentScan(basePackages="com.iot.jpa.rest")
@ApplicationPath("com.iot.jpa.rest")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
