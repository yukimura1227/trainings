LOAD DATA LOCAL INFILE
  '/docker-entrypoint-initdb.d/anime_genre_top10_pivoted.csv'
INTO TABLE jupyter.anime_genre_top10_pivoteds
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
IGNORE 1 LINES
;
