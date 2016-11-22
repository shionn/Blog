package shionn.blog.home;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import shionn.blog.db.dao.HomeDao;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Controller()
@RequestScope
public class Home  {

	@Autowired
	private SqlSession session;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		HomeDao dao = session.getMapper(HomeDao.class);
		return new ModelAndView("home").addObject("posts", dao.readPosts());
	}

}
