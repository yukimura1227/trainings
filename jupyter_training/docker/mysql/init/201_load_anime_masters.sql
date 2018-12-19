LOAD DATA LOCAL INFILE
  '/docker-entrypoint-initdb.d/anime_master.csv'
INTO TABLE jupyter.anime_masters
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
IGNORE 1 LINES
;
