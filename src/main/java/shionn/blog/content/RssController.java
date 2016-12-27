package shionn.blog.content;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import shionn.blog.content.rss.Channel;
import shionn.blog.content.rss.Item;
import shionn.blog.content.rss.Rss;
import shionn.blog.db.dao.RssDao;
import shionn.blog.db.dbo.Post;

@RestController
@RequestScope
public class RssController {

	@Autowired
	private SqlSession session;

	@RequestMapping(value = "/feed", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public Rss get() {
		Rss rss = new Rss();
		rss.setChannel(buildChannel());
		return rss;
	}

	private Channel buildChannel() {
		Channel channel = new Channel();
		channel.setDescription("description");
		channel.setLink("http://shionn.org");
		channel.setTitle("GCS/O d- s+:+ a C++ UL P L+++ E--- W++ N K- w--- M- PS PE-- Y- PGP- t+ 5 X R+ !tv b+ D+ G- e+++ h+ r++ y+");
		channel.setItems(buildItems());
		return channel;
	}

	private List<Item> buildItems() {
		List<Item> items = new ArrayList<Item>();
		for (Post post : session.getMapper(RssDao.class).readLastPosts()) {
			Item item = new Item();
			item.setTitle(post.getTitle());
			items.add(item);
		}
		return items;
	}

}
