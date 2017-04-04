package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import shionn.blog.db.dao.frag.ContentDao;
import shionn.blog.db.dbo.Category;
import shionn.blog.db.dbo.Post;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
public interface CategoryDao extends ContentDao {

	@Select("SELECT p.id, p.url, p.title, p.published, p.content, "
			+ "u.name, count(c.id) AS comment_count, "
			+ "cat.url AS cat_url, cat.title AS cat_title "
			+ "FROM post AS p "
			+ "LEFT JOIN user AS u ON p.author = u.id "
			+ "LEFT JOIN comment AS c ON c.post = p.id "
			+ "LEFT JOIN category AS cat ON cat.id = p.category "
			+ "WHERE p.type = 'post' "
			+ "AND p.status = 'publish' "
			+ "AND p.published < NOW() "
			+ "AND cat.url = #{url} "
			+ "GROUP BY p.id "
			+ "ORDER BY p.published DESC "
			+ "LIMIT 5")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "u.name", property = "author.name"),
			@Result(column = "cat_title", property = "category.title"),
			@Result(column = "cat_url", property = "category.url"),
			@Result(column = "id", property = "tags", many = @Many(select = "readTags", fetchType = FetchType.EAGER)) })
	public List<Post> readPosts(String url);

	@Select("SELECT * FROM category WHERE url = #{url} ")
	public Category readCategory(String url);
	
}
