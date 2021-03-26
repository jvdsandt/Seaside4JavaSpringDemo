package com.cloudctrl.seaside.document;

import java.util.ArrayList;
import java.util.List;

public class HtmlRoot {

	 private String docType;
	 private HtmlAttributes htmlAttrs;
	 private HtmlAttributes headAttrs;
	 private HtmlAttributes bodyAttrs;
	 private List<HtmlElement> headElements;
	 private String title;

	 public HtmlRoot() {
	 	 super();
	 	 beHtml5();
	 	 this.headElements = new ArrayList<>();
	 	 this.title = "";
	 }

	 public void beHtml5() {
	 	 setDocType("<!DOCTYPE html>");
	 }

	 void openOn(Document doc) {
		writeHead(doc);
	 }

	 void closeOn(Document doc) {
	 	 writeFootOn(doc);
	 }

	 void writeHead(Document doc) {
		  doc.write(docType);
		  doc.openTag("html", htmlAttrs);
		  doc.openTag("head", headAttrs);
		  writeElements(doc);
		  doc.closeTag("head");
		  doc.openTag("body", bodyAttrs);
	 }

	 void writeElements(Document doc) {
	 	 doc.openTag("title");
	 	 doc.text(title);
	 	 doc.closeTag("title");
	 	 headElements.forEach(elem -> elem.encodeOn(doc));
	 }

	 void writeFootOn(Document doc) {
	 	 doc.closeTag("body");
	 	 doc.closeTag("html");
	 }

	 public String getDocType() {
		  return docType;
	 }

	 public HtmlRoot setDocType(String docType) {
		  this.docType = docType;
		  return this;
	 }

	 public HtmlAttributes getHtmlAttrs() {
	 	 if (htmlAttrs == null) {
	 	 	 htmlAttrs = new HtmlAttributes();
		 }
	 	 return htmlAttrs;
	 }

	 public HtmlRoot setHtmlAttrs(HtmlAttributes htmlAttrs) {
		  this.htmlAttrs = htmlAttrs;
		  return this;
	 }

	 public HtmlAttributes getHeadAttrs() {
	 	 if (headAttrs == null) {
	 	 	 htmlAttrs = new HtmlAttributes();
		 }
		  return headAttrs;
	 }

	 public HtmlRoot setHeadAttrs(HtmlAttributes headAttrs) {
		  this.headAttrs = headAttrs;
		  return this;
	 }

	 public HtmlAttributes getBodyAttrs() {
	 	 if (bodyAttrs == null) {
	 	 	 bodyAttrs = new HtmlAttributes();
		 }
		  return bodyAttrs;
	 }

	 public HtmlRoot setBodyAttrs(HtmlAttributes bodyAttrs) {
		  this.bodyAttrs = bodyAttrs;
		  return this;
	 }

	 public void add(HtmlElement element) {
	 	 headElements.add(element);
	 }

	 public void setLang(String languageCode) {
	 	 getHtmlAttrs().put("lang", languageCode);
	 }

	 public HtmlLinkElement link() {
		  HtmlLinkElement elem = new HtmlLinkElement(this);
		  add(elem);
		  return elem;
	 }

	 public HtmlMetaElement meta() {
		  HtmlMetaElement elem = new HtmlMetaElement(this);
		  add(elem);
		  return elem;
	 }

	 public HtmlScriptElement script() {
		  HtmlScriptElement elem = new HtmlScriptElement(this);
		  add(elem);
		  return elem;
	 }

	 public HtmlLinkElement stylesheet() {
	 	 return link().beStylesheet().beCss();
	 }

	 public String getTitle() {
		  return title;
	 }

	 public HtmlRoot setTitle(String title) {
		  this.title = title;
		  return this;
	 }
}
