package com.cdzci.zic_yt_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ZicYtTestApplication extends SpringBootServletInitializer{
//public class ZicYtTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZicYtTestApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ZicYtTestApplication.class);
	}
}
