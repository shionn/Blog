package shionn.blog.content.formatter;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Component
public class ContentFormater {

	@Autowired
	@Qualifier("full")
	private Parser fullPostParser;
	@Autowired
	@Qualifier("home")
	private Parser homeParser;
	@Autowired
	private HtmlRenderer renderer;


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

}
