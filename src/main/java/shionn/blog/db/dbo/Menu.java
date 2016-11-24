package shionn.blog.db.dbo;

import java.util.List;


public class Menu {

	private List<Menu> items;
	private String title;
	private String url;
	private boolean current;

	public void setItems(List<Menu> items) {
		this.items = items;
	}

	public List<Menu> getItems() {
		return items;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public Menu current(String path) {
		if (path.equals(url)) {
			this.setCurrent(true);
		} else {
			for (Menu child : items) {
				child.current(path);
			}
		}
		return this;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public boolean isCurrent() {
		return current;
	}
}

