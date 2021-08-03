package com.cloudctrl.seaside.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication
public class DemoApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApp.class, args);
	}

	@Bean
	public HttpMessageConverters customConverters() {
		return new HttpMessageConverters(false, List.of(new SeasideResponseConverter()));
	}
}
