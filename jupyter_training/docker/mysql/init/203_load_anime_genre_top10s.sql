LOAD DATA LOCAL INFILE
  '/docker-entrypoint-initdb.d/anime_genre_top10.csv'
INTO TABLE jupyter.anime_genre_top10s
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
IGNORE 1 LINES
;
