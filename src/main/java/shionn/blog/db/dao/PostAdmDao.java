package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.Post;

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
	
	@Insert("INSERT INTO backup-post "
			+ "(id, url, status, type, author, published, updated, title, content) "
			+ "SELECT id, url, status, type, author, published, updated, title, content "
			+ "FROM post WHERE id = #{id}")
	int backup(int id);

}
