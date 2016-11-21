package shionn.blog.security;

import java.text.SimpleDateFormat;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;

import shionn.blog.db.dao.AuthenticationDao;
import shionn.blog.db.dbo.User;

@Controller
public class AuthenticationProvider
		implements org.springframework.security.authentication.AuthenticationProvider {

	@Autowired
	private SqlSession session;

	private String salt = "salt";

	@Override
	public boolean supports(Class<?> type) {
		return type == UsernamePasswordAuthenticationToken.class;
	}

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		User user = session.getMapper(AuthenticationDao.class)
				.readUser((String) token.getPrincipal());
		if (user != null && checkPassword(token, user)) {
			authentication = new UsernamePasswordAuthenticationToken(token.getPrincipal(),
					token.getCredentials(),
					AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
		}
		return authentication;
	}

	private boolean checkPassword(UsernamePasswordAuthenticationToken token, User user) {
		return user.getPassword().equals(encodePassword(token, user));
	}

	private String encodePassword(UsernamePasswordAuthenticationToken token, User user) {
		String encoded = DigestUtils
				.sha1Hex(new SimpleDateFormat("yyyyMMdd").format(user.getCreated())
						+ token.getCredentials() + salt);
		System.out.println(encoded);
		return encoded;
	}
}
