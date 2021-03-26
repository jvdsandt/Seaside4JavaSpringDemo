package com.cloudctrl.seaside.component;

import com.cloudctrl.seaside.canvas.HtmlCanvas;

@FunctionalInterface
public interface HtmlRenderable {

	 void renderContentOn(HtmlCanvas html);
}
