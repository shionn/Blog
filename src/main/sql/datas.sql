-- menu

insert into menu (id, parent, position, title, url)
values 
(0, NULL, 0, "Menu", "/"),
(1, 0, 0, "Acceuil", "/"),
(2, 0, 1, "Radiomodélisme", "/category/radiomodelisme"),
(3, 0, 2, "Slick 2D", "/category/slick2d"),
(4, 0, 3, "Informatique", "/category/informatique"),
(5, 0, 4, "Contact", "mailto:shionn@gmail.com"),

(10, 2,  0, "Mes Bolides", "/page/mes-bolides"),
(11, 10, 0, "3Racing F109", "/category/radiomodelisme/3racing-f109"),
(12, 10, 1, "3Racing Sakura D3", "/category/radiomodelisme/3racing-sakura-d3"),
(13, 10, 2, "Axial SCX F-150","/category/radiomodelisme/axial-scx-f-150"),
(14, 10, 3, "Camion RC Rally Man","/category/radiomodelisme/camion-rc-rally-man"),
(15, 10, 4, "Durango DESC210","/category/radiomodelisme/durango-desc210"),
(16, 10, 5, "Tamiya F104 VerII Pro","/category/radiomodelisme/tamiya-f104-verii-pro"),
(17, 10, 6, "Tamiya Scania R470","/category/radiomodelisme/tamiya-scania-r470"),
(18, 10, 7, "Tamiya TA02T","/category/radiomodelisme/tamiya-ta02t"),
(19, 10, 8, "Tamiya TB03VDS","/category/radiomodelisme/tamiya-tb-03-vds"),
(20, 10, 9, "TeamC TC02","/category/radiomodelisme/teamc-tc02"),

(21, 2,  1, "Test Matos RC", "/category/radiomodelisme/test-materiel-rc"),
(22, 21, 0, "Servo PowerHD 1207TG", "/servo-powerhd-1207tg"),
(23, 21, 1, "Team Magic Touring Car Bag &amp; Transmitter", "/team-magic-touring-car-bag-transmitter-review"),

(24,  2, 2, "Tutoriels", "/radiomodelisme-tutoriel"),
(25, 24, 0, "Entretiens d’un différentiel à bille", "/entretien-differentiel-a-bille"),
(26, 24, 1, "Fabrication d’insert", "/tutorial-fabrication-d-insert"),
(27, 24, 2, "Intégrer le bec sur un TEU104Bk", "/tutoriel-integrer-le-bec-sur-un-teu104bk"),

(28,  2, 3, "Guide du Débutant", "/category/radiomodelisme/guide"),
(29, 28, 0, "Lexique du Débutant en RC", "/lexique-du-debutant-en-rc"),
(30, 28, 1, "Comparaison Tamiya TT01/E/D", "/comparaison-tamiya-tt01ed"),
(31, 28, 2, "Moteurs Tamiya", "/moteurs-tamiya"),

(40, 3,  0, "Divers", "/category/slick2d"),
(41, 40, 0, "Sommaire", "/tutoriels-slick-2d"),
(42, 40, 1, "Slick2d @ HumanTalks Genève", "/ht-geneve-slick2d"),
(43, 40, 2, "SlickUtils", "/slickutils"),

(44, 3,  1, "Leçons 1-9", "/category/slick2d/slick2d-part1"),
(45, 44, 0, "Leçon 1 : Création d’une fenêtre", "/slick2d-lesson-1-window-creation"),
(46, 44, 1, "Leçon 2 : Affichage d’une carte", "/slick2d-lesson-2-map-display"),
(47, 44, 2, "Leçon 3 : Animer et Déplacer un Personnage", "/slick2d-lesson-3-animate-and-move"),
(48, 44, 3, "Leçon 4 : Une Camera", "/slick2d-lesson-4-une-camera"),
(49, 44, 4, "Leçon 5 : Collision &amp; Avant plan", "/slick2d-lesson-5-collision-avant-plan"),
(50, 44, 5, "Leçon 6 : Les Triggers", "/slick2d-lesson-6-les-triggers"),
(51, 44, 6, "Leçon 7 : La musique", "/slick2d-lesson-7-music"),
(52, 44, 7, "Leçon 8 : Distribution", "/lesson-8-jar-execute-slick"),
(53, 44, 8, "Leçon 9 : Changement de Carte", "/slick2d-lecon-9-changement-de-carte"),

(54, 3,  2, "Leçons 10-19", "/category/slick2d/slick2d-part2"),
(55, 54, 0, "Leçon 10 : Séparation en objet (1/2)", "/slick2d-lecon-10-separation-en-objet"),
(56, 54, 1, "Leçon 11 : Séparation en objet (2/2)", "/slick2d-lecon-11-separation-en-objets-suite"),
(57, 54, 2, "Leçon 12 : Contrôle avec un Joystick", "/slick2d-lecon-12-controle-avec-un-joystick"),
(58, 54, 3, "Leçon 13 : Afficher un HUD", "/slick2d-lecon-13-afficher-un-hud"),
(59, 54, 4, "Leçon 14 : Déplacement Analogique", "/slick2d-lecon-14-deplacement-analogique"),
(60, 54, 5, "Leçon 15 : Les phases de jeux", "/slick2d-lecon-15-plusieurs-ecrans"),
(61, 54, 6, "Leçon 16 : Les combats au tour par tour (1/6)", "/slick2d-lecon-16-les-combats-au-tour-par-tour-1x"),
(62, 54, 7, "Leçon 17 : Les combats au tour par tour (2/6)", "/slick2d-lecon-17-les-combats-tour-par-tour-2x"),
(63, 54, 8, "Leçon 18 : Les combats aux tour par tour (3/6)", "/slick2d-lecon-18-les-combats-tour-par-tour-3x"),
(64, 54, 9, "Leçon 19 : Les combats aux tour par tour (4/6)", "/slick2d-lecon-19-les-combats-aux-tour-par-tour-4x"),

(65, 3,  3, "Leçons 20-29", "/category/slick2d/slick2d-lecons-20-29"),
(66, 65, 0, "Leçon 20 : Les combats aux tour par tour (5/6)", "/slick2d-lecon-20-les-combats-aux-tour-par-tour-5x"),
(67, 65, 0, "Leçon 21 : Les combats aux tour par tour (6/6)", "/slick2d-lecon-21-les-combats-aux-tour-par-tour-66"),

(90, 4,  0, "Tuto JavaEE", "/category/informatique/javaee"),
(91, 90, 0, "Leçon 1 : Introduction", "/rest-over-tomcat-lesson-1"),
(92, 90, 1, "Leçon 2 : Un service de message", "/rest-over-tomcat-lesson-2"),
(93, 90, 2, "Leçon 3 : Persistance avec OpenJPA", "/rest-over-tomcat-lesson-3-openjpa"),
(94, 90, 3, "Resteasy / Weld / Tomcat7", "/resteasy-weld-tomcat7"),

(95, 4,  1, "Algorithme", "/category/informatique/algorithme"),
(96, 95, 0, "Donjon Aléatoire", "/algorihtme-donjon-aleatoire"),

(97, 4,  2, "Raspberry Pi", "/category/informatique/raspberry-pi"),
(98, 97, 0, "Rétro Gaming-Box", "/retro-gaming-box-sur-raspberry-pi"),

(99,   4, 3, "Projets", "/category/informatique/projet"),
(100, 99, 0, "Mtg DB", "/mtg-db-magic-the-gathering-database"),
(101, 99, 1, "W40k Web Army Editor", "/warhammer-40k-web-army-editor"),
(102, 99, 2, "DotModeler", "/dotmodeler"),
(103, 99, 3, "Hebergement", "/hebergement"),
(104, 99, 4, "Ce Blog", "/java-blog"),

(120, 5, 0, "shionn@gmail.com", "mailto:shionn@gmail.com"),
(121, 5, 1, "Facebook", "https://www.facebook.com/shionn"),
(122, 5, 2, "Twitter @shionn", "https://twitter.com/shionn");










