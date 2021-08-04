package com.cloudctrl.seaside.bootstrap;

import com.cloudctrl.seaside.canvas.HtmlCanvas;

public abstract class BaseMenuItem {

	 private String label;
	 private String href;
	 private boolean disabled;
	 private boolean active;

	 public abstract void renderUsing(BootstrapNavbar navbar, HtmlCanvas html);

	 public String getLabel() {
		  return label;
	 }

	 public BaseMenuItem setLabel(String label) {
		  this.label = label;
		  return this;
	 }

	 public String getHref() {
		return href;
	}

	public BaseMenuItem setHref(String href) {
		this.href = href;
		return this;
	}

	public boolean isDisabled() {
		  return disabled;
	 }

	 public BaseMenuItem setDisabled(boolean disabled) {
		  this.disabled = disabled;
		  return this;
	 }

	 public boolean isActive() {
		  return active;
	 }

	 public BaseMenuItem setActive(boolean active) {
		  this.active = active;
		  return this;
	 }
}
