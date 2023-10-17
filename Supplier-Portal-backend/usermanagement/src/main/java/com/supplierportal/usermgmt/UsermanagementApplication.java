package com.supplierportal.usermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsermanagementApplication {

	@Bean
	public WebClient webCient() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(UsermanagementApplication.class, args);
	}

}
