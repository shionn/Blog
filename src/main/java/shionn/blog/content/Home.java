package shionn.blog.content;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import shionn.blog.content.formatter.ContentFormater;
import shionn.blog.db.dao.CommentDao;
import shionn.blog.db.dao.HomeDao;
import shionn.blog.db.dao.MenuDao;
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
public class Home {

	@Autowired
	private SqlSession session;
	@Autowired
	private ContentFormater contentFormatter;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		HomeDao dao = session.getMapper(HomeDao.class);
		List<Post> posts = dao.readPosts();
		for (Post post : posts) {
			post.setContent(contentFormatter.homePost(post.getContent()));
		}
		return new ModelAndView("home").addObject("posts", posts)
				.addObject("menu", session.getMapper(MenuDao.class).readMenu(0).current("/"))
				.addObject("cloodtags", session.getMapper(TagDao.class).readCloodTags())
				.addObject("lastcomments", session.getMapper(CommentDao.class).readLastComments());
	}

}
