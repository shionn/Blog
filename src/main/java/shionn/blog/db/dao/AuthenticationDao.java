package shionn.blog.db.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import shionn.blog.db.dbo.User;

public interface AuthenticationDao {

	@Select("SELECT id, email, password, created "
			+ "FROM user "
			+ "WHERE email = #{email}")
	User readUser(@Param("email") String email);

}
