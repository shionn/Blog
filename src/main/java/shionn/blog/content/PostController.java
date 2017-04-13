package shionn.blog.content;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import shionn.blog.content.error.PostNotFoundExcpetion;
import shionn.blog.content.formatter.ContentFormater;
import shionn.blog.db.dao.PostDao;
import shionn.blog.db.dbo.Comment;
import shionn.blog.db.dbo.Post;
import shionn.blog.db.dbo.User;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Controller
@RequestScope
public class PostController {

	@Autowired
	private SqlSession session;
	@Autowired
	private ContentFormater contentFormatter;
	@Autowired
	private User user;
	@Autowired
	@Value("${comment.forbidden.ips}")
	private String forbiddenIps;

	@RequestMapping(value = "/{url}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("url") String url) {
		PostDao dao = session.getMapper(PostDao.class);
		Post post = dao.readPost(url);
		if (post == null) {
			throw new PostNotFoundExcpetion(url);
		}
		post.setContent(contentFormatter.fullPost(post.getContent()));
		for (Comment comment : post.getComments()) {
			comment.setGravatar(gravatar(comment));
			comment.setContent(contentFormatter.comment(comment.getContent()));
		}
		return new ModelAndView("article")
				.addObject("post",post)
				.addObject("user", user)
				.addObject("menu", dao.readMenu(0).current(url))
				.addObject("cloodtags", dao.readCloodTags())
				.addObject("lastcomments", dao.readLastComments());
	}

	private String gravatar(Comment comment) {
		return DigestUtils.md5Hex(comment.getAuthorEmail());
	}

	@RequestMapping(value = "/{url}/comment", method = RequestMethod.POST)
	public String postComment(@PathVariable("url") String url, @ModelAttribute Comment comment,
			HttpServletRequest request) {
		comment.setIp(request.getRemoteAddr());
		PostDao dao = session.getMapper(PostDao.class);
		dao.saveComment(comment, url, user);
		if (!isForbidden(comment)) {
			session.commit();
		}
		return "redirect:/" + url + "#lastcomment";
	}

	@RequestMapping(value = "/{url}/preview", method = RequestMethod.POST)
	@ResponseBody
	public String previewComment(@PathVariable("url") String url, @RequestParam(name = "content") String comment) {
		return contentFormatter.comment(comment);
	}

	private boolean isForbidden(Comment comment) {
		return forbiddenIps.contains(comment.getIp()) || comment.getContent().contains("http://")
				|| comment.getContent().contains("https://");
	}

	@RequestMapping(value = "/page/{url}", method = RequestMethod.GET)
	public String redirectOldPage(@PathVariable("url") String url) {
		return "redirect:/" + url;
	}

}
