package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.Post;

public interface RssDao {

	@Select("SELECT p.url, p.title, p.published, p.content, u.name "
			+ "FROM post AS p "
			+ "LEFT JOIN user AS u ON p.author = u.id "
			+ "WHERE p.status = 'publish' "
			+ "ORDER BY p.published DESC "
			+ "LIMIT 10")
	@Results({ @Result(column = "u.name", property = "author.name") })
	List<Post> readLastPosts();

}
