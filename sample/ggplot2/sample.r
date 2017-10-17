library(ggplot2)
theme_set(theme_gray(base_family ='Migu 1M'))


qplot(
  carat,
  price,
  data = diamonds,
  main ='ダイヤモンドのカラットと価格の関係',
  xlab='カラット',
  ylab='価格[$]'
)