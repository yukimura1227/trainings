library(rpart)
library(C50)

data(churn)

# 決定木学習
model.rp <- rpart(churn ~ ., data = churnTrain, control = list(maxdepth = 3))
model.rp

plot(model.rp)
text(model.rp)

# テストデータに対する予測
pred <- predict(model.rp, churnTest, type ='class')
# 混合行列
conf.mat <- table(pred, churnTest$churn)
conf.mat

library(pROC)
prob <- predict(model.rp, churnTest)
roc.curve <- roc(
    response = churnTest$churn, predictor = prob[, 'yes'],
    levels = c('no', 'yes')
  )

plot(roc.curve, legacy.zces = TRUE)
