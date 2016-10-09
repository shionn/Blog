package shionn.blog.adm;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import shionn.blog.db.dao.PostAdmDao;
import shionn.blog.db.dbo.Post;

@Controller
@SessionScope
public class PostAdm {

	@Autowired
	private SqlSession session;

	@Autowired
	private PostAdmFilters filters;

	@RequestMapping(value = "/adm/posts", method = RequestMethod.GET)
	public String home(
			@RequestParam(value = "sortby", required = false, defaultValue = "updated") PostAdmDao.SortBy sortby,
			@RequestParam(value = "type", required = false, defaultValue = "post") Post.Type type,
			@RequestParam(value = "status", required = false, defaultValue = "draft") Post.Status status,
			ModelMap model) {
		if (sortby !=null) {
			filters.setSortBy(sortby);
		}
		if (type != null) {
			filters.setType(type);
		}
		if (status != null) {
			filters.setStatus(status);
		}
		
		model.addAttribute("posts", session.getMapper(PostAdmDao.class).list(filters.getType(),
				filters.getStatus(), filters.getSortBy()));
		model.addAttribute("activepage", "posts");
		model.addAttribute("filters", filters);
		return "adm/posts";
	}

}
