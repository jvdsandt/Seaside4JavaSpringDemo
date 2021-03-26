package com.cloudctrl.seaside.document;

public abstract class HtmlElement {

	 private final HtmlRoot root;
	 private final HtmlAttributes attribs;

	 public HtmlElement(HtmlRoot root) {
		  this.root = root;
		  this.attribs = new HtmlAttributes();
	 }

	 public abstract String tag();

	 public void attributePut(String name, String value) {
	 	 attribs.put(name, value);
	 }

	 public void setType(String aMimeType) {
	 	 attributePut("type", aMimeType);
	 }

	 public void chatSet(String aCharSet) {
		  attributePut("charset", aCharSet);
	 }

	 public boolean isClosed() {
	 	 return true;
	 }

	 void encodeOn(Document doc) {
		  doc.openTag(tag(), attribs, isClosed());
		  if (!isClosed()) {
		  	 doc.closeTag(tag());
		  }
	 }
}
