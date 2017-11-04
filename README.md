# 目的
Ansbileの勉強用

# 前提条件
Vagrantが使える状態であること

# 準備

```
vagrant up
# -> これで、2つのhostができる(node1： ansibleのコマンドを実行するhost。ansibleはVagrantfileで指定してinstall済。 node2: node1から接続されて、ansibleのbookに従って諸々setupされるhost)
```


```
# 事前準備として、node1 <-> node2でssh接続するできる様にしておく。
# local -> node1にssh接続する
vagrant ssh node1
# 接続後
# ssh [node1 -> node2]
ssh 192.168.33.12
# パスワードはvagrant(デフォルト)

exit

# local -> node2にssh接続する
vagrant ssh node2
# 接続後
# ssh [node2 -> node1]
ssh 192.168.33.11
# パスワードはvagrant(デフォルト)

exit
```

# ansible実行

```
vagrant ssh node1

cd ansible_files/
ansible-playbook sample-playbook.yml
````
