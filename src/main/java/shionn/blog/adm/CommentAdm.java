package shionn.blog.adm;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shionn.blog.db.dao.adm.CommentAdmDao;
import shionn.blog.db.dbo.Comment;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Controller()
public class CommentAdm {
	private static final String PAGE = "comments";
	@Autowired
	private SqlSession session;

	@RequestMapping(value = "/adm/comments", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("adm/comment/list").addObject("comments", session.getMapper(CommentAdmDao.class).list())
				.addObject("activepage", PAGE);
	}

	@RequestMapping(value = "/adm/comment/edit/{id:\\d+}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id) {
		Comment comment = session.getMapper(CommentAdmDao.class).get(id);
		return new ModelAndView("adm/comment/edit").addObject("comment", comment).addObject("activepage", PAGE);
	}

	@RequestMapping(value = "/adm/comment/edit/{id:\\d+}", method = RequestMethod.POST)
	public String save(@PathVariable("id") int id, @ModelAttribute Comment comment) {
		comment.setId(id);
		session.getMapper(CommentAdmDao.class).save(comment);
		session.commit();
		return "redirect:/adm/comment/edit/" + id;
	}

}
