LOAD DATA LOCAL INFILE
  '/docker-entrypoint-initdb.d/anime_stock_price.csv'
INTO TABLE jupyter.anime_stock_prices
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
IGNORE 1 LINES
;
