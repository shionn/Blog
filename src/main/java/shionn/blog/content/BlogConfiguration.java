package shionn.blog.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlogConfiguration {

	@Autowired
	@Value("${blog.description}")
	private String blogDescription;

	@Autowired
	@Value("${blog.title}")
	private String blogTitle;

	@Autowired
	@Value("${blog.url}")
	private String blogUrl;

	@Autowired
	@Value("${blog.language}")
	private String blogLanguage;

	public String getBlogDescription() {
		return blogDescription;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public String getBlogUrl() {
		return blogUrl;
	}

	public String getBlogLanguage() {
		return blogLanguage;
	}
}
