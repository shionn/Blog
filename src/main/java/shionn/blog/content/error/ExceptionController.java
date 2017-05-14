package shionn.blog.content.error;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import shionn.blog.db.dao.HomeDao;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@ControllerAdvice
public class ExceptionController {

	@Autowired
	private Logger logger;

	@Autowired
	private SqlSession session;

	@ExceptionHandler({ NoHandlerFoundException.class, PostNotFoundException.class })
	public ModelAndView handleNoHandlerFoundException(Exception e) {
		HomeDao dao = session.getMapper(HomeDao.class);
		logger.warn("Redirect to 404", e);
		return new ModelAndView("404")
				.addObject("menu", dao.readMenu(0))
				.addObject("cloodtags", dao.readCloodTags())
				.addObject("lastcomments", dao.readLastComments());
	}


	@ExceptionHandler({ NotAllowedException.class })
	public ModelAndView handleNotAllowedException(Exception e) {
		HomeDao dao = session.getMapper(HomeDao.class);
		return new ModelAndView("405").addObject("menu", dao.readMenu(0)).addObject("cloodtags", dao.readCloodTags())
				.addObject("lastcomments", dao.readLastComments());
	}

}
