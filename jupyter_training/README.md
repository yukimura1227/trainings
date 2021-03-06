# SETUP

## Prerequirement
pyenvが使える様になっていること

## install Anaconda
```
pyenv install -l | grep anaconda
# 適当なanacondaのバージョンを探す
pyenv install $(cat .python-version)
```

# condaに関するメモ
## 概要
holoviewsを使ってみようとした際に、pipだと
どうしても動かなかった(具体的には、notebook上で画像が表示されなかった)
ので、holoviewsのstartup guideを参考に、condaで環境を構築することにした。
その時のコマンドメモ

## conda createを実施
```
conda create --name jupyter_training python=3.6.0
```

## createした環境を有効化
```
source activate jupyter_training
```

## createした環境を無効化する場合
```
source deactivate jupyter_training
```

## conda環境をポータブルにするためにyamlにexport

```
conda env export > jupyter_training.yaml
```

## yamlを別の環境で復元する場合

```
# まだ環境が作成されていない場合
conda env create --file jupyter_training.yaml
# すでに環境が作成されている場合
conda env update -f=jupyter_training.yaml
```
