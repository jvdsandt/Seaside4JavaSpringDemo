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
		  TagBrush tag = canvas.paragraph();
		  assertFalse(tag.isClosed());
		  tag.cssClass("strong");
		  tag.with("some text");
		  assertTrue(tag.isClosed());
		  assertEquals("<p class=\"strong\">some text</p>", canvas.getDocument().toString());
	 }
}
