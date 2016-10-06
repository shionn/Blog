package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.Post;

public interface PostAdmDao {

	@Select("SELECT id, url, status, type, author, published, updated, title "
			+ "FROM post "
			+ "ORDER BY updated DESC")
	List<Post> list();
	
}
