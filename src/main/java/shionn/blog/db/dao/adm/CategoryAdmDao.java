package shionn.blog.db.dao.adm;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import shionn.blog.db.dbo.Category;

public interface CategoryAdmDao {

	@Select("select * from category order by parent, title")
	@Results({ @Result(column = "parent", property = "parent.id") })
	List<Category> list();

	@Select("select * from category where id = #{id}")
	@Results({ @Result(column = "parent", property = "parent.id") })
	Category get(int id);

	@Update("UPDATE category "
			+ "SET title = #{title}, url = #{url}, parent = #{parent.id} "
			+ "WHERE id = #{id}")
	int save(Category category);

	@Select("select * from category where title like #{title}")
	List<Category> find(String title);

}
