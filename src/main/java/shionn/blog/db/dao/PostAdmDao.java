package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.Post;

public interface PostAdmDao {
	public static enum SortBy {
		published, updated
	}

	@Select("SELECT id, url, status, type, author, published, updated, title "
			+ "FROM post "
			+ "WHERE type = #{type} AND status = #{status} "
			+ "ORDER BY ${sort} DESC")
	List<Post> list(@Param("type") Post.Type type, @Param("status") Post.Status status,
			@Param("sort") SortBy sort);
	
}
