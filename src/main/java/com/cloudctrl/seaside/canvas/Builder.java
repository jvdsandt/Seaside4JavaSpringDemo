package com.cloudctrl.seaside.canvas;

import com.cloudctrl.seaside.component.HtmlRenderable;
import com.cloudctrl.seaside.document.Document;
import com.cloudctrl.seaside.document.HtmlRoot;

import java.io.StringWriter;
import java.io.Writer;
import java.util.function.Consumer;

public class Builder {

	 private boolean fullDocument;
	 private Consumer<HtmlRoot> rootBlock;

	 public String render(HtmlRenderable anObject) {
		  StringWriter writer = new StringWriter(512);
		  render(anObject, writer);
		  return writer.toString();
	 }

	 public void render(HtmlRenderable anObject, Writer writer) {
		  Document doc = new Document(writer);
		  HtmlCanvas renderer = new HtmlCanvas(doc);
		  openDocument(doc);
		  renderer.render(anObject);
		  renderer.flush();
		  closeDocument(doc);
	 }

	 public Builder setFullDocument(boolean fullDocument) {
		  this.fullDocument = fullDocument;
		  return this;
	 }

	 public Builder setRootBlock(Consumer<HtmlRoot> rootBlock) {
		  this.rootBlock = rootBlock;
		  return this;
	 }

	 void openDocument(Document doc) {
		  if (!fullDocument) {
				return;
		  }
		  HtmlRoot docRoot = new HtmlRoot();
		  if (rootBlock != null) {
				rootBlock.accept(docRoot);
		  }
		  doc.open(docRoot);
	 }

	 void closeDocument(Document doc) {
		  doc.close();
	 }
}
