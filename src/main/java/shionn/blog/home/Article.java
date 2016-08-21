package shionn.blog.home;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private Toto toto;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url = req.getRequestURI().substring(req.getRequestURI().lastIndexOf('/') + 1);
		System.out.println(toto.getA());
		System.out.println(url);
		this.getServletContext().getRequestDispatcher("/jsp/article.jsp").forward(req, resp);
	}


}
