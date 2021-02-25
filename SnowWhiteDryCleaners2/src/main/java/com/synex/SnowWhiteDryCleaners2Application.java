package com.synex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SnowWhiteDryCleaners2Application {

	public static void main(String[] args) {
		SpringApplication.run(SnowWhiteDryCleaners2Application.class, args);
	}
	
//	public class ServletInitializer extends SpringBootServletInitializer {
//
//	    @Override
//	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//	        return application.sources(SnowWhiteDryCleaners2Application.class);
//	    }
//
//	}

}
