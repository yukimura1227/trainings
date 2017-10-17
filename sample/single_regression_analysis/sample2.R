# 単回帰分析のsample y= ax + bを求めるようなやつ。(ggplot2を使用)
library(ggplot2)

data(cars)
head(cars)

# 単回帰分析実行
data(cars)
p <-
  ggplot(
    data = cars,
    aes( x = speed, y = dist )
  ) +
  stat_smooth(method = 'lm') +
  geom_point()

print(p)
