package shionn.blog.adm;

import java.io.Serializable;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import shionn.blog.db.dao.PostAdmDao;
import shionn.blog.db.dbo.Post;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PostAdmFilters implements Serializable {
	private static final long serialVersionUID = 6041120222740960067L;

	private PostAdmDao.SortBy sortBy = PostAdmDao.SortBy.updated;
	private PostAdmDao.SortOrder sortOrder = PostAdmDao.SortOrder.DESC;
	private Post.Status status = Post.Status.draft;
	private Post.Type type = Post.Type.post;

	public PostAdmDao.SortBy getSortBy() {
		return sortBy;
	}

	public void setSortBy(PostAdmDao.SortBy sortBy) {
		this.sortBy = sortBy;
	}

	public Post.Status getStatus() {
		return status;
	}

	public void setStatus(Post.Status status) {
		this.status = status;
	}

	public Post.Type getType() {
		return type;
	}

	public void setType(Post.Type type) {
		this.type = type;
	}

	public PostAdmDao.SortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(PostAdmDao.SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

}
