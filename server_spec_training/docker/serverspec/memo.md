# Docker Command Memo

## 利用されていないコンテナ、イメージ、ボリューム、ネットワーク等を削除
```
docker system prune
```

## 特権モードでdockerを実行
privilegedオプションによって、systemctlなどの実行ができるようになる。
```
IMAGE_ID=xxxxx; docker run --privileged -d -p 80:80 ${IMAGE_ID} /sbin/init
```

## 指定コンテナでbashを実行
```
CONTAINER_ID=xxxxxx; docker exec -it ${CONTAINER_ID} /bin/bash
```

## コンテナを停止
CONTAINER_ID=xxxxxx; docker stop ${CONTAINER_ID}
