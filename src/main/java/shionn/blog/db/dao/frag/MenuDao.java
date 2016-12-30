package shionn.blog.db.dao.frag;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import shionn.blog.db.dbo.Menu;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
public interface MenuDao {

	@Select("SELECT id, parent, title, url FROM menu WHERE id=#{id} order by position")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "items", many = @Many(fetchType = FetchType.EAGER, select = "readChildsMenu")) })
	public Menu readMenu(@Param("id") int id);

	@Select("SELECT id, parent, title, url FROM menu WHERE parent=#{parent} order by position")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "items", many = @Many(fetchType = FetchType.EAGER, select = "readChildsMenu")) })
	public List<Menu> readChildsMenu(@Param("parent") int id);

}
