package shionn.blog.content;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import shionn.blog.content.formatter.ContentFormater;
import shionn.blog.db.dao.HomeDao;
import shionn.blog.db.dbo.Post;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Controller()
@RequestScope
public class HomeController {

	@Autowired
	private SqlSession session;
	@Autowired
	private ContentFormater contentFormatter;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		HomeDao dao = session.getMapper(HomeDao.class);
		List<Post> posts = dao.readPosts();
		for (Post post : posts) {
			post.setContent(contentFormatter.shortPost(post.getContent()));
		}
		dao.insertStat(request.getRemoteAddr(), "/");
		session.commit();
		return new ModelAndView("home").addObject("posts", posts)
				.addObject("menu", dao.readMenu(0).current("/"))
				.addObject("cloodtags", dao.readCloodTags())
				.addObject("lastcomments", dao.readLastComments());
	}

}
