package com.metaphorce.shopall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
@ComponentScan(basePackages = "com.metaphorce.shopall")
public class ShopallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopallApplication.class, args);
	}

}
