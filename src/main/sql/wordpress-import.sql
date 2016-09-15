
-- import des utilisateurs  
insert into user (id, email, name, password, status, created)
select w.id as id, w.user_email as email, w.display_name as name,
'TODO' as password, 'active' as status, w.user_registered as created
from wp_users AS w 
left join user AS u ON u.id=w.id 
WHERE u.id is null and w.user_status=0;

insert into post (id, url, status, type, author, published, updated, title, content)
select w.id as id, 
if (w.post_name = '', w.id, w.post_name) as url,
post_status as status,
post_type as type, post_author as author, post_date as published, post_modified AS updated, 
post_title as title, post_content AS content
from wp_posts AS w 
left join post AS p ON p.id=w.id 
WHERE p.id is null and w.post_type in ('post','page');
