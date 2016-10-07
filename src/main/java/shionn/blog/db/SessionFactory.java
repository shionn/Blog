package shionn.blog.db;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Controller
public class SessionFactory {

	private static class Holder {
		private static final Holder instance = new Holder();

		private SqlSessionFactory factory = build();

		private SqlSessionFactory build() {
			return new SqlSessionFactoryBuilder().build(Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("mybatis.xml"));
		}
	}

	private SqlSessionFactory factory() {
		return Holder.instance.factory;
	}

	@Autowired
	private Logger logger;

	@Bean
	@Scope(value = "request")
	public SqlSession open() {
		SqlSession session = factory().openSession();
		logger.debug("Session " + session.hashCode() + " opened");
		return session;
	}

	// public void close(@Disposes SqlSession session) {
	// logger.debug("Session " + session.hashCode() + " closed");
	// try {
	// session.rollback();
	// } finally {
	// session.close();
	// }
	// }
}
