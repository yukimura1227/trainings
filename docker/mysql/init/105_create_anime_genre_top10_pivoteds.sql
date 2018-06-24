CREATE TABLE IF NOT EXISTS `jupyter`.`anime_genre_top10_pivoteds` (
  `genre` varchar(255) NOT NULL DEFAULT '',
  `Movie` float NOT NULL,
  `Music` float NOT NULL,
  `ONA` float NOT NULL,
  `OVA` float NOT NULL,
  `Special` float NOT NULL,
  `TV` float NOT NULL,
  INDEX (`genre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
