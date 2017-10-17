library(dplyr)
library(ggplot2)

# クラスタへの分割(クラスタ数=3)
ct.cars <- cutree(hc.cars, k = 3)
# クラスタ番号の結合
cars.hc <- cars %>% mutate(cluster = factor(ct.cars, levels = 1:3))
# 点の色をクラスタ番号とする散布図のプロット
p <- ggplot(
    data = cars.hc,
    aes( x = speed, y = dist, colour = cluster, shape = cluster)
  ) + geom_point(aes(shape = cluster))
print(p)
