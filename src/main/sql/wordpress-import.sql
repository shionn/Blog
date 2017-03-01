

-- import des utilisateurs -- 
SET SESSION sql_mode='NO_AUTO_VALUE_ON_ZERO';
insert into user (id, email, name, password, status, created, web)
select w.id as id, w.user_email as email, w.display_name as name,
'TODO' as password, 'active' as status, w.user_registered as created, 
user_url as web
from wp_users AS w 
left join user AS u ON u.id=w.id 
WHERE u.id is null and w.user_status=0;
-- azerty
update user set password='ad16678292e6d9d19a05b74946b5a5643e3191e6436023f8bc10d5499bbc65444e87484334131d539e17b12738623cd65e378f8303f63314e8774ba71425f070' where email = 'shionn@gmail.com';

-- import des category
SET SESSION sql_mode='NO_AUTO_VALUE_ON_ZERO';
insert into category (id, parent, title, url) values (0, null, 'root', 'root');
insert into category (id, parent, title, url)
select t.term_id as id, parent, name as title, slug as url
from wp_terms as t 
left join wp_term_taxonomy AS tt on t.term_id = tt.term_id
where tt.taxonomy = 'category'
order by parent;

-- import des posts --
SET SESSION sql_mode='NO_AUTO_VALUE_ON_ZERO';
insert into post (id, url, status, type, author, published, updated, title, content, category)
select w.id as id, 
  if (w.post_name = '', w.id, w.post_name) as `url`,
  post_status as status,
  post_type as type, post_author as author, post_date as published, post_modified AS updated, 
  post_title as title, post_content AS content, 
  0 as category -- semble difficile une migration manuel est préférable duplication de post sinon
from wp_posts AS w 
left join post AS p ON p.id=w.id 
WHERE p.id is null 
and w.post_type in ('post','page');

update post set status = 'draft' where status = 'auto-draft';
update post set status = 'publish' where status = 'private';

-- import des commentaires --
SET SESSION sql_mode='NO_AUTO_VALUE_ON_ZERO';
insert into comment (id, post, author, author_name, author_email, author_web, `date`, content, ip)
select w.comment_ID as id, w.comment_post_ID as post, if(w.user_id = 0, NULL, w.user_id) AS author,
w.comment_author as author_name, w.comment_author_email as author_email, w.comment_author_url AS author_web, 
w.comment_date as date, w.comment_content as content, w.comment_author_IP as ip
from wp_comments as w
LEFT JOIN comment as c on c.id = w.comment_ID
LEFT JOIN post AS p on p.id = w.comment_post_ID
WHERE w.comment_approved = '1'
AND c.id is NULL
AND p.id is not null; 
-- certain commentaire sont sur des images. 

-- import des tag
SET SESSION sql_mode='NO_AUTO_VALUE_ON_ZERO';
INSERT INTO tag (id, title, url) 
SELECT t.term_id AS id, t.name AS title, t.slug AS url FROM wp_term_taxonomy as tt 
LEFT JOIN wp_terms as t on tt.term_id = t.term_id 
WHERE tt.taxonomy = 'post_tag';

-- import des lien tag - post
SET SESSION sql_mode='NO_AUTO_VALUE_ON_ZERO';
INSERT INTO posttags (tag, post)
SELECT tt.term_id AS tag, p.ID AS post
FROM wp_term_relationships AS tr
LEFT join wp_term_taxonomy as tt on tt.term_taxonomy_id = tr.term_taxonomy_id
LEFT join post as p on tr.object_id = p.id 
LEFT join tag AS t on tt.term_id = t.id
WHERE tt.taxonomy = 'post_tag'
AND p.id is not null;

