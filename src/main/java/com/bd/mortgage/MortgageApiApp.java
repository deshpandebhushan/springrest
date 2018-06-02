package com.bd.mortgage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 
 * @author bhushan
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
public class MortgageApiApp {

	public static void main(String[] args) {
		
		SpringApplication.run(MortgageApiApp.class, args);

	}

}
