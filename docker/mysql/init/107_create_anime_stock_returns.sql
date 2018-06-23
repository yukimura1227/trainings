CREATE TABLE IF NOT EXISTS `jupyter`.`anime_stock_returns` (
  `Date` date NOT NULL,
  `TOEI ANIMATION` float NOT NULL DEFAULT 0.0,
  `IG Port` float NOT NULL DEFAULT 0.0,
  INDEX (`Date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
