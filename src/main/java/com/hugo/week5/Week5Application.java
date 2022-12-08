package com.hugo.week5;

import com.hugo.week5.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week5Application {

	public static void main(String[] args) {
		SpringApplication.run(new Class[] { Week5Application.class, SecurityConfig.class }, args);
	}

}
