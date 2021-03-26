package com.cloudctrl.seaside.tags;

public class HeadingTag extends TagBrush {

	 private int level = 1;

	 @Override
	 public String getTag() {
	 	 return "h" + level;
	 }

	 public HeadingTag setLevel(int newLevel) {
	 	 this.level = newLevel;
	 	 return this;
	 }
}
