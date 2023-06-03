package com.shop.ecomshop;
import com.shop.ecomshop.controllers.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.shop.ecomshop")
public class EcomShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomShopApplication.class, args);
	}

}
