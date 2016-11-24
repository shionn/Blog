package shionn.blog.content;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Component
public class ContentFormater implements AttributeProviderFactory, AttributeProvider {

	private Parser parser = Parser.builder().build();
	private HtmlRenderer renderer = HtmlRenderer.builder().attributeProviderFactory(this).build();

	public String format(String content) {
		Node nodes = parser.parse(content);
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
		}
	}

}
