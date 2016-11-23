package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.Post;

public interface HomeDao {

	@Select("SELECT p.url, p.title, p.published, p.updated, p.content, "
			+ "u.name "
			+ "FROM post AS p "
			+ "LEFT JOIN user AS u ON p.author = u.id "
			+ "WHERE p.type = 'post' "
			+ "AND p.status = 'publish' "
			+ "AND p.published < NOW() "
			+ "ORDER BY p.published DESC "
			+ "LIMIT 5")
	@Results({ @Result(column = "name", property = "author.name") })
	public List<Post> readPosts();
}
