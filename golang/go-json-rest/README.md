# PREPARE

```shell
docker compose up -d
docker compose exec go_training /bin/sh
export GO111MODULE="auto"
apk add git
```

# SETUP
```
go get github.com/ant0ine/go-json-rest/rest
```

# USAGE
```
go run helloworld.go
```

```
go run countries.go
curl -i -H 'Content-Type: application/json' \
    -d '{"Code":"FR","Name":"France"}' http://127.0.0.1:8080/countries
curl -i -H 'Content-Type: application/json' \
    -d '{"Code":"US","Name":"United States"}' http://127.0.0.1:8080/countries
curl -i http://127.0.0.1:8080/countries/FR
curl -i http://127.0.0.1:8080/countries/US
curl -i http://127.0.0.1:8080/countries
curl -i -X DELETE http://127.0.0.1:8080/countries/FR
curl -i http://127.0.0.1:8080/countries
curl -i -X DELETE http://127.0.0.1:8080/countries/US
curl -i http://127.0.0.1:8080/countries
```
