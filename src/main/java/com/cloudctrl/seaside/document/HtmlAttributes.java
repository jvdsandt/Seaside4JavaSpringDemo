package com.cloudctrl.seaside.document;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class HtmlAttributes {

	 private Map<String, Object> attribs = new LinkedHashMap<>();

	 public void encodeOn(Writer writer) throws IOException {
	 	 for (var entry : attribs.entrySet()) {
	 	 	 writer.append(' ')
						.append(entry.getKey())
						.append("=\"")
						.append(Objects.toString(entry.getValue()))
						.append('\"');
		 }
	 }

	 public void addClass(String aString) {
		  append("class", aString, " ");
	 }

	 public void addStyle(String aString) {
	 	 append("style", aString, ";");
	 }

	 public void append(String key, String value, String aSeparator) {
	 	 var current = attribs.get(key);
	 	 if (current == null) {
	 	 	 attribs.put(key, value);
		 } else {
	 	 	 attribs.put(key, current.toString() + aSeparator + value);
		 }
	 }

	 public void put(String name, Object value) {
	 	 attribs.put(name, value);
	 }
}
