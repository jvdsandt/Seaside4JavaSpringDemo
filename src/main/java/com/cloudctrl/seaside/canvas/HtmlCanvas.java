package com.cloudctrl.seaside.canvas;

import com.cloudctrl.seaside.component.HtmlRenderable;
import com.cloudctrl.seaside.document.Document;
import com.cloudctrl.seaside.tags.*;

public class HtmlCanvas extends Canvas {

	public static HtmlCanvas build() {
		return new HtmlCanvas();
	}

	public static Builder builder() {
		return new Builder();
	}

	public HtmlCanvas(Document document) {
		super(document);
	}

	public HtmlCanvas() {
		super(new Document());
	}

	public void render(HtmlRenderable anObject) {
		flush();
		if (anObject != null) {
			anObject.renderContentOn(this);
		}
	}

	@SuppressWarnings("rawtypes")
	public <T extends TagBrush> T tag(Class<T> clazz) {
		try {
			var tag = clazz.getDeclaredConstructor().newInstance();
			setBrush(tag);
			return tag;
		} catch (Exception ex) {
			throw new RuntimeException("Cannot create instance of tag " + clazz, ex);
		}
	}

	public GenericTag tag(String tagName) {
		var tag = new GenericTag(tagName);
		setBrush(tag);
		return tag;
	}

	public AnchorTag anchor() {
		return tag(AnchorTag.class);
	}

	public void anchor(Runnable action) {
		anchor().with(action);
	}

	public void anchor(Object anObject) {
		anchor().with(anObject);
	}

	public GenericTag div() {
		return tag("div");
	}

	public void div(Object anObject) {
		div().with(anObject);
	}

	public void div(Runnable anObject) {
		div().with(anObject);
	}

	public BreakTag br() {
		var tag = new BreakTag();
		setBrush(tag);
		return tag;
	}

	public GenericTag paragraph() {
		return tag("p");
	}

	public void paragraph(Runnable anObject) {
		paragraph().with(anObject);
	}

	public void paragraph(Object anObject) {
		paragraph().with(anObject);
	}

	public LabelTag label() {
		return tag(LabelTag.class);
	}

	public GenericTag listItem() {
		return tag("li");
	}

	public void listItem(Object anObject) {
		listItem().with(anObject);
	}

	public HeadingTag heading() {
		HeadingTag tag = new HeadingTag();
		setBrush(tag);
		return tag;
	}

	public TableTag table() {
		TableTag tag = new TableTag();
		setBrush(tag);
		return tag;
	}

	public void table(Runnable anObject) {
		table().with(anObject);
	}

	public GenericTag tableBody() {
		return tag("tbody");
	}

	public void tableBody(Runnable anObject) {
		tableBody().with(anObject);
	}

	public TableDataTag tableData() {
		TableDataTag tag = new TableDataTag();
		setBrush(tag);
		return tag;
	}

	public void tableData(Runnable action) {
		tableData().with(action);
	}

	public void tableData(Object anObject) {
		tableData().with(anObject);
	}

	public GenericTag tableRow() {
		return tag("tr");
	}

	public void tableRow(Runnable action) {
		tableRow().with(action);
	}

	public void space() {
		flush();
		getDocument().write("&nbsp;");
	}
	
	public GenericTag span() {
		return tag("span");
	}

	public GenericTag unorderedList() {
		return tag("ul");
	}

	public void span(Object anObject) {
		span().with(anObject);
	}

	public FormTag form() {
		return tag(FormTag.class);
	}

	public void form(Runnable anObject) {
		form().with(anObject);
	}

	public TextInputTag textInput() {
		TextInputTag tag = new TextInputTag();
		setBrush(tag);
		return tag;
	}

	public ScriptTag script() {
		ScriptTag tag = new ScriptTag();
		setBrush(tag);
		return tag;
	}

	public ButtonTag button() {
		ButtonTag tag = new ButtonTag();
		setBrush(tag);
		return tag;
	}

	public void html(String markup) {
		flush();
		getDocument().write(markup);
	}
}
