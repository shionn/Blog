# Blog
Moteur de blog en java, developpé initialement pour remplacé mon wordpress. Ce moteur propose : 
* Deux type de contenu **Article** et **Page**, les articles apparaissant sur la page d'acceuil et les pages non. 
* L'écriture des contenus et les commentaires en [CommonMark](http://commonmark.org/)
* Chaque article et page sont dans une seule categorie, mais peuvent pavoir plusieurs tags.  
* Coloration syntaxique des codes java (d'autre à venir)

Plus d'info sur [shionn.org](http://shionn.org). 

# Technique
* Basé sur Spring Web Mvc en servlet 3
* Bdd Mysql, via MyBatis
* Css construite en Less
* Peu de javascript, mais basé sur jquery. 
* CommonMark avec la lib d'[altassian](https://github.com/atlassian/commonmark-java)

# Version des lib frontales :
* Purecss _utilisé pour le backend_ : 0.6.0 
* fontawesome : 4.6.3
*	jquery : 3.1.0
* highlight-9.8.0
