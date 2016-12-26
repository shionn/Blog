package shionn.blog.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.Tag;

public interface TagDao {

	@Select("SELECT t.id, t.title, t.url, count(p.post) AS post_count "
			+ "FROM posttags AS p "
			+ "LEFT JOIN tag AS t ON p.tag = t.id "
			+ "GROUP BY t.id "
			+ "ORDER BY post_count DESC, title ASC")
	List<Tag> readWidgetTags();

}
