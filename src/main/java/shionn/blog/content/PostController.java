package shionn.blog.content;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import shionn.blog.content.error.PostNotFoundExcpetion;
import shionn.blog.content.formatter.ContentFormater;
import shionn.blog.db.dao.PostDao;
import shionn.blog.db.dbo.Post;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Controller
@RequestScope
public class PostController {

	@Autowired
	private SqlSession session;
	@Autowired
	private ContentFormater contentFormatter;

	@RequestMapping(value = "/{url}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("url") String url) {
		PostDao dao = session.getMapper(PostDao.class);
		Post post = dao.readPost(url);
		if (post == null) {
			throw new PostNotFoundExcpetion(url);
		}
		post.setContent(contentFormatter.fullPost(post.getContent()));
		return new ModelAndView("article")
				.addObject("post",post)
				.addObject("menu", dao.readMenu(0).current(url))
				.addObject("cloodtags", dao.readCloodTags())
				.addObject("lastcomments", dao.readLastComments());
	}

}
