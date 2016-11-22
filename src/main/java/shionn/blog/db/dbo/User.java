package shionn.blog.db.dbo;

import java.util.Date;

public class User {

	private int id;
	private Date created;
	private String password;
	private String email;
	private String name;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
