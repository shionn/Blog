package shionn.blog.db.dbo;

import java.util.Date;

public class User {

	private Date created;
	private String password;

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getCreated() {
		return created;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

}
