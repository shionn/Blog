
-- import des utilisateurs -- 
insert into user (id, email, name, password, status, created)
select w.id as id, w.user_email as email, w.display_name as name,
'TODO' as password, 'active' as status, w.user_registered as created
from wp_users AS w 
left join user AS u ON u.id=w.id 
WHERE u.id is null and w.user_status=0;

update user set password='7be50c6aae87bc627a523cb502ddcc1ebd92fbbc' where email = 'shionn@gmail.com';

-- import des posts --
insert into post (id, url, status, type, author, published, updated, title, content)
select w.id as id, 
  if (w.post_name = '', w.id, w.post_name) as url,
  post_status as status,
  post_type as type, post_author as author, post_date as published, post_modified AS updated, 
  post_title as title, post_content AS content
from wp_posts AS w 
left join post AS p ON p.id=w.id 
WHERE p.id is null and w.post_type in ('post','page');

update post set status = 'draft' where status = 'auto-draft';
update post set status = 'publish' where status = 'private';

-- import des commentaires --
insert into comment (id, post, author, author_name, author_email, author_web, `date`, content, ip)
select w.comment_ID as id, w.comment_post_ID as post, if(w.user_id = 0, NULL, w.user_id) AS author,
w.comment_author as author_name, w.comment_author_email as author_email, w.comment_author_url AS author_web, 
w.comment_date as date, w.comment_content as content, w.comment_author_IP as ip
from wp_comments as w
LEFT JOIN comment as c on c.id = w.comment_ID
LEFT join post AS p on p.id = w.comment_post_ID
WHERE w.comment_approved = '1'
AND c.id is NULL
AND p.id is not null; -- certain commentaire sont sur des images. 

select * from wp_terms as t left join wp_term_taxonomy AS tt on t.term_id = tt.term_id
where tt.taxonomy = 'category';
