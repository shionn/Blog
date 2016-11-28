package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.Post;

public interface HomeDao {

	@Select("SELECT p.id, p.url, p.title, p.published, p.updated, p.content, "
			+ "u.name, count(c.id) AS comment_count "
			+ "FROM post AS p "
			+ "LEFT JOIN user AS u ON p.author = u.id "
			+ "LEFT JOIN comment AS c ON c.post = p.id "
			+ "WHERE p.type = 'post' "
			+ "AND p.status = 'publish' "
			+ "AND p.published < NOW() "
			+ "GROUP BY p.id "
			+ "ORDER BY p.published DESC "
			+ "LIMIT 5")
	@Results({ @Result(column = "name", property = "author.name") })
	public List<Post> readPosts();
}
