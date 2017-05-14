package shionn.blog.content;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import shionn.blog.content.rss.Channel;
import shionn.blog.content.rss.Item;
import shionn.blog.content.rss.Rss;
import shionn.blog.db.dao.RssDao;
import shionn.blog.db.dbo.Comment;
import shionn.blog.db.dbo.Post;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@RestController
@RequestScope
public class RssController {

	private static final SimpleDateFormat RFC822_DATE_FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
	@Autowired
	private SqlSession session;
	@Autowired
	private BlogConfiguration configuration;

	@RequestMapping(value = "/feed", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public Rss posts() {
		Rss rss = new Rss();
		rss.setChannel(buildChannel(buildPosts()));
		return rss;
	}

	@RequestMapping(value = "/comment/feed", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public Rss comments() {
		Rss rss = new Rss();
		rss.setChannel(buildChannel(buildComments()));
		return rss;
	}

	private Channel buildChannel(List<Item> items) {
		Channel channel = new Channel();
		channel.setDescription(configuration.getBlogDescription());
		channel.setLink(configuration.getBlogUrl());
		channel.setTitle(configuration.getBlogTitle());
		channel.setLanguage(configuration.getBlogLanguage());
		channel.setItems(items);
		return channel;
	}

	private List<Item> buildPosts() {
		List<Item> items = new ArrayList<Item>();
		for (Post post : session.getMapper(RssDao.class).readLastPosts()) {
			Item item = new Item();
			item.setTitle(post.getTitle());
			item.setLink(StringUtils.appendIfMissing(configuration.getBlogUrl(), "/")
					+ post.getUrl());
			item.setDescription(buildShortContent(post.getContent()));
			item.setPubDate(formatDate(post.getPublished()));
			item.setAuthor(post.getAuthor().getEmail());
			items.add(item);
		}
		return items;
	}

	private List<Item> buildComments() {
		List<Item> items = new ArrayList<Item>();
		for (Comment comment : session.getMapper(RssDao.class).readLastComments()) {
			Item item = new Item();
			item.setTitle(comment.getPost().getTitle());
			item.setLink(StringUtils.appendIfMissing(configuration.getBlogUrl(), "/") + comment.getPost().getUrl());
			item.setDescription(buildShortContent(comment.getContent()));
			item.setPubDate(formatDate(comment.getDate()));
			item.setAuthor(comment.getAuthorEmail());
			items.add(item);
		}
		return items;
	}

	private synchronized String formatDate(Date date) {
		return RFC822_DATE_FORMAT.format(date);
	}

	private String buildShortContent(String content) {
		return StringUtils.abbreviate(content, 300);
	}

}
