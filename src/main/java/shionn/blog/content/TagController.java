package shionn.blog.content;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import shionn.blog.content.formatter.ContentFormater;
import shionn.blog.db.dao.TagDao;
import shionn.blog.db.dbo.Post;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Controller()
@RequestScope
public class TagController {

	@Autowired
	private SqlSession session;
	@Autowired
	private ContentFormater contentFormatter;

	@RequestMapping(value = "/tag/{url:.*}", method = RequestMethod.GET)
	public ModelAndView tag(@PathVariable("url") String url) {
		TagDao dao = session.getMapper(TagDao.class);
		List<Post> posts = dao.readPosts(url);
		for (Post post : posts) {
			post.setContent(contentFormatter.shortPost(post.getContent()));
		}
		return new ModelAndView("tag").addObject("posts", posts)
				.addObject("menu", dao.readMenu(0).current("/category/" + url))
				.addObject("tag", dao.readTag(url))
				.addObject("cloodtags", dao.readCloodTags())
				.addObject("lastcomments", dao.readLastComments());
	}

}
