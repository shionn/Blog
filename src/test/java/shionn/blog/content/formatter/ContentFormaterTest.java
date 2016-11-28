package shionn.blog.content.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import shionn.blog.content.formatter.ContentFormater;

public class ContentFormaterTest {

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

}
