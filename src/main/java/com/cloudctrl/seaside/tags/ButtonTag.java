package com.cloudctrl.seaside.tags;

public class ButtonTag extends TagBrush<ButtonTag> {

	 public ButtonTag() {
	 	 super();
	 	 beSumbit();
	 }

	 @Override
	 public String getTag() {
		  return "button";
	 }

	 public ButtonTag beSumbit() {
	 	 attributePut("type", "submit");
	 	 return this;
	 }

	 public ButtonTag bePush() {
		  attributePut("type", "button");
		  return this;
	 }
}
