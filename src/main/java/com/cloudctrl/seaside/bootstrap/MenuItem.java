package com.cloudctrl.seaside.bootstrap;

import com.cloudctrl.seaside.canvas.HtmlCanvas;

public class MenuItem extends BaseMenuItem {

	 public MenuItem(String label) {
	 	 super();
	 	 setLabel(label);
	 }

	 public void renderUsing(BootstrapNavbar navbar, HtmlCanvas html) {
	 	 navbar.renderMenuItem(this, html);
	 }
}
