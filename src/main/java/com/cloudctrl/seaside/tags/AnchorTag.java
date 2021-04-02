package com.cloudctrl.seaside.tags;

public class AnchorTag extends TagBrush<AnchorTag> {

	 @Override
	 public String getTag() {
		  return "a";
	 }

	 public AnchorTag setHref(String href) {
	 	 getAttributes().put("href", href);
	 	 return this;
	 }

	 public AnchorTag setTargetBlank() {
		  return setTarget("_blank");
	 }

	 public AnchorTag setTarget(String aTarget) {
	 	 getAttributes().put("target", aTarget);
	 	 return this;
	 }
}
