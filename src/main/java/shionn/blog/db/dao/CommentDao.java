package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.Comment;

public interface CommentDao {

	@Select("SELECT c.author_name, p.title, p.url "
			+ "FROM comment AS c "
			+ "LEFT JOIN post AS p ON c.post = p.id "
			+ "ORDER BY c.date DESC "
			+ "LIMIT 6")
	@Results({
			@Result(column = "title", property = "post.title"),
			@Result(column = "url", property = "post.url") })
	List<Comment> readLastComments();
}
