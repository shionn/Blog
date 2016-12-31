package shionn.blog.db.dbo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
public class Menu {

	private int id;
	private List<Menu> items;
	private String title;
	private String url;
	private boolean active;

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
		if (StringUtils.prependIfMissing(path, "/").equals(url)) {
			this.setActive(true);
		}
		if (items != null) {
			for (Menu child : items) {
				child.current(path);
				if (child.isActive()) {
					this.setActive(true);
				}
			}
		}
		return this;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", title=" + title + "]";
	}

}

