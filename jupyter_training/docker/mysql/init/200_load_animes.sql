LOAD DATA LOCAL INFILE
  '/docker-entrypoint-initdb.d/anime.csv'
INTO TABLE jupyter.animes
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
IGNORE 1 LINES
;
