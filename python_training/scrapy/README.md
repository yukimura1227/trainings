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
## conda createを実施
```
conda create --name scrapy_training python=3.6.8
```

## createした環境を有効化
```
source activate scrapy_training
```

## createした環境を無効化する場合
```
source deactivate scrapy_training
```

## conda環境をポータブルにするためにyamlにexport

```
conda env export > scrapy_training.yaml
```

## yamlを別の環境で復元する場合

```
# まだ環境が作成されていない場合
conda env create --file > scrapy_training.yaml
# すでに環境が作成されている場合
conda env update -f=scrapy_training.yaml
