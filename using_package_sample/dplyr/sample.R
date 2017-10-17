library(dplyr)

# head(iris)

# filterで絞りこむサンプル
filter(iris, Species=='virginica')

# selectで抽出するサンプル
select(iris, Species)
