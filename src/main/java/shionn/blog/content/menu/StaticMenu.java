package shionn.blog.content.menu;

import java.util.Arrays;

import shionn.blog.db.dbo.Menu;

public class StaticMenu {

	public Menu build() {
		Menu menu = one("home", "/");
		menu.setItems(Arrays.asList(one("Accueil", "/"), radiomodelisme(), one("slick2d", "/category/slick2d"),
				one("projets", "/category/projects"), one("contact", "mailto:shionn@gmail.com")));
		return menu;
	}

	private Menu radiomodelisme() {
		Menu menu = one("radiomedélisme", "/category/radiomodelisme");
		menu.setItems(Arrays.asList(mesbolides(), testMatosRc(), tutoriel(), guideDuDebutant()));
		return menu;
	}

	private Menu mesbolides() {
		Menu menu = one("Mes Bolides", "/page/mes-bolides");
		menu.setItems(Arrays.asList(one("3Racing F109", "/category/radiomodelisme/3racing-f109"),
				one("3Racing Sakura D3", "/category/radiomodelisme/3racing-sakura-d3"),
				one("Axial SCX F-150", "/category/radiomodelisme/axial-scx-f-150"),
				one("Camion RC Rally Man", "/category/radiomodelisme/camion-rc-rally-man"),
				one("Durango DESC210", "/category/radiomodelisme/durango-desc210"),
				one("Tamiya F104 VerII Pro", "/category/radiomodelisme/tamiya-f1-chassis/tamiya-f104-verii-pro"),
				one("Tamiya Scania R470", "/category/radiomodelisme/tamiya-scania-r470"),
				one("Tamiya TA02T", "/category/radiomodelisme/tamiya-ta02t"),
				one("Tamiya TB03VDS", "/category/radiomodelisme/tamiya-tb-03-vds"),
				one("TeamC TC02", "/category/radiomodelisme/teamc-tc02")));
		return menu;
	}

	private Menu testMatosRc() {
		Menu menu = one("Test Matos RC", "/category/radiomodelisme/test-materiel-rc");
		menu.setItems(Arrays.asList(one("Servo PowerHD 1207TG", "/servo-powerhd-1207tg"),
				one("Team Magic Touring Car Bag &amp; Transmitter", "/team-magic-touring-car-bag-transmitter-review")));
		return menu;
	}

	private Menu tutoriel() {
		Menu menu = one("tutoriel", "/category/radiomodelisme/tutoriel");
		menu.setItems(Arrays.asList(one("Entretiens d’un différentiel à bille", "/entretien-differentiel-a-bille"),
				one("Fabrication d’insert", "/tutorial-fabrication-d-insert"),
				one("Intégrer le bec sur un TEU104Bk", "/tutoriel-integrer-le-bec-sur-un-teu104bk")));
		return menu;
	}

	private Menu guideDuDebutant() {
		Menu menu = one("Guide du Débutant", "/category/radiomodelisme/guide");
		menu.setItems(Arrays.asList(one("Lexique du Débutant en RC", "/lexique-du-debutant-en-rc"),
				one("Comparaison Tamiya TT01/E/D", "/comparaison-tamiya-tt01ed"),
				one("Moteurs Tamiya", "/moteurs-tamiya")));
		return menu;
	}

	private Menu one(String title, String url) {
		Menu menu = new Menu();
		menu.setTitle(title);
		menu.setUrl(url);
		return menu;
	}

}
