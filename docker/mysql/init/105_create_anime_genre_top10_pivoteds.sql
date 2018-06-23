CREATE TABLE IF NOT EXISTS `jupyter`.`anime_genre_top10_pivoteds` (
  `genre` varchar(255) NOT NULL DEFAULT '',
  `Movie` varchar(255) NOT NULL DEFAULT '',
  `Music` varchar(255) NOT NULL DEFAULT '',
  `ONA` varchar(255) NOT NULL DEFAULT '',
  `OVA` varchar(255) NOT NULL DEFAULT '',
  `Special` varchar(255) NOT NULL DEFAULT '',
  `TV` varchar(255) NOT NULL DEFAULT '',
  INDEX (`genre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
