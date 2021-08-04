package com.cloudctrl.seaside.demo;

import com.cloudctrl.seaside.canvas.HtmlCanvas;
import com.cloudctrl.seaside.component.HtmlRenderable;

import java.util.List;

public class ProductListPanel implements HtmlRenderable {

	private List<DemoModel.Product> products;

	public ProductListPanel(List<DemoModel.Product> products) {
		this.products = products;
	}

	@Override
	public void renderContentOn(HtmlCanvas html) {

		html.heading().setLevel(3).with("Product list");
		html.table(() -> {
			html.tableBody(() -> {
				for (DemoModel.Product p : products) {
					renderProduct(p, html);
				}
			});
		});
	}

	private void renderProduct(DemoModel.Product p, HtmlCanvas html) {
		html.tableRow(() -> {
			html.tableData(p.getName());
			html.tableData(p.getPrice());
			html.tableData(() -> {
				html.anchor().setHref(DemoRouter.product(p.getName()).getPath()).with("Details");
			});
		});
	}
}
