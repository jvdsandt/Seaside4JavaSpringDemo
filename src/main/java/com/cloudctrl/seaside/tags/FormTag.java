package com.cloudctrl.seaside.tags;

import com.cloudctrl.seaside.canvas.Canvas;

public class FormTag extends TagBrush<FormTag> {

	@Override
	public void setParent(TagBrush parent, Canvas canvas) {
		super.setParent(parent, canvas);
		bePost();
	}

	@Override
	public String getTag() {
		return "form";
	}
	
	public FormTag setAction(String action) {
		getAttributes().put("action", action);
		return this;
	}

	public FormTag setMethod(String method) {
		getAttributes().put("method", method);
		return this;
	}

	public FormTag beGet() {
		return setMethod("get");
	}

	public FormTag bePost() {
		return setMethod("post");
	}
}
