package shionn.blog.adm;

import org.apache.ibatis.session.SqlSession;
import org.dozer.inject.Inject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shionn.blog.db.dao.PostAdmDao;

@Controller()
@Scope(value = "request")
public class Posts {

	@Inject
	private SqlSession session;

	@RequestMapping(value = "/adm/posts", method = RequestMethod.GET)
	public String home(ModelMap model) {
		model.addAttribute("posts", session.getMapper(PostAdmDao.class).list());
		return "adm/posts";
	}

}
