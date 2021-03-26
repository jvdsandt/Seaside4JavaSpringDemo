package com.cloudctrl.seaside.canvas;

import com.cloudctrl.seaside.component.HtmlRenderable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderTest {

	 @Test
	 public void testDefault() {
		  Builder b = HtmlCanvas.builder();
		  HtmlRenderable c = html -> html.paragraph("Hello");
		  assertEquals("<p>Hello</p>", b.render(c));
	 }

	 @Test
	 public void testMinimal() {
		  Builder b = HtmlCanvas.builder();
		  HtmlRenderable c = html -> html.text("Hello");
		  assertEquals("Hello", b.render(c));
	 }

	 @Test
	 public void testFullDocument() {
		  Builder b = HtmlCanvas.builder()
					 .setFullDocument(true)
					 .setRootBlock(root -> root.setTitle("Hello"));
		  HtmlRenderable c = html -> html.paragraph("Hello");
		  String expected = "<!DOCTYPE html><html><head><title>Hello</title></head><body><p>Hello</p></body></html>";
		  assertEquals(expected, b.render(c));
	 }
}
