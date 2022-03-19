# What
Dockerを使ったRailsの開発環境を作ってみる。

# 初期セットアップ
```
# 最初や、Dockerfileを更新した場合
docker compose build
# docker compose build --no-cache # cacheされていてうまくbuildされない場合は--no-cacheつける
```


# 起動

```
docker compose up -d
```

```
# Railsアプリの作成
# note: docker compose upで、databaseが動いている必要がある。
# 動かなかったので保留：docker compose exec my_application rails new . --force --database=postgresql --skip-bundle -m https://raw.githubusercontent.com/yukimura1227/rails_template/master/template/template.rb --webpack
docker compose exec my_application rails new . --force --database=postgresql --webpack
```

```
# bundle installしたい場合
docker compose exec my_application bundle install
```

```
# databaseのcreate したい場合
docker compose exec my_application rails db:create
```

```
# migrateしたい場合
docker compose exec my_application rails db:migrate
```

