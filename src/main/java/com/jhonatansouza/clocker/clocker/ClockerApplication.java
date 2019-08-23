package com.jhonatansouza.clocker.clocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ClockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClockerApplication.class, args);
	}

}
