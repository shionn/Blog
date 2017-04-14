package shionn.blog.content.formatter;

import org.commonmark.parser.Parser;
import org.commonmark.parser.Parser.ParserExtension;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlNodeRendererFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.html.HtmlRenderer.HtmlRendererExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GalleryExtension implements ParserExtension, HtmlRendererExtension {

	@Override
	public void extend(Parser.Builder builder) {
		builder.customBlockParserFactory(new GalleryBlockParser.Factory());
	}

	@Autowired
	@Value("#{servletContext.contextPath}")
	private String servletContextPath;

	@Autowired
	@Value("${gallery.preview.w}")
	private int w;
	@Autowired
	@Value("${gallery.preview.h}")
	private int h;


	@Override
	public void extend(HtmlRenderer.Builder builder) {
		builder.nodeRendererFactory(new HtmlNodeRendererFactory() {
			@Override
			public NodeRenderer create(HtmlNodeRendererContext context) {
				return new GalleryNodeRenderer(context, servletContextPath, w, h);
			}
		});
	}

}
