package com.cloudctrl.seaside.tags;

public class GenericTag extends TagBrush {

	 private final String tag;

	 public GenericTag(String tag) {
		 super();
	 	 this.tag = tag;
	 }

	 public String tag() {
	 	 return tag;
	 }

	 @Override
	 public String getTag() {
		  return tag;
	 }
}
