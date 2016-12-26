
--- user ---
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(128) CHARACTER SET utf8 NOT NULL,
  `password` varchar(256) CHARACTER SET utf8 NOT NULL,
  `name` varchar(128) CHARACTER SET utf8 NOT NULL,
  `status` varchar(32) CHARACTER SET utf8 NOT NULL,
  `created` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `status` (`status`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

--- category ---
CREATE TABLE IF NOT EXISTS category (
  id int(11) NOT NULL AUTO_INCREMENT,
  parent int(11) NULL,
  title varchar(64) NOT NULL,
  url varchar(64) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (url),
  CONSTRAINT parent_category FOREIGN KEY (parent) REFERENCES category (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

--- post ---
CREATE TABLE IF NOT EXISTS `post` (
  id int(11) NOT NULL AUTO_INCREMENT,
  url varchar(128) CHARACTER SET utf8 NOT NULL,
  status varchar(32) NOT NULL,
  `type` varchar(32) NOT NULL,
  author int(11) NOT NULL,
  published datetime NOT NULL,
  updated timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  title varchar(128) CHARACTER SET utf8 NOT NULL,
  content longtext NOT NULL,
  category int(11) NULL,
  PRIMARY KEY (id),
  UNIQUE KEY url (url, `type`),
  CONSTRAINT wtrite_by FOREIGN KEY (author) REFERENCES `user` (id),
  CONSTRAINT into_category FOREIGN KEY (category) REFERENCES category (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

--- COMMENT ---
CREATE TABLE IF NOT EXISTS `comment` (
  id int(11) NOT NULL AUTO_INCREMENT,
  post int(11) NOT NULL,
  author int(11) DEFAULT NULL,
  author_name varchar(128) NOT NULL,
  author_email varchar(128) DEFAULT NULL,
  author_web varchar(256) DEFAULT NULL,
  `date` datetime NOT NULL,
  content text NOT NULL,
  ip varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `comment_post` FOREIGN KEY (`post`) REFERENCES `post` (`id`),
  CONSTRAINT `comment_author` FOREIGN KEY (`author`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

--- tag ---
CREATE TABLE IF NOT EXISTS tag (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(64) NOT NULL,
  url varchar(64) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (url)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

--- post-tag ---
CREATE TABLE IF NOT EXISTS posttags (
  post int(11) NOT NULL,
  tag int(11) NOT NULL,
  PRIMARY KEY (post, tag),
  CONSTRAINT `posttags_post` FOREIGN KEY (`post`) REFERENCES `post` (`id`),
  CONSTRAINT `posttags_tag` FOREIGN KEY (`tag`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

--- menu ---
CREATE TABLE IF NOT EXISTS menu (
  id int(11) NOT NULL AUTO_INCREMENT,
  parent int(11) NULL,
  position int(11) NOT NULL,
  title varchar(32) NOT NULL,
  url varchar(128) NOT NULL,
  PRIMARY KEY (id),
  KEY (parent),
  CONSTRAINT parent_menu FOREIGN KEY (parent) REFERENCES menu (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- backup
CREATE TABLE IF NOT EXISTS `backup_post` (
  `backup_id` int(11) NOT NULL AUTO_INCREMENT,
  `backup_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id` int(11) NOT NULL,
  `url` varchar(128) CHARACTER SET utf8,
  `status` varchar(32),
  `type` varchar(32),
  `author` int(11),
  `published` datetime,
  `updated` timestamp NULL,
  `title` varchar(128) CHARACTER SET utf8,
  `content` longtext,
  PRIMARY KEY (`backup_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

