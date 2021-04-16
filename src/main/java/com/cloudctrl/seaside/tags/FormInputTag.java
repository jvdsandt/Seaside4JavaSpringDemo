package com.cloudctrl.seaside.tags;

public abstract class FormInputTag<T extends FormInputTag<T>> extends TagBrush<T> {

	 public T setType(String newValue) {
	 	 attributePut("type", newValue);
	 	 return self();
	 }

	 public T setPlaceholder(String newValue) {
	 	 attributePut("placeholder", newValue);
		  return self();
	 }

}
