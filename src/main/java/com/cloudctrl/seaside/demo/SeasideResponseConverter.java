package com.cloudctrl.seaside.demo;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.cloudctrl.seaside.canvas.HtmlCanvas;
import com.cloudctrl.seaside.component.HtmlRenderable;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class SeasideResponseConverter implements HttpMessageConverter<HtmlRenderable> {

	private static final Charset CHAR_SET = StandardCharsets.UTF_8;
	private static final MediaType CONTENT_TYPE = new MediaType(MediaType.TEXT_HTML, CHAR_SET);

	@Override
	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		return false;
	}

	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		return (mediaType == null || mediaType.isCompatibleWith(MediaType.TEXT_HTML)) &&
				HtmlRenderable.class.isAssignableFrom(clazz);
	}

	@Override
	public List<MediaType> getSupportedMediaTypes() {
		return List.of(MediaType.TEXT_HTML);
	}

	@Override
	public HtmlRenderable read(Class<? extends HtmlRenderable> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		return null;
	}

	@Override
	public void write(HtmlRenderable page, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		outputMessage.getHeaders().setContentType(CONTENT_TYPE);
		try (Writer writer = new OutputStreamWriter(outputMessage.getBody(), CHAR_SET)) {
			HtmlCanvas.builder()
					.setFullDocument(true)
					.setRootBlock(root -> page.updateRoot(root))
					.render(page, writer);
			writer.flush();
		}
	}
}
