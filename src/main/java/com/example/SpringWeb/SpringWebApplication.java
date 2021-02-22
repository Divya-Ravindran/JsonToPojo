package com.example.SpringWeb;

import com.example.SpringWeb.repository.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;

@SpringBootApplication
public class SpringWebApplication{


	public static void main(String[] args) {

		SpringApplication.run(SpringWebApplication.class, args);
	}
	/**
	@Override
	public void run(String[] args) throws IOException {
		String text="";
		try{
			File resource = ResourceUtils.getFile("classpath:customer.json");
			text = new String(Files.readAllBytes(resource.toPath()));



		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		//read json file and convert to customer object
		Customer cust = objectMapper.readValue(resource, Customer.class);

		//print customer details
		System.out.println(cust.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	*/
}
