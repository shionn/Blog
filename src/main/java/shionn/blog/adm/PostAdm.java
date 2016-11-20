package shionn.blog.adm;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import shionn.blog.db.dao.PostAdmDao;
import shionn.blog.db.dbo.Post;

@Controller
@RequestScope
public class PostAdm {

	@Autowired
	private SqlSession session;

	@Autowired
	private PostAdmFilters filters;

	@RequestMapping(value = "/adm/posts", method = RequestMethod.GET)
	public ModelAndView list(
			@RequestParam(value = "sortby", required = false) PostAdmDao.SortBy sortby,
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

		List<Post> posts = session.getMapper(PostAdmDao.class).list(filters.getType(),
				filters.getStatus(), filters.getSortBy(), filters.getSortOrder());
		return new ModelAndView("adm/post/list").addObject("posts", posts)
				.addObject("activepage", "posts").addObject("filters", filters);
	}

	@RequestMapping(value = "/adm/posts", method = RequestMethod.POST)
	public ModelAndView create() {
		return list(null, null, Post.Status.draft);
	}

	@RequestMapping(value = "/adm/post/edit/{id:\\d+}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id) {
		Post post = session.getMapper(PostAdmDao.class).get(id);
		return new ModelAndView("adm/post/edit").addObject("post", post).addObject("activepage",
				"posts");
	}

}
