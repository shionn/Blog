package shionn.blog.db.dao.frag;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.Tag;

public interface ContentDao extends LastCommentDao, MenuDao, TagCloodDao{

	@Select("SELECT t.title, t.url "
			+ "FROM posttags AS p "
			+ "LEFT JOIN tag AS t ON p.tag = t.id "
			+ "WHERE p.post = #{post} "
			+ "ORDER BY t.title")
	public List<Tag> readTags(@Param("post") int post);

	@Insert("INSERT INTO stat (ip, path, time) VALUES (#{ip}, #{path}, NOW())")
	public int insertStat(@Param("ip") String ip, @Param("path") String path);
}
