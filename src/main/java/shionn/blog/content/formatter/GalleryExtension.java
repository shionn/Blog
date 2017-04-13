package shionn.blog.content.formatter;

import org.commonmark.parser.Parser;
import org.commonmark.parser.Parser.ParserExtension;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlNodeRendererFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.html.HtmlRenderer.HtmlRendererExtension;

public class GalleryExtension implements ParserExtension, HtmlRendererExtension {

	@Override
	public void extend(Parser.Builder builder) {
		builder.customBlockParserFactory(new GalleryBlockParser.Factory());
	}

	@Override
	public void extend(HtmlRenderer.Builder builder) {
		builder.nodeRendererFactory(new HtmlNodeRendererFactory() {

			@Override
			public NodeRenderer create(HtmlNodeRendererContext context) {

				return new GalleryNodeRenderer(context);
			}
		});
	}

}
