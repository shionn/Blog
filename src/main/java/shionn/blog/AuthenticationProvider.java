package shionn.blog;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;

import shionn.blog.db.dao.AuthenticationDao;

@Controller
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

	@Autowired
	private SqlSession session;

	private String salt = "salt";

	@Override
	public boolean supports(Class<?> type) {
		return type == UsernamePasswordAuthenticationToken.class;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		session.getMapper(AuthenticationDao.class).isValid((String) token.getPrincipal(), token.getCredentials());
		return authentication;
	}
}
