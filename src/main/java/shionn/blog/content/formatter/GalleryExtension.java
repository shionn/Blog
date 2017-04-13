package shionn.blog.content.formatter;

import org.commonmark.parser.Parser;
import org.commonmark.parser.Parser.ParserExtension;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.html.HtmlRenderer.HtmlRendererExtension;

public class GalleryExtension implements ParserExtension, HtmlRendererExtension {

	@Override
	public void extend(Parser.Builder builder) {
		builder.customBlockParserFactory(new GalleryBlockParser.Factory());
	}

	@Override
	public void extend(HtmlRenderer.Builder builder) {
		// TODO Auto-generated method stub

	}

}
