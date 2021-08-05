package com.cloudctrl.seaside.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class DemoModel {

	private List<Product> products;

	public DemoModel() {
		initProducts();
	}

	public List<Product> getProducts() {
		return products;
	}

	public Optional<Product> getProduct(int id) {
		return getProducts().stream()
				.filter(p -> p.getId() == id)
				.findAny();
	}

	private void initProducts() {
		products = new ArrayList<>();
		products.add(new Product("Chair", "Office chair", new BigDecimal("120.00"), 40));
		products.add(new Product("Desk", "Office desk - small", new BigDecimal("120.00"), 30));
		products.add(new Product("BigDesk", "Office desk - big", new BigDecimal("150.00"), 30));
	}

	public static class Product {
		
		private static int id_counter = 1000;

		private int id;
		private String name;
		private String description;

		private BigDecimal price;
		private int inStock;

		public Product(String name, String description, BigDecimal price, int inStock) {
			this.id = id_counter++;
			this.name = name;
			this.description = description;
			this.price = price;
			this.inStock = inStock;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public int getInStock() {
			return inStock;
		}
	}
}
