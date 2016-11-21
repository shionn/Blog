package shionn.blog.db.dao;

public interface AuthenticationDao {

	void isValid(String name, Object credentials);

}
