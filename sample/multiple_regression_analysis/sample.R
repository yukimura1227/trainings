library(MASS)

data(Boston)

# 重回帰分析実施
lm.Boston <- lm(medv ~ . , data = Boston)

summary(lm.Boston)
