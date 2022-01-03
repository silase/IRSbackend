package com.example.ivd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan({"com.example.ivd"})
public class IvdApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(IvdApplication.class, args);
	}

}
