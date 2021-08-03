package com.cloudctrl.seaside.demo;

import java.util.List;

import com.cloudctrl.seaside.bootstrap.BootstrapNavbar;
import com.cloudctrl.seaside.bootstrap.MenuItem;
import com.cloudctrl.seaside.canvas.HtmlCanvas;
import com.cloudctrl.seaside.component.HtmlRenderable;
import com.cloudctrl.seaside.document.HtmlRoot;

public class DemoPage implements HtmlRenderable {

	private BootstrapNavbar navbar;
	private HtmlRenderable mainPanel;

	public DemoPage(HtmlRenderable mainPanel) {
		super();
		this.navbar = new BootstrapNavbar();
		this.navbar.setBrandName("Seaside");
		this.navbar.setMenuItems(List.of(
				new MenuItem("Products"),
				new MenuItem("Second"),
				new MenuItem("Third")
		));
		this.mainPanel = mainPanel;
	}

	@Override
	public void renderContentOn(HtmlCanvas html) {

		html.render(navbar);

		html.div().cssClass("container").with(() -> {
			html.div().cssClass("row").with(() -> {
				html.div().cssClass("col-sm").with(() -> {
					html.text("col-1");
				});
				html.div().cssClass("col-sm").with(() -> {
					html.render(mainPanel);
				});
				html.div().cssClass("col-sm").with(() -> {
					html.text("col-3");
				});
			});
		});

		html.script()
				.setUrl("https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js")
				.setIntegrity("sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM")
				.beAnonymous();
	}

	@Override
	public void updateRoot(HtmlRoot root) {
		root.setLang("en");
		root.meta().chatSet("utf-8");
		root.meta().setName("viewport").setContent("width=device-width, initial-scale=1");

		root.stylesheet()
				.setUrl("https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css")
				.setIntegrity("sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC")
				.beAnonymous();
	}

}
