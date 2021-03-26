package com.cloudctrl.seaside.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@SpringBootApplication
public class DemoApp {

	 public static void main(String[] args) throws Exception {
		  SpringApplication.run(DemoApp.class, args);
	 }

}
