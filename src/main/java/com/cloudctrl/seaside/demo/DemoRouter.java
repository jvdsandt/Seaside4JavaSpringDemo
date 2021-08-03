package com.cloudctrl.seaside.demo;

import java.io.IOException;
import java.util.function.Function;

import com.cloudctrl.seaside.component.HtmlRenderable;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

public class DemoRouter {

	public static UriComponents home() {
		try {
			MvcUriComponentsBuilder.fromMethod(MvcUriComponentsBuilder.on(SeasideController.class).getHome())
					.build();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private static final Route HOME = new Route("/",
			(input) -> new DemoPage(null)
	);

	private static final Route PRODUCTS = new Route("/products",
			(input) -> new DemoPage(null)
	);

	private static final Route PRODUCT_DETAILS = new Route("/product/{id}",
			(input) -> new DemoPage(null)
	);

	public Route products() {
		return new Route("/products");
	}

	public Route product(int productId) {
		return new Route("/products/{id}");
	}

	static class Route {

		String path;

		Function<Object, HtmlRenderable> renderFunction;

		public Route(String path) {
			this.path = path;
		}

		public Route(String path, Function<Object, HtmlRenderable> renderFunction) {
			this.path = path;
			this.renderFunction = renderFunction;
		}

		public String getUrl() {
			return path;
		}
	}
}
