package shionn.blog.content;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlNodeRendererFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Component
public class ContentFormater implements HtmlNodeRendererFactory, NodeRenderer {

	private Parser parser = Parser.builder().build();
	private HtmlRenderer renderer = HtmlRenderer.builder().nodeRendererFactory(this).build();

	public String format(String content) {
		return renderer.render(parser.parse(content));
	}

	@Override
	public NodeRenderer create(HtmlNodeRendererContext context) {
		return this;
	}

	@Override
	public Set<Class<? extends Node>> getNodeTypes() {
		return new HashSet<>(Arrays.asList(IndentedCodeBlock.class));
	}

	@Override
	public void render(Node node) {
		IndentedCodeBlock codeBlock = (IndentedCodeBlock) node;
	}

}
