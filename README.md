# 目的
Ansbileの勉強用

# 前提条件
Vagrantが使える状態であること

# 準備

```
vagrant up
# -> これで、2つのhostができる(node1： ansibleのコマンドを実行するhost。ansibleはVagrantfileで指定してinstall済。 node2,node3: node1から接続されて、ansibleのbookに従って諸々setupされるhost)
```


# ansible実行

```
vagrant ssh node1

cd ansible_files/
ansible-playbook sample-playbook.yml
````
