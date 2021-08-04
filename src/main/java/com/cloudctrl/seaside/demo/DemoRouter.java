package com.cloudctrl.seaside.demo;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

public class DemoRouter {

	public static UriComponents home() {
		return MvcUriComponentsBuilder.fromMethodCall(on(SeasideController.class).getHome())
				.build();
	}

	public static UriComponents products() {
		return MvcUriComponentsBuilder.fromMethodCall(on(SeasideController.class).getProducts())
				.build();
	}

	public static UriComponents product(String id) {
		return MvcUriComponentsBuilder.fromMethodCall(on(SeasideController.class).getProduct(id))
				.build();
	}

	public static UriComponents editProduct(DemoModel.Product product) {
		return MvcUriComponentsBuilder.fromMethodCall(on(SeasideController.class).editProduct(product.getName()))
				.build();
	}
}
