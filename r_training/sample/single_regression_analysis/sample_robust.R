# 外れ値がある場合の単回帰分析のsample y= ax + bを求めるようなやつ。(lmを使用)
# ここでは、ロバスト回帰(はずれ値の影響を小さくして回帰を実行するやつ)
library(ggplot2)

# 外れ値があるデータを単純回帰
p <- ggplot(
    phones %>% as.data.frame,
    aes( x = year, y =calls)
  ) +
  stat_smooth(method ='lm') +
  geom_point()
print(p)

# lmを使って詳細を確認してみる
lm.phones <- lm(calls ~ year, data = phones %>% as.data.frame)
summary(lm.phones)

# 回帰診断を実行
layout(matrix(1:4, 2, 2))
plot(lm.phones)

# ロバスト回帰実施(外れ値の影響を受けて小さくする)
library(ggplot2)
library(MASS)

rlm.phones <- rlm(calls ~ year, data = phones %>% as.data.frame, maxit = 100)
rlm.phones
# ロバストな回帰直線の可視化
p <-
  ggplot(
    data = phones %>% as.data.frame,
    aes( x= year, y =calls)
  ) +
  stat_smooth(
    method = function(
      formula,
      data,
      weights = weight
    )
    rlm(formula, data, weights = weight, maxit =100)
  ) +
  geom_point()
print(p)
