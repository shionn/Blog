package shionn.blog.content.menu;

import java.util.Arrays;

import shionn.blog.db.dbo.Menu;

public class StaticMenu {

	public Menu build() {
		Menu menu = one("home", "/");
		menu.setItems(
				Arrays.asList(one("Accueil", "/"), radiomodelisme(),
						one("slick2d", "/category/slick2d"), one("projets", "/category/projects"),
						one("contact", "mailto:shionn@gmail.com")));
		return menu;
	}

	private Menu radiomodelisme() {
		Menu menu = one("radiomedélisme", "/category/radiomodelisme");
		menu.setItems(Arrays.asList(one("Mes Bolides", "/page/mes-bolides")));
		return menu;
	}

	private Menu one(String title, String url) {
		Menu menu = new Menu();
		menu.setTitle(title);
		menu.setUrl(url);
		return menu;
	}

}
