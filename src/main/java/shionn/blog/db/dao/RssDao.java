package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.Comment;
import shionn.blog.db.dbo.Post;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
public interface RssDao {

	@Select("SELECT p.url, p.title, p.published, p.content, u.name, u.email "
			+ "FROM post AS p "
			+ "LEFT JOIN user AS u ON p.author = u.id "
			+ "WHERE p.status = 'publish' "
			+ "AND p.type = 'post' "
			+ "ORDER BY p.published DESC "
			+ "LIMIT 10")
	@Results({ @Result(column = "u.name", property = "author.name"),
			@Result(column = "u.email", property = "author.email") })
	List<Post> readLastPosts();

	@Select("SELECT c.author_name, c.author_email, c.date, c.content,  p.title, p.url "
			+ "FROM comment AS c "
			+ "LEFT JOIN post AS p ON c.post = p.id "
			+ "ORDER BY c.date DESC "
			+ "LIMIT 20")
	@Results({
			@Result(column = "title", property = "post.title"),
			@Result(column = "url", property = "post.url") })
	List<Comment> readLastComments();

}
