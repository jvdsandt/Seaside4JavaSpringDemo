package com.cloudctrl.seaside.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeasideController {

	@Autowired
	private DemoModel model;

	@GetMapping("/")
	public DemoPage getHome() throws IOException {
		return new DemoPage(null);
	}

	@GetMapping("/products")
	public DemoPage getProducts() throws IOException {
		return new DemoPage(new ProductListPanel(model.getProducts()));
	}

	@GetMapping("/product/{id}")
	public DemoPage getProduct(@PathVariable String id) throws IOException {
		var product = model.getProduct(id);
		if (product.isEmpty()) {
			return null;
		}
		return new DemoPage(new ProductDetailsPanel(product.get()));
	}
}