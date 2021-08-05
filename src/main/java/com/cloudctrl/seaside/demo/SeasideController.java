package com.cloudctrl.seaside.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

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
	public DemoPage getProduct(@PathVariable int id) {
		var product = model.getProduct(id);
		if (product.isEmpty()) {
			return null;
		}
		return new DemoPage(new ProductDetailsPanel(product.get()));
	}

	@GetMapping("/product/{id}/edit")
	public DemoPage editProduct(@PathVariable int id) {
		var product = model.getProduct(id);
		if (product.isEmpty()) {
			return null;
		}
		return new DemoPage(new ProductEditPanel(product.get()));
	}
	
	@PostMapping(path = "/saveProduct", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public RedirectView saveProduct(@RequestParam MultiValueMap<String,String> paramMap) {

		return new RedirectView(DemoRouter.products().getPath(), true);
	}
	
}