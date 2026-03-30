package com.labourmanagement.labourmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.labourmanagement")
public class LabourmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabourmanagementApplication.class, args);
		
		 System.out.println("Labour Management Application Started Successfully!");
	}

}
