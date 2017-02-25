package shionn.blog.security;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.annotation.RequestScope;

import shionn.blog.db.dao.AuthenticationDao;
import shionn.blog.db.dbo.User;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Configuration
public class CurrentUserFactory {

	@Autowired
	private SqlSession session;

	@Bean
	@RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
	public User buildAuthentifiedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return session.getMapper(AuthenticationDao.class).readUser(auth.getName());
	}

}
