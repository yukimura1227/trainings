# Memo

## Setup
### 1st
最初に、Dockerファイル等を作った。
- sample/Dockerfile
- sample/Gemfile
- sample/Gemfile.lock
- sample/docker-compose.yml
- sample/entrypoint.sh

### 2nd
以下を実行して、railsアプリを生成
```
docker compose run --no-deps web rails new . --force --database=postgresql
```

#### 適宜
rails newを含めて、DockerfileやGemfileを更新した場合は、dockerのbuildを行う。
```
docker compose build
```

## 3rd
db create
```
docker compose run web rake db:create
```

## Execute

```
docker compose up
```

## How To Debug

binding.pryを用いてDebugする場合は、


```
# containerのidを調べる
docker ps
# attachする
docker attach 80e34a49c0a1
# このattachしているterminal上で止まります。
# 抜けるときはCtrl+p -> Ctrl+q で抜けましょう
# Ctrl+Cで抜けるとコンテナが終了してしまいますので避けましょう
`````

## referene
https://docs.docker.com/samples/rails/
