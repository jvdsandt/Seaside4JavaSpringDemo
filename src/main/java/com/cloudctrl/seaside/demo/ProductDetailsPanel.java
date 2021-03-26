package com.cloudctrl.seaside.demo;

import com.cloudctrl.seaside.canvas.HtmlCanvas;
import com.cloudctrl.seaside.component.HtmlRenderable;

import java.util.List;

public class ProductDetailsPanel implements HtmlRenderable {

	 private DemoModel.Product product;

	 public ProductDetailsPanel(DemoModel.Product product) {
		  this.product = product;
	 }

	 @Override
	 public void renderContentOn(final HtmlCanvas html) {

		  html.div(() -> {
				html.paragraph(() -> {
					 html.text("Name: ").text(product.getName());
				});
				html.paragraph(() -> {
					 html.text("Description: ").text(product.getDescription());
				});
				html.paragraph(() -> {
					 html.text("Price: ").text(product.getPrice());
				});
				html.paragraph(() -> {
					 html.text("In stock: ").text(product.getInStock());
				});
		  });
	 }

}
