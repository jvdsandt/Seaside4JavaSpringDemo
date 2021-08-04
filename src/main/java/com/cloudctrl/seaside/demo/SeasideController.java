package com.cloudctrl.seaside.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeasideController {

	@Autowired
	private DemoModel model;

	@GetMapping("/")
	public DemoPage getHome() {
		return new DemoPage(null);
	}

	@GetMapping("/products")
	public DemoPage getProducts() {
		return new DemoPage(new ProductListPanel(model.getProducts()));
	}

	@GetMapping("/product/{id}")
	public DemoPage getProduct(@PathVariable String id) {
		var product = model.getProduct(id);
		if (product.isEmpty()) {
			return null;
		}
		return new DemoPage(new ProductDetailsPanel(product.get()));
	}

	@GetMapping("/product/{id}/edit")
	public DemoPage editProduct(@PathVariable String id) {
		var product = model.getProduct(id);
		if (product.isEmpty()) {
			return null;
		}
		return new DemoPage(new ProductEditPanel(product.get()));
	}
}