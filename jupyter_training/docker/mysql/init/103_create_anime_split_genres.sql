CREATE TABLE IF NOT EXISTS `jupyter`.`anime_split_genres` (
  `anime_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `genre` varchar(255) NOT NULL DEFAULT '',
  `type` varchar(255) NOT NULL DEFAULT '',
  `episodes` int(11) NOT NULL,
  `rating` float NOT NULL,
  `members` int(11) NOT NULL,
  INDEX (`anime_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
