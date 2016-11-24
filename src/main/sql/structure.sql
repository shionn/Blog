
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

--- post ---

CREATE TABLE IF NOT EXISTS `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(128) CHARACTER SET utf8 NOT NULL,
  `status` varchar(32) NOT NULL,
  `type` varchar(32) NOT NULL,
  `author` int(11) NOT NULL,
  `published` datetime NOT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `title` varchar(128) CHARACTER SET utf8 NOT NULL,
  `content` longtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `url` (`url`, `type`),
  KEY `author` (`author`),
  CONSTRAINT `wtrite_by` FOREIGN KEY (`author`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;


--- COMMENT ---

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post` int(11) NOT NULL,
  `author` int(11) DEFAULT NULL,
  `author_name` varchar(128) NOT NULL,
  `author_email` varchar(128) DEFAULT NULL,
  `author_web` varchar(256) DEFAULT NULL,
  `date` datetime NOT NULL,
  `content` text NOT NULL,
  `ip` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `post` (`post`),
  KEY `author` (`author`),
  CONSTRAINT `comment_post` FOREIGN KEY (`post`) REFERENCES `post` (`id`),
  CONSTRAINT `comment_author` FOREIGN KEY (`author`) REFERENCES `user` (`id`)
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

