package com.cloudctrl.seaside.demo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DemoModel {

	 private List<Product> products;

	 public DemoModel() {
	 	 initProducts();
	 }

	 public List<Product> getProducts() {
		  return products;
	 }

	 private void initProducts() {
	 	 products = new ArrayList<>();
	 	 products.add(new Product("Chair", "Office chair", new BigDecimal("120.00"), 40));
		  products.add(new Product("Desk", "Office desk - small", new BigDecimal("120.00"), 30));
		  products.add(new Product("BigDesk", "Office desk - big", new BigDecimal("150.00"), 30));
	 }

	 public static class Product {

	 	 private String name;
	 	 private String description;

	 	 private BigDecimal price;
	 	 private int inStock;

		  public Product(String name, String description, BigDecimal price, int inStock) {
				this.name = name;
				this.description = description;
				this.price = price;
				this.inStock = inStock;
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
