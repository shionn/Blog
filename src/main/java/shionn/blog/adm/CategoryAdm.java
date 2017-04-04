package shionn.blog.adm;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import shionn.blog.db.dao.adm.CategoryAdmDao;
import shionn.blog.db.dbo.Category;

@Controller()
@RequestScope
public class CategoryAdm {

	private static final String PAGE = "categories";
	@Autowired
	private SqlSession session;

	@RequestMapping(value = "/adm/categories", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("adm/category/list")
				.addObject("categories", session.getMapper(CategoryAdmDao.class).list())
				.addObject("activepage", PAGE);
	}

	@RequestMapping(value = "/adm/category/edit/{id:\\d+}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id) {
		return new ModelAndView("adm/category/edit")
				.addObject("category", session.getMapper(CategoryAdmDao.class).get(id))
				.addObject("activepage", PAGE);
	}

	@RequestMapping(value = "/adm/category/edit/{id:\\d+}", method = RequestMethod.POST)
	public ModelAndView save(@PathVariable("id") int id, @ModelAttribute Category category) {
		category.setId(id);
		session.getMapper(CategoryAdmDao.class).save(category);
		session.commit();
		return list();
	}

}
