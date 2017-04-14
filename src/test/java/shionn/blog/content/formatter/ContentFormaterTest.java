package shionn.blog.content.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
public class ContentFormaterTest {

	private static final String IMG_1 = "/image.png";

	@Test
	public void testFullPostJava() throws Exception {
		assertThat(new ContentFormater().fullPost("~~~\ntutu\n~~~"))
				.isEqualTo("<pre><code class=\"java\">tutu\n</code></pre>\n");
	}

	@Test
	public void testFullPostXml() throws Exception {
		assertThat(new ContentFormater().fullPost("~~~xml\ntutu\n~~~"))
				.isEqualTo("<pre><code class=\"xml\">tutu\n</code></pre>\n");
	}

	@Test
	public void testGallery() {
		assertThat(new ContentFormater()
				.fullPost("[gallery]\n" + IMG_1 + "\n" + "/tuto-slick2d-052-trigger-sortie.png" + "\n" + "[/gallery]"))
						.contains("<div class=\"gallery\">").contains("<a href=\"" + IMG_1 + "\">")
						.contains("<img src=\"" + IMG_1 + "\">");
	}

}
