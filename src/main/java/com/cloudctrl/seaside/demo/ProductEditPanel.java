package com.cloudctrl.seaside.demo;

import com.cloudctrl.seaside.bootstrap.BootstrapFormControl;
import com.cloudctrl.seaside.canvas.HtmlCanvas;
import com.cloudctrl.seaside.component.HtmlRenderable;

public class ProductEditPanel implements HtmlRenderable {

	private DemoModel.Product product;

	public ProductEditPanel(DemoModel.Product product) {
		this.product = product;
	}

	@Override
	public void renderContentOn(HtmlCanvas html) {

		html.heading().setLevel(3).with("Edit product " + product.getName());
		html.form(() -> {
			html.render(new BootstrapFormControl("Name:")
					.setValue(product.getName())
					.setHelpText("Enter a valid and descriptive name for this product"));
			html.render(new BootstrapFormControl("Description:").setValue(product.getDescription()));
		});
	}

}
