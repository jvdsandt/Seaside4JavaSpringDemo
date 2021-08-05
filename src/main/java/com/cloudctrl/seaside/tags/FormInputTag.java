package com.cloudctrl.seaside.tags;

public abstract class FormInputTag<T extends FormInputTag<T>> extends TagBrush<T> {

	 @Override
	 public boolean isClosed() {
		 return true;
	 }

	 public T setType(String newValue) {
	 	 attributePut("type", newValue);
	 	 return self();
	 }
	 
	 public T setName(String name) {
		 if (name != null) {
			 attributePut("name", name);
		 }
		 return self();
	 }

	 public T setValue(Object newValue) {
		 if (newValue != null) {
			 attributePut("value", newValue);
		 }
	 	 return self();
	 }

	 public T setPlaceholder(String newValue) {
	 	 attributePut("placeholder", newValue);
		  return self();
	 }

}
