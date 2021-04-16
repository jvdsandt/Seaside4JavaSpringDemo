package com.cloudctrl.seaside.tags;

public class TextInputTag extends FormInputTag<TextInputTag> {

	 public TextInputTag() {
	 	 super();
	 	 setType("text");
	 }

	 @Override
	 public String getTag() {
		  return "input";
	 }
}
