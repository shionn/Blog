package shionn.blog.security;

import java.text.SimpleDateFormat;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;

import shionn.blog.db.dao.AuthenticationDao;
import shionn.blog.db.dbo.User;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
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
		User user = session.getMapper(AuthenticationDao.class).readUser((String) authentication.getPrincipal());
		if (user != null && checkPassword((UsernamePasswordAuthenticationToken) authentication, user)) {
			authentication = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
					authentication.getCredentials(),
					AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
		} else {
			throw new BadCredentialsException("msg");
		}
		return authentication;
	}

	private boolean checkPassword(UsernamePasswordAuthenticationToken token, User user) {
		return user.getPassword().equals(encodePassword(token, user));
	}

	private String encodePassword(UsernamePasswordAuthenticationToken token, User user) {
		String encoded = DigestUtils
				.sha1Hex(new SimpleDateFormat("yyyyMMdd").format(user.getCreated()) + token.getCredentials() + salt);
		System.out.println(encoded);
		return encoded;
	}
}
