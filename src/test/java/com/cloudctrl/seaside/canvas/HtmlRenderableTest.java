package com.cloudctrl.seaside.canvas;

import com.cloudctrl.seaside.component.HtmlRenderable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HtmlRenderableTest {

	 @Test
	 public void test() {
		  HtmlCanvas canvas = HtmlCanvas.build();
		  HtmlRenderable c = html -> html.paragraph("Hello");
		  canvas.render(c);
		  assertEquals("<p>Hello</p>", canvas.getDocument().toString());
	 }

	 @Test
	 public void testBuilder() {
		  Builder b = HtmlCanvas.builder();
		  HtmlRenderable c = html -> html.paragraph("Hello");
		  assertEquals("<p>Hello</p>", b.render(c));
	 }
}
