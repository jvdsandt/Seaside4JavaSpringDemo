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
		html.form()
			.setAction(DemoRouter.saveProduct().getPath())
			.with(() -> {
				html.render(new BootstrapFormControl("Name:")
						.setName("name")
						.setValue(product.getName())
						.setHelpText("Enter a valid and descriptive name for this product"));
				html.render(new BootstrapFormControl("Description:")
						.setName("description")
						.setValue(product.getDescription()));
				
				html.button().cssClass("btn btn-primary").with("Submit");
				html.space();
				html.anchor()
					.cssClass("btn btn-secondary")
					.setHref(DemoRouter.product(product.getId()).getPath())
					.with("Cancel");
			});
	}

}
