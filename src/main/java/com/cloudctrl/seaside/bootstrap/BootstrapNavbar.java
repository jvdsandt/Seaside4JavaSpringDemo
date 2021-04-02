package com.cloudctrl.seaside.bootstrap;

import com.cloudctrl.seaside.canvas.HtmlCanvas;
import com.cloudctrl.seaside.component.HtmlRenderable;

import java.util.List;

public class BootstrapNavbar implements HtmlRenderable {

	 private String brandName = "Nav";

	 private List<BaseMenuItem> menuItems;

	 @Override
	 public void renderContentOn(HtmlCanvas html) {

	 	 html.tag("nav")
					.cssClass("navbar navbar-expand-lg navbar-light bg-light")
					.with(() -> {
						 html.div().cssClass("container-fluid").with(() -> {
						 	 renderBrand(html);
						 	 renderToggler(html);
						 });
					});
	 }

	 private void renderBrand(HtmlCanvas html) {
		  html.anchor()
					 .cssClass("navbar-brand")
					 .setHref("#")
					 .with(brandName);
	 }

	 private void renderToggler(HtmlCanvas html) {
		  html.button().cssClass("navbar-toggler").with(() -> {
				html.span().cssClass("navbar-toggler-icon").with("");
		  });
	 }

	 private void renderMenu(HtmlCanvas html) {
	 	 html.unorderedList()
					.cssClass("navbar-nav me-auto mb-2 mb-lg-0")
					.with(() -> {
						 menuItems.forEach(mi -> renderUsing(this, html));
					});
	 }
}
