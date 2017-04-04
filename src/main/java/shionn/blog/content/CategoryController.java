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
import shionn.blog.db.dao.CategoryDao;
import shionn.blog.db.dbo.Category;
import shionn.blog.db.dbo.Post;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Controller()
@RequestScope
public class CategoryController {

	@Autowired
	private SqlSession session;
	@Autowired
	private ContentFormater contentFormatter;

	@RequestMapping(value = "/category/{url:.*}", method = RequestMethod.GET)
	public ModelAndView category(@PathVariable("url") String url) {
		CategoryDao dao = session.getMapper(CategoryDao.class);
		Category category = dao.readCategory(url);
		if (category.getId() == 0) {
			return new ModelAndView("redirect:/");
		}
		List<Post> posts = dao.readPosts(url);
		for (Post post : posts) {
			post.setContent(contentFormatter.shortPost(post.getContent()));
		}
		return new ModelAndView("category").addObject("posts", posts)
				.addObject("menu", dao.readMenu(0).current("/category/" + url))
				.addObject("category", category)
				.addObject("cloodtags", dao.readCloodTags())
				.addObject("lastcomments", dao.readLastComments());
	}

	/**
	 * Redirection des anciennes url de wordpress
	 */
	@RequestMapping(value = { "/category/{p1}/{url}", "/category/{p1}/{p2}/{url}",
			"/category/{p1}/{p2}/{p3}/{url}" }, method = RequestMethod.GET)
	public String old(@PathVariable("url") String url) {
		return "redirect:/category/" + url;
	}
}
