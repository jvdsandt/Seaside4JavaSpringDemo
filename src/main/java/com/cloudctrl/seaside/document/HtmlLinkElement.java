package com.cloudctrl.seaside.document;

import javax.swing.text.html.HTMLDocument;

public class HtmlLinkElement extends HtmlElement {

	 public HtmlLinkElement(HtmlRoot root) {
		  super(root);
	 }

	 @Override
	 public String tag() {
		  return "link";
	 }

	 public HtmlLinkElement setRelationship(String aValue) {
	 	 attributePut("rel", aValue);
	 	 return this;
	 }

	 public HtmlLinkElement beAnonymous() {
		  attributePut("crossorigin", "anonymous");
		  return this;
	 }

	 public HtmlLinkElement beCss() {
	 	 setType("text/css");
	 	 return this;
	 }

	 public HtmlLinkElement beStylesheet() {
		  return setRelationship("stylesheet");
	 }

	 public HtmlLinkElement setIntegrity(String hash) {
	 	 attributePut("integrity", hash);
	 	 return this;
	 }

	 public HtmlLinkElement setUrl(String anUrl) {
	 	 attributePut("href", anUrl);
	 	 return this;
	 }

}
