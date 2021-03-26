package com.cloudctrl.seaside.document;

public class HtmlMetaElement extends HtmlElement {

	 public HtmlMetaElement(HtmlRoot root) {
		  super(root);
	 }

	 public String tag() {
		  return "meta";
	 }

	 public HtmlMetaElement setName(String aName) {
	 	 attributePut("name", aName);
	 	 return this;
	 }

	 public HtmlMetaElement setContent(String aValue) {
	 	 attributePut("content", aValue);
	 	 return this;
	 }

}
