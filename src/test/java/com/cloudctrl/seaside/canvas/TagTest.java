package com.cloudctrl.seaside.canvas;

import com.cloudctrl.seaside.tags.TagBrush;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TagTest {

	 @Test
	 public void testBreak() {
	 	 HtmlCanvas canvas = HtmlCanvas.build();
	 	 var tag = canvas.br();
	 	 assertTrue(tag.isClosed());
	 	 assertEquals("<br/>", canvas.getDocument().toString());
	 }

	 @Test
	 public void testParagraph() {
		  HtmlCanvas canvas = HtmlCanvas.build();
		  var tag = canvas.paragraph();
		  tag.cssClass("strong");
		  tag.with("some text");
		  assertEquals("<p class=\"strong\">some text</p>", canvas.getDocument().toString());
	 }
	 
	 @Test
	 public void testInput() {
		  HtmlCanvas canvas = HtmlCanvas.build();
		  canvas.div(() -> {
			 canvas.textInput().setId("id-1"); 
		  });
		  assertEquals("<div><input type=\"text\" id=\"id-1\"/></div>", canvas.getDocument().toString());
	 }
	 
}
