package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import shionn.blog.db.dbo.Post;

/**
 * Dao pour l'edition des articles
 *
 */
public interface PostAdmDao {
	public static enum SortBy {
		published, updated
	}

	public static enum SortOrder {
		ASC, DESC;

		public SortOrder reverse() {
			return this == ASC ? DESC : ASC;
		}
	}

	@Select("SELECT id, url, status, type, author, published, updated, title "
			+ "FROM post "
			+ "WHERE type = #{type} AND status = #{status} "
			+ "ORDER BY ${sort} ${order}")
	List<Post> list(@Param("type") Post.Type type, @Param("status") Post.Status status,
			@Param("sort") SortBy sort, @Param("order") SortOrder order);

	@Select("SELECT * FROM post where id = #{id}")
	Post get(int id);
	
	@Insert("INSERT INTO backup_post "
			+ "(id, url, status, type, author, published, updated, title, content) "
			+ "SELECT id, url, status, type, author, published, updated, title, content "
			+ "FROM post WHERE id = #{id}")
	int backup(int id);

	@Update("UPDATE post "
			+ "SET title = #{title}, content = #{content}, url = #{url}, "
			+ "type = #{type}, status = #{status}, published = #{published}, updated = NOW() "
			+ "WHERE id= #{id} ")
	int save(Post post);

	@Insert("INSERT INTO post (url, status, type, author, published, updated, title, content) "
			+ "VALUES ( #{url}, 'draft', #{type}, #{author.id}, null, NOW(), #{title}, #{content} )")
	int create(Post post);

}
