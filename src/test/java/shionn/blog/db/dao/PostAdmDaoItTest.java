package shionn.blog.db.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import shionn.blog.db.SessionFactory;

@RunWith(MockitoJUnitRunner.class)
public class PostAdmDaoItTest {

	@Mock
	private org.slf4j.Logger logger;

	@InjectMocks
	private SessionFactory factory;

	@Test
	public void testList() {
		try (SqlSession session = factory.open()) {
			assertThat(session.getMapper(PostAdmDao.class).list()).isNotEmpty();

		}
	}

}