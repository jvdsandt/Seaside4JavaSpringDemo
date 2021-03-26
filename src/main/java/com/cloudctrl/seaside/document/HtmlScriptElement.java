package com.cloudctrl.seaside.document;

public class HtmlScriptElement extends HtmlElement {

	 public HtmlScriptElement(HtmlRoot root) {
		  super(root);
	 }

	 public HtmlScriptElement beJavascript() {
	 	 setType("text/javascript");
	 	 return this;
	 }

	 public HtmlScriptElement setUrl(String anUrl) {
	 	 attributePut("src", anUrl);
	 	 return this;
	 }

	 public String tag() {
	 	 return "script";
	 }
}
