package com.cloudctrl.seaside.bootstrap;

import com.cloudctrl.seaside.canvas.HtmlCanvas;
import com.cloudctrl.seaside.component.HtmlRenderable;

public class BootstrapFormControl implements HtmlRenderable {
	
	private String label;
	private String helpText;
	
	private Object value;
	
	public BootstrapFormControl() {
		super();
	}

	public BootstrapFormControl(String label) {
		this();
		this.label = label;
	}
	
	@Override
	public void renderContentOn(HtmlCanvas html) {

		html.div()
			.cssClass("mb-3")
			.with(() -> {
				if (label != null) {
					html.label()
						.setFor(html.nextId())
						.cssClass("form-label")
						.with(label);
				} else {
					html.nextId();
				}
				html.textInput()
					.setId(html.getLastId())
					.cssClass("form-control")
					.setValue(value);
				if (helpText != null) {
					html.div()
						.cssClass("form-text")
						.with(helpText);
				}
			});
	}

	public String getLabel() {
		return label;
	}

	public BootstrapFormControl setLabel(String label) {
		this.label = label;
		return this;
	}

	public String getHelpText() {
		return helpText;
	}

	public BootstrapFormControl setHelpText(String helpText) {
		this.helpText = helpText;
		return this;
	}

	public Object getValue() {
		return value;
	}

	public BootstrapFormControl setValue(Object value) {
		this.value = value;
		return this;
	}
	
	

}
