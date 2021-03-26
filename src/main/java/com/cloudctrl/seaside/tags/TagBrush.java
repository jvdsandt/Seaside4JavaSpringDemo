package com.cloudctrl.seaside.tags;

import com.cloudctrl.seaside.canvas.Canvas;
import com.cloudctrl.seaside.document.Document;
import com.cloudctrl.seaside.document.HtmlAttributes;

public abstract class TagBrush {

	 private Canvas canvas;
	 private TagBrush parent;
	 private boolean closed = false;
	 private HtmlAttributes attributes;

	 public void setParent(TagBrush parent, Canvas canvas) {
	 	 this.parent = parent;
	 	 this.canvas = canvas;
	 }

	 public void close() {
	 	 if (!closed) {
	 	 	 with(null);
		 }
	 }

	 public void with(Object anObject) {
	 	 openTag();
	 	 if (anObject instanceof Runnable) {
	 	 	 canvas.nest((Runnable) anObject);
		 } else if (anObject != null) {
	 	 	 getDocument().text(anObject.toString());
		 }
	 	 if (!closed) {
			  closeTag();
			  closed = true;
		 }
	 }

	 protected Document getDocument() {
	 	 return canvas.getDocument();
	 }

	 private void openTag() {
		getDocument().openTag(getTag(), attributes, closed);
	 }

	 private void closeTag() {
		getDocument().closeTag(getTag());
	 }

	 public boolean isClosed() {
	 	 return closed;
	 }

	 protected void setClosed(boolean b) {
	 	 this.closed = b;
	 }

	 public abstract String getTag();

	 public HtmlAttributes getAttributes() {
	 	 if (attributes == null) {
	 	 	 attributes = new HtmlAttributes();
		 }
	 	 return attributes;
	 }

	 public Canvas getCanvas() {
		  return canvas;
	 }

	 public TagBrush getParent() {
		  return parent;
	 }

	 public void cssClass(String aString) {
		getAttributes().addClass(aString);
	 }

	 public void style(String aString) {
		  getAttributes().addStyle(aString);
	 }
}
