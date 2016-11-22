package shionn.blog.security;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import shionn.blog.db.dbo.User;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CurrentUser {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
