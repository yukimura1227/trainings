# USAGE


## Run

```
docker compose up -d
```

## Stop

```
docker compose stop
```

## Check Container ID

```
docker compose ps
```

## Connect MySQL

```
mysql -u root -ppassword -h 127.0.0.1 -P 13306
```

## Login on bash

```
docker exec -it ${ID_OR_NAME} bash
```
