package shionn.blog.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Controller
public class Home  {

//	@Inject
//	private Toto toto;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "home";
	}

	@RequestMapping(value = "/{name:.+}", method = RequestMethod.GET)
	public ModelAndView article(@PathVariable("name") String name) {
		return new ModelAndView("home");
	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		System.out.println(toto.getA());
//		System.out.println("home");
//		this.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
//	}

}
