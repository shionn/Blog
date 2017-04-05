package shionn.blog.db.dao.adm;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import shionn.blog.db.dbo.Post;
import shionn.blog.db.dbo.Tag;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 * 
 *         Dao pour l'edition des articles
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

	@Select("SELECT p.*, c.title AS cat_title FROM post AS p "
			+ "LEFT JOIN category AS c ON p.category = c.id "
			+ "WHERE p.id = #{id}")
	@Results({ @Result(column = "id", property = "id"), 
			@Result(column = "category", property = "category.id"),
			@Result(column = "cat_title", property = "category.title"),
			@Result(column = "id", property = "tags", many = @Many(select = "readTags", fetchType = FetchType.EAGER)) })
	Post get(int id);
	
	@Insert("INSERT INTO backup_post "
			+ "(id, url, status, type, author, published, updated, title, content, category, logo) "
			+ "SELECT id, url, status, type, author, published, updated, title, content, category, logo "
			+ "FROM post WHERE id = #{id}")
	int backup(int id);

	@Update("UPDATE post "
			+ "SET title = #{title}, content = #{content}, url = #{url}, "
			+ "type = #{type}, status = #{status}, published = #{published}, updated = NOW(), "
			+ "category = #{category.id}, logo = #{logo} "
			+ "WHERE id= #{id} ")
	int save(Post post);

	@Insert("INSERT INTO post (url, status, type, author, published, updated, title, content) "
			+ "VALUES ( #{url}, 'draft', #{type}, #{author.id}, null, NOW(), #{title}, #{content} )")
	int create(Post post);

	@Select("SELECT t.id, t.title, t.url, (CASE WHEN p.post IS NULL THEN 0 ELSE 1 END) as postcount " + "FROM tag AS t "
			+ "LEFT JOIN posttags AS p ON p.tag = t.id " + "AND (p.post = #{post} OR p.post IS NULL) "
			+ "ORDER BY t.title")
	List<Tag> readTags(@Param("post") int post);

	@Delete("DELETE FROM posttags WHERE post = #{post}")
	int deleteTags(int post);

	@Insert("INSERT INTO posttags (post, tag) VALUES (#{post}, #{tag})")
	int addTag(@Param("post") int post, @Param("tag") int tag);

}
