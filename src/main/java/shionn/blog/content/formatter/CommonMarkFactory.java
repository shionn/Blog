package shionn.blog.content.formatter;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.parser.PostProcessor;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlNodeRendererFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CommonMarkFactory {

	@Autowired
	@Value("${gallery.preview.w}")
	private int w;
	@Autowired
	@Value("${gallery.preview.h}")
	private int h;

	@Autowired
	@Value("#{servletContext.contextPath}")
	private String servletContextPath;

	@Bean(name = "full")
	public Parser full() {
		return Parser.builder().customBlockParserFactory(new GalleryBlockParser.Factory()).build();
	}

	@Bean(name = "home")
	public Parser home() {
		return Parser.builder().customBlockParserFactory(new GalleryBlockParser.Factory())
				.postProcessor(new PostProcessor() {
					/**
					 * permet de limiter à 6 paragraph pour la page d'acceuil
					 */
					@Override
					public Node process(Node root) {
						Node current = root.getFirstChild();
						int count = 0;
						while (current != null) {
							Node next = current.getNext();
							if (count++ > 6) {
								current.unlink();
							}
							current = next;
						}
						return root;
					}
				}).build();
	}

	@Bean
	public HtmlRenderer html() {
		return HtmlRenderer.builder().nodeRendererFactory(new HtmlNodeRendererFactory() {
			@Override
			public NodeRenderer create(HtmlNodeRendererContext context) {
				return new GalleryNodeRenderer(context, servletContextPath, w, h);
			}
		}).attributeProviderFactory(new AttributeProviderFactory() {
			@Override
			public AttributeProvider create(AttributeProviderContext context) {
				return new AttributeProvider() {
					@Override
					public void setAttributes(Node node, Map<String, String> attributes) {
						if (node instanceof FencedCodeBlock) {
							String type = ((FencedCodeBlock) node).getInfo();
							if (StringUtils.isBlank(type)) {
								type = "java";
							}
							attributes.put("class", type);
						} else if (node instanceof Image) {
							String src = ((Image) node).getDestination();
							if (src.startsWith("/")) {
								src = servletContextPath + StringUtils.prependIfMissing(src, "/img");
								attributes.put("src", src);
							}
						} else if (node instanceof Link) {
							String src = ((Link) node).getDestination();
							if (src.startsWith("http")) {
								attributes.put("target", "_blank");
							}
						}
					}
				};
			}
		}).build();
	}

}
