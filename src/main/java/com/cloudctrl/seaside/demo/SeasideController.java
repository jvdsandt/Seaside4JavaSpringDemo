package com.cloudctrl.seaside.demo;

import com.cloudctrl.seaside.canvas.HtmlCanvas;
import com.cloudctrl.seaside.document.HtmlRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SeasideController {

	 @Autowired
	 private DemoModel model;

	 @GetMapping("/products")
	 public void getProducts(HttpServletResponse response) throws IOException {

		  var panel = new ProductListPanel(model.getProducts());

		  HtmlCanvas.builder()
					 .setFullDocument(true)
					 .setRootBlock(root -> {
					 	 root.setTitle("Hello");
					 	 updateRoot(root);
					 })
					 .render(panel, response.getWriter());
	 }

	 @GetMapping("/product/{id}")
	 public void getProduct(@PathVariable String id, HttpServletResponse response) throws IOException {

		  var product = model.getProducts().stream()
					 .filter(p -> p.getName().equals(id))
					 .findAny();

		  if (product.isEmpty()) {
				handleNotFound(response);
				return;
		  }
		  var panel = new ProductDetailsPanel(product.get());
		  HtmlCanvas.builder()
					 .setFullDocument(true)
					 .setRootBlock(root -> root.setTitle("Hello"))
					 .render(panel, response.getWriter());
	 }

	 private void handleNotFound(HttpServletResponse response) {
	 	 response.setStatus(404);
	 }

	 private void updateRoot(HtmlRoot root) {
	 	 root.setLang("en");
	 	 root.meta().chatSet("utf-8");
	 	 root.meta().setName("viewport").setContent("width=device-width, initial-scale=1");

	 	 root.stylesheet()
					.setUrl("https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css")
					.setIntegrity("sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6")
					.beAnonymous();
	 }

}
