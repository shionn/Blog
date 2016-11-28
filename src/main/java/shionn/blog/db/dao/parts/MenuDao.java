package shionn.blog.db.dao.parts;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import shionn.blog.db.dbo.Menu;

public interface MenuDao {

	@Select("SELECT id, parent, title, url FROM menu WHERE parent=#{id} order by position")
	@Results({
			@Result(column = "id", property = "items", many = @Many(fetchType = FetchType.EAGER, select = "readMenu")) })
	public Menu readMenu(@Param("id") int menu);
}
