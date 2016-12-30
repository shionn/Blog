package shionn.blog.db.dao.frag;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.Tag;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
public interface TagCloodDao {

	@Select("SELECT t.id, t.title, t.url, count(p.post) AS post_count "
			+ "FROM posttags AS p "
			+ "LEFT JOIN tag AS t ON p.tag = t.id "
			+ "GROUP BY t.id "
			+ "ORDER BY post_count DESC, title ASC")
	List<Tag> readCloodTags();

}
