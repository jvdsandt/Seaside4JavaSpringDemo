package com.cloudctrl.seaside.tags;

public class LabelTag extends TagBrush<LabelTag> {

	@Override
	public String getTag() {
		return "label";
	}
	
	public LabelTag setFor(String id) {
		getAttributes().put("for", id);
		return this;
	}

}
