library(MASS)
library(coefplot)

data(Boston)

# 重回帰分析実施
lm.Boston <- lm(medv ~ . , data = Boston)

summary(lm.Boston)

# 結果のプロット
coef(summary(lm.Boston))

coefplot(lm.Boston)

# 重回帰分析の説明変数を「変数選択」処理で減らしてみる。
lm.Boston.step <- step(lm.Boston)
summary(lm.Boston.step)

pairs(Boston)
