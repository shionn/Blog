package shionn.blog.db.dao.adm;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import shionn.blog.db.dbo.Comment;

public interface CommentAdmDao {

	@Select("SELECT c.id, c.author_name, c.author_email, c.content, c.date, c.ip, c.post, "
			+ "p.title AS post_title,  p.url AS post_url "
			+ "FROM comment AS c "
			+ "LEFT JOIN post AS p ON c.post = p.id "
			+ "ORDER BY c.date DESC")
	@Results({ @Result(column = "post_title", property = "post.title"),
			@Result(column = "post", property = "post.id"),
			@Result(column = "post_url", property = "post.url")})
	List<Comment> list();

	@Select("SELECT * FROM comment WHERE id = #{id}")
	Comment get(int id);

	@Update("UPDATE comment "
			+ "SET author_name = #{authorName}, author_email = #{authorEmail}, author_web = #{authorWeb}, "
			+ "content = #{content}, date = #{date}, "
			+ "ip = #{ip} "
			+ "WHERE id = #{id}")
	void save(Comment comment);

}
