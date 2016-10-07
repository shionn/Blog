package shionn.blog.adm;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import shionn.blog.db.dao.PostAdmDao;

@Controller()
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class Posts {

	@Autowired
	private SqlSession session;

	@RequestMapping(value = "/adm/posts", method = RequestMethod.GET)
	public String home(ModelMap model) {
		model.addAttribute("posts", session.getMapper(PostAdmDao.class).list());
		return "adm/posts";
	}

}
