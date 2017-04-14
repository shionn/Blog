package shionn.blog.content.formatter;

import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.parser.PostProcessor;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Component
public class ContentFormater implements AttributeProviderFactory, AttributeProvider, PostProcessor {

	@Autowired
	private GalleryExtension gallery;
	private Parser fullPostParser = Parser.builder().extensions(Collections.singletonList(gallery)).build();
	private Parser homeParser = Parser.builder().extensions(Collections.singletonList(gallery)).postProcessor(this)
			.build();
	private HtmlRenderer renderer = HtmlRenderer.builder().extensions(Collections.singletonList(gallery))
			.attributeProviderFactory(this).build();

	@Autowired
	@Value("#{servletContext.contextPath}")
	private String servletContextPath;

	public String shortPost(String content) {
		Node nodes = homeParser.parse(content);
		return renderer.render(nodes);
	}

	public String fullPost(String content) {
		Node nodes = fullPostParser.parse(content);
		return renderer.render(nodes);
	}

	public String comment(String content) {
		Node nodes = fullPostParser.parse(content);
		return renderer.render(nodes);
	}

	@Override
	public AttributeProvider create(AttributeProviderContext context) {
		return this;
	}

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

}
