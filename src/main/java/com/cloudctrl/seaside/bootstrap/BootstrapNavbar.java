package com.cloudctrl.seaside.bootstrap;

import com.cloudctrl.seaside.canvas.HtmlCanvas;
import com.cloudctrl.seaside.component.HtmlRenderable;

import java.util.List;

public class BootstrapNavbar implements HtmlRenderable {

	 private String brandName = "Nav";
	 private String brandHref = "/";

	 private String searchPlaceholder = "Search";

	 private List<BaseMenuItem> menuItems;

	 @Override
	 public void renderContentOn(HtmlCanvas html) {

	 	 html.tag("nav")
					.cssClass("navbar navbar-expand-lg navbar-light bg-light")
					.with(() -> {
						 html.div().cssClass("container-fluid").with(() -> {
						 	 renderBrand(html);
						 	 html.div().cssClass("collapse navbar-collapse").with(() -> {
									renderMenu(html);
									renderSearchForm(html);
							 });
						 });
					});
	 }

	 private void renderBrand(HtmlCanvas html) {
		  html.anchor()
					 .cssClass("navbar-brand")
					 .setHref(brandHref)
					 .with(brandName);
	 }

	 private void renderMenu(HtmlCanvas html) {
	 	 html.unorderedList()
					.cssClass("navbar-nav me-auto mb-2 mb-lg-0")
					.with(() -> {
						 menuItems.forEach(mi -> mi.renderUsing(this, html));
					});
	 }

	 public void renderMenuItem(MenuItem item, HtmlCanvas html) {
	 	 html.listItem()
					.cssClass("nav-item")
					.with(() -> {
						 html.anchor()
									.setHref(item.getHref())
									.cssClass("nav-link")
									.cssClass("active", item.isActive())
									.cssClass("disabled", item.isDisabled())
									.attributePutIf("tabindex", -1, item.isDisabled())
									.attributePutIf("aria-disabled", true, item.isDisabled())
									.with(item.getLabel());
					});
	 }

	 private void renderSearchForm(HtmlCanvas html) {
	 	 html.form().cssClass("d-flex").with(() -> {
	 	 	 html.textInput()
						.cssClass("form-control me-2")
						.setType("search")
						.setPlaceholder(searchPlaceholder)
						.attributePut("aria-label", "Search");
	 	 	 html.button()
						.cssClass("btn btn-outline-success")
						.with("Search");
		 });
	 }

	 public String getBrandName() {
		  return brandName;
	 }

	 public BootstrapNavbar setBrandName(String brandName) {
		  this.brandName = brandName;
		  return this;
	 }

	 public BootstrapNavbar setBrandHref(String brandHref) {
		this.brandHref = brandHref;
		return this;
	}

	public String getSearchPlaceholder() {
		  return searchPlaceholder;
	 }

	 public BootstrapNavbar setSearchPlaceholder(String searchPlaceholder) {
		  this.searchPlaceholder = searchPlaceholder;
		  return this;
	 }

	 public List<BaseMenuItem> getMenuItems() {
		  return menuItems;
	 }

	 public BootstrapNavbar setMenuItems(List<BaseMenuItem> menuItems) {
		  this.menuItems = menuItems;
		  return this;
	 }
}
