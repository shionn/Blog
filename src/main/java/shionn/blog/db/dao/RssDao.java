package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.Post;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
public interface RssDao {

	@Select("SELECT p.url, p.title, p.published, p.content, u.name "
			+ "FROM post AS p "
			+ "LEFT JOIN user AS u ON p.author = u.id "
			+ "WHERE p.status = 'publish' "
			+ "AND p.type = 'post' "
			+ "ORDER BY p.published DESC "
			+ "LIMIT 10")
	@Results({ @Result(column = "u.name", property = "author.name") })
	List<Post> readLastPosts();

}
