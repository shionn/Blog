package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import shionn.blog.db.dbo.Post;
import shionn.blog.db.dbo.Tag;

public interface HomeDao {

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
			+ "GROUP BY p.id "
			+ "ORDER BY p.published DESC "
			+ "LIMIT 5")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "u.name", property = "author.name"),
			@Result(column = "cat_title", property = "category.title"),
			@Result(column = "cat_url", property = "category.url"),
			@Result(column = "id", property = "tags", many = @Many(select = "readTags", fetchType = FetchType.EAGER)) })
	public List<Post> readPosts();
	
	@Select("SELECT t.title, t.url "
			+ "FROM posttags AS p "
			+ "LEFT JOIN tag AS t ON p.tag = t.id "
			+ "WHERE p.post = #{post} "
			+ "ORDER BY t.title")
	public List<Tag> readTags( @Param("post") int post);
}
