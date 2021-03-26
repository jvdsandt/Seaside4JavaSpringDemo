package com.cloudctrl.seaside.canvas;

import com.cloudctrl.seaside.document.Document;
import com.cloudctrl.seaside.tags.TagBrush;

public class Canvas {

	 private final Document document;

	 private TagBrush currentBrush;
	 private TagBrush parentBrush;

	 public Canvas(Document document) {
	 	 super();
		  this.document = document;
	 }

	 public void nest(Runnable action) {
	 	 parentBrush = currentBrush;
	 	 currentBrush = null;
	 	 action.run();
	 	 parentBrush = parentBrush.getParent();
	 }

	 public Canvas text(Object aText) {
	 	 flush();
	 	 getDocument().text(aText);
	 	 return this;
	 }

	 public Document getDocument() {
	 	 return document;
	 }

	 protected void flush() {
	 	 if (currentBrush == null) {
	 	 	 return;
		 }
	 	 currentBrush.close();
	 	 currentBrush = null;
	 }

	 protected void setBrush(TagBrush aBrush) {
	 	 flush();
		  currentBrush = aBrush;
		  aBrush.setParent(parentBrush, this);
	 }

}
