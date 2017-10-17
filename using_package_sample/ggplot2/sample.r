library(ggplot2)
theme_set(theme_gray(base_family ='Migu 1M'))

# 散布図(sample of qplot)
qplot(
  carat,
  price,
  colour = cut,
  data = diamonds,
  main ='ダイヤモンドのカラットと価格の関係',
  xlab='カラット',
  ylab='価格[$]'
)

g <- ggplot(diamonds, aes(cut))
g_bar <- g + geom_bar(aes(fill = clarity))
print(g_bar)

g2 <- ggplot(diamonds, aes(cut))
g_bar_dodge <- g2 + geom_bar(position='dodge', aes(fill =clarity))
print(g_bar_dodge)
