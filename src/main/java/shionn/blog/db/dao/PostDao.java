package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import shionn.blog.db.dao.frag.LastCommentDao;
import shionn.blog.db.dao.frag.MenuDao;
import shionn.blog.db.dao.frag.TagCloodDao;
import shionn.blog.db.dbo.Comment;
import shionn.blog.db.dbo.Post;
import shionn.blog.db.dbo.Tag;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
public interface PostDao extends LastCommentDao, MenuDao, TagCloodDao {

	@Select("SELECT p.id, p.url, p.title, p.published, p.updated, p.content, "
			+ "u.name as author_name, count(c.id) AS comment_count, "
			+ "cat.url AS cat_url, cat.title AS cat_title "
			+ "FROM post AS p "
			+ "LEFT JOIN user AS u ON p.author = u.id "
			+ "LEFT JOIN category AS cat ON cat.id = p.category "
			+ "LEFT JOIN comment AS c ON c.post = p.id "
			+ "WHERE p.url = #{url} "
			+ "GROUP BY p.id ")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "author_name", property = "author.name"),
			@Result(column = "cat_title", property = "category.title"),
			@Result(column = "cat_url", property = "category.url"),
			@Result(column = "id", property = "tags", many = @Many(select = "readTags", fetchType = FetchType.EAGER)),
			@Result(column = "id", property = "comments", many = @Many(select = "readComments", fetchType = FetchType.EAGER)), })
	Post readPost(String url);

	@Select("SELECT t.title, t.url "
			+ "FROM posttags AS p "
			+ "LEFT JOIN tag AS t ON p.tag = t.id "
			+ "WHERE p.post = #{post} "
			+ "ORDER BY t.title")
	List<Tag> readTags(@Param("post") int post);
	
	@Select("SELECT IFNULL(u.name, c.author_name) AS author_name, "
			+ "c.author_email, c.author_web, c.date, c.content "
			+ "FROM comment AS c "
			+ "LEFT JOIN user AS u ON c.author = u.id "
			+ "WHERE c.post = #{post} "
			+ "ORDER BY c.date ASC")
	List<Comment> readComments(@Param("post") int post);

	@Insert("INSERT into comment(post, author, author_name, author_email, author_web, date, content, ip) "
			+ "VALUES ( (SELECT id from post where url= #{url}), "
			+ "NULL, "
			+ "#{comment.authorName},"
			+ "#{comment.authorEmail}, "
			+ "#{comment.authorWeb},"
			+ "NOW(),"
			+ "#{comment.content},"
			+ "'azerty' )")
	void saveComment(@Param("comment") Comment comment, @Param("url") String url);

}
