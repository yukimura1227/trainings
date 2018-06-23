LOAD DATA LOCAL INFILE
  '/docker-entrypoint-initdb.d/anime_stock_returns.csv'
INTO TABLE jupyter.anime_stock_returns
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
IGNORE 1 LINES
;
