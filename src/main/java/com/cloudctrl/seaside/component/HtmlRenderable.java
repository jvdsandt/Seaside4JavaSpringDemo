package com.cloudctrl.seaside.component;

import com.cloudctrl.seaside.canvas.HtmlCanvas;
import com.cloudctrl.seaside.document.HtmlRoot;

@FunctionalInterface
public interface HtmlRenderable {

	 void renderContentOn(HtmlCanvas html);

	 default void updateRoot(HtmlRoot root) {

	 }
}
