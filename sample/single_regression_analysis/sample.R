# 単回帰分析のsample y= ax + bを求めるようなやつ。(lmを使用)
library(ggplot2)

data(cars)
head(cars)

# 単回帰分析実行
lm.cars = lm(dist ~ speed, data = cars)
lm.cars

p <-
  ggplot(
    data = cars,
    aes(
      x = speed,
      y = dist
    )
  ) +
  geom_point() +
  geom_abline(
    intercept = lm.cars$coefficients[1],
    slope = lm.cars$coefficients[2]
  )

print(p)

# 回帰分析結果の要約を表示する
summary(lm.cars)
