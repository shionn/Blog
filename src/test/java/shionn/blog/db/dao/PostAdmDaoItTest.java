package shionn.blog.db.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import shionn.blog.db.SessionFactory;
import shionn.blog.db.dao.adm.PostAdmDao;
import shionn.blog.db.dao.adm.PostAdmDao.SortBy;
import shionn.blog.db.dao.adm.PostAdmDao.SortOrder;
import shionn.blog.db.dbo.Post;
import shionn.blog.db.dbo.Post.Status;
import shionn.blog.db.dbo.Post.Type;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@RunWith(MockitoJUnitRunner.class)
public class PostAdmDaoItTest {

	@Mock
	private org.slf4j.Logger logger;

	@InjectMocks
	private SessionFactory factory;

	@Test
	public void testList() {
		try (SqlSession session = factory.open()) {
			assertThat(session.getMapper(PostAdmDao.class).list(Type.post, Status.publish,
					SortBy.published, SortOrder.ASC)).isNotEmpty();

		}
	}

	@Test
	public void testGet() {
		try (SqlSession session = factory.open()) {
			PostAdmDao dao = session.getMapper(PostAdmDao.class);
			Post post = dao.get(2584);
			assertThat(post).isNotNull();
			assertThat(post.getCategory().getTitle()).isNotEmpty();
		}
	}

}
