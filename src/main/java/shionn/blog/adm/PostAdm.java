package shionn.blog.adm;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import shionn.blog.db.dao.PostAdmDao;
import shionn.blog.db.dbo.Post;
import shionn.blog.db.dbo.User;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Controller()
@RequestScope
public class PostAdm {

	private static final String PAGE = "posts";
	@Autowired
	private SqlSession session;
	@Autowired
	private PostAdmFilters filters;
	@Autowired
	private User user;

	@RequestMapping(value = "/adm/posts", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(value = "sortby", required = false) PostAdmDao.SortBy sortby,
			@RequestParam(value = "type", required = false) Post.Type type,
			@RequestParam(value = "status", required = false) Post.Status status) {
		if (sortby != null) {
			if (filters.getSortBy() == sortby) {
				filters.setSortOrder(filters.getSortOrder().reverse());
			} else {
				filters.setSortBy(sortby);
			}
		}
		if (type != null) {
			filters.setType(type);
		}
		if (status != null) {
			filters.setStatus(status);
		}
		List<Post> posts = session.getMapper(PostAdmDao.class).list(filters.getType(), filters.getStatus(),
				filters.getSortBy(), filters.getSortOrder());
		return new ModelAndView("adm/post/list").addObject("posts", posts).addObject("activepage", PAGE)
				.addObject("filters", filters);
	}

	@RequestMapping(value = "/adm/posts", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute Post post) {
		post.setUrl(Pattern.compile("[^a-zA-Z]").matcher(post.getTitle()).replaceAll("-"));
		post.setAuthor(user);
		session.getMapper(PostAdmDao.class).create(post);
		session.commit();
		return list(null, null, Post.Status.draft);
	}

	@RequestMapping(value = "/adm/post/edit/{id:\\d+}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id) {
		Post post = session.getMapper(PostAdmDao.class).get(id);
		return new ModelAndView("adm/post/edit").addObject("post", post).addObject("activepage", PAGE);
	}

	@RequestMapping(value = "/adm/post/edit/{id:\\d+}", method = RequestMethod.POST)
	public String save(@PathVariable("id") int id, @ModelAttribute Post post) {
		post.setId(id);
		session.getMapper(PostAdmDao.class).backup(id);
		session.getMapper(PostAdmDao.class).save(post);
		session.commit();
		return "redirect:/adm/post/edit/" + id;
	}

	/**
	 * Je cherche toujours une méthode plus élégante.
	 */
	@RequestMapping(value = "/adm/post/edit/tag/{id:\\d+}", method = RequestMethod.POST)
	public String saveTags(@PathVariable("id") int id, HttpServletRequest request) {
		session.getMapper(PostAdmDao.class).deleteTags(id);
		Map<String, String[]> params = request.getParameterMap();
		for (Entry<String, String[]> e : params.entrySet()) {
			if ("on".equalsIgnoreCase(e.getValue()[0])) {
				session.getMapper(PostAdmDao.class).addTag(id, Integer.parseInt(e.getKey()));
			}
		}
		session.commit();
		return "redirect:/adm/post/edit/" + id;
	}

}
