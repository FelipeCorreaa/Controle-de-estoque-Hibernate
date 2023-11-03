package com.felipe.controllstock.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipe.controllstock.entities.Product;
import com.felipe.controllstock.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private ProductRepository productRepository;
	
	
	
	



	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product (null,"Paystation",50.1,12);
		Product p2 = new Product (null,"Controle",29.1,2);
		productRepository.saveAll(Arrays.asList(p1,p2));
		
	}
	

}
