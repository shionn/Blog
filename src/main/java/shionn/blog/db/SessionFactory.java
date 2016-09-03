package shionn.blog.db;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
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

//	@Inject
	private Logger logger;

//	@Produces
//	@RequestScoped
	public SqlSession open() {
		SqlSession session = factory().openSession();
		logger.debug("Session " + session.hashCode() + " opened");
		return session;
	}

//	public void close(@Disposes SqlSession session) {
//		logger.debug("Session " + session.hashCode() + " closed");
//		try {
//			session.rollback();
//		} finally {
//			session.close();
//		}
//	}
}
