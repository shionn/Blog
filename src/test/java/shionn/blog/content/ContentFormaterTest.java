package shionn.blog.content;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ContentFormaterTest {

	@Test
	public void testFormatJava() throws Exception {
		assertThat(new ContentFormater().format("~~~\ntutu\n~~~"))
				.isEqualTo("<pre><code class=\"java\">tutu\n</code></pre>\n");
	}

	@Test
	public void testFormatXml() throws Exception {
		assertThat(new ContentFormater().format("~~~xml\ntutu\n~~~"))
				.isEqualTo("<pre><code class=\"xml\">tutu\n</code></pre>\n");
	}

}
