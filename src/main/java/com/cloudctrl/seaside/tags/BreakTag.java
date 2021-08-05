package com.cloudctrl.seaside.tags;

import com.cloudctrl.seaside.canvas.Canvas;

public class BreakTag extends TagBrush<BreakTag> {

	 public BreakTag() {
	 	 super();
	 }

	 @Override
	 public void setParent(TagBrush parent, Canvas canvas) {
		  super.setParent(parent, canvas);
		  with(null);
	 }

	 @Override
	 public String getTag() {
		  return "br";
	 }
	 
	 @Override
	 public boolean isClosed() {
		 return true;
	 }
}
