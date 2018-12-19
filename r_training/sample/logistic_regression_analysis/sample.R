# kernlabは、spmaのデータセットを持っている
library(kernlab)
library(dplyr)
library(coefplot)

data(spam)
spam %>% head(3)

# ロジスティック回帰は、目的変数が0,1前提になっているので加工
# 分かり辛いが、spam$typeはfactor(is.factor(spam$type)はTRUEになる)
# そして、factorは、as.integerで変換すると'yes'(この場合はspamである)
# この場合は、1に、'no'(この場合はspamではない)場合は2になる。
# spamを1に、spam出無いものを0にしたいので、符号を反転して2を足してあげている。
# mutateを使って、typeをかラムを追加している(この場合typeを上書きしてしまっている。)
spam.converted <- spam %>% mutate(type = - as.integer(type) + 2)
head(spam.converted, 3)

glm.spam <- glm( type ~ . , data=spam.converted, family=binomial)
summary(glm.spam)
coefplot(glm.spam)

