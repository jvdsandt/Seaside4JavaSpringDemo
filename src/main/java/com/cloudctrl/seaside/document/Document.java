package com.cloudctrl.seaside.document;

import org.unbescape.html.HtmlEscape;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class Document {

	 private Writer writer;
	 private HtmlRoot root;

	 public Document(Writer writer) {
	 	 super();
	 	 this.writer = writer;
	 }

	 public Document() {
	 	 this(new StringWriter());
	 }

	 public void openTag(String tag) {
		  openTag(tag, null, false);
	 }

	 public void openTag(String tag, HtmlAttributes attributes) {
		  openTag(tag, attributes, false);
	 }

	 public void openTag(String tag, HtmlAttributes attributes, boolean closed) {
	 	 try {
			  writer.append('<').append(tag);
			  if (attributes != null) {
					attributes.encodeOn(writer);
			  }
			  if (closed) {
					writer.append('/');
			  }
			  writer.append('>');
		 } catch (IOException ex) {
			  throw newWriteError(ex);
		 }
	 }

	 public void closeTag(String tag) {
		  try {
				writer.append("</").append(tag).append('>');
		  } catch (IOException ex) {
				throw newWriteError(ex);
		  }
	 }

	 public void text(String aString) {
		  try {
				HtmlEscape.escapeHtml5(aString, writer);
		  } catch (IOException ex) {
				throw newWriteError(ex);
		  }
	 }

	 public void text(Object aText) {
		  if (aText != null) {
		  	 text(aText.toString());
		  }
	 }

	 public void write(String markup) {
	 	 try {
			  writer.write(markup);
		 } catch (IOException ex) {
	 	 	 throw newWriteError(ex);
		 }
	 }

	 @Override
	 public String toString() {
	 	 return writer.toString();
	 }

	 public Writer getWriter() {
		  return writer;
	 }

	 public void open(HtmlRoot aRoot) {
	 	 root = aRoot;
	 	 root.openOn(this);
	 }

	 public void close() {
	 	 if (root != null) {
	 	 	 root.closeOn(this);
		 }
	 }

	 protected RuntimeException newWriteError(Exception ex) {
	 	 throw new RuntimeException("Write error", ex);
	 }
}
