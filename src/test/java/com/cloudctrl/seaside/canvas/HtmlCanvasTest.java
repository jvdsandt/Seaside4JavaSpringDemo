package com.cloudctrl.seaside.canvas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HtmlCanvasTest {

	 @Test
	 public void testParagraph() {

		  var canvas = new HtmlCanvas();
		  canvas.paragraph("Pipo de Clown");
		  assertEquals("<p>Pipo de Clown</p>", canvas.getDocument().toString());

		  canvas = new HtmlCanvas();
		  canvas.paragraph("p1");
		  canvas.paragraph("p2");
		  assertEquals("<p>p1</p><p>p2</p>", canvas.getDocument().toString());
	 }

	 @Test
	 public void testBreak() {
		  var canvas = new HtmlCanvas();
		  canvas.text("Hello");
		  canvas.br();
		  canvas.text("World");
		  assertEquals("Hello<br/>World", canvas.getDocument().toString());
	 }

	 @Test
	 public void testDivWithParagraph() {
		  var canvas = new HtmlCanvas();
		  canvas.div(() -> {
				canvas.paragraph(() -> canvas.text("blah"));
		  });
		  assertEquals("<div><p>blah</p></div>", canvas.getDocument().toString());
	 }

	 @Test
	 public void testParagraphWithBlock() {
		  var canvas = new HtmlCanvas();
		  canvas.paragraph(() -> canvas.text("blah"));
		  assertEquals("<p>blah</p>", canvas.getDocument().toString());
	 }

	 @Test
	 public void testText() {
		  var canvas = new HtmlCanvas();
		  canvas.text("Hello world");
		  assertEquals("Hello world", canvas.getDocument().toString());
	 }

}
