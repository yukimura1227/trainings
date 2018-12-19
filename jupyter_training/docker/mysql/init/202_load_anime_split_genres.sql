LOAD DATA LOCAL INFILE
  '/docker-entrypoint-initdb.d/anime_split_genre.csv'
INTO TABLE jupyter.anime_split_genres
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
IGNORE 1 LINES
;
